/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.FacturasPagadasModel;
import cr.ac.una.fucem.inge.hawac.view.FacturasPagadasView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class FacturasPagadasController {
    Model domainModel;
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
         Usuario e1 = (Usuario) session.getAttribute("Usuario");
         if(e1.tipo()==-1){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        //model.getFiltro().getCliente().setNombre(view.nombreTextFd.getText());
        List<Factura> rows = domainModel.getFacturaBl().findAll(Factura.class.getName());
        for(int i = 0; i< rows.size(); i++){
            rows.get(i).setC(domainModel.getClienteBl().findById(rows.get(i).getCliente()));
            rows.get(i).setU(domainModel.getUsuarioBl().findById(rows.get(i).getUsuario()));
        }
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
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if( e1.tipo() == -1){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        despachos.clearErrors();
        try{
            //f1.setEstado(true);
            despachos.setFiltro(f1);
            //domainModel.updateFactura5(f1);
//            domainModel.deleteFactura(f1);
            List<Factura> despachadas = new ArrayList<Factura>();
            despachadas =  domainModel.getFacturaBl().findAll(Factura.class.getName());
            despachos.setFacturas(despachadas);
        }catch(Exception e){
            model.setMensaje("Problemas con la Base de Datos");
        }  
    }
    

    
     public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
}
