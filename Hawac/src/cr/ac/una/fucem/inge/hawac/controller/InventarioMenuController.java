
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.InventarioMenuView;
import hawac.Application;
import hawac.Session;
import java.util.List;

public class InventarioMenuController {
    Model domainModel;
    Session session; 
    InventarioMenuView view;
    
    public InventarioMenuController(InventarioMenuView view, Model domainmodel, Session session){
        this.domainModel=domainmodel;
        this.session=session;
        this.view=view;
        view.setController(this);
    }
    
    public void mostrarInventarioTienda(){
        Application.INVENTARIOS_VIEW.setVisible(true);
    }
    

}
