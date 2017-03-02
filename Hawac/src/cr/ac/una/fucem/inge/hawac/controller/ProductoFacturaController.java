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
import ferreteria.presentacion.model.FacturaModel;
import ferreteriaentidades.Cliente;
import ferreteriaentidades.Empleado;
import ferreteriaentidades.Producto;
import ferreteria.presentacion.model.ProductoModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteria.presentacion.view.ProductoFacturaView;
import ferreteriaentidades.Factura;
import ferreteriaentidades.FacturaCompra;
import ferreteriaentidades.Linea;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

*/

public class ProductoFacturaController {
  /*  Model domainModel;
    Session session;
    ProductoFacturaView view;
    ProductosModel model;
    public static  int CONTADOR=1;

    
    public ProductoFacturaController(ProductoFacturaView view, Session session, ProductosModel model, Model domainModel) {
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
    public void seleccionar(int row){
        model.clearErrors();
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        Producto p1 = model.getProductos().getRowAt(row);
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if( !Arrays.asList(Application.ROL_SELLER,Application.ROL_STOREKEEPER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Linea l1 = new Linea();
        if(view.cantidadTextField.getText().length()==0){
            model.getErrores().put("Cantidad","Cantidad requerida");
            model.setMensaje("Cantidad requerida");
        }else{
            if(!isNumeric(view.cantidadTextField.getText())){
             model.getErrores().put("Cantidad","Digite Solo numeros");
            }else{
                int ex = Integer.parseInt(view.cantidadTextField.getText());
                if(ex>p1.getExistencias()){
                    model.getErrores().put("Cantidad","Existencias Insuficientes");
                 }
                if(ex==0){
                    model.getErrores().put("Cantidad","Digito Invalido");
                }
                 l1.setCodProducto(p1);
                 l1.setCantidad(ex);
//                 l1.setNumeroLinea(CONTADOR);
//                 CONTADOR++;
                
             }
        }
        List<Linea> lineas;
        if(model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                    Factura f1 = domainModel.getFacturaMayor();
                    l1.setNumFactura(f1);
                    domainModel.addLinea(l1);
                    int cantidad = l1.getCodProducto().getExistencias()-l1.getCantidad();
                    l1.getCodProducto().setExistencias(cantidad);
                    domainModel.updateProducto2(l1.getCodProducto());
                    model.setMensaje("PRODUCTO AGREGADO");
                    List<Linea> nuevo = new ArrayList<Linea>();
                    lineas = domainModel.searchLineas(l1);
                    facturaModel.setLineas(lineas);
                    f1.setEmpleado(e1);
                    f1.setCliente(Application.FACTURA_VIEW.getModel().getCliente());
                    facturaModel.setCurrent(f1);
                    view.cantidadTextField.setText("0");
                    Application.PRODUCTOFACTURA_VIEW.setVisible(false);
                    break;
                    
                    case Application.MODO_EDITAR:
//                    FacturaCompra f2 = domainModel.getFacturaMayor2();
//                    l1.setNumFactura(f2);
//                    domainModel.addLineaCompra(l1);
//                    int cantidad2 = l1.getCodProducto().getExistencias()+l1.getCantidad();
//                    l1.getCodProducto().setExistencias(cantidad2);
//                    domainModel.updateProducto2(l1.getCodProducto());
//                    model.setMensaje("PRODUCTO AGREGADO");
//                    List<Linea> lineaCompra = new ArrayList<Linea>();
//                    lineaCompra = domainModel.searchLineas2(l1);
//                    facturaModel.setLineas(lineaCompra);
//                    f2.setEmpleado(e1);
//                    Application.PRODUCTOFACTURA_VIEW.setVisible(false);
                    
                    break;
            }
        }catch(Exception e){
                model.setMensaje("Problemas con la Base de Datos");
            }
        }else{
            model.setMensaje("Errores");
        }
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