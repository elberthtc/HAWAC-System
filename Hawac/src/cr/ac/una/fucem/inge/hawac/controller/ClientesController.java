/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.view.ClientesView;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
/*import ferreteria.Application;
import ferreteria.logic.Model;
import ferreteria.Session;
import ferreteriaentidades.Cliente;
import ferreteriaentidades.Empleado;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.view.ClientesView;*/


public class ClientesController {
    Model domainModel;
    Session session;
    ClientesView view;
    ClientesModel model;
    public ClientesController(ClientesView view, Session session, ClientesModel model, Model domainModel) {
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
        model.getFilter().setNombre(view.nombreTextFd.getText());
        List<Cliente> rows = domainModel.getClienteBl().findAll(null); // ACA BUSCA POR NOMBRE
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    public void buscar2(){
        model.clearErrors();
        model.getFilter().setCedula(Integer.parseInt(view.nombreTextFd.getText()));
        List<Cliente> rows = domainModel.getClienteBl().findAll(null); //ACA BUSCA POR ID
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    public void borrar(int row){
      /*  model.clearErrors();
        Cliente c1 = model.getClientes().getRowAt(row);
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try{
            domainModel.getClienteBl().delete(c1);
        }catch (Exception ex) { }
        List<Cliente> rowsMod = domainModel.searchClientes(model.getFilter());
        model.setClientes(rowsMod); */
    }
    public void preAgregar(){
        /*
        model.clearErrors();
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        clienteModel.clearErrors();
        clienteModel.setModo(Application.MODO_AGREGAR);
        clienteModel.setCurrent(new Cliente());
        Application.CLIENTE_VIEW.setVisible(true);
                */
    }
    public void editar(int row){
        /*
        model.clearErrors();
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        Cliente c1 = model.getClientes().getRowAt(row);
        clienteModel.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if(Arrays.asList(Application.ROL_SELLER).contains(principal.getRol().getDescripcion())){
            clienteModel.setModo(Application.MODO_EDITAR);
        }else{
            clienteModel.setModo(Application.MODO_CONSULTAR);
        }
        clienteModel.setCurrent(c1);
        Application.CLIENTE_VIEW.setVisible(true);
                */
    }

    public void salir(){
      /*  model.clearErrors();        
        domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
              */
    }

 
    
}
