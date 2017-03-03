/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;


import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoView;
import hawac.Application;
import hawac.Session;
import java.util.List;
/*import ferreteria.Application;
import ferreteria.Session;
import ferreteriaentidades.Producto;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ProductoModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteria.presentacion.view.ProductoView;

*/
public class ProductoController {
    Model domainModel;    
    ProductoView view;
    ProductoModel model;
    Session session;
    
    public ProductoController(ProductoView view, ProductoModel model, Model domainModel,Session session) {
        model.init();
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session=session;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        model.clearErrors();
        ProductosModel productosModel =Application.PRODUCTOS_VIEW.getModel();
        Producto p1 = new Producto();
        p1.setIdProducto(Integer.parseInt(view.CodigoText.getText()));
        if(view.CodigoText.getText().length()==0){
            model.getErrores().put("Codigo", "Codigo requerido");
        }
        p1.setDescripcion(view.DescripcionText.getText());
        if(view.DescripcionText.getText().length()==0){
             model.getErrores().put("Descripcion", "Descripcion requerida");
        }
        if(isNumeric(view.ExistenciaText.getText())){
            int ex = Integer.parseInt(view.ExistenciaText.getText());
            if(ex==0){
                model.getErrores().put("Cantidad","Digito Invalido");
            }
            //p1.setExistencias(ex);
        }else{
            model.getErrores().put("Cantidad","Digite Solo numeros");
        }
        if(view.ExistenciaText.getText().length()==0){
            model.getErrores().put("Cantidad","Cantidad requerida");
        }
        if(isNumeric2(view.PrecioText.getText())){
            double prec = Double.parseDouble(view.PrecioText.getText());
            if(prec==0.0){
                model.getErrores().put("Precio","Digito Invalido");
            }
             p1.setPrecio((float) prec);
        }
        if(view.PrecioText.getText().length()==0){
            model.getErrores().put("Precio","Precio Requerido");
        }
     
        List<Producto> productos;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.getProductoBl().save(p1);
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Producto());
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        productosModel.setProductos(productos);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.getProductoBl().merge(p1);
                        model.setMensaje("PRODUCTO MODIFICADO");
                        model.setCurrent(p1);
                        productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                        productosModel.setProductos(productos);
                        view.setVisible(false);
                        break;
                }
            } catch(Exception e){
                model.getErrores().put("Codigo", "Producto ya existente");
                model.setMensaje("Producto YA EXISTENTE");
                model.setCurrent(p1);
            }
            } 
        else{
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
            model.setCurrent(p1);
        }
    }
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException exc){
		return false;
	}
    }
    private static boolean isNumeric2(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException exc){
		return false;
	}
    }
}
