/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;
/*import ferreteria.presentacion.view.FacturaView;
import ferreteria.presentacion.view.ClientesView;
import ferreteria.presentacion.view.ProductosView;
import java.util.List;
import ferreteria.Application;
import ferreteria.Session;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.FacturaModel;
import ferreteria.presentacion.model.FacturasVentasModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.model.LineaModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteriaentidades.Cliente;
import ferreteriaentidades.Empleado;
import ferreteriaentidades.Factura;
import ferreteriaentidades.Linea;
import ferreteriaentidades.Producto; */
import java.util.ArrayList;
import java.util.Arrays;

public class FacturaController {
    /*Model domainModel;
    Session session;
    FacturaView view;
    FacturaModel model;
    public static  int CONTADOR=1;
    
    public FacturaController(FacturaView v ,FacturaModel m,Model domainModel,Session session){
        this.view = v;
        this.model=m;
        this.domainModel= domainModel;
        this.session= session;
        model.init();
        view.setController(this);
        view.setModel(m);
    }
    
      public void preAgregarCliente(){
          model.clearErrors();
          Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
         if(view.idClienteTextFd.getText().length()==0){
         ClientesModel clientesModel = Application.CLIENTES_FACTURA_VIEW.getModel();
         clientesModel.clearErrors();
         model.clearErrors();
         clientesModel.setFilter(new Cliente());
         Application.CLIENTES_FACTURA_VIEW.setVisible(true);
         }
    }
      
      public void preAgregarProducto(){
         model.clearErrors();
          Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
         ProductosModel productosModel = Application.PRODUCTOFACTURA_VIEW.getModel();
         productosModel.clearErrors();
         productosModel.setFilter(new Producto());
         productosModel.setModo(Application.MODO_AGREGAR);
         Application.PRODUCTOFACTURA_VIEW.setVisible(true);
    
      }
      public void eliminar(int row){
          model.clearErrors();
          Linea l1 = model.getLineas().getRowAt(row);
          int cantidad;
          Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try{
             cantidad = l1.getCodProducto().getExistencias()+l1.getCantidad();
             l1.getCodProducto().setExistencias(cantidad);
             domainModel.updateProducto2(l1.getCodProducto());
             domainModel.deleteLinea(l1,row+1);
         }catch (Exception ex) { }
         List<Linea> lineas = domainModel.getLineas();
         model.setLineas(lineas);
      }
      public void guardar(){
          model.clearErrors();
          FacturasVentasModel facturas = Application.FACTURAS_VENTAS_VIEW.getModel();
          Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
          Factura f1 = Application.FACTURA_VIEW.getModel().getCurrent();
         if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        } 
//         if(view.ListProductosTable.getRowCount()!=0 && view.ListProductosTable.getSelectedRow()!=-1){
            if(model.getLineas().getRowCount()==0){
                 model.getErrores().put("GRABAR","Factura Vacia");
                 model.setMensaje("Debe insertar Productos a la Factura");
             }else{
                 f1.setNumero(CONTADOR);
                CONTADOR++;
                 List<Factura> facturasVentas;
                if(model.getErrores().isEmpty()){
                 try{
                    double total = Double.valueOf(view.TotalTextFd.getText());
                    f1.setTipoPago((String)view.metodoPagoComboBox.getSelectedItem());
                    f1.setTotal(total);
                    domainModel.updateFactura(f1);
                    facturasVentas = domainModel.getFacturas();
                    Application.FACTURAS_VENTAS_VIEW.getModel().setFacturas(facturasVentas);
                    List<Linea> nuevo = new ArrayList<Linea>();
                    model.setCurrent(new Factura());
                    model.setFiltro(new Linea());
                    model.setMensaje("FACTURA AGREGADA");
                    model.setLineas(nuevo);
                    view.setVisible(false);          
                }catch(Exception e){
                 model.getErrores().put("GRABAR","Errores");
                 model.setMensaje("Problemas con la Base de Datos");
//                 model.setCurrent(f1);
                 }
            }else{
            model.setMensaje("Errores");
//             model.setCurrent(f1);
            }
        }
      }
        
//    public void clientesShow(){
//        Application.CLIENTES_FACTURA_VIEW.setVisible(true);
//    }
    public void productosShow(){
        Application.PRODUCTOFACTURA_VIEW.setVisible(true);
    }
 
     public void salir(){
        model.clearErrors();
        view.setVisible(false);
        Application.PRODUCTOFACTURA_VIEW.setVisible(false);
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
