/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;


import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoFacturaView;
import cr.ac.una.fucem.inge.hawac.view.ProductoInventarioView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ProductoInventarioController {
    Model domainModel;
    Session session;
    ProductoInventarioView view;
    ProductosModel model;

    
    public ProductoInventarioController(ProductoInventarioView view, Session session, ProductosModel model, Model domainModel) {
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
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
 
    }
    
    public void seleccionar(int row) {
        model.clearErrors();
        Producto c1 = model.getProductos().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            
            Application.INVENTARIO_VIEW.getModelo().setProductoActual(c1);
            //Application.FACTURA_VIEW.getModel().setCliente(c1);
            

        } catch (Exception ex) {
            model.setMensaje("Problemas con la Base de Datos");
        }
        view.setVisible(false);
        Application.INVENTARIO_VIEW.update(model, e1);
        Application.INVENTARIO_VIEW.setVisible(true);
    }
  
     public void buscar2(){
        model.clearErrors();
        model.getFilter().setIdProducto(Integer.parseInt(view.DescripcionText.getText()));
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
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