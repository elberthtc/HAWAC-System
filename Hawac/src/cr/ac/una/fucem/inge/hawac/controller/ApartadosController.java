/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ApartadoModel;
import cr.ac.una.fucem.inge.hawac.model.ApartadosModel;
import cr.ac.una.fucem.inge.hawac.view.ApartadosView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ApartadosController {

    Model domainModel;
    Session session;
    ApartadosView view;
    ApartadosModel model;

    public ApartadosController(ApartadosView view, Session session, ApartadosModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
     
        
        
        model.clearErrors();
        model.getFilter().getC().setNombre(view.descripcionText.getText());
        List<Apartado> rows = domainModel.getApartadoBl().findAll(Apartado.class.getName());
        for(int i = 0; i < rows.size(); i++){
            rows.get(i).setC(domainModel.getClienteBl().findById(rows.get(i).getCliente()));
            rows.get(i).setP(domainModel.getProductoBl().findById(rows.get(i).getProducto()));
            rows.get(i).setU(domainModel.getUsuarioBl().findById(rows.get(i).getUsuario()));
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setApartados(rows);
        
    }

    public void buscarPorCliente() {
        model.clearErrors();
        model.getFilter().getC().setNombre(view.descripcionText.getText());
        List<Apartado> rows = domainModel.getApartadoBl().findAll(Apartado.class.getName());
        int i = 0, cont = rows.size();
        
        for(int j = 0; j<rows.size();j++){
            rows.get(j).setC(domainModel.getClienteBl().findById(rows.get(j).getCliente()));
            rows.get(j).setP(domainModel.getProductoBl().findById(rows.get(j).getProducto()));
            rows.get(j).setU(domainModel.getUsuarioBl().findById(rows.get(j).getUsuario()));
        }
        
        while (i < rows.size() && cont > 0) {
            if (rows.get(i).getC().getNombre().toLowerCase().indexOf(view.descripcionText.getText().toLowerCase()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setApartados(rows);
        
    }

    public void buscarPorCodigo() {
        model.clearErrors();
        List<Apartado> rows = domainModel.getApartadoBl().findAll(Apartado.class.getName());
        int i = 0, cont = rows.size();
        for(int j = 0; j<rows.size();j++){
            rows.get(j).setC(domainModel.getClienteBl().findById(rows.get(j).getCliente()));
            rows.get(j).setP(domainModel.getProductoBl().findById(rows.get(j).getProducto()));
            rows.get(j).setU(domainModel.getUsuarioBl().findById(rows.get(j).getUsuario()));
        }
        while (i < rows.size() && cont > 0) {
            if (String.valueOf(rows.get(i).getIdApartado()).indexOf(view.descripcionText.getText()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setApartados(rows);
        
    }

    public void borrar(int row) {
        model.clearErrors();
        Apartado p1 = model.getApartados().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            domainModel.getApartadoBl().delete(p1);
        } catch (Exception ex) {
        }
        List<Apartado> rowsMod = domainModel.getApartadoBl().findAll(Apartado.class.getName());
        model.setApartados(rowsMod);
    }

    public void abrirAbonos(int row) {
        model.clearErrors();
        Apartado p1 = model.getApartados().getRowAt(row);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        List<Abono> rows = domainModel.getAbonoBl().findAll(Abono.class.getName());
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (rows.get(i).getApartado() != p1.getIdApartado()) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        for (int j = 0; j < rows.size(); j++) {
            rows.get(j).setA(domainModel.getApartadoBl().findById(rows.get(j).getApartado()));
            rows.get(j).setU(domainModel.getUsuarioBl().findById(rows.get(j).getUsuario()));
        }
        Application.ABONOS_VIEW.setVisible(true);
        Application.ABONOS_VIEW.getModel().getFilter().setA(p1);
        Application.ABONOS_VIEW.getModel().getFilter().setApartado(p1.getIdApartado());
        /*if (rows.isEmpty()) {
            Application.ABONOS_VIEW.getModel().getErrores().put("DescripcionText", "Ningun registro coincide");
            Application.ABONOS_VIEW.getModel().setMensaje("AUN NO EXISTEN ABONOS");
        }*/
        Application.ABONOS_VIEW.getModel().setAbonos(rows);
    }
    
    public void preAgregar() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ApartadoModel apartadoModel = Application.APARTADO_VIEW.getModel();
        apartadoModel.clearErrors();
        apartadoModel.setModo(Application.MODO_AGREGAR);
        apartadoModel.setCurrent(new Apartado());
        Application.APARTADO_VIEW.setVisible(true);
    }
    
    /*

    public void editar(int row) {
        model.clearErrors();
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        Producto c1 = model.getProductos().getRowAt(row);
        productoModel.clearErrors();
        Usuario principal = (Usuario) session.getAttribute("Usuario");
        if (principal.getTipo() == 0) {
            productoModel.setModo(Application.MODO_EDITAR);
        } else {
            productoModel.setModo(Application.MODO_CONSULTAR);
        }
        productoModel.setCurrent(c1);
        Application.PRODUCTO_VIEW.setVisible(true);
    }
    
    
   */

    public void salir() {
        model.clearErrors();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }
}