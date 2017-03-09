
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.view.InventariosView;
import hawac.Application;
import hawac.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InventariosController {
    Model domainModel;
    Session session;
    InventariosView vista;
    InventariosModel modelo;
    
    public InventariosController(InventariosView vista, InventariosModel modelo, Model domainModel,Session session){
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
        //modelo.getFiltro().setNombre(vista.nomjTextField.getText());
        List<Inventario> filas= domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i=0;i<filas.size();i++){
            if(filas.get(i).getId().getLocal().compareTo(Application.INVENTARIO)!=0)
                filas.remove(filas.get(i));
        }
        if(filas.isEmpty()){
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setInventarios(filas);
    }
    
    public void buscarPorNombre(){
        modelo.borrarErrores();
       // modelo.getFiltro().setNombre(vista.nomjTextField.getText());
        String nombre = vista.nomjTextField.getText();
        List<Usuario> filas= domainModel.getUsuarioBl().findAll(Usuario.class.getName());
        for(int i = 0; i<filas.size();i++){
            if(filas.get(i).getNombre().indexOf(nombre)==-1){
                filas.remove(filas.get(i));
            }
        }    
        if(filas.isEmpty()){
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        //modelo.setUsuarios(filas);
    }
    
    public void buscarPorId(){
        modelo.borrarErrores();
        //modelo.getFiltro().setIdUsuario(Integer.parseInt(vista.nomjTextField.getText()));
        String nombre = vista.nomjTextField.getText();
        List<Inventario> filas = new ArrayList<Inventario>(); //= domainModel.getInventarioBl().findAll(Inventario.class.getName());
        /*for(int i = 0; i<filas.size();i++){
            if(String.valueOf(filas.get(i).getId().getProducto()).indexOf(nombre)==-1){
                filas.remove(filas.get(i));
            }
        }*/
        filas.add(domainModel.getInventarioBl().findById(new InventarioId(Application.INVENTARIO,Integer.parseInt(nombre))));
        
        
        if(filas.isEmpty()){
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setInventarios(filas);
    }
    
    public void preAgregar(){
        modelo.borrarErrores();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
         if(e1.getTipo() != 0){
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        InventarioModel empleadoModel=Application.INVENTARIO_VIEW.getModelo();
        empleadoModel.clearErrors();
        empleadoModel.setModo(Application.MODO_AGREGAR);
        empleadoModel.setCurrent(new Inventario());
        Application.INVENTARIO_VIEW.setVisible(true);
    }
    
    public void editar(int fil){
        /*modelo.borrarErrores();
        UsuarioModel empleadoModel=Application.EMPLEADO_VIEW.getModelo();
        Usuario seleccionado= modelo.getUsuarios().getFila(fil);
        empleadoModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
         if(principal.getTipo() == 0){
            empleadoModel.setModo(Application.MODO_EDITAR);
        }else{
            empleadoModel.setModo(Application.MODO_CONSULTAR);
        }
        empleadoModel.setCurrent(seleccionado);
        Application.EMPLEADO_VIEW.setVisible(true);*/
    }
    
    public void borrar(int fil){
       modelo.borrarErrores();
       Inventario seleccionado= modelo.getInventarios().getFila(fil);
       Usuario principal = (Usuario) session.getAttribute("Usuario");
       if(principal.getTipo()!=0){
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
       try{
           domainModel.getInventarioBl().delete(seleccionado);
       }catch(Exception ex){}
       List<Inventario> filas = domainModel.getInventarioBl().findAll(Inventario.class.getName());
       modelo.setInventarios(filas);
    }

    public void salir(){
        modelo.borrarErrores();       
        vista.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
}
