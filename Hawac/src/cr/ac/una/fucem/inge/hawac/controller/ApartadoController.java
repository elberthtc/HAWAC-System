/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ApartadoModel;
import cr.ac.una.fucem.inge.hawac.model.ApartadosModel;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ApartadoView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ApartadoController {

    Model domainModel;
    ApartadoView view;
    ApartadoModel model;
    Session session;

    public ApartadoController(ApartadoView view, ApartadoModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.session = session;
        view.setController(this);
        view.setModel(model);
    }

    public void preAgregarCliente() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute(("Usuario"));
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        if (view.clienteText.getText().length() == 0) {
            ClientesModel clientesModel = Application.CLIENTES_APARTADO_VIEW.getModel();
            clientesModel.clearErrors();
            model.clearErrors();
            clientesModel.setFilter(new Cliente());
            Application.CLIENTES_APARTADO_VIEW.setVisible(true);
        }
    }
    
    public void preAgregarProducto() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ProductosModel productosModel = Application.PRODUCTO_APARTADO_VIEW.getModel();
        productosModel.clearErrors();
        productosModel.setFilter(new Producto());
        productosModel.setModo(Application.MODO_AGREGAR);
        Application.PRODUCTO_APARTADO_VIEW.setVisible(true);

    }
    
    public void guardar() {
        model.clearErrors();
        ApartadosModel apartadosModel = Application.APARTADOS_VIEW.getModel();
        Apartado p1 = model.getCurrent();
        Inventario i1 = new Inventario();
        
        if (view.dependienteText.getText().length() == 0) {
            model.getErrores().put("Vendedor", "Vendededor requerido");
        }else{
            p1.setUsuario(Application.APARTADO_VIEW.getModel().getCurrent().getUsuario());
        }
        
        if (view.clienteText.getText().length() == 0) {
            model.getErrores().put("Cliente", "Cliente requerido");
        }else{
            p1.setCliente(Application.APARTADO_VIEW.getModel().getCurrent().getCliente());
        }
        
        if (view.productoText.getText().length() == 0) {
            model.getErrores().put("Producto", "Producto Requerido");
        }else{
            p1.setProducto(Application.APARTADO_VIEW.getModel().getCurrent().getProducto());
            i1 = domainModel.getInventarioBl().findById(new InventarioId("Tienda",p1.getProducto()));
            i1.setCantidad(i1.getCantidad()-1);
        }
        
        if (view.primaText.getText().length() == 0 || !isNumeric2(view.primaText.getText()) || !isNumeric(view.primaText.getText())) {
            model.getErrores().put("Prima", "Prima requerida");
            view.primaLabel.setBorder(Application.BORDER_ERROR);
            view.primaLabel.setToolTipText(model.getErrores().get("primaLabel"));
        } else{
            double a = p1.getP().getPrecio() - Double.parseDouble(view.primaText.getText());
            if(a<=0){
                model.getErrores().put("Prima", "Prima requerida");
                view.primaLabel.setBorder(Application.BORDER_ERROR);
                view.primaLabel.setToolTipText(model.getErrores().get("primaLabel"));
                JOptionPane.showMessageDialog(view, "La prima debe ser Menor o igual al saldo");
            }else{
                p1.setSaldo(p1.getP().getPrecio() - Double.parseDouble(view.primaText.getText()));
            }
        }
        

        List<Apartado> apartados;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(),Application.USUARIO.getNombre()+" ha agregado un apartado del producto: "+p1.getP().getDescripcion()+", al Cliente: "+p1.getC().getNombre(),new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getApartadoBl().save(p1);
                        domainModel.getInventarioBl().merge(i1);
                        model.setMensaje("APARTADO AGREGADO");
                        model.setCurrent(new Apartado());
                        apartados = domainModel.getApartadoBl().findAll(Apartado.class.getName());
                        for (int i = 0; i < apartados.size(); i++) {
                            apartados.get(i).setC(domainModel.getClienteBl().findById(apartados.get(i).getCliente()));
                            apartados.get(i).setP(domainModel.getProductoBl().findById(apartados.get(i).getProducto()));
                            apartados.get(i).setU(domainModel.getUsuarioBl().findById(apartados.get(i).getUsuario()));
                        }
                        apartadosModel.setApartados(apartados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                       /* domainModel.getProductoBl().merge(p1);
                        model.setMensaje("PRODUCTO MODIFICADO");
                        model.setCurrent(p1);
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        productosModel.setProductos(productos);
                        view.setVisible(false); */
                        break;
                }
            } catch (Exception e) {
                model.getErrores().put("Codigo", "Producto ya existente");
                model.setMensaje("Producto YA EXISTENTE");
                model.setCurrent(p1);
            }
        } else {
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
            model.setCurrent(p1);
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    private static boolean isNumeric2(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }
}
