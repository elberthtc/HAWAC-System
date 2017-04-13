/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.LoginModel;
import cr.ac.una.fucem.inge.hawac.view.LoginView;
import hawac.Application;
import hawac.Session;

public class LoginController {
    
    Model domainModel;
    Session session;    
    LoginView view;
    LoginModel model;
    
     public LoginController(LoginView view, LoginModel model, Model domainModel, Session session) {
        this.domainModel= domainModel;
        this.session=session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void login(){
        model.clearErrors();
        Usuario e1 = model.getCurrent();
        if (view.idTextField.getText().equals("") || !cr.ac.una.fucem.inge.hawac.logic.Model.isNumeric(view.idTextField.getText())){
            model.getErrores().put("Id", "Id requerido");
        }
        else {
            e1.setIdUsuario(Integer.parseInt(view.idTextField.getText()));
        }
        e1.setPassword(new String(view.claveTextField.getPassword()));
        if (view.claveTextField.getPassword().length == 0) {
            model.getErrores().put("Clave", "Clave Requerida");
        }
        if (model.getErrores().isEmpty()) {
            Usuario real = domainModel.getUsuario(e1.getIdUsuario(), e1.getPassword());
            if (real != null) {
                session.setAttibute("Usuario", real);
                view.setVisible(false);
                Application.USUARIO = real;
                Application.APPLICATION_VIEW.getController().enter();
                Application.FACTURA_VIEW.getModel().setEmpleado(real);
                Application.APPLICATION_VIEW.update(Application.APPLICATION_VIEW.getModel(),0);
            } else {
                model.setMensaje("Datos incorrectos");
                e1.setPassword("");
                e1.setIdUsuario(0);
                model.setCurrent(e1);
            }
        } else {
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
            model.setCurrent(e1);
        }
    }

    public void logout(){
        model.clearErrors();
        session.removeAttribute("Usuario");
        model.setCurrent(new Usuario());
        view.setVisible(true);
    }
    
    public void exit(){
        System.exit(0);
    }
}
