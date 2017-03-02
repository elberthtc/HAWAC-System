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
import ferreteria.presentacion.model.FacturasPagadasModel;
import ferreteria.presentacion.view.FacturasPagadasView;*/
import java.util.ArrayList;


public class FacturasPagadasController {
    /*Model domainModel;
    Session session;
    FacturasPagadasModel model;
    FacturasPagadasView view;
    
    public FacturasPagadasController( FacturasPagadasView view,FacturasPagadasModel model,Model domainModel,Session session){
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
         if( !Arrays.asList(Application.ROL_DISPATCHER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFiltro().getCliente().setNombre(view.nombreTextFd.getText());
        List<Factura> rows = domainModel.FacturaSearch2(model.getFiltro()); 
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }
    public void seleeccionar(int row){
        model.clearErrors();
        FacturasPagadasModel  despachos = Application.FACTURAS_PAGADAS_VIEW.getModel();
        Factura f1 = model.getFacturas().getRowAt(row);
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if(!Arrays.asList(Application.ROL_DISPATCHER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        despachos.clearErrors();
        try{
            f1.setEstado(true);
            despachos.setFiltro(f1);
            domainModel.updateFactura5(f1);
//            domainModel.deleteFactura(f1);
            List<Factura> despachadas = new ArrayList<Factura>();
            despachadas =  domainModel.FacturaSearch2(f1);
            despachos.setFacturas(despachadas);
        }catch(Exception e){
            model.setMensaje("Problemas con la Base de Datos");
        }  
        
    }
    

    
     public void salir(){
        model.clearErrors();        
        domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
    */
}
