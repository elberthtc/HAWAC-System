package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Bitacora;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.InventarioModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.view.InventarioView;
import hawac.Application;
import hawac.Session;
import java.util.Date;
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
        Inventario inventarioNuevo = Application.INVENTARIO_VIEW.getModelo().getCurrent();
        inventarioNuevo.setProducto(Application.INVENTARIO_VIEW.getModelo().getProductoActual());
        if (view.idTextField.getText().length() == 0) {
            model.getErrores().put("Id", "Id requerido");
        }else{
            inventarioNuevo.setId(new InventarioId(Application.INVENTARIO,Integer.parseInt(view.idTextField.getText())));
            inventarioNuevo.setProducto(domainModel.getProductoBl().findById(inventarioNuevo.getId().getProducto()));
        }
        if (view.cantidadTextField.getText().length() == 0) {
            model.getErrores().put("Cantidad", "Cantidad requerida");
        } else if(!Model.isNumeric(view.cantidadTextField.getText())){
            model.getErrores().put("Cantidad", "La cantidad debe ser numerica");
        } else
            inventarioNuevo.setCantidad(Integer.parseInt(view.cantidadTextField.getText()));
        inventarioNuevo.setEstado("Listo");
        
        List<Inventario> empleados;
        if (model.getErrores().isEmpty()) {
            try {
                switch (model.getModo()) {
                    case Application.MODO_AGREGAR:
                        Inventario inv = domainModel.getInventarioBl().findById(inventarioNuevo.getId());
                        if(inv==null){
                            Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), Application.USUARIO.getNombre() + " ha agregado al Inventario " + inventarioNuevo.getProducto().getDescripcion() + " cantidad: " + inventarioNuevo.getCantidad(), new Date());
                            domainModel.getBitacoraBl().save(b);
                            domainModel.getInventarioBl().save(inventarioNuevo);
                        }else{
                            Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), Application.USUARIO.getNombre() + " ha Modificado el Inventario " + inventarioNuevo.getProducto().getDescripcion() + " cantidad: " + inventarioNuevo.getCantidad(), new Date());
                            domainModel.getBitacoraBl().save(b);
                            inv.setCantidad(inv.getCantidad()+ Integer.parseInt(view.cantidadTextField.getText()));
                            domainModel.getInventarioBl().merge(inv);
                        }
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Inventario());
                        model.setProductoActual(new Producto());
                        empleados = domainModel.getInventario();
                        for(int i = 0; i<empleados.size();i++){
                            empleados.get(i).setProducto(domainModel.getProductoBl().findById(empleados.get(i).getId().getProducto()));
                        }
                        empleadosModel.setInventarios(empleados);
                        view.setVisible(false);
                        break;
                    case Application.MODO_EDITAR:
                        Bitacora b = new Bitacora(Application.USUARIO.getIdUsuario(), Application.USUARIO.getNombre() + " ha Modificado el Inventario " + inventarioNuevo.getProducto().getDescripcion() + " cantidad: " + inventarioNuevo.getCantidad(), new Date());
                        domainModel.getBitacoraBl().save(b);
                        domainModel.getInventarioBl().merge(inventarioNuevo);
                        model.setMensaje("INVENTARIO MODIFICADO");
                        model.setCurrent(inventarioNuevo);
                        model.setProductoActual(new Producto());
                        empleados = domainModel.getInventario();
                        for(int i = 0; i<empleados.size();i++){
                            empleados.get(i).setProducto(domainModel.getProductoBl().findById(empleados.get(i).getId().getProducto()));
                        }
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
