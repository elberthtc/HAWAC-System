/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.AbonoModel;
import cr.ac.una.fucem.inge.hawac.model.AbonosModel;
import cr.ac.una.fucem.inge.hawac.model.ApartadoModel;
import cr.ac.una.fucem.inge.hawac.model.ApartadosModel;
import cr.ac.una.fucem.inge.hawac.view.AbonosView;
import cr.ac.una.fucem.inge.hawac.view.ApartadosView;
import hawac.Application;
import hawac.Session;
import java.util.ArrayList;
import java.util.List;

public class AbonosController {

    Model domainModel;
    Session session;
    AbonosView view;
    AbonosModel model;

    public AbonosController(AbonosView view, Session session, AbonosModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
     
        /*
        
        model.clearErrors();
        model.getFilter().getC().setNombre(view.DescripcionText.getText());
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
        
        */
    }

    public void buscarPorDescripcion() {
        
        /*
        
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (rows.get(i).getDescripcion().toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase()) == -1) {
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
        model.setProductos(rows);
        
        */
        
    }

    public void buscarPorCodigo() {
        model.clearErrors();
        List<Abono> rows = new ArrayList<Abono>();
        Abono a = domainModel.getAbonoBl().findById(Integer.parseInt(view.descripcionT.getText()));
        a.setA(domainModel.getApartadoBl().findById(a.getApartado()));
        if(a.getA().getIdApartado()==Application.ABONOS_VIEW.getModel().getFilter().getA().getIdApartado()){
            rows.add(a);
        }
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setAbonos(rows);        
    }

    public void borrar(int row) {
     
        /*
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
        */
        
    }
    
    public void preAgregar() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        AbonoModel abonoModel = Application.ABONO_VIEW.getModel();
        abonoModel.clearErrors();
        abonoModel.setModo(Application.MODO_AGREGAR);
        abonoModel.setCurrent(Application.ABONOS_VIEW.getModel().getFilter());
        Application.ABONO_VIEW.setVisible(true);
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