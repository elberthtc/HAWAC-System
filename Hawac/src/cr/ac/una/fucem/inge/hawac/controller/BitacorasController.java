/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.BitacorasModel;
import cr.ac.una.fucem.inge.hawac.model.BitacorasModel;
import cr.ac.una.fucem.inge.hawac.view.BitacorasView;
import cr.ac.una.fucem.inge.hawac.view.BitacorasView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BitacorasController {

    Model domainModel;
    Session session;
    BitacorasView view;
    BitacorasModel model;

    public BitacorasController(BitacorasView view, Session session, BitacorasModel model, Model domainModel) {
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
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Bitacora> rows = encontrarTodas();
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setBitacoras(rows);
    }
    
    public List<Bitacora> encontrarTodas(){
        List<Bitacora> rows = domainModel.getBitacoraBl().findAll(Bitacora.class.getName());
        for(int i = 0;i<rows.size();i++){
            rows.get(i).setU(domainModel.getUsuarioBl().findById(rows.get(i).getUsuario()));
        }
        return rows;
    }

    public void buscarPorDescripcion() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Bitacora> rows = encontrarTodas();
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
        model.setBitacoras(rows);
    }

    public void buscarPorUsuario() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Bitacora> rows = encontrarTodas();
        List<Bitacora> aux = new LinkedList<Bitacora>();
        for(int i = 0; i< rows.size();i++){       
            if (rows.get(i).getU().getNombre().toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase()) != -1 || String.valueOf(rows.get(i).getUsuario()).toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase()) != -1) {
                aux.add(rows.get(i));
            }
        }
        if (aux.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setBitacoras(aux);
    }
    
    public void buscarPorFecha(Date a){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Bitacora> rows = encontrarTodas();
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (!mismoDia(a,rows.get(i).getFecha())) {
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
        model.setBitacoras(rows);
    }
    
    public boolean mismoDia(Date a,Date b){
        return a.getDate() == b.getDate() && a.getMonth() == b.getMonth() && a.getYear() == b.getYear();
    }
    
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
