/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;
import java.util.List;
/*import ferreteria.Application;
import ferreteria.Session;
import ferreteriaentidades.TarjetaCredito;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.FacturasVentasModel;
import ferreteria.presentacion.model.TarjetaCreditoModel;
import ferreteria.presentacion.view.TarjetaCreditoView;
import ferreteriaentidades.Factura;*/
import java.util.ArrayList;
/**
 *
 * @author Alonso Aguilar
 */
public class TarjetaCreditoController {
  /*   Model domainModel;    
    TarjetaCreditoView view;
    TarjetaCreditoModel model;
    Session session;

public TarjetaCreditoController(TarjetaCreditoView view, TarjetaCreditoModel model, Model domainModel,Session session) {
        model.init();
        this.domainModel= domainModel;
        this.view = view;
        this.model = model;
        this.session=session;
        view.setController(this);
        view.setModel(model);
    }
    public void registrarPago(){
    model.clearErrors();
    FacturasVentasModel  ventas = Application.FACTURAS_VENTAS_VIEW.getModel();
    Factura f1 = ventas.getFiltro();
    TarjetaCredito t1 = new TarjetaCredito();
    t1.setDescripcion("TarjetaCredito");
    if(view.Monto.getText().length()==0){
        model.getErrores().put("Monto"," Monto requerido");
    }
    if(isNumeric2(view.Monto.getText())){
        double monto = Double.parseDouble(view.Monto.getText());
        if(monto==0){
            model.getErrores().put("Monto","Digito Invalido");   
        }
         t1.setMonto(monto);
    }else{
        model.getErrores().put("Monto","Digite solo numeros");
    }
    double  total = f1.getTotal();
    if(t1.getMonto()<total){
        model.getErrores().put("Monto","Monto Insuficiente");
        model.setMensaje("MONTO INSUFICIENTE");
    }
    if(view.Voucher.getText().length()==0){
         model.getErrores().put("Voucher","Voucher requerido");
    }
    if(isNumeric2(view.Voucher.getText())){
        double voucher = Double.parseDouble(view.Voucher.getText());
        if(voucher==0){
            model.getErrores().put("Voucher","Digito Invalido");   
        }
        t1.setNumeroVoucher(voucher);
    }else{
         model.getErrores().put("Voucher","Digite solo numeros");
    }
    if (model.getErrores().isEmpty()){
        try{
            f1.setMontoTarjeta(t1.getMonto());
            f1.setPagada(true);
            ventas.setFiltro(f1);
            domainModel.updateFactura4(f1);
            List<Factura> pagadas = new ArrayList<Factura>();
            pagadas = domainModel.FacturaSearch(f1);
            ventas.setFacturas(pagadas);
            model.setCurrent(new TarjetaCredito());
            view.setVisible(false);
        }catch(Exception e){
            model.setMensaje("Problemas con la Base de Datos");
            model.setCurrent(t1);

         }
    }else{
         model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
         model.setCurrent(t1);
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
    */
}
