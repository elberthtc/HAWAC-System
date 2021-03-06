/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;

public class ProductoController {

    Model domainModel;
    ProductoView view;
    ProductoModel model;
    Session session;

    public ProductoController(ProductoView view, ProductoModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel = domainModel;
        this.view = view;
        this.model = model;
        this.session = session;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar() {
        model.clearErrors();
        ProductosModel productosModel = Application.PRODUCTOS_VIEW.getModel();
        Producto p1 = new Producto();
        Inventario i1 = new Inventario();
        if (view.CodigoText.getText().length() == 0) {
            model.getErrores().put("Codigo", "Codigo requerido");
        }else if(Model.isNumeric(view.CodigoText.getText())){
            //int m = Integer.parseInt(view.CodigoText.getText());
            p1.setIdProducto(Integer.parseInt(view.CodigoText.getText()));
            i1.setProducto(p1);
        }else{
            model.getErrores().put("Codigo", "El codigo debe ser Numerico");
        }
        p1.setDescripcion(view.DescripcionText.getText());
        if (view.DescripcionText.getText().length() == 0) {
            model.getErrores().put("Descripcion", "Descripcion requerida");
        }
        
        if (isNumeric2(view.PrecioText.getText())) {
            double prec = Double.parseDouble(view.PrecioText.getText());
            if (prec == 0.0) {
                model.getErrores().put("Precio", "Digito Invalido");
            }
            p1.setPrecio((float) prec);
        }else{
            model.getErrores().put("Precio", "Precio Incorrecto");
        }
        p1.setColor(view.ColorText.getText());
        
        if (view.ColorText.getText().length() == 0) {
            model.getErrores().put("Color", "Color requerido");
        }
        if( !view.masculinoRB.isSelected() && !view.femeninoRB.isSelected() ){
            view.GeneroLabel.setBorder(Application.BORDER_ERROR);
            view.GeneroLabel.setToolTipText(model.getErrores().get("GeneroLabel"));
        }
        else
            if(view.masculinoRB.isSelected()){
                p1.setGenero(true);
            } 
            else {
                p1.setGenero(false);
            }
        p1.setTalla(view.tallaCB.getSelectedItem().toString());
        

        List<Producto> productos;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha agregado: " + p1.getDescripcion(), new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getProductoBl().save(p1);
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Producto());
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        for (int j = 0; j < productos.size(); j++) {
                            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda", productos.get(j).getIdProducto()));
                            if (inventario != null) {
                                int cantidad = inventario.getCantidad();
                                productos.get(j).setCantidad(cantidad);
                            }
                        }
                        productosModel.setProductos(productos);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Bitacora b1 = new Bitacora(Application.USUARIO.getIdUsuario(), "Ha modificado: " + p1.getDescripcion(), new Date());
                        domainModel.getBitacoraBl().save(b1);
                        domainModel.getProductoBl().merge(p1);
                        model.setMensaje("PRODUCTO MODIFICADO");
                        model.setCurrent(p1);
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        for (int j = 0; j < productos.size(); j++) {
                            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda", productos.get(j).getIdProducto()));
                            if (inventario != null) {
                                int cantidad = inventario.getCantidad();
                                productos.get(j).setCantidad(cantidad);
                            }
                        }
                        productosModel.setProductos(productos);
                        view.setVisible(false);
                        break;
                }
            } catch (Exception e) {
                model.getErrores().put("Codigo", "Producto ya existente");
                model.setMensaje("Producto YA EXISTENTE");
                model.setCurrent(p1);
            }
        } else {
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR O CON FORMATO INCORRECTO POR FAVOR VERIFICAR");
            model.setCurrent(p1);
        }
    }

    private static boolean isNumeric2(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }
}
