/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.FacturaView;
import hawac.Application;
import hawac.Session;
import java.util.ArrayList;
import java.util.Date;
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
//        if (view.idClienteTextFd.getText().length() != 0) {
            ClientesModel clientesModel = Application.CLIENTES_FACTURA_VIEW.getModel();
            clientesModel.clearErrors();
            model.clearErrors();
            clientesModel.setFilter(new Cliente());
            Application.CLIENTES_FACTURA_VIEW.setVisible(true);
//        }
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
        if(factura.getCliente()==0 || factura.getCliente()==-1){
            factura.setCliente(0);
        }else
            factura.setCliente(model.getCurrent().getCliente());
    }

    public void eliminar(int row) {
        model.clearErrors();
        Linea l1 = model.getLineas().getRowAt(row);
        int cantidad;
        //InventarioId iId = new InventarioId("Tienda", l1.getProducto().getIdProducto());
        //Inventario i1 = domainModel.getInventarioBl().findById(iId);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() != 0) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        try {
            //cantidad = i1.getCantidad() + l1.getCantidad();
            //i1.setCantidad(cantidad);
            //domainModel.getInventarioBl().merge(i1);
            domainModel.getLineaBl().delete(l1);
        } catch (Exception ex) {
        }
        //List<Linea> lineas = domainModel.getLineaBl().findAll(Linea.class.getName());
        model.getLineas2().remove(l1);
        model.setLineas(model.getLineas2());
    }

    public void guardar() {
        model.clearErrors();
        //FacturasVentasModel facturas = Application.FACTURAS_VENTAS_VIEW.getModel();
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        Factura f1 = Application.FACTURA_VIEW.getModel().getCurrent();
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        int a = view.ListProductosTable.getRowCount();
        int b = view.ListProductosTable.getSelectedRow();
        if (view.ListProductosTable.getRowCount() != 0) {
            if (model.getLineas().getRowCount() == 0) {
                model.getErrores().put("GRABAR", "Factura Vacia");
                model.setMensaje("Debe insertar Productos a la Factura");
            } else {
                if (model.getErrores().isEmpty()) {
                    guardarDatosBasicos();
                    double total = Double.valueOf(view.totalTextFd.getText());
                    f1.setMonto((float) total);
                    f1.getC().setTotalComprado(f1.getC().getTotalComprado() + (float) total);
                    domainModel.getClienteBl().merge(f1.getC());
                    domainModel.getFacturaBl().save(f1);
                    view.setVisible(false);
                    Application.CANTIDAD = Application.CANTIDAD + 1;
                    Application.FACTURA_VIEW.numeroL.setText(Application.CANTIDAD + "");
                    List<Linea> lineas = facturaModel.getLineas2();
                    for (int i = 0; i < lineas.size(); i++) {
                        InventarioId inventarioId = new InventarioId("Tienda", lineas.get(i).getProducto().getIdProducto());
                        Inventario inventario = domainModel.getInventarioBl().findById(inventarioId);
                        if (inventario != null) {
                            Linea l = lineas.get(i);
                            l.setId(new LineaId(l.getProducto().getIdProducto(), l.getFactura().getCodigoFactura()));
                            inventario.setCantidad(inventario.getCantidad() - lineas.get(i).getCantidad());
                            domainModel.getInventarioBl().merge(inventario);
                            domainModel.getLineaBl().save(l);
                        }
                    }
                    Bitacora b1 = new Bitacora(Application.USUARIO.getIdUsuario(), Application.USUARIO.getNombre() + " ha vendido al Cliente: " + f1.getC().getNombre()+" por el monto de: "+ f1.getMonto() +" Numero de factura: " + f1.getCodigoFactura(), new Date());
                    domainModel.getBitacoraBl().save(b1);
                    List<Linea> nuevo = new ArrayList<Linea>();
                    model.setCurrent(new Factura());
                    model.setCliente(new Cliente());
                    model.setFiltro(new Linea());
                    model.setMensaje("FACTURA AGREGADA");
                    model.setLineas(nuevo);
                    model.setLineas2(nuevo);
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
}
