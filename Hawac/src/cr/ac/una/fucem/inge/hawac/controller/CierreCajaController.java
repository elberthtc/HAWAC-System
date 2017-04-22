/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.CierreCajaModel;
import cr.ac.una.fucem.inge.hawac.view.CierreCajaView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Date;


public class CierreCajaController {
    Model domainModel;
    Session session;
    CierreCajaModel model;
    CierreCajaView view;
    
    public CierreCajaController( CierreCajaView view,CierreCajaModel model,Model domainModel,Session session){
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session= session;
        model.init();
        view.setController(this);
        view.setModel(model);  
}
    
    public void buscar(){
        model.clearErrors();
         Usuario e1 = (Usuario) session.getAttribute("Usuario");
         if(e1.tipo()==-1){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        //model.getFiltro().getCliente().setNombre(view.nombreTextFd.getText());
        List<Factura> rows = encontrarTodas();
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }
 
    /*
    
    public void buscarPorNumero() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.tipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        List<Factura> rows = encontrarTodas();
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (String.valueOf(rows.get(i).getCodigoFactura()).toLowerCase().indexOf(view.nombreTF.getText().toLowerCase()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("nombreTextFd", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }

    public void buscarPorCliente() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.tipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        List<Factura> rows = encontrarTodas();
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (rows.get(i).getC().getNombre().toLowerCase().indexOf(view.nombreTF.getText().toLowerCase()) == -1) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("nombreTextFd", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }
*/  
    public void vendidoEntreFechas(Date a, Date b) {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.tipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        List<Factura> rows = encontrarTodas();
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (!estaEntreFechas(a,b,rows.get(i).getFecha())) {
                rows.remove(rows.get(i));
            } else {
                i++;
            }
            cont--;
        }
        if (rows.isEmpty()) {
            model.getErrores().put("nombreTextFd", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
        model.setFacturasLista(rows);
    }
    
    public void vendidoHoy() {
        model.clearErrors();
        Date a = new Date();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.tipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        List<Factura> rows = encontrarTodas();
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
            model.getErrores().put("nombreTextFd", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
        model.setFacturasLista(rows);
    }
    
    public double totalVendido(){
        List<Factura> facturas = model.getFacturasLista();
        if(facturas.size()!=0){
            double suma = 0;
            for(int i = 0; i<facturas.size();i++){
                suma = suma + facturas.get(i).getMonto();
            }
            return suma;
        }
        return 0;
    }
    
    public void vendidoHoyB(){
        vendidoHoy();
        view.montoL.setText(totalVendido() + "");
    }
    
    public void vendidoEntreFechasB(Date a, Date b){
        vendidoEntreFechas(a,b);
        view.montoL.setText(totalVendido() + "");
    }
    
    public List<Factura> encontrarTodas(){
        List<Factura> rows = domainModel.getFacturaBl().findAll(Factura.class.getName());
        for(int i = 0; i< rows.size(); i++){
            rows.get(i).setC(domainModel.getClienteBl().findById(rows.get(i).getCliente()));
            rows.get(i).setU(domainModel.getUsuarioBl().findById(rows.get(i).getUsuario()));
        }
        return rows;
    }
    
    public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
    public boolean mismoDia(Date a,Date b){
        return a.getDate() == b.getDate() && a.getMonth() == b.getMonth() && a.getYear() == b.getYear();
    }
    
    public boolean estaEntreFechas(Date a, Date b, Date c) {
//        int k = c.getYear();
//        long x=a.getTime(),y=c.getTime(), z=b.getTime();
//        boolean h = a.getTime()<=c.getTime() && c.getTime()<=b.getTime();
//        return a.getTime()<=c.getTime() && c.getTime()<=b.getTime();
        int da = a.getDate(), db = b.getDate(), dc = c.getDate();
        int ma = a.getMonth(), mb = b.getMonth(), mc = c.getMonth();
        int aa = a.getYear(), ab = b.getYear(), ac = c.getYear();
        if (aa <= ac && ac <= ab) {
            if (ma <= mc && mc <= mb) {
                if (da <= dc && dc <= db) {
                    return true;
                }
            }
        }
        return false;
    }
}
