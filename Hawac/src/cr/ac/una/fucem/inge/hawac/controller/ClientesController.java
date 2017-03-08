/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClienteModel;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.view.ClientesView;
import hawac.Application;
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
        List<Cliente> rows = domainModel.getClienteBl().findAll(Cliente.class.getName()); // ACA BUSCA POR NOMBRE
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    
    public void buscarPorNombre() {
        model.clearErrors();
        model.getFilter().setNombre(view.nombreTextFd.getText());
        List<Cliente> aux = domainModel.getClienteBl().findAll(Cliente.class.getName());
        for(int i=0;i<aux.size();i++){
            if(aux.get(i).getNombre().indexOf(view.nombreTextFd.getText())==-1){
                aux.remove(aux.get(i));
            }
        }
        if (aux.isEmpty()) {
            model.getErrores().put("nombreTextFd", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(aux);
    }

    public void buscarPorId(){
        model.clearErrors();
        //model.getFilter().setCedula(Integer.parseInt(view.nombreTextFd.getText()));
        List<Cliente> rows = domainModel.getClienteBl().findAll(Cliente.class.getName()); //ACA BUSCA POR ID
        for(int i=0;i<rows.size();i++){
            if(String.valueOf(rows.get(i).getCedula()).indexOf(view.nombreTextFd.getText())==-1){
                rows.remove(rows.get(i));
            }
        }
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    
    public void borrar(int row){
        model.clearErrors();
        Cliente c1 = model.getClientes().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
         if( e1.getTipo() != 0 ){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try{
            domainModel.getClienteBl().delete(c1);
        }catch (Exception ex) { }
        
        List<Cliente> rowsMod = domainModel.getClienteBl().findAll(Cliente.class.getName());
        model.setClientes(rowsMod);
    }
    
    
    public void preAgregar(){
        
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        System.out.println(e1.getPassword());
        if(e1.getTipo()==-1){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        clienteModel.clearErrors();
        clienteModel.setModo(Application.MODO_AGREGAR);
        clienteModel.setCurrent(new Cliente());
        Application.CLIENTE_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        Cliente c1 = model.getClientes().getRowAt(row);
        clienteModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
        if(true){
            clienteModel.setModo(Application.MODO_EDITAR);
        }else{
            clienteModel.setModo(Application.MODO_CONSULTAR);
        }
        clienteModel.setCurrent(c1);
        Application.CLIENTE_VIEW.setVisible(true);
    }

    public void salir(){
        model.clearErrors();        
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
}
