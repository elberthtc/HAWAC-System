/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.FacturasVentasModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.FacturaView;
import hawac.Application;
import hawac.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacturaController {

    Model domainModel;
    Session session;
    FacturaView view;
    FacturaModel model;
    public static int CONTADOR = 1;

    public FacturaController(FacturaView v, FacturaModel m, Model domainModel, Session session) {
        this.view = v;
        this.model = m;
        this.domainModel = domainModel;
        this.session = session;
        model.init();
        view.setController(this);
        view.setModel(m);    
    }

    public void preAgregarCliente() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute(("Usuario"));
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        if (view.idClienteTextFd.getText().length() == 0) {
            ClientesModel clientesModel = Application.CLIENTES_FACTURA_VIEW.getModel();
            clientesModel.clearErrors();
            model.clearErrors();
            clientesModel.setFilter(new Cliente());
            Application.CLIENTES_FACTURA_VIEW.setVisible(true);
        }
    }

    public void preAgregarProducto() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ProductosModel productosModel = Application.PRODUCTOFACTURA_VIEW.getModel();
        productosModel.clearErrors();
        productosModel.setFilter(new Producto());
        productosModel.setModo(Application.MODO_AGREGAR);
        Application.PRODUCTOFACTURA_VIEW.setVisible(true);

    }
    
    public void guardarDatosBasicos(){
        Factura factura = model.getCurrent();
        factura.setCodigoFactura(Application.CANTIDAD);
        //factura.setFecha(model.getCurrent().getFecha());
        factura.setMonto(0);
        factura.setUsuario(model.getEmpleado().getIdUsuario());
        factura.setApartado(null);
        if(factura.getCliente()==0){
            factura.setCliente(0);
        }else
            factura.setCliente(model.getCurrent().getCliente());
        domainModel.getFacturaBl().save(factura);
    }

    public void eliminar(int row) {
        model.clearErrors();
        Linea l1 = model.getLineas().getRowAt(row);
        int cantidad;
        InventarioId iId = new InventarioId("Tienda", l1.getProducto().getIdProducto());
        Inventario i1 = domainModel.getInventarioBl().findById(iId);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            cantidad = i1.getCantidad() + l1.getCantidad();
            i1.setCantidad(cantidad);
            //domainModel.updateProducto2(l1.getCodProducto());
            domainModel.getInventarioBl().merge(i1);
            domainModel.getLineaBl().delete(l1);
        } catch (Exception ex) {
        }
        List<Linea> lineas = domainModel.getLineaBl().findAll(Linea.class.getName());
        model.setLineas(lineas);
    }

    public void guardar() {
        model.clearErrors();
        //FacturasVentasModel facturas = Application.FACTURAS_VENTAS_VIEW.getModel();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        Factura f1 = Application.FACTURA_VIEW.getModel().getCurrent();
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        if (view.ListProductosTable.getRowCount() != 0 && view.ListProductosTable.getSelectedRow() != -1) {
            if (model.getLineas().getRowCount() == 0) {
                model.getErrores().put("GRABAR", "Factura Vacia");
                model.setMensaje("Debe insertar Productos a la Factura");
            } else {
                //f1.setCodigoFactura(CONTADOR);
                //CONTADOR++;
                List<Factura> facturasVentas;
                if (model.getErrores().isEmpty()) {
                    try {
                        double total = Double.valueOf(view.TotalTextFd.getText());
                        //f1.setTipoPago((String) view.metodoPagoComboBox.getSelectedItem());
                        
                        f1.setMonto((float) total);
                        domainModel.getFacturaBl().merge(f1);
                        facturasVentas = domainModel.getFacturaBl().findAll(Factura.class.getName());
                        //Application.FACTURAS_VENTAS_VIEW.getModel().setFacturas(facturasVentas);
                        List<Linea> nuevo = new ArrayList<Linea>();
                        model.setCurrent(new Factura());
                        model.setCliente(new Cliente());
                        model.setFiltro(new Linea());
                        model.setMensaje("FACTURA AGREGADA");
                        model.setLineas(nuevo);
                        view.setVisible(false);
                        Application.CANTIDAD = Application.CANTIDAD+1;
                        Application.FACTURA_VIEW.numFacTextFd.setText(Application.CANTIDAD+"");
                    } catch (Exception e) {
                        model.getErrores().put("GRABAR", "Errores");
                        model.setMensaje("Problemas con la Base de Datos");
                        model.setCurrent(f1);
                    }
                } else {
                    model.setMensaje("Errores");
                    model.setCurrent(f1);
                }
            }
        }
    }

    public void clientesShow() {
        Application.CLIENTES_FACTURA_VIEW.setVisible(true);
    }
        
        
    public void productosShow() {
        Application.PRODUCTOFACTURA_VIEW.setVisible(true);
    }

    public void salir() {
        model.clearErrors();
        view.setVisible(false);
        Application.PRODUCTOFACTURA_VIEW.setVisible(false);
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
