package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoApartadoView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ProductoApartadoController {
    Model domainModel;
    Session session;
    ProductoApartadoView view;
    ProductosModel model;
    public static  int CONTADOR=1;

    
    public ProductoApartadoController(ProductoApartadoView view, Session session, ProductosModel model, Model domainModel) {
        model.init();
        this.domainModel= domainModel;
        this.session=session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }    
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
 
    }
    
    public void seleccionar(int row) {
        model.clearErrors();
        Producto p1 = model.getProductos().getRowAt(row);
        InventarioId iId = new InventarioId("Tienda", (Integer) p1.getIdProducto());
        Inventario i1 = domainModel.getInventarioBl().findById(iId);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        
        if (model.getErrores().isEmpty()) {
            //try {
            switch (model.getModo()) {
                case Application.MODO_AGREGAR:
                    int cantidad = i1.getCantidad()-1;
                    //i1.setCantidad(cantidad);
                    //domainModel.getInventarioBl().merge(i1);
                    Application.APARTADO_VIEW.getModel().getCurrent().setProducto(p1.getIdProducto());
                    Application.APARTADO_VIEW.getModel().getCurrent().setP(p1);
                    Application.APARTADO_VIEW.update(model, row);
                    //model.setMensaje("PRODUCTO AGREGADO");
                    //lineas.add(l1);
                    //f1.setCliente(Application.FACTURA_VIEW.getModel().getCliente());
                    //facturaModel.setCurrent(f1);
                    //view.cantidadTextField.setText("0");
                    Application.PRODUCTO_APARTADO_VIEW.setVisible(false);
                    Application.APARTADO_VIEW.setVisible(true);
                    break;

                case Application.MODO_EDITAR:
                    break;
            }
        } else {
            model.setMensaje("Errores");
        }
    }
  
    public void buscarPorDescripcion(){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(rows.get(j).getDescripcion().toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
    }
    
     public void buscarPorId(){
        model.clearErrors();
        model.getFilter().setIdProducto(Integer.parseInt(view.DescripcionText.getText()));
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(String.valueOf(rows.get(j).getIdProducto()).compareTo(view.DescripcionText.getText())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
 
    }

  public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
 }
  
     private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException exc){
		return false;
	}
    }
}