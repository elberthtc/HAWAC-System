/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

//import ferreteria.Application;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ApplicationModel;
import cr.ac.una.fucem.inge.hawac.view.ApplicationView;
import hawac.Application;
import hawac.Session;

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
        Application.CLIENTES_FACTURA_VIEW.getModel().init();
        Application.EMPLEADOS_VIEW.getModel().inicializar();
        Application.FACTURA_VIEW.getModel().init();
        Application.INVENTARIOS_VIEW.getModel().inicializar();
        //Application.FACTURA_COMPRA_VIEW.getModel().init();
        Application.PRODUCTOFACTURA_VIEW.getModel().init();
        Application.FACTURAS_VENTAS_VIEW.getModel().init();
        //Application.FACTURAS_PAGADAS_VIEW.getModel().init();
        Application.APPLICATION_VIEW.getModel().init();
        Application.APPLICATION_VIEW.getModel().setCurrent((Usuario) session.getAttribute("Usuario"));
        view.setVisible(true);

    }

    public void exit() {
        Application.CLIENTES_VIEW.setVisible(false);
        Application.PRODUCTOS_VIEW.setVisible(false);
        Application.EMPLEADOS_VIEW.setVisible(false);
        Application.CLIENTES_FACTURA_VIEW.setVisible(false);
        Application.PRODUCTOFACTURA_VIEW.setVisible(false);
        Application.FACTURA_VIEW.setVisible(false);
        Application.FACTURAS_VENTAS_VIEW.setVisible(false);
        //Application.FACTURAS_PAGADAS_VIEW.setVisible(false);
        //Application.FACTURA_COMPRA_VIEW.setVisible(false);
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }

    public void clientesShow() {
        Application.CLIENTES_VIEW.setVisible(true);
    }

    public void productosShow() {
        Application.PRODUCTOS_VIEW.setVisible(true);
    }

    public void empleadosShow() {
        Application.EMPLEADOS_VIEW.setVisible(true);
    }

    public void facturaShow() {
        Application.FACTURA_VIEW.setVisible(true);
    }

    public void cobrosShow() {
        Application.FACTURAS_VENTAS_VIEW.setVisible(true);
    }

    public void despachosShow() {
        //Application.FACTURAS_PAGADAS_VIEW.setVisible(true);
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
