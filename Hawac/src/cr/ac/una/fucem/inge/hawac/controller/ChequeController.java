/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ChequeModel;
import cr.ac.una.fucem.inge.hawac.view.ChequeView;
import hawac.Session;
import java.util.List;
/*import ferreteria.Application;
import ferreteria.Session;
import ferreteriaentidades.Cheque;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ChequeModel;
import ferreteria.presentacion.model.FacturasVentasModel;
import ferreteria.presentacion.view.ChequeView;
import ferreteriaentidades.Factura;*/
import java.util.ArrayList;
/**
 *
 * @author Alonso Aguilar
 */
public class ChequeController {
    Model domainModel;    
    ChequeView view;
    ChequeModel model;
    Session session;

public ChequeController(ChequeView view, ChequeModel model, Model domainModel,Session session) {
        model.init();
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session=session;
        view.setController(this);
        view.setModel(model);
    }
     public void registrarPago(){
  /*      model.clearErrors();
        FacturasVentasModel  ventas = Application.FACTURAS_VENTAS_VIEW.getModel();
        Factura f1 = ventas.getFiltro();
        Cheque c1 = new Cheque();
        c1.setDescripcion("Cheque");
        if(view.Monto.getText().length()==0){
         model.getErrores().put("Monto"," Monto requerido");
        }
        if(isNumeric2(view.Monto.getText())){
            double monto = Double.parseDouble(view.Monto.getText());
            if(monto==0){
             model.getErrores().put("Monto","Digito Invalido");   
            }
            c1.setMonto(monto);
        }else{
            model.getErrores().put("Monto","Digite solo numeros");
        }
        double  total = f1.getTotal();
        if(c1.getMonto()<total){
            model.getErrores().put("Monto","Monto Insuficiente");
            model.setMensaje("MONTO INSUFICIENTE");
        }
        if(view.Numerodecheque.getText().length()==0){
            model.getErrores().put("N° Cheque","N° Cheque requerido");
        }
        if(isNumeric2(view.Numerodecheque.getText())){
            double cheque = Double.parseDouble(view.Numerodecheque.getText());
            if(cheque==0){
                model.getErrores().put("N° Cheque","Digito Invalido"); 
            }
            c1.setNumeroCheque(cheque);
        }else{
             model.getErrores().put("N° Cheque","Digite solo numeros");
        }
        if (model.getErrores().isEmpty()){
         try{
            f1.setMontoCheque(c1.getMonto());
            f1.setPagada(true);
            ventas.setFiltro(f1);
            domainModel.updateFactura3(f1);
            List<Factura> pagadas = new ArrayList<Factura>();
            pagadas = domainModel.FacturaSearch(f1);
            ventas.setFacturas(pagadas);
            model.setCurrent(new Cheque());
            view.setVisible(false);
        }catch(Exception e){
            model.setMensaje("Problemas con la Base de Datos");
            model.setCurrent(c1);

         }
    }else{
         model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
         model.setCurrent(c1);
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