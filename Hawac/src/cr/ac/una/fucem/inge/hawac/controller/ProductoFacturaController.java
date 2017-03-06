/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;


import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoFacturaView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ProductoFacturaController {
    Model domainModel;
    Session session;
    ProductoFacturaView view;
    ProductosModel model;
    public static  int CONTADOR=1;

    
    public ProductoFacturaController(ProductoFacturaView view, Session session, ProductosModel model, Model domainModel) {
        model.init();
        this.domainModel= domainModel;
        this.session=session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void buscar(){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
 
    }
    
    public void seleccionar(int row) {
        model.clearErrors();
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        Producto p1 = model.getProductos().getRowAt(row);
        InventarioId iId = new InventarioId("Tienda", p1.getIdProducto());
        Inventario i1 = domainModel.getInventarioBl().findById(iId);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Linea l1 = new Linea();
        if (view.cantidadTextField.getText().length() == 0) {
            model.getErrores().put("Cantidad", "Cantidad requerida");
            model.setMensaje("Cantidad requerida");
        } else {
            if (!isNumeric(view.cantidadTextField.getText())) {
                model.getErrores().put("Cantidad", "Digite Solo numeros");
            } else {
                int ex = Integer.parseInt(view.cantidadTextField.getText());
                if (ex > i1.getCantidad()) {
                    model.getErrores().put("Cantidad", "Existencias Insuficientes");
                }
                if (ex == 0) {
                    model.getErrores().put("Cantidad", "Digito Invalido");
                }
                l1.setProducto(p1);
                l1.setCantidad(ex);
                l1.setId(new LineaId(p1.getIdProducto(), 0));
                 //l1.setNumeroLinea(CONTADOR);
                // l1.set
                // CONTADOR++;

            }
        }
        List<Linea> lineas;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Factura f1;
                        List<Factura> facturas = domainModel.getFacturaBl().findAll(Factura.class.getName());
                        int n = 19;
                        if (facturas.size() != 0) {
                            f1 = facturas.get(0);
                            int index = 0;
                            for (int i = 0; i < facturas.size() - 1; i++) {
                                index = i;
                            }
                            f1 = facturas.get(index);
                        }
                        f1 = new Factura();
                        f1.setCodigoFactura(facturas.size()+1);
                        f1.setCliente(null);
                        f1.setFecha(new Date());
                        f1.setMonto(-1);
                        
                        l1.setFactura(f1);
                        l1.getId().setFactura(f1.getCodigoFactura());
                        domainModel.getFacturaBl().save(f1);
                        domainModel.getLineaBl().save(l1);
                        int cantidad = i1.getCantidad() - l1.getCantidad();
                        i1.setCantidad(cantidad);
                        domainModel.getInventarioBl().merge(i1);
                        model.setMensaje("PRODUCTO AGREGADO");
                        List<Linea> nuevo = new ArrayList<Linea>();
                        lineas = domainModel.getLineaBl().findAll(Linea.class.getName());
                        for (int i = 0; i < lineas.size(); i++) {
                            if (lineas.get(i).getId().getFactura() != f1.getCodigoFactura()) {
                                lineas.remove(lineas.get(i));
                            }
                        }
                        facturaModel.setLineas(lineas);
                        f1.setCliente(Application.FACTURA_VIEW.getModel().getCliente());
                        facturaModel.setCurrent(f1);
                        view.cantidadTextField.setText("0");
                        Application.PRODUCTOFACTURA_VIEW.setVisible(false);
                        break;

                    case Application.MODO_EDITAR:
//                    FacturaCompra f2 = domainModel.getFacturaMayor2();
//                    l1.setNumFactura(f2);
//                    domainModel.addLineaCompra(l1);
//                    int cantidad2 = l1.getCodProducto().getExistencias()+l1.getCantidad();
//                    l1.getCodProducto().setExistencias(cantidad2);
//                    domainModel.updateProducto2(l1.getCodProducto());
//                    model.setMensaje("PRODUCTO AGREGADO");
//                    List<Linea> lineaCompra = new ArrayList<Linea>();
//                    lineaCompra = domainModel.searchLineas2(l1);
//                    facturaModel.setLineas(lineaCompra);
//                    f2.setEmpleado(e1);
//                    Application.PRODUCTOFACTURA_VIEW.setVisible(false);

                        break;
                }
            } catch (Exception e) {
                model.setMensaje("Problemas con la Base de Datos");
            }
        } else {
            model.setMensaje("Errores");
        }
    }
  
     public void buscar2(){
        model.clearErrors();
        model.getFilter().setIdProducto(Integer.parseInt(view.DescripcionText.getText()));
        List<Producto> rows = domainModel.getProductoBl().findAll(Producto.class.getName()); 
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
 
    }

  public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
 }
  
     private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException exc){
		return false;
	}
    }
}