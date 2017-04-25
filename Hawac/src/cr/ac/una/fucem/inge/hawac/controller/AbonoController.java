package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import cr.ac.una.fucem.inge.hawac.domain.Apartado;
import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.AbonoModel;
import cr.ac.una.fucem.inge.hawac.model.AbonosModel;
import cr.ac.una.fucem.inge.hawac.view.AbonoView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AbonoController {

    Model domainModel;
    AbonoView view;
    AbonoModel model;
    Session session;

    public AbonoController(AbonoView view, AbonoModel model, Model domainModel, Session session) {
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
        AbonosModel abonosModel = Application.ABONOS_VIEW.getModel();
        Abono p1 = model.getCurrent();
        Apartado a1 = p1.getA();
        
        if (view.dependienteText.getText().length() == 0) {
            model.getErrores().put("Vendedor", "Vendededor requerido");
            model.setMensaje("Debe seleccionarse un Vendedor");
            JOptionPane.showMessageDialog(view,model.getMensaje());
        } else {
            p1.setUsuario(Application.ABONO_VIEW.getModel().getCurrent().getUsuario());
        }

        if (view.apartadoText.getText().length() == 0) {
            model.getErrores().put("Apartado", "Apartado Requerido");
            model.setMensaje("Debe seleccionarse un Apartado");
            JOptionPane.showMessageDialog(view,model.getMensaje());
        } else {
            p1.setA(Application.ABONO_VIEW.getModel().getCurrent().getA());
        }

        if (view.montoText.getText().length() == 0 || !isNumeric2(view.montoText.getText()) || !isNumeric(view.montoText.getText())) {
            model.getErrores().put("Prima", "Prima requerida");
            model.setMensaje("El monto es requerido");
            JOptionPane.showMessageDialog(view,model.getMensaje());
            view.montoLabel.setBorder(Application.BORDER_ERROR);
            view.montoLabel.setToolTipText(model.getErrores().get("primaLabel"));
        } else {
            double a = a1.getSaldo() - Double.parseDouble(view.montoText.getText());
            if (a < 0) {
                model.getErrores().put("Prima", "Prima requerida");
                model.setMensaje("El Monto no puede se Mayor al Saldo");
                JOptionPane.showMessageDialog(view,model.getMensaje());
                view.montoLabel.setBorder(Application.BORDER_ERROR);
                view.montoLabel.setToolTipText(model.getErrores().get("primaLabel"));
            } else {
                p1.setSaldo(a1.getSaldo() - Double.parseDouble(view.montoText.getText()));
                a1.setSaldo(p1.getSaldo());
                p1.setMonto((float) Double.parseDouble(view.montoText.getText()));
            }
        }

        List<Abono> abonos;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Factura f  = new Factura();
                        f.setCodigoFactura(Application.CANTIDAD);
                        Application.CANTIDAD = Application.CANTIDAD + 1;
                        f.setCliente(a1.getCliente());
                        f.setFecha(p1.getFechaRealizado());
                        f.setMonto(p1.getMonto());
                        f.setUsuario(Application.USUARIO.getIdUsuario());
                        domainModel.getFacturaBl().save(f);
                        Application.FACTURA_VIEW.getModel().getCurrent().setCodigoFactura(Application.CANTIDAD);
                        Application.FACTURA_VIEW.update( Application.FACTURA_VIEW.getModel(), 1);
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(),Application.USUARIO.getNombre()+" ha agregado un abono de: " + p1.getMonto() + " al Apartado Numero: "+a1.getIdApartado(),new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getAbonoBl().save(p1);
                        domainModel.getApartadoBl().merge(a1);
                        model.setMensaje("ABONO AGREGADO");
                        model.setCurrent(new Abono());
                        abonos = domainModel.getAbonoBl().findAll(Abono.class.getName());
                        int i = 0,
                         cont = abonos.size();
                        while (i < abonos.size() && cont > 0) {
                            if (abonos.get(i).getApartado() != a1.getIdApartado()) {
                                abonos.remove(abonos.get(i));
                            } else {
                                i++;
                            }
                            cont--;
                        }

                        for (int j = 0; j < abonos.size(); j++) {
                            abonos.get(j).setA(domainModel.getApartadoBl().findById(abonos.get(j).getApartado()));
                            abonos.get(j).setU(domainModel.getUsuarioBl().findById(abonos.get(j).getUsuario()));
                        }
                        abonosModel.setAbonos(abonos);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        /* domainModel.getProductoBl().merge(p1);
                         model.setMensaje("PRODUCTO MODIFICADO");
                         model.setCurrent(p1);
                         productos = domainModel.getProductoBl().findAll(Producto.class.getName());
                         productosModel.setProductos(productos);
                         view.setVisible(false); */

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
