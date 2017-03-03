/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClienteModel;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.view.ClienteView;
import hawac.Application;
import hawac.Session;
import java.util.List;
/*import ferreteria.Application;
import ferreteria.Session;
import ferreteriaentidades.Cliente;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.view.ClienteView;*/


public class ClienteController {

    Model domainModel;
    ClienteView view;
    ClienteModel model;
    Session session;

    public ClienteController(ClienteView view, ClienteModel model, Model domainModel, Session session) {
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
        ClientesModel clientesModel = Application.CLIENTES_VIEW.getModel();
        Cliente c1 = new Cliente();
        c1.setNombre(view.nombreTextFd.getText());
        if (view.nombreTextFd.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }
        if (view.idTextFd.getText().length() == 0 || view.idTextFd.getText().length() > 7 || !cr.ac.una.fucem.inge.hawac.logic.Model.isNumeric(view.idTextFd.getText())) {
            model.getErrores().put("Id", "Id Incorrecto");
        } else {
            c1.setCedula(Integer.parseInt(view.idTextFd.getText()));
        }

        c1.setTotalComprado(0);

        //c1.setNumeroTelefono(view.numTelefonoTextFd.getText());
        //c1.setCorreo(view.correoTextFd.getText());
        /*if(view.DescuentoTextFd.getText().length()==0){
         c1.setPorcentajeDescuento(0.0);
         }
         if(isNumeric2(view.DescuentoTextFd.getText())){
         double desc = Double.parseDouble(view.DescuentoTextFd.getText());
         c1.setPorcentajeDescuento(desc);
         }else{
         model.getErrores().put("Descuento","Digite Solo numeros");
         }*/
        List<Cliente> clientes;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        domainModel.getClienteBl().save(c1);
                        model.setMensaje("CLIENTE AGREGADO");
                        model.setCurrent(new Cliente());
                        clientes = domainModel.getClienteBl().findAll(Cliente.class.getName());
                        clientesModel.setClientes(clientes);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.getClienteBl().merge(c1);
                        model.setMensaje("CLIENTE MODIFICADO");
                        model.setCurrent(c1);
                        clientes = domainModel.getClienteBl().findAll(Cliente.class.getName());
                        clientesModel.setClientes(clientes);
                        view.setVisible(false);
                        break;
                }
            } catch (Exception e) {
                if (e.toString().compareTo("java.lang.NullPointerException") != 0) {
                    model.getErrores().put("Id", "Cliente ya existe");
                    model.setMensaje("CLIENTE YA EXISTENTE");
                    model.setCurrent(c1);
                }
            }
        } else {
            model.setMensaje("CAMPOS REQUERIDOS SIN LLENAR");
            model.setCurrent(c1);
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

