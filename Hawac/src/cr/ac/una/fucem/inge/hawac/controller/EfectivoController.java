/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.EfectivoModel;
import cr.ac.una.fucem.inge.hawac.model.FacturasVentasModel;
import cr.ac.una.fucem.inge.hawac.view.EfectivoView;
import hawac.Application;
import hawac.Session;
import java.util.List;
/*import ferreteria.Application;
import ferreteria.Session;
import ferreteriaentidades.Efectivo;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.EfectivoModel;
import ferreteria.presentacion.model.FacturasVentasModel;
import ferreteria.presentacion.view.EfectivoView;
import ferreteriaentidades.Factura;*/
import java.util.ArrayList;

public class EfectivoController {
    Model domainModel;    
    EfectivoView view;
    EfectivoModel model;
    Session session;

public EfectivoController(EfectivoView view, EfectivoModel model, Model domainModel,Session session) {
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session=session;
        model.init();
        view.setController(this);
        view.setModel(model);
    }

public void registrarPago(){
    /*model.clearErrors();
    FacturasVentasModel  ventas = Application.FACTURAS_VENTAS_VIEW.getModel();
    Factura f1 = ventas.getFiltro();
    Efectivo e1 = new Efectivo();
    e1.setDescripcion("Efectivo");
    if(view.Monto.getText().length()==0){
        model.getErrores().put("Monto"," Monto requerido");
    }
    if(isNumeric2(view.Monto.getText())){
        double monto = Double.parseDouble(view.Monto.getText());
        if(monto==0){
            model.getErrores().put("Monto","Digito Invalido");   
        }
         e1.setMonto(monto);
    }else{
        model.getErrores().put("Monto","Digite solo numeros");
    }
    double  total = f1.getTotal();
    if(e1.getMonto()<total){
        model.getErrores().put("Monto","Monto Insuficiente");
        model.setMensaje("MONTO INSUFICIENTE");
    }
    if (model.getErrores().isEmpty()){
        try{
            double vuelto = e1.getMonto() - total;
            f1.setMontoEfectivo(e1.getMonto());
            e1.setVuelto(vuelto);
            f1.setPagada(true);
            String vuelto1 = String.valueOf(vuelto);
            ventas.setFiltro(f1);
            domainModel.updateFactura2(f1);
            List<Factura> pagadas = new ArrayList<Factura>();
            pagadas = domainModel.FacturaSearch(f1);
            ventas.setFacturas(pagadas);
            view.Vuelto.setText(vuelto1);
//            model.setCurrent(e1);
            model.setMensaje("Su vuelto es de "+vuelto1);
            model.setCurrent(new Efectivo());
            view.setVisible(false);
        }catch(Exception e){
            model.setMensaje("Problemas con la Base de Datos");
            model.setCurrent(e1);

         }
    }else{
         model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
         model.setCurrent(e1);
    }

    */
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
