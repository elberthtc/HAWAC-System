/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;


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
    /*Model domainModel;
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
        List<Producto> rows = domainModel.searchProductos(model.getFilter()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
 
    }
     public void buscar2(){
        model.clearErrors();
        model.getFilter().setCodigo(view.DescripcionText.getText());
        List<Producto> rows = domainModel.searchProductos2(model.getFilter()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
 
    }
   public void borrar(int row){
        model.clearErrors();
        Producto p1 = model.getProductos().getRowAt(row);
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_MANAGER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try{
            domainModel.deleteProducto(p1);
        }catch (Exception ex) { }
        List<Producto> rowsMod = domainModel.searchProductos(model.getFilter());
        model.setProductos(rowsMod);
    }
    public void preAgregar(){
        model.clearErrors();
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if( !Arrays.asList(Application.ROL_MANAGER).contains(e1.getRol().getDescripcion())){
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
        Empleado principal = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if(Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol().getDescripcion())){
            productoModel.setModo(Application.MODO_EDITAR);
        }else{
            productoModel.setModo(Application.MODO_CONSULTAR);
        }
        productoModel.setCurrent(c1);
        Application.PRODUCTO_VIEW.setVisible(true);
 }

  public void salir(){
        model.clearErrors();        
        domainModel.close();
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
  */
}


