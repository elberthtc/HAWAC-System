package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.view.InventariosView;
import hawac.Application;
import hawac.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class InventariosController {

    Model domainModel;
    Session session;
    InventariosView vista;
    InventariosModel modelo;

    public InventariosController(InventariosView vista, InventariosModel modelo, Model domainModel, Session session) {
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
        //modelo.getFiltro().setNombre(vista.nomjTextField.getText());
        List<Inventario> filas = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for (int j = 0; j < filas.size(); j++) {
            filas.get(j).setProducto(domainModel.getProductoBl().findById(filas.get(j).getId().getProducto()));
        }
        int i = 0, cont = filas.size();
        while (filas.size() > 0 && cont > 0) {
            if (filas.get(i).getId().getLocal().compareTo(Application.INVENTARIO) != 0) {
                filas.remove(filas.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
            JOptionPane.showMessageDialog(vista, modelo.getMensaje());
        }
        modelo.setInventarios(filas);
    }

    public void buscarPorDescripcion() {
        modelo.borrarErrores();
        String nombre = vista.nombreTF.getText();
        List<Inventario> filas = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for (int j = 0; j < filas.size(); j++) {
            filas.get(j).setProducto(domainModel.getProductoBl().findById(filas.get(j).getId().getProducto()));
        }
        int i = 0, cont = filas.size();
        while (filas.size() > 0 && cont > 0) {
            if (filas.get(i).getProducto().getDescripcion().toLowerCase().indexOf(nombre.toLowerCase()) != 0) {
                filas.remove(filas.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
            JOptionPane.showMessageDialog(vista, modelo.getMensaje());
        } else {
            modelo.setInventarios(filas);
        }
    }

    public void buscarPorId() {
        modelo.borrarErrores();
        String nombre = vista.nombreTF.getText();
        List<Inventario> filas = new ArrayList<Inventario>();
        Inventario f = domainModel.getInventarioBl().findById(new InventarioId(Application.INVENTARIO, Integer.parseInt(nombre)));
        if (f != null) {
            f.setProducto(domainModel.getProductoBl().findById(f.getId().getProducto()));
            filas.add(f);
        }
        if (filas.isEmpty()) {
            modelo.getErrores().put("nomjTextField", "Ningún registro coincide con la busqueda");
            modelo.setMensaje("NINGUN REGISTRO COINCIDE CON LA BUSQUEDA");
            JOptionPane.showMessageDialog(vista, modelo.getMensaje());
        }
        modelo.setInventarios(filas);
    }

    public void preAgregar() {
        modelo.borrarErrores();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        InventarioModel empleadoModel = Application.INVENTARIO_VIEW.getModelo();
        empleadoModel.clearErrors();
        empleadoModel.setModo(Application.MODO_AGREGAR);
        empleadoModel.setCurrent(new Inventario());
        Application.INVENTARIO_VIEW.setVisible(true);
    }

    public void editar(int fil) {
        modelo.borrarErrores();
        InventarioModel inventarioModel = Application.INVENTARIO_VIEW.getModelo();
        Inventario seleccionado = modelo.getInventarios().getFila(fil);
        inventarioModel.setProductoActual(domainModel.getProductoBl().findById(seleccionado.getId().getProducto()));
        inventarioModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() == 0) {
            inventarioModel.setModo(Application.MODO_EDITAR);
        } else {
            inventarioModel.setModo(Application.MODO_CONSULTAR);
        }
        Application.INVENTARIO_VIEW.getModelo().setCurrent(seleccionado);
        Application.INVENTARIO_VIEW.getModelo().setProductoActual(seleccionado.getProducto());
        inventarioModel.setCurrent(seleccionado);
        Application.INVENTARIO_VIEW.setVisible(true);
    }

    public void borrar(int fil) {
        modelo.borrarErrores();
        Inventario seleccionado = modelo.getInventarios().getFila(fil);
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() != 0) {
            modelo.setMensaje(Application.ROL_NOTAUTHORIZED);
            modelo.commit();
            return;
        }
        try {
            domainModel.getInventarioBl().delete(seleccionado);
            Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha eliminado " + seleccionado.getProducto().getDescripcion() + " del Inventario", new Date());
            domainModel.getBitacoraBl().save(b);
        } catch (Exception ex) {
        }
        List<Inventario> filas = domainModel.getInventario();
        modelo.setInventarios(filas);
    }

    public void salir() {
        modelo.borrarErrores();
        vista.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
}
