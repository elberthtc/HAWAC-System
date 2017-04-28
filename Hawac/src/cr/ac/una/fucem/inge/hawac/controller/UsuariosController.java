package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.UsuariosView;
import hawac.Application;
import hawac.Session;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UsuariosController {

    Model domainModel;
    Session session;
    UsuariosView vista;
    UsuariosModel modelo;

    public UsuariosController(UsuariosView vista, UsuariosModel modelo, Model domainModel, Session session) {
        modelo.inicializar();
        this.session = session;
        this.vista = vista;
        this.modelo = modelo;
        this.domainModel = domainModel;
        vista.setController(this);
        vista.setModel(modelo);

    }

    public void buscar() {
        modelo.borrarErrores();
        modelo.getFiltro().setNombre(vista.nombreT.getText());
        List<Usuario> filas = domainModel.getUsuarioBl().findAll(Usuario.class.getName());
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setUsuarios(filas);
    }

    public void buscarPorNombre() {
        modelo.borrarErrores();
        modelo.getFiltro().setNombre(vista.nombreT.getText());
        String nombre = vista.nombreT.getText();
        List<Usuario> filas = domainModel.getUsuarioBl().findAll(Usuario.class.getName());
        //for(int i = 0; i<filas.size();i++){
        int i = 0, cont = filas.size();
        while (i < filas.size() && cont > 0) {
            if (filas.get(i).getNombre().toLowerCase().indexOf(nombre.toLowerCase()) == -1) {
                filas.remove(filas.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setUsuarios(filas);
    }

    public void buscarPorId() {
        modelo.borrarErrores();
        //modelo.getFiltro().setIdUsuario(Integer.parseInt(vista.nomjTextField.getText()));
        String nombre = vista.nombreT.getText();
        List<Usuario> filas = domainModel.getUsuarioBl().findAll(Usuario.class.getName());
        int i = 0, cont = filas.size();
        while (i < filas.size() && cont > 0) {
            if (String.valueOf(filas.get(i).getIdUsuario()).indexOf(nombre) == -1) {
                filas.remove(filas.get(i));
            }else {
                i++;
            }
            cont--;
        }
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
        }
        modelo.setUsuarios(filas);
    }

    public void preAgregar() {
        modelo.borrarErrores();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        UsuarioModel empleadoModel = Application.EMPLEADO_VIEW.getModelo();
        empleadoModel.clearErrors();
        empleadoModel.setModo(Application.MODO_AGREGAR);
        empleadoModel.setCurrent(new Usuario());
        Application.EMPLEADO_VIEW.setVisible(true);
    }

    public void editar(int fil) {
        modelo.borrarErrores();
        UsuarioModel empleadoModel = Application.EMPLEADO_VIEW.getModelo();
        Usuario seleccionado = modelo.getUsuarios().getFila(fil);
        empleadoModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() == 0) {
            empleadoModel.setModo(Application.MODO_EDITAR);
        } else {
            empleadoModel.setModo(Application.MODO_CONSULTAR);
        }
        empleadoModel.setCurrent(seleccionado);
        Application.EMPLEADO_VIEW.setVisible(true);
    }

    public void borrar(int fil) {
        modelo.borrarErrores();
        Usuario seleccionado = modelo.getUsuarios().getFila(fil);
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() != 0) {
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        try {
            Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha eliminado a " + seleccionado.getNombre(), new Date());
            domainModel.getBitacoraBl().save(b);
            domainModel.getUsuarioBl().delete(seleccionado);
        } catch (Exception ex) {
        }
        List<Usuario> filas = domainModel.getUsuarioBl().findAll(Usuario.class.getName());
        modelo.setUsuarios(filas);
    }

    public void salir() {
        modelo.borrarErrores();
        vista.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }

}
