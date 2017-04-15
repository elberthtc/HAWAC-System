/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hawac;
import cr.ac.una.fucem.inge.hawac.controller.*;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import cr.ac.una.fucem.inge.hawac.logic.Model;
import cr.ac.una.fucem.inge.hawac.model.*;
import cr.ac.una.fucem.inge.hawac.view.*;
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
        USUARIOS_VIEW=empleadosView;
        applicationView.addInternalFrame(empleadosView);
        UsuariosController empleadosController= new UsuariosController(empleadosView,empleadosModel,domainModel,session);
 
        
        UsuarioModel empleadoModel = new UsuarioModel();
        UsuarioView empleadoView= new UsuarioView(applicationView,true);
        EMPLEADO_VIEW=empleadoView;
        UsuarioController empleadoController= new UsuarioController(empleadoView, empleadoModel, domainModel,session);
        
        InventarioModel inventarioModel = new InventarioModel();
        InventarioView inventarioView = new InventarioView(applicationView,true);
        INVENTARIO_VIEW=inventarioView;
        InventarioController inventarioControler = new InventarioController(inventarioView,inventarioModel,domainModel,session);
        
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
        
        ClientesApartadoView clieApaView = new ClientesApartadoView();
        CLIENTES_APARTADO_VIEW = clieApaView;
        applicationView.addInternalFrame(clieApaView);
        ClientesApartadoController clieAparController = new ClientesApartadoController(clieApaView,session,clientesModel,domainModel);
        
        ProductosModel productosModel = new ProductosModel();
        ProductosView productosView = new ProductosView();
        PRODUCTOS_VIEW = productosView;
        applicationView.addInternalFrame(productosView);
        ProductosController productoscontroller = new ProductosController(productosView,session,productosModel,domainModel);
        
        
        BitacorasModel bitacorasModel = new BitacorasModel();
        BitacorasView bitacorasView = new BitacorasView();
        BITACORAS_VIEW = bitacorasView;
        applicationView.addInternalFrame(bitacorasView);
        BitacorasController bitacorascontroller = new BitacorasController(bitacorasView,session,bitacorasModel,domainModel);
        
        ApartadosModel apartadosModel = new ApartadosModel();
        ApartadosView apartadosView = new ApartadosView();
        APARTADOS_VIEW = apartadosView;
        applicationView.addInternalFrame(apartadosView);
        ApartadosController apartadoscontroller = new ApartadosController(apartadosView,session,apartadosModel,domainModel);
        
        AbonosModel abonosModel = new AbonosModel();
        AbonosView abonosView = new AbonosView();
        ABONOS_VIEW = abonosView;
        applicationView.addInternalFrame(abonosView);
        AbonosController abonoscontroller = new AbonosController(abonosView, session, abonosModel, domainModel);
        
        InventariosModel inventariosModel = new InventariosModel();
        InventariosView inventariosView = new InventariosView();
        INVENTARIO_TIENDA_VIEW = inventariosView;
        applicationView.addInternalFrame(inventariosView);
        InventariosController inventariosController = new InventariosController(inventariosView,inventariosModel,domainModel,session);
        
        //InventariosModel inventariosModel = new InventariosModel();
        InventariosView inventariosView2 = new InventariosView();
        INVENTARIO_FABRICA_VIEW = inventariosView2;
        applicationView.addInternalFrame(inventariosView2);
        InventariosController inventariosController1 = new InventariosController(inventariosView2,inventariosModel,domainModel,session);
        
        /*FacturasVentasModel facturasVentasModel = new FacturasVentasModel();
        FacturasVentasView facturasVentasView = new FacturasVentasView();
        FACTURAS_VENTAS_VIEW = facturasVentasView;
        applicationView.addInternalFrame(facturasVentasView);
        FacturasVentasController factVentasController = new FacturasVentasController(facturasVentasView,facturasVentasModel,domainModel,session);
        
        */
       
        
        FacturasPagadasModel facturasPagadasModel = new FacturasPagadasModel();
        FacturasPagadasView facturasPagadasView = new FacturasPagadasView();
        FACTURAS_PAGADAS_VIEW = facturasPagadasView;
        applicationView.addInternalFrame(facturasPagadasView);
        FacturasPagadasController factPagadasController = new FacturasPagadasController(facturasPagadasView,facturasPagadasModel,domainModel,session);
        
       
        
        ProductoModel productoModel = new ProductoModel();
        ProductoView productoView = new ProductoView(applicationView,true);
        PRODUCTO_VIEW = productoView;
        ProductoController productoController = new ProductoController(productoView,productoModel,domainModel,session); 
       
        ApartadoModel apartadoModel = new ApartadoModel();
        ApartadoView apartadoView = new ApartadoView(applicationView,true);
        APARTADO_VIEW = apartadoView;
        ApartadoController apartadoController = new ApartadoController(apartadoView,apartadoModel,domainModel,session); 
        
        AbonoModel abonoModel = new AbonoModel();
        AbonoView abonoView = new AbonoView(applicationView,true);
        ABONO_VIEW = abonoView;
        AbonoController abonoController = new AbonoController(abonoView,abonoModel,domainModel,session); 
        
        ProductoFacturaView productoFacturaView=new ProductoFacturaView();
        PRODUCTOFACTURA_VIEW=productoFacturaView;
        applicationView.addInternalFrame(productoFacturaView);
        ProductoFacturaController productoFacturaController=new ProductoFacturaController(productoFacturaView,session,productosModel,domainModel);
        
        ProductoApartadoView productoApartadoView=new ProductoApartadoView();
        PRODUCTO_APARTADO_VIEW=productoApartadoView;
        applicationView.addInternalFrame(productoApartadoView);
        ProductoApartadoController productoApartadoController=new ProductoApartadoController(productoApartadoView,session,productosModel,domainModel);
        
        ProductoInventarioView productoInventarioView = new ProductoInventarioView();
        PRODUCTOINVENTARIO_VIEW=productoInventarioView;
        applicationView.addInternalFrame(productoInventarioView);
        ProductoInventarioController productoInventarioController = new ProductoInventarioController(productoInventarioView,session,productosModel,domainModel);
        
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

        */
        
        EfectivoModel efectivoModel = new EfectivoModel();
        EfectivoView efectivoView = new EfectivoView(applicationView,true);
        Efectivo_VIEW = efectivoView;
        EfectivoController  efectivoController = new EfectivoController(efectivoView,efectivoModel,domainModel,session);
        
        /*
        
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
 
    public static Usuario USUARIO;
    
    public static About ABOUT;
    public static InventarioMenuView INVENTARIO_MENU;
    public static ApplicationView APPLICATION_VIEW;     
    public static LoginView LOGIN_VIEW; 
    public static ClientesView CLIENTES_VIEW;
    public static ClientesFacturaView CLIENTES_FACTURA_VIEW;
    public static ClientesApartadoView CLIENTES_APARTADO_VIEW;
    public static ClienteView CLIENTE_VIEW;
    public static ProductosView PRODUCTOS_VIEW;
    public static BitacorasView BITACORAS_VIEW;
    public static ApartadosView APARTADOS_VIEW;
    public static AbonosView ABONOS_VIEW;
    public static ProductoView PRODUCTO_VIEW;
    public static ProductoApartadoView PRODUCTO_APARTADO_VIEW;
    public static ApartadoView APARTADO_VIEW;
    public static AbonoView ABONO_VIEW;
    public static UsuariosView USUARIOS_VIEW;
    public static UsuarioView EMPLEADO_VIEW;
    public static FacturaView FACTURA_VIEW;
    public static InventariosView INVENTARIO_TIENDA_VIEW;
    public static InventariosView INVENTARIO_FABRICA_VIEW;
    //public static FacturaCompraView FACTURA_COMPRA_VIEW;
    public static ProductoFacturaView PRODUCTOFACTURA_VIEW;
    public static InventarioView INVENTARIO_VIEW;
    public static ProductoInventarioView PRODUCTOINVENTARIO_VIEW;
    public static FacturasVentasView FACTURAS_VENTAS_VIEW;
    public static FacturasPagadasView FACTURAS_PAGADAS_VIEW;
    //public static ChequeView Cheque_VIEW;
    public static EfectivoView Efectivo_VIEW;
    //public static TarjetaCreditoView TarjetaCredito_VIEW;
       
    public static final int MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_CONSULTAR=2;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    
    public static int CANTIDAD = -1;
    public static String INVENTARIO = "";
    public static  final String  ROL_NOTAUTHORIZED="No Autorizado!";
}
