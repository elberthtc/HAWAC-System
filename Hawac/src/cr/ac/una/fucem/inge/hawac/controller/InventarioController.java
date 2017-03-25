
package cr.ac.una.fucem.inge.hawac.controller;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.view.InventarioView;
import hawac.Application;
import hawac.Session;
import java.util.List;

public class InventarioController {
    Model domainModel;
    Session session; 
    InventarioView view;
    InventarioModel model;
    
    public InventarioController(InventarioView view, InventarioModel model, Model domainmodel, Session session){
        this.domainModel=domainmodel;
        this.session=session;
        this.view=view;
        this.model=model;
        model.init();
        view.setController(this);
        view.setModelo(model);
    }
    
    public void abrirProductos(){
       Application.PRODUCTOINVENTARIO_VIEW.setVisible(true);
    }
    
    public void guardar() {
        model.clearErrors();
        InventariosModel empleadosModel = Application.INVENTARIO_TIENDA_VIEW.getModel();

        Inventario inventarioNuevo = new Inventario();
        if (view.idTextField.getText().length() == 0) {
            model.getErrores().put("id", "Id requerido");
        }else{
            inventarioNuevo.setId(new InventarioId(Application.INVENTARIO,Integer.parseInt(view.idTextField.getText())));
        }

        if (view.cantidadTextField.getText().length() == 0) {
            model.getErrores().put("cantidad", "Cantidad requerida");
        } else if(!Model.isNumeric(view.cantidadTextField.getText())){
            model.getErrores().put("cantidad", "La cantidad debe ser numerica");
        } else
            inventarioNuevo.setCantidad(Integer.parseInt(view.cantidadTextField.getText()));
        
        inventarioNuevo.setProducto(Application.INVENTARIO_VIEW.getModelo().getProductoActual());
        inventarioNuevo.setEstado(view.estadoCB.getSelectedItem().toString());
        
        List<Inventario> empleados;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        domainModel.getInventarioBl().save(inventarioNuevo);
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Inventario());
                        model.setProductoActual(new Producto());
                        empleados = domainModel.getInventario();
                        empleadosModel.setInventarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.getInventarioBl().merge(inventarioNuevo);
                        model.setMensaje("INVENTARIO MODIFICADO");
                        model.setCurrent(inventarioNuevo);
                        model.setProductoActual(new Producto());
                        empleados = domainModel.getInventario();
                        empleadosModel.setInventarios(empleados);
                        view.setVisible(false);
                        break;
                }
            } catch (Exception e) {
                model.getErrores().put("id", "Usuario ya existe");
                model.setMensaje("EMPLEADO YA EXISTE");
                model.setCurrent(inventarioNuevo);
            }
        } else {
            model.setMensaje("HAY ERRORES");
            model.setCurrent(inventarioNuevo);
            model.setProductoActual(new Producto());
        }

    }
}
