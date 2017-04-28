package cr.ac.una.fucem.inge.hawac.controller;

import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.InventarioId;
import cr.ac.una.fucem.inge.hawac.domain.Linea;
import cr.ac.una.fucem.inge.hawac.domain.LineaId;
import cr.ac.una.fucem.inge.hawac.domain.Producto;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.view.ProductoFacturaView;
import hawac.Application;
import hawac.Session;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ProductoFacturaController {
    Model domainModel;
    Session session;
    ProductoFacturaView view;
    ProductosModel model;
    public static  int CONTADOR=1;

    
    public ProductoFacturaController(ProductoFacturaView view, Session session, ProductosModel model, Model domainModel) {
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
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");   
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
 
    }
    
    public void seleccionar(int row) {
        model.clearErrors();
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        Producto p1 = model.getProductos().getRowAt(row);
        InventarioId iId = new InventarioId("Tienda", (Integer) p1.getIdProducto());
        Inventario i1 = domainModel.getInventarioBl().findById(iId);
        Usuario e1 = (Usuario) session.getAttribute("Usuario");
        if (e1.getTipo() == -1) {
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Linea l1 = new Linea();
        if (view.cantidadTextField.getText().length() == 0) {
            model.getErrores().put("Cantidad", "Cantidad requerida");
            model.setMensaje("Se requiere que ingrese una Cantidad");
            JOptionPane.showMessageDialog(view, model.getMensaje());
        } else {
            if (!isNumeric(view.cantidadTextField.getText())) {
                model.getErrores().put("Cantidad", "Digite Solo numeros");
                model.setMensaje("Asegurese de ingresar solo valores numericos enteros");
                JOptionPane.showMessageDialog(view, model.getMensaje());
            } else {
                int n = Integer.parseInt(view.cantidadTextField.getText());
                if (n < 0) {
                    //JOptionPane.showConfirmDialog(view, "Cantidad no puede ser un valor negativo");
                    model.getErrores().put("Cantidad", "No puede ingresar numeros negativos");
                    model.setMensaje("La Cantidad no puede ser un valor negativo");
                    JOptionPane.showMessageDialog(view, model.getMensaje());
                } else {
                    int ex = Integer.parseInt(view.cantidadTextField.getText());
                    if(i1 == null){
                        model.getErrores().put("Inventario","No han agregado el producto al Inventario");
                        model.setMensaje("No Existe ese producto en el Inventario de la Tienda");
                        JOptionPane.showMessageDialog(view, model.getMensaje());
                    }else if (ex > i1.getCantidad()){
                        model.getErrores().put("Cantidad", "Existencias Insuficientes");
                        model.setMensaje("En este momento solo existen "+ i1.getCantidad()+" de el producto seleccionado");
                        JOptionPane.showMessageDialog(view, model.getMensaje());
                    }
                    if (ex == 0) {
                        model.getErrores().put("Cantidad", "Digito Invalido");
                        model.setMensaje("La cantidad debe ser mayor a 0");
                        JOptionPane.showMessageDialog(view, model.getMensaje());
                    }
                    l1.setProducto(p1);
                    l1.setCantidad(ex);
                }
            }
        }
        List<Linea> lineas = facturaModel.getLineas2();
        if (model.getErrores().isEmpty()) {
            switch (model.getModo()) {
                case Application.MODO_AGREGAR:
                    Factura factura = facturaModel.getCurrent();
                    l1.setId(new LineaId(p1.getIdProducto(), factura.getCodigoFactura()));
                    l1.setFactura(factura);
                    boolean existe = false;
                    for(int i = 0; i<lineas.size();i++){
                        if (lineas.get(i).getProducto().getIdProducto()==l1.getProducto().getIdProducto()){
                            lineas.get(i).setCantidad(lineas.get(i).getCantidad()+l1.getCantidad());
                            existe = true;
                        }
                    }
                    if(!existe)
                        lineas.add(l1);
                    model.setMensaje("PRODUCTO AGREGADO");
                    facturaModel.setLineas(lineas);
                    facturaModel.setLineas2(lineas);
                    view.cantidadTextField.setText("0");
                    Application.PRODUCTOFACTURA_VIEW.setVisible(false);
                    break;
                case Application.MODO_EDITAR:
                    break;
            }
        } else {
            model.setMensaje("Errores");
        }
    }
  
    public void buscarPorDescripcion(){
        model.clearErrors();
        model.getFilter().setDescripcion(view.DescripcionText.getText());
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(rows.get(j).getDescripcion().toLowerCase().indexOf(view.DescripcionText.getText().toLowerCase())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
             model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
             JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
    }
    
     public void buscarPorId(){
        model.clearErrors();
        model.getFilter().setIdProducto(Integer.parseInt(view.DescripcionText.getText()));
        List<Producto> rows = new LinkedList<Producto>();//domainModel.getProductoBl().findAll(Producto.class.getName()); 
        List<Inventario> inv = domainModel.getInventarioBl().findAll(Inventario.class.getName());
        for(int i = 0; i< inv.size(); i++){
            if(inv.get(i).getId().getLocal().compareTo("Tienda")==0 && inv.get(i).getCantidad()>0){
                rows.add(domainModel.getProductoBl().findById(inv.get(i).getId().getProducto()));
            }
        }
        for(int j=0;j<rows.size();j++){
            Inventario inventario = domainModel.getInventarioBl().findById(new InventarioId("Tienda",rows.get(j).getIdProducto()));
            if(inventario!=null){
                int cantidad = inventario.getCantidad();
                rows.get(j).setCantidad(cantidad);
            }
        }
        int j=0, cont=rows.size();
        while(j<rows.size() && cont>0){
            if(String.valueOf(rows.get(j).getIdProducto()).compareTo(view.DescripcionText.getText())!=0){
                rows.remove(rows.get(j));
            }else
                j++;
            cont--;
        }
        if(rows.isEmpty()){
            model.getErrores().put("DescripcionText","Ningun registro coincide");
            model.setMensaje("Ningun registro coincide con el criterio de busqueda");            
            JOptionPane.showMessageDialog(view, model.getMensaje());
        }
        model.setProductos(rows);
 
    }

  public void salir(){
        model.clearErrors();  
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
 }
  
     private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException exc){
		return false;
	}
    }
}