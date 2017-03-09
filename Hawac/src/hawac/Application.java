/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hawac;
import cr.ac.una.fucem.inge.hawac.controller.ApplicationController;
import cr.ac.una.fucem.inge.hawac.controller.ClienteController;
import cr.ac.una.fucem.inge.hawac.controller.ClientesController;
import cr.ac.una.fucem.inge.hawac.controller.ClientesFacturaController;
import cr.ac.una.fucem.inge.hawac.controller.UsuariosController;
import cr.ac.una.fucem.inge.hawac.controller.FacturaController;
import cr.ac.una.fucem.inge.hawac.controller.FacturasVentasController;
import cr.ac.una.fucem.inge.hawac.controller.InventariosController;
import cr.ac.una.fucem.inge.hawac.controller.LoginController;
import cr.ac.una.fucem.inge.hawac.controller.ProductoController;
import cr.ac.una.fucem.inge.hawac.controller.ProductoFacturaController;
import cr.ac.una.fucem.inge.hawac.controller.ProductosController;
import cr.ac.una.fucem.inge.hawac.controller.UsuarioController;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.ApplicationModel;
import cr.ac.una.fucem.inge.hawac.model.ClienteModel;
import cr.ac.una.fucem.inge.hawac.model.ClientesModel;
import cr.ac.una.fucem.inge.hawac.model.FacturaModel;
import cr.ac.una.fucem.inge.hawac.model.FacturasVentasModel;
import cr.ac.una.fucem.inge.hawac.model.InventariosModel;
import cr.ac.una.fucem.inge.hawac.model.LoginModel;
import cr.ac.una.fucem.inge.hawac.model.ProductoModel;
import cr.ac.una.fucem.inge.hawac.model.ProductosModel;
import cr.ac.una.fucem.inge.hawac.model.UsuarioModel;
import cr.ac.una.fucem.inge.hawac.model.UsuariosModel;
import cr.ac.una.fucem.inge.hawac.view.About;
import cr.ac.una.fucem.inge.hawac.view.ApplicationView;
import cr.ac.una.fucem.inge.hawac.view.ClienteView;
import cr.ac.una.fucem.inge.hawac.view.ClientesFacturaView;
import cr.ac.una.fucem.inge.hawac.view.ClientesView;
import cr.ac.una.fucem.inge.hawac.view.UsuarioView;
import cr.ac.una.fucem.inge.hawac.view.UsuariosView;
import cr.ac.una.fucem.inge.hawac.view.FacturaView;
import cr.ac.una.fucem.inge.hawac.view.FacturasPagadasView;
import cr.ac.una.fucem.inge.hawac.view.FacturasVentasView;
import cr.ac.una.fucem.inge.hawac.view.InventarioMenuView;
import cr.ac.una.fucem.inge.hawac.view.InventariosView;
import cr.ac.una.fucem.inge.hawac.view.LoginView;
import cr.ac.una.fucem.inge.hawac.view.ProductoFacturaView;
import cr.ac.una.fucem.inge.hawac.view.ProductoView;
import cr.ac.una.fucem.inge.hawac.view.ProductosView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;



public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();
        Session session = new Session();
        
        ApplicationModel applicationModel = new ApplicationModel();
        ApplicationView applicationView= new ApplicationView();
        APPLICATION_VIEW=applicationView;
        ApplicationController applicationController = new ApplicationController(applicationView,applicationModel,domainModel,session);
        
        UsuariosModel empleadosModel = new UsuariosModel();
        UsuariosView empleadosView=new UsuariosView();
        EMPLEADOS_VIEW=empleadosView;
        applicationView.addInternalFrame(empleadosView);
        UsuariosController empleadosController= new UsuariosController(empleadosView,empleadosModel,domainModel,session);
 
        
        UsuarioModel empleadoModel = new UsuarioModel();
        UsuarioView empleadoView= new UsuarioView(applicationView,true);
        EMPLEADO_VIEW=empleadoView;
        UsuarioController empleadoController= new UsuarioController(empleadoView, empleadoModel, domainModel,session);
        
        ClientesModel clientesModel = new ClientesModel();
        ClientesView clientesView = new ClientesView();
        CLIENTES_VIEW= clientesView;
        applicationView.addInternalFrame(clientesView);
        ClientesController clientescontroller = new ClientesController(clientesView,session,clientesModel,domainModel);
 
        ClienteModel clienteModel = new ClienteModel();
        ClienteView clienteView = new ClienteView(applicationView,true);
        CLIENTE_VIEW = clienteView;
        ClienteController clienteController = new ClienteController(clienteView,clienteModel,domainModel,session);      
        
        ClientesFacturaView clieFacView = new ClientesFacturaView();
        CLIENTES_FACTURA_VIEW = clieFacView;
        applicationView.addInternalFrame(clieFacView);
        ClientesFacturaController clieFacturaController = new ClientesFacturaController(clieFacView,session,clientesModel,domainModel);
        
        ProductosModel productosModel = new ProductosModel();
        ProductosView productosView = new ProductosView();
        PRODUCTOS_VIEW = productosView;
        applicationView.addInternalFrame(productosView);
        ProductosController productoscontroller = new ProductosController(productosView,session,productosModel,domainModel);
        
        
        InventariosModel inventariosModel = new InventariosModel();
        InventariosView inventariosView = new InventariosView();
        INVENTARIOS_VIEW = inventariosView;
        applicationView.addInternalFrame(inventariosView);
        InventariosController inventariosController = new InventariosController(inventariosView,inventariosModel,domainModel,session);
        
        FacturasVentasModel facturasVentasModel = new FacturasVentasModel();
        FacturasVentasView facturasVentasView = new FacturasVentasView();
        FACTURAS_VENTAS_VIEW = facturasVentasView;
        applicationView.addInternalFrame(facturasVentasView);
        FacturasVentasController factVentasController = new FacturasVentasController(facturasVentasView,facturasVentasModel,domainModel,session);
        
        /*
        
        FacturasPagadasModel facturasPagadasModel = new FacturasPagadasModel();
        FacturasPagadasView facturasPagadasView = new FacturasPagadasView();
        FACTURAS_PAGADAS_VIEW = facturasPagadasView;
        applicationView.addInternalFrame(facturasPagadasView);
        FacturasPagadasController factPagadasController = new FacturasPagadasController(facturasPagadasView,facturasPagadasModel,domainModel,session);
        
        */
        
        ProductoModel productoModel = new ProductoModel();
        ProductoView productoView = new ProductoView(applicationView,true);
        PRODUCTO_VIEW = productoView;
        ProductoController productoController = new ProductoController(productoView,productoModel,domainModel,session); 
       
        ProductoFacturaView productoFacturaView=new ProductoFacturaView();
        PRODUCTOFACTURA_VIEW=productoFacturaView;
        applicationView.addInternalFrame(productoFacturaView);
        ProductoFacturaController productoFacturaController=new ProductoFacturaController(productoFacturaView,session,productosModel,domainModel);
        
        FacturaModel facturaModel = new FacturaModel();
        FacturaView facturaView = new FacturaView();
        FACTURA_VIEW = facturaView;
        applicationView.addInternalFrame(facturaView);
        FacturaController  facturaController = new FacturaController(facturaView,facturaModel,domainModel,session);
        
        /*
        
        FacturaCompraModel facturaCompraModel= new FacturaCompraModel();
        FacturaCompraView facturaCompraView = new FacturaCompraView();
        FACTURA_COMPRA_VIEW=facturaCompraView;
        applicationView.addInternalFrame(facturaCompraView);
        FacturaCompraController facturaCompraController = new FacturaCompraController(facturaCompraView, facturaCompraModel, domainModel, session);
        
        
        ChequeModel chequeModel = new ChequeModel();
        ChequeView chequeView = new ChequeView(applicationView,true);
        Cheque_VIEW = chequeView;
        ChequeController  chequeController = new ChequeController(chequeView,chequeModel,domainModel,session);
        
        EfectivoModel efectivoModel = new EfectivoModel();
        EfectivoView efectivoView = new EfectivoView(applicationView,true);
        Efectivo_VIEW = efectivoView;
        EfectivoController  efectivoController = new EfectivoController(efectivoView,efectivoModel,domainModel,session);
        
        TarjetaCreditoModel tarjetacreditoModel = new TarjetaCreditoModel();
        TarjetaCreditoView tarjetacreditoView = new TarjetaCreditoView(applicationView,true);
        TarjetaCredito_VIEW = tarjetacreditoView;
        TarjetaCreditoController  tarjetacreditoController = new TarjetaCreditoController(tarjetacreditoView,tarjetacreditoModel,domainModel,session);
        
        */
                
        LoginModel loginModel = new LoginModel();
        LoginView loginView= new LoginView();
        LOGIN_VIEW=loginView;
        LoginController logincontroller = new LoginController(loginView,loginModel,domainModel,session);
        loginView.setVisible(true);
        
        InventarioMenuView inventarioMenu = new InventarioMenuView(applicationView,true);
        INVENTARIO_MENU = inventarioMenu;
        
        About about= new About();
        ABOUT= about;
        
    }
 
    public static About ABOUT;
    public static InventarioMenuView INVENTARIO_MENU;
    public static ApplicationView APPLICATION_VIEW;     
    public static LoginView LOGIN_VIEW; 
    public static ClientesView CLIENTES_VIEW;
    public static ClientesFacturaView CLIENTES_FACTURA_VIEW;
    public static ClienteView CLIENTE_VIEW;
    public static ProductosView PRODUCTOS_VIEW;
    public static ProductoView PRODUCTO_VIEW;
    public static UsuariosView EMPLEADOS_VIEW;
    public static UsuarioView EMPLEADO_VIEW;
    public static FacturaView FACTURA_VIEW;
    public static InventariosView INVENTARIOS_VIEW;
    //public static FacturaCompraView FACTURA_COMPRA_VIEW;
    public static ProductoFacturaView PRODUCTOFACTURA_VIEW;
    public static FacturasVentasView FACTURAS_VENTAS_VIEW;
    public static FacturasPagadasView FACTURAS_PAGADAS_VIEW;
    //public static ChequeView Cheque_VIEW;
    //public static EfectivoView Efectivo_VIEW;
    //public static TarjetaCreditoView TarjetaCredito_VIEW;
       
    public static final int MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_CONSULTAR=2;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static String INVENTARIO = "";
    public static  final String  ROL_NOTAUTHORIZED="No Autorizado!";
}
