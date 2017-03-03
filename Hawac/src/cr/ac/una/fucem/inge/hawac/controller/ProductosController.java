/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;


import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductosView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
/*import ferreteria.Application;
import ferreteria.logic.Model;
import ferreteria.Session;
import ferreteriaentidades.Cliente;
import ferreteriaentidades.Empleado;
import ferreteriaentidades.Producto;
import ferreteria.presentacion.model.ProductoModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteria.presentacion.view.ProductosView;
import ferreteriaentidades.Linea;*/
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProductosController {
    Model domainModel;
    Session session;
    ProductosView view;
    ProductosModel model;
    
    public ProductosController(ProductosView view, Session session, ProductosModel model, Model domainModel) {
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
    
    public void buscarPorDescripcion() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getDescripcion().indexOf(view.DescripcionText.getText()) == -1) {
                rows.remove(rows.get(i));
            }
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
    
    public void buscarPorCodigo() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        for (int i = 0; i < rows.size(); i++) {
            if (String.valueOf(rows.get(i).getIdProducto()).indexOf(view.DescripcionText.getText()) == -1) {
                rows.remove(rows.get(i));
            }
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
     
     
   public void borrar(int row){
        model.clearErrors();
        Producto p1 = model.getProductos().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
         if(true){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try{
            domainModel.getProductoBl().delete(p1);
        }catch (Exception ex) { }
        List<Producto> rowsMod = domainModel.getProductoBl().findAll(Producto.class.getName());
        model.setProductos(rowsMod);
    }
    public void preAgregar(){
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if(e1.getTipo()!=0){
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
   public void editar(int row){
        model.clearErrors();
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        Producto c1 = model.getProductos().getRowAt(row);
        productoModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if(principal.getTipo()==0){
            productoModel.setModo(Application.MODO_EDITAR);
        }else{
            productoModel.setModo(Application.MODO_CONSULTAR);
        }
        productoModel.setCurrent(c1);
        Application.PRODUCTO_VIEW.setVisible(true);
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


