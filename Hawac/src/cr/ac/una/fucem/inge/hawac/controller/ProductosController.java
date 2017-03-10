/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductosView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProductosController {

    Model domainModel;
    Session session;
    ProductosView view;
    ProductosModel model;

    public ProductosController(ProductosView view, Session session, ProductosModel model, Model domainModel) {
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
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        if (rows.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);

    }

    public void buscarPorDescripcion() {
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
    }

    public void buscarPorCodigo() {
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName());
        //for (int i = 0; i < rows.size(); i++) {
        int i = 0, cont = rows.size();
        while (i < rows.size() && cont > 0) {
            if (String.valueOf(rows.get(i).getIdProducto()).indexOf(view.DescripcionText.getText()) == -1) {
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
    }

    public void borrar(int row) {
        model.clearErrors();
        Producto p1 = model.getProductos().getRowAt(row);
        List<Inventario> inventarioLista = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            for (int i = 0; i < inventarioLista.size(); i++) {
                if (inventarioLista.get(i).getId().getProducto() == p1.getIdProducto()) {
                    domainModel.getInventarioBl().delete(inventarioLista.get(i));
                }
            }
            domainModel.getProductoBl().delete(p1);
        } catch (Exception ex) {
        }
        List<Producto> rowsMod = domainModel.getProductoBl().findAll(Producto.class.getName());
        model.setProductos(rowsMod);
    }

    public void preAgregar() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        productoModel.clearErrors();
        productoModel.setModo(Application.MODO_AGREGAR);
        productoModel.setCurrent(new Producto());
        Application.PRODUCTO_VIEW.setVisible(true);
    }

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
