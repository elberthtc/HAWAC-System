/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoView;
import hawac.Application;
import hawac.Session;
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
        }
        p1.setDescripcion(view.DescripcionText.getText());
        if (view.DescripcionText.getText().length() == 0) {
            model.getErrores().put("Descripcion", "Descripcion requerida");
        }

        if (Model.isNumeric(view.cantidadText.getText())) {
            int ex = Integer.parseInt(view.cantidadText.getText());
            if (ex == 0 || ex%1 != 0) {
                model.getErrores().put("Cantidad", "Digito Invalido");
            }
            i1.setCantidad(ex);
        } else if (view.cantidadText.getText().compareTo("NO PERMITIDO")!=0){
            model.getErrores().put("Cantidad", "Digite Solo numeros");
        }
        
        if (view.cantidadText.getText().length() == 0) {
            model.getErrores().put("Cantidad", "Cantidad requerida");
        }
        
        if (isNumeric2(view.PrecioText.getText())) {
            double prec = Double.parseDouble(view.PrecioText.getText());
            if (prec == 0.0) {
                model.getErrores().put("Precio", "Digito Invalido");
            }
            p1.setPrecio((float) prec);
        }
        if (view.PrecioText.getText().length() == 0) {
            model.getErrores().put("Precio", "Precio Requerido");
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
        
        InventarioId inventarioId = new InventarioId();
        inventarioId.setProducto(p1.getIdProducto());
        if( !view.tiendaRB.isSelected() && !view.fabricaRB.isSelected() ){
            view.inventarioLabel.setBorder(Application.BORDER_ERROR);
            view.inventarioLabel.setToolTipText(model.getErrores().get("inventarioLabel"));
        }
        else
            if(view.tiendaRB.isSelected()){
                inventarioId.setLocal(view.tiendaRB.getText());
                i1.setId(inventarioId);
            } 
            else{
                inventarioId.setLocal(view.fabricaRB.getText());
            }
        System.out.println(view.tallaCB.getSelectedItem().toString());
        p1.setTalla(view.tallaCB.getSelectedItem().toString());
        i1.setEstado(view.estadoCB.getSelectedItem().toString());
        
        

        List<Producto> productos;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        domainModel.getProductoBl().save(p1);
                        domainModel.getInventarioBl().save(i1);
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Producto());
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        productosModel.setProductos(productos);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.getProductoBl().merge(p1);
                        //domainModel.getInventarioBl().merge(i1);
                        model.setMensaje("PRODUCTO MODIFICADO");
                        model.setCurrent(p1);
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
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
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
            model.setCurrent(p1);
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
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
