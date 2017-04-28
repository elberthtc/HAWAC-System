package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductosView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductosController {

    Model domainModel;
    Session session;
    ProductosView view;
    ProductosModel model;

    public ProductosController(ProductosView view, Session session, ProductosModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.descripcionT.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for(int i = 0; i< rows.size(); i++){
            Inventario inv = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(i).getIdProducto()));
            if(inv!=null){
                int cantidad = inv.getCantidad();
                rows.get(i).setCantidad(cantidad);
            }
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);

    }

    public void buscarPorDescripcion() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.descripcionT.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for(int i = 0; i< rows.size(); i++){
            Inventario inv = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(i).getIdProducto()));
            if(inv!=null){
                int cantidad = inv.getCantidad();
                rows.get(i).setCantidad(cantidad);
            }
        }
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (rows.get(i).getDescripcion().toLowerCase().indexOf(view.descripcionT.getText().toLowerCase()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
    }

    public void mensajeError(){
        if(model.getErrores().size()>0){
            JOptionPane.showMessageDialog(view, model.getMensaje(), "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void buscarPorCodigo() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.descripcionT.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for(int i = 0; i< rows.size(); i++){
            Inventario inv = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(i).getIdProducto()));
            if(inv!=null){
                int cantidad = inv.getCantidad();
                rows.get(i).setCantidad(cantidad);
            }
        }
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (String.valueOf(rows.get(i).getIdProducto()).indexOf(view.descripcionT.getText()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");          
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
    }

    public void borrar(int row) {
        model.clearErrors();
        Producto p1 = model.getProductos().getRowAt(row);
        List<Inventario> inventarioLista = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            if (!domainModel.productoVendido(p1)) {
                for (int i = 0; i < inventarioLista.size(); i++) {
                    if (inventarioLista.get(i).getId().getProducto() == p1.getIdProducto()) {
                        domainModel.getInventarioBl().delete(inventarioLista.get(i));
                    }
                }
                Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha eliminado: " + p1.getDescripcion(), new Date());
                domainModel.getBitacoraBl().save(b);
                domainModel.getProductoBl().delete(p1);
            }else{
                JOptionPane.showMessageDialog(view,"Este Producto se esta utilizando en otros registros, no se puede eliminar");
            }
        } catch (Exception ex) {
        }
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for(int i = 0; i< rows.size(); i++){
            Inventario inv = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(i).getIdProducto()));
            if(inv!=null){
                int cantidad = inv.getCantidad();
                rows.get(i).setCantidad(cantidad);
            }
        }
        model.setProductos(rows);
    }

    public void preAgregar() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        productoModel.clearErrors();
        productoModel.setModo(Application.MODO_AGREGAR);
        productoModel.setCurrent(new Producto());
        Application.PRODUCTO_VIEW.setVisible(true);
    }

    public void editar(int row) {
        model.clearErrors();
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        Producto c1 = model.getProductos().getRowAt(row);
        productoModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() == 0) {
            productoModel.setModo(Application.MODO_EDITAR);
        } else {
            productoModel.setModo(Application.MODO_CONSULTAR);
        }
        productoModel.setCurrent(c1);
        Application.PRODUCTO_VIEW.setVisible(true);
    }

    public void salir() {
        model.clearErrors();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

}
