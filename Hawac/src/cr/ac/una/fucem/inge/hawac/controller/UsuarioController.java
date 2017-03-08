
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.UsuarioView;
import hawac.Application;
import hawac.Session;
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
        UsuariosModel empleadosModel= Application.EMPLEADOS_VIEW.getModel();
        
        Usuario empleadoNuevo= new Usuario();
        if(view.idTextField.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        } else if(!Model.isNumeric(view.idTextField.getText())){
            model.getErrores().put("id", "Id debe ser numerico");
        } else{
            empleadoNuevo.setIdUsuario(Integer.parseInt(view.idTextField.getText()));
        }
        
        empleadoNuevo.setPassword(view.passwordText.getText());
        if(empleadoNuevo.getPassword().length()==0){
            model.getErrores().put("password", "Contraseña Requerida");
        }
        
        empleadoNuevo.setNombre(view.nombreTextField.getText());
        if(view.idTextField.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
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
                        domainModel.getUsuarioBl().save(empleadoNuevo);
                        model.setMensaje("EMPLEADO AGREGADO");
                        model.setCurrent(new Usuario());  
                        empleados=domainModel.getUsuarioBl().findAll(Usuario.class.getName());
                        empleadosModel.setUsuarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
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
