/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ApplicationModel;
import cr.ac.una.fucem.inge.hawac.view.ApplicationView;
import hawac.Application;
import hawac.Session;
import java.util.Date;

public class ApplicationController {

    Model domainModel;
    Session session;
    ApplicationView view;
    ApplicationModel model;

    public ApplicationController(ApplicationView view, ApplicationModel model, Model domainModel, Session session) {
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void enter() {
        Application.CLIENTES_VIEW.getModel().init();
        Application.PRODUCTOS_VIEW.getModel().init();
        Application.BITACORAS_VIEW.getModel().init();
        Application.CLIENTES_FACTURA_VIEW.getModel().init();
        Application.CLIENTES_APARTADO_VIEW.getModel().init();
        Application.USUARIOS_VIEW.getModel().inicializar();
        Application.INVENTARIO_VIEW.getModelo().init();
        Application.INVENTARIO_TIENDA_VIEW.getModel().inicializar();
        Application.INVENTARIO_FABRICA_VIEW.getModel().inicializar();
        //Application.FACTURA_COMPRA_VIEW.getModel().init();
        Application.PRODUCTOFACTURA_VIEW.getModel().init();
        Application.PRODUCTO_APARTADO_VIEW.getModel().init();
        Application.PRODUCTOINVENTARIO_VIEW.getModel().init();
        //Application.FACTURAS_VENTAS_VIEW.getModel().init();
        Application.FACTURAS_PAGADAS_VIEW.getModel().init();
        Application.CIERRE_CAJA_VIEW.getModel().init();
        Application.APARTADOS_VIEW.getModel().init();
        Application.ABONOS_VIEW.getModel().init();
        Application.APPLICATION_VIEW.getModel().init();
        Application.FACTURA_VIEW.getModel().init();
        Application.APPLICATION_VIEW.getModel().setCurrent(Application.USUARIO);
        view.setVisible(true);

    }

    public void exit() {
        Application.CLIENTES_VIEW.setVisible(false);
        Application.PRODUCTOS_VIEW.setVisible(false);
        Application.BITACORAS_VIEW.setVisible(false);
        Application.APARTADOS_VIEW.setVisible(false);
        Application.ABONOS_VIEW.setVisible(false);
        Application.USUARIOS_VIEW.setVisible(false);
        Application.CLIENTES_FACTURA_VIEW.setVisible(false);
        Application.CLIENTES_APARTADO_VIEW.setVisible(false);
        Application.PRODUCTOFACTURA_VIEW.setVisible(false);
        Application.PRODUCTO_APARTADO_VIEW.setVisible(false);
        Application.FACTURA_VIEW.setVisible(false);
        Application.FACTURAS_PAGADAS_VIEW.setVisible(false);
        Application.CIERRE_CAJA_VIEW.setVisible(false);
        view.setVisible(false);
        Application.INVENTARIO_VIEW.setVisible(false);
        Application.PRODUCTOINVENTARIO_VIEW.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(),Application.USUARIO.getNombre()+" ha Cerrado Cesión.",new Date());
        domainModel.getBitacoraBl().save(b);
    }

    public void clientesShow() {
        Application.CLIENTES_VIEW.setVisible(true);
    }

    public void productosShow() {
        Application.PRODUCTOS_VIEW.setVisible(true);
    }

    public void cierreShow(){
        Application.CIERRE_CAJA_VIEW.setVisible(true);
    }
    
    public void apartadosShow() {
        Application.APARTADOS_VIEW.setVisible(true);
    }
    
    public void bitacorasShow(){
        Application.BITACORAS_VIEW.setVisible(true);
    }
    
    public void empleadosShow() {
        Application.USUARIOS_VIEW.setVisible(true);
    }

    public void facturaShow() {
        Application.FACTURA_VIEW.setVisible(true);
    }

    public void cobrosShow() {
        //Application.FACTURAS_VENTAS_VIEW.setVisible(true);
    }

    public void despachosShow() {
        Application.FACTURAS_PAGADAS_VIEW.setVisible(true);
    }

    public void facturaCompraShow() {
        //Application.FACTURA_COMPRA_VIEW.setVisible(true);
    }

    public void about() {
        Application.ABOUT.setVisible(true);
    }

    public void inventarioMenuShow(){
        Application.INVENTARIO_MENU.setVisible(true);
    }
}
