/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.view.ClientesApartadoView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;

public class ClientesApartadoController {
    Model domainModel;
    Session session;
    ClientesApartadoView view;
    ClientesModel model;
    int cont;
    public static  int CONTADOR=1;
    
    public ClientesApartadoController(ClientesApartadoView view, Session session, ClientesModel model, Model domainModel) {
        model.init();
        this.domainModel= domainModel;
        this.session=session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscarPorNombre() {
        model.clearErrors();
        model.getFilter().setNombre(view.nombreTextFd.getText());
        List<Cliente> aux = domainModel.getClienteBl().findAll(Cliente.class.getName());
        //for(int i=0;i<aux.size();i++){
        int i=0, cont= aux.size();
        while(i<aux.size() && cont>0){
            if(aux.get(i).getNombre().toLowerCase().indexOf(view.nombreTextFd.getText().toLowerCase())==-1){
                aux.remove(aux.get(i));
            }else
                i++;
            cont--;
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
        //for(int i=0;i<rows.size();i++){
        int i=0, cont= rows.size();
        while(i<rows.size() && cont>0){
            if(String.valueOf(rows.get(i).getCedula()).indexOf(view.nombreTextFd.getText())==-1){
                rows.remove(rows.get(i));
            }else
                i++;
         cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    
    public void buscar(){
        model.clearErrors();
        model.getFilter().setNombre(view.nombreTextFd.getText());
        List<Cliente> rows = domainModel.getClienteBl().findAll(Cliente.class.getName());
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    
    
    public void seleccionar(int row) {
        model.clearErrors();
        Cliente c1 = model.getClientes().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            Application.APARTADO_VIEW.getModel().getCurrent().setC(c1);
            Application.APARTADO_VIEW.getModel().getCurrent().setCliente(c1.getCedula());
            Application.APARTADO_VIEW.update(model, row);
        } catch (Exception ex) {
            model.setMensaje("Problemas con la Base de Datos");
        }
        Application.APARTADO_VIEW.setVisible(true);
        Application.CLIENTES_APARTADO_VIEW.setVisible(false);
    }
    
    public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
}