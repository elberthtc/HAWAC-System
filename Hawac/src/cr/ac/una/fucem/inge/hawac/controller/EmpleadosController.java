
package cr.ac.una.fucem.inge.hawac.controller;

/*import ferreteria.presentacion.model.EmpleadosModel;
import ferreteria.presentacion.view.EmpleadosView;
import java.util.List;
import ferreteria.Application;
import ferreteria.Session;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.EmpleadoModel;
import ferreteriaentidades.Empleado;*/
import java.util.Arrays;


public class EmpleadosController {
/*    Model domainModel;
    Session session;
    EmpleadosView vista;
    EmpleadosModel modelo;
    
    public EmpleadosController(EmpleadosView vista, EmpleadosModel modelo, Model domainModel,Session session){
        modelo.inicializar();
        this.session=session;
        this.vista=vista;
        this.modelo=modelo;
        this.domainModel=domainModel;
        vista.setController(this);
        vista.setModel(modelo);
        
    }
    
    public void buscar(){
        modelo.borrarErrores();
        modelo.getFiltro().setNombre(vista.nomjTextField.getText());
        List<Empleado> filas= domainModel.searchEmpleados(modelo.getFiltro());
        if(filas.isEmpty()){
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setEmpleados(filas);
    }
    public void buscar2(){
        modelo.borrarErrores();
        modelo.getFiltro().setIdEmpleado(vista.nomjTextField.getText());
        List<Empleado> filas= domainModel.searchEmpleados2(modelo.getFiltro());
        if(filas.isEmpty()){
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setEmpleados(filas);
    }
    
    public void preAgregar(){
        modelo.borrarErrores();
        Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if( !Arrays.asList(Application.ROL_MANAGER).contains(e1.getRol().getDescripcion())){
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        EmpleadoModel empleadoModel=Application.EMPLEADO_VIEW.getModelo();
        empleadoModel.clearErrors();
        empleadoModel.setModo(Application.MODO_AGREGAR);
        empleadoModel.setCurrent(new Empleado());
        Application.EMPLEADO_VIEW.setVisible(true);
    }
    
    public void editar(int fil){
        modelo.borrarErrores();
        EmpleadoModel empleadoModel=Application.EMPLEADO_VIEW.getModelo();
        Empleado seleccionado= modelo.getEmpleados().getFila(fil);
        empleadoModel.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
         if(Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol().getDescripcion())){
            empleadoModel.setModo(Application.MODO_EDITAR);
        }else{
            empleadoModel.setModo(Application.MODO_CONSULTAR);
        }
        empleadoModel.setCurrent(seleccionado);
        Application.EMPLEADO_VIEW.setVisible(true);
    }
    
    public void borrar(int fil){
       modelo.borrarErrores();
       Empleado seleccionado= modelo.getEmpleados().getFila(fil);
       Empleado principal = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
       if( !Arrays.asList(Application.ROL_MANAGER).contains(principal.getRol().getDescripcion())){
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
       try{
           domainModel.deleteEmpleado(seleccionado);
       }catch(Exception ex){}
       List<Empleado> filas = domainModel.searchEmpleados(modelo.getFiltro());
       modelo.setEmpleados(filas);
    }

    public void salir(){
        modelo.borrarErrores();       
        vista.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
        domainModel.close();
    }
  */  
}
