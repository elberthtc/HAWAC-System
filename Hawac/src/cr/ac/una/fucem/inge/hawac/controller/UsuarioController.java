
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.EmpleadoView;
import hawac.Application;
import hawac.Session;
import java.util.List;
/*import ferreteria.Application;
import ferreteriaentidades.Usuario;
import ferreteriaentidades.Rol;
import ferreteria.logic.Model;
import ferreteria.Session;
import ferreteria.presentacion.model.UsuarioModel;
import ferreteria.presentacion.model.UsuariosModel;
import ferreteria.presentacion.view.UsuarioView;*/

public class UsuarioController {
    Model domainModel;
    Session session; 
    EmpleadoView view;
    UsuarioModel model;
    
    public UsuarioController(EmpleadoView view, UsuarioModel model, Model domainmodel, Session session){
        this.domainModel=domainmodel;
        this.session=session;
        this.view=view;
        this.model=model;
        model.init();
        //view.setController(this);
        //view.setModelo(model);
    }
    
    public void guardar(){
        model.clearErrors();
        //UsuariosModel empleadosModel= Application.EMPLEADOS_VIEW.getModel();
        
        Usuario empleadoNuevo= new Usuario();
        empleadoNuevo.setIdUsuario(Integer.parseInt(view.idTextField.getText()));
        if(view.nombreTextField.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        
        /*empleadoNuevo.setNombre(view.nombreTextField.getText());
        if(view.idTextField.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }*/
        
        /*empleadoNuevo.setRol((Rol) view.RolComboBox.getSelectedItem());
        if(empleadoNuevo.getRol().getDescripcion().equals(Application.ROL_MANAGER)){
            empleadoNuevo.setClave("001");
        }
        if(empleadoNuevo.getRol().getDescripcion().equals(Application.ROL_SELLER)){
            empleadoNuevo.setClave("002");
        }
        if(empleadoNuevo.getRol().getDescripcion().equals(Application.ROL_CASHIER)){
            empleadoNuevo.setClave("003");
        }
        if(empleadoNuevo.getRol().getDescripcion().equals(Application.ROL_DISPATCHER)){
            empleadoNuevo.setClave("004");
        }
        if(empleadoNuevo.getRol().getDescripcion().equals(Application.ROL_STOREKEEPER)){
            empleadoNuevo.setClave("005");
        }
         
        List<Usuario> empleados;
        if(model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.addUsuario(empleadoNuevo);
                        model.setMensaje("EMPLEADO AGREGADO");
                        model.setCurrent(new Usuario());  
                        empleados=domainModel.searchUsuarios(empleadosModel.getFiltro());
                        empleadosModel.setUsuarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.updateUsuario(empleadoNuevo);
                        model.setMensaje("EMPLEADO MODIFICADO");
                        model.setCurrent(empleadoNuevo);
                        empleados= domainModel.searchUsuarios(empleadosModel.getFiltro());
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
        */
    }
}
