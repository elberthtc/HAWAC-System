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
import java.util.LinkedList;
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
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        
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
        InventarioId iId = new InventarioId("Tienda", (Integer) p1.getIdProducto());
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
            }
        }
        List<Linea> lineas = new ArrayList<Linea>();
        if (model.getErrores().isEmpty()) {
            //try {
            switch (model.getModo()) {
                case Application.MODO_AGREGAR:

                    Factura factura = Application.FACTURA_VIEW.getModel().getCurrent();
                    //Application.FACTURA_VIEW.getModel().setCurrent(factura);
                    l1.setId(new LineaId(p1.getIdProducto(), factura.getCodigoFactura()));
                    l1.setFactura(factura);
                        //Factura f1;
                    //List<Factura> facturas = domainModel.getFacturaBl().findAll(Factura.class.getName());
                    //f1 = new Factura();
                    //f1.setCodigoFactura(facturas.size()+1);
                    //f1.setCliente();
                    //f1.setFecha(new Date());
                    //f1.setMonto(-1);
                    //f1.setUsuario(e1);
                    //f1.setApartado(null);

                        //l1.setFactura(f1);
                    //l1.getId().setFactura(f1.getCodigoFactura());
                    //domainModel.getFacturaBl().save(f1);
                    domainModel.getLineaBl().save(l1);
                    int cantidad = i1.getCantidad() - l1.getCantidad();
                    i1.setCantidad(cantidad);
                    domainModel.getInventarioBl().merge(i1);
                    model.setMensaje("PRODUCTO AGREGADO");
                    lineas = domainModel.getLineaBl().findAll(Linea.class.getName());
                    //for (int i = 0; i < lineas.size(); i++) {
                    int i = 0,
                     cont = lineas.size();
                    while (i < lineas.size() && cont > 0) {
                        if (lineas.get(i).getId().getFactura() != factura.getCodigoFactura()) {
                            lineas.remove(lineas.get(i));
                        } else {
                            lineas.get(i).setProducto(domainModel.getProductoBl().findById(lineas.get(i).getId().getProducto()));
                            i++;
                        }
                        cont--;
                    }
                    //lineas.add(l1);
                    Application.FACTURA_VIEW.getModel().setLineas(lineas);
                        //f1.setCliente(Application.FACTURA_VIEW.getModel().getCliente());
                    //facturaModel.setCurrent(f1);
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
            //} catch (Exception e) {
            //  System.out.println(e.toString());
            // model.setMensaje("Problemas con la Base de Datos");
            //}
        } else {
            model.setMensaje("Errores");
        }
    }
  
    public void buscarPorDescripcion(){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(rows.get(j).getDescripcion().toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
    
     public void buscarPorId(){
        model.clearErrors();
        model.getFilter().setIdProducto(Integer.parseInt(view.DescripcionText.getText()));
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        } 
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(String.valueOf(rows.get(j).getIdProducto()).compareTo(view.DescripcionText.getText())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
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