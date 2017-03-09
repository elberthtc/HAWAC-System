
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.view.InventarioView;
import hawac.Application;
import hawac.Session;
import java.util.List;

public class InventarioController {
    Model domainModel;
    Session session; 
    InventarioView view;
    InventarioModel model;
    
    public InventarioController(InventarioView view, InventarioModel model, Model domainmodel, Session session){
        this.domainModel=domainmodel;
        this.session=session;
        this.view=view;
        this.model=model;
        model.init();
        view.setController(this);
        view.setModelo(model);
    }
    
    public void abrirProductos(){
       Application.PRODUCTOINVENTARIO_VIEW.setVisible(true);
    }
    
    public void guardar(){
       /* model.clearErrors();
        InventariosModel empleadosModel= Application.INVENTARIOS_VIEW.getModel();
        
        Inventario empleadoNuevo= new Inventario();
        if(view.idTextField.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        } else if(!Model.isNumeric(view.idTextField.getText())){
            model.getErrores().put("id", "Id debe ser numerico");
        } else{
            empleadoNuevo.setIdInventario(Integer.parseInt(view.idTextField.getText()));
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
        List<Inventario> empleados;
        if(model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.getInventarioBl().save(empleadoNuevo);
                        model.setMensaje("EMPLEADO AGREGADO");
                        model.setCurrent(new Inventario());  
                        empleados=domainModel.getInventarioBl().findAll(Inventario.class.getName());
                        empleadosModel.setInventarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.getInventarioBl().merge(empleadoNuevo);
                        model.setMensaje("EMPLEADO MODIFICADO");
                        model.setCurrent(empleadoNuevo);
                        empleados= domainModel.getInventarioBl().findAll(Inventario.class.getName());
                        empleadosModel.setInventarios(empleados);
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
