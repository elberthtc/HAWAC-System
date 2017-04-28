package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Abono;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.AbonoModel;
import cr.ac.una.fucem.inge.hawac.model.AbonosModel;
import cr.ac.una.fucem.inge.hawac.view.AbonosView;
import hawac.Application;
import hawac.Session;
import java.util.LinkedList;
import java.util.List;

public class AbonosController {

    Model domainModel;
    Session session;
    AbonosView view;
    AbonosModel model;

    public AbonosController(AbonosView view, Session session, AbonosModel model, Model domainModel) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar(int apartado){
        model.clearErrors();
        //model.getFilter().getC().setNombre(view.DescripcionText.getText());
        List<Abono> rows = domainModel.getAbonoBl().findAll(Abono.class.getName());
        List<Abono> aux = new LinkedList<Abono>();
        for(int i = 0; i < rows.size(); i++){
            rows.get(i).setA(domainModel.getApartadoBl().findById(rows.get(i).getApartado()));
            rows.get(i).setU(domainModel.getUsuarioBl().findById(rows.get(i).getUsuario()));
            if(rows.get(i).getApartado()==apartado){
                aux.add(rows.get(i));
            }
        }
        if (aux.isEmpty()) {
            model.getErrores().put("DescripcionText", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setAbonos(aux);
    }
    
    public void preAgregar() {
        model.clearErrors();
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        AbonoModel abonoModel = Application.ABONO_VIEW.getModel();
        abonoModel.clearErrors();
        abonoModel.setModo(Application.MODO_AGREGAR);
        abonoModel.setCurrent(Application.ABONOS_VIEW.getModel().getFilter());
        Application.ABONO_VIEW.setVisible(true);
    }

    public void salir() {
        model.clearErrors();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
}