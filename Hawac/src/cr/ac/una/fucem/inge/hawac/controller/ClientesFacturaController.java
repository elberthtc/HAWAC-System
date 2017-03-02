/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.view.ClientesFacturaView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.Arrays;
/*import ferreteria.Application;
import ferreteria.logic.Model;
import ferreteria.Session;
import ferreteriaentidades.Cliente;
import ferreteriaentidades.Empleado;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.view.ClientesFacturaView;
import ferreteriaentidades.Factura;*/


public class ClientesFacturaController {
    Model domainModel;
    Session session;
    ClientesFacturaView view;
    ClientesModel model;
    int cont;
    public static  int CONTADOR=1;
    
    public ClientesFacturaController(ClientesFacturaView view, Session session, ClientesModel model, Model domainModel) {
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
        model.getFilter().setNombre(view.nombreTextFd.getText());
        List<Cliente> rows = null; //domainModel.searchClientes(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        //model.setClientes(rows);
    }
    public void buscar2(){
        /*model.clearErrors();
        model.getFilter().setIdCliente(view.nombreTextFd.getText());
        List<Cliente> rows = domainModel.searchClientes2(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("nombreTextFd","Ningun registro coincide");
             model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);*/
    }
    public void seleccionar(int row){
       /*  model.clearErrors();
         Cliente c1 = model.getClientes().getRowAt(row);
         Empleado e1 = (Empleado) session.getAttribute(Application.EMPLOYEE_ATTRIBUTE);
          if( !Arrays.asList(Application.ROL_SELLER).contains(e1.getRol().getDescripcion())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }try{   
            Factura f1 = new Factura();
            f1.setCliente(c1);
            f1.setEmpleado(e1);
            f1.setNumero(CONTADOR);
            f1.setTipoPago((String)Application.FACTURA_VIEW.metodoPagoComboBox.getSelectedItem());
            domainModel.addFactura(f1);
            f1.setNumero(CONTADOR);
            Application.FACTURA_VIEW.getModel().setCurrent(f1);
             Application.FACTURA_VIEW.getModel().setCliente(c1);
            CONTADOR++;
   
        }catch (Exception ex) { 
            model.setMensaje("Problemas con la Base de Datos");
        }
        Application.CLIENTES_FACTURA_VIEW.setVisible(false);
         */
    }
    public void salir(){
        model.clearErrors();        
        //domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }

 
    
}
