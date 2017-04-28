package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Cliente;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ClienteModel;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.utils.Validaciones;
import cr.ac.una.fucem.inge.hawac.view.ClienteView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
import java.util.List;


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
        if(view.nombreTextFd.getText().length() == 0) {
            model.getErrores().put("Nombre", "Nombre requerido");
        }
        if(!Validaciones.validarCedula(view.idTextFd.getText())) {
            model.getErrores().put("Id", "Id Incorrecto");
        } else {
            c1.setCedula(Integer.parseInt(view.idTextFd.getText()));
        }
        if(view.correoTextFd.getText().length()==0 || !Validaciones.validarEmail(view.correoTextFd.getText())){
            model.getErrores().put("Correo", "Correo Incorrecto");
        }else{
            c1.setCorreo(view.correoTextFd.getText());
        }
        String telefono = view.numTelefonoTextFd.getText();
        telefono = Validaciones.validarTel(telefono);
        if(telefono==null || telefono.length()==0){
            model.getErrores().put("Telefono","Telefono Incorrecto");
        }else{
            c1.setTelefono(telefono);
        }
        List<Cliente> clientes;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(),Application.USUARIO.getNombre()+" ha agregado al Cliente: "+c1.getNombre(),new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getClienteBl().save(c1);
                        model.setMensaje("CLIENTE AGREGADO");
                        model.setCurrent(new Cliente());
                        clientes = domainModel.getClienteBl().findAll(Cliente.class.getName());
                        clientes.remove(clientes.get(0));
                        clientesModel.setClientes(clientes);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Cliente a = domainModel.getClienteBl().findById(c1.getCedula());
                        c1.setTotalComprado(a.getTotalComprado());
                        Bitacora b1 = new Bitacora(Application.USUARIO.getIdUsuario(),Application.USUARIO.getNombre()+" ha modificado al Cliente: "+c1.getNombre(),new Date());
                        domainModel.getBitacoraBl().save(b1);
                        domainModel.getClienteBl().merge(c1);
                        model.setMensaje("CLIENTE MODIFICADO");
                        model.setCurrent(c1);
                        clientes = domainModel.getClienteBl().findAll(Cliente.class.getName());
                        clientes.remove(clientes.get(0));
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

