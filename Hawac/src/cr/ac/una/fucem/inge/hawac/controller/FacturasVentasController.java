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
import ferreteriaentidades.Factura;
import ferreteriaentidades.Empleado;
import ferreteria.presentacion.model.FacturasVentasModel;
import ferreteria.presentacion.view.FacturasVentasView;
*/

public class FacturasVentasController {
  /*  Model domainModel;
    Session session;
    FacturasVentasModel model;
    FacturasVentasView view;
    
    public FacturasVentasController( FacturasVentasView view,FacturasVentasModel model,Model domainModel,Session session){
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session= session;
        model.init();
        view.setController(this);
        view.setModel(model);  
}
    
    public void buscar(){
        model.clearErrors();
         Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_CASHIER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFiltro().getCliente().setNombre(view.nombreTextFd.getText());
        List<Factura> rows = domainModel.FacturaSearch(model.getFiltro());
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }
    public void seleeccionar(int row){
        model.clearErrors();
        FacturasVentasModel  ventas = Application.FACTURAS_VENTAS_VIEW.getModel();
        Factura f1 = model.getFacturas().getRowAt(row);
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if(!Arrays.asList(Application.ROL_CASHIER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ventas.clearErrors();
    
        if(f1.getTipoPago().equals("Efectivo")){
            ventas.setFiltro(f1);
            Application.Efectivo_VIEW.setVisible(true);
        }
        if(f1.getTipoPago().equals("TarjetaCredito")){
            ventas.setFiltro(f1);
            Application.TarjetaCredito_VIEW.setVisible(true);
        }
        if(f1.getTipoPago().equals("Cheque")){
              ventas.setFiltro(f1);
              Application.Cheque_VIEW.setVisible(true);
        }
        
    }
    
//     public void RegistraPago(){
//        model.clearErrors();
//        Factura f1=model.getFiltro();
//        if(f1.getTipoPago().equals("Cheque")){
//        int monto = Integer.parseInt(Application.Cheque_VIEW.Monto.getText());
//        f1.setMontoCheque(monto);
//         model.setFiltro(f1);
//         Application.Cheque_VIEW.setVisible(false);
//         }
//        if(f1.getTipoPago().equals("Efectivo")){
//        int monto = Integer.parseInt(Application.Efectivo_VIEW.Monto.getText());
//        f1.setMontoEfectivo(monto);
//        model.setFiltro(f1);
//        Application.Efectivo_VIEW.setVisible(false);
//        }
//        if(f1.getTipoPago().equals("TarjetaCredito")){
//        int monto = Integer.parseInt(Application.TarjetaCredito_VIEW.Monto.getText());
//        f1.setMontoTarjeta(monto);
//        model.setFiltro(f1);
//         Application.TarjetaCredito_VIEW.setVisible(false);
//      }
//      
//    }
    
     public void salir(){
        model.clearErrors();        
        domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    */
}
