package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.UsuarioView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;

public class UsuarioController {
    Model domainModel;
    Session session; 
    UsuarioView view;
    UsuarioModel model;
    
    public UsuarioController(UsuarioView view, UsuarioModel model, Model domainmodel, Session session){
        this.domainModel=domainmodel;
        this.session=session;
        this.view=view;
        this.model=model;
        model.init();
        view.setController(this);
        view.setModelo(model);
    }
    
    public void guardar(){
        model.clearErrors();
        UsuariosModel empleadosModel= Application.USUARIOS_VIEW.getModel();
        Usuario empleadoNuevo= new Usuario();
        if(view.idTextField.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
            view.IdLb.setBorder(Application.BORDER_ERROR);
        } else if(!Model.isNumeric(view.idTextField.getText())){
            model.getErrores().put("id", "Id debe ser numerico");
            view.IdLb.setBorder(Application.BORDER_ERROR);
        } else{
            empleadoNuevo.setIdUsuario(Integer.parseInt(view.idTextField.getText()));
        }
        empleadoNuevo.setPassword(view.passwordText.getText());
        if(empleadoNuevo.getPassword().length()==0){
            model.getErrores().put("password", "Contraseña Requerida");
            view.passwordLB.setBorder(Application.BORDER_ERROR);
        }
        empleadoNuevo.setNombre(view.nombreTextField.getText());
        if(view.nombreTextField.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
            view.nombreLb.setBorder(Application.BORDER_ERROR);
        }
        if(view.administradorRB.isSelected()){
            empleadoNuevo.setTipo(0);
        } else {
            empleadoNuevo.setTipo(1);
        }
        List<Usuario> empleados;
        if(model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha agregado a " + empleadoNuevo.getNombre(), new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getUsuarioBl().save(empleadoNuevo);
                        model.setMensaje("EMPLEADO AGREGADO");
                        model.setCurrent(new Usuario());  
                        empleados=domainModel.getUsuarioBl().findAll(Usuario.class.getName());
                        empleadosModel.setUsuarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Bitacora b1 = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha modificado a " + empleadoNuevo, new Date());
                        domainModel.getBitacoraBl().save(b1);
                        domainModel.getUsuarioBl().merge(empleadoNuevo);
                        model.setMensaje("EMPLEADO MODIFICADO");
                        model.setCurrent(empleadoNuevo);
                        empleados= domainModel.getUsuarioBl().findAll(Usuario.class.getName());
                        empleadosModel.setUsuarios(empleados);
                        view.setVisible(false);
                        break;
                }
            } catch(Exception e){
                model.getErrores().put("id", "Usuario ya existe");
                model.setMensaje("EMPLEADO YA EXISTE");
                model.setCurrent(empleadoNuevo);
            }
        }   
        else{
            model.setMensaje("HAY ERRORES");
            model.setCurrent(empleadoNuevo);
        }
    }
}