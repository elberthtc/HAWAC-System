/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.logic;
import cr.ac.una.fucem.inge.hawac.bl.*;
import cr.ac.una.fucem.inge.hawac.domain.Factura;
import cr.ac.una.fucem.inge.hawac.domain.Inventario;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import hawac.Application;
import java.util.Collection;
import java.util.List;

public class Model {
    private AbonoBL abonoBl;
    private ApartadoBL apartadoBl;
    private BitacoraBL bitacoraBl;
    private ClienteBL clienteBl;
    private FacturaBL facturaBl;
    private InventarioBL inventarioBl;
    private LineaBL lineaBl;
    private ProductoBL productoBl;
    private UsuarioBL usuarioBl;
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }
    private Model(){
        abonoBl = new AbonoBL();
        apartadoBl = new ApartadoBL();
        bitacoraBl = new BitacoraBL();
        clienteBl = new ClienteBL();
        facturaBl = new FacturaBL();
        inventarioBl = new InventarioBL();
        lineaBl = new LineaBL();
        productoBl = new ProductoBL();
        usuarioBl = new UsuarioBL();
        Application.CANTIDAD = facturaBl.findAll(Factura.class.getName()).size() + 1;
    }
    
    public Usuario getUsuario(int id, String clave) throws Exception{
        Usuario u1 = usuarioBl.findById(id);
        if(u1.getPassword().equals(clave)){
            return u1;
        }else{
            throw new Exception ("Contraseña Incorrecta");
        }
    }
    
    public List<Inventario> getInventario(){
        List<Inventario> inventarios = inventarioBl.findAll(Inventario.class.getName());
        int i=0, cont=inventarios.size();
        while(inventarios.size()>0 && cont > 0){
            if(inventarios.get(i).getId().getLocal().compareTo(Application.INVENTARIO)!=0){
                inventarios.remove(inventarios.get(i));
            }else
                i++;
            cont--;
        }
        return inventarios;
    }

    public AbonoBL getAbonoBl() {
        return abonoBl;
    }

    public ApartadoBL getApartadoBl() {
        return apartadoBl;
    }

    public BitacoraBL getBitacoraBl() {
        return bitacoraBl;
    }

    public ClienteBL getClienteBl() {
        return clienteBl;
    }

    public FacturaBL getFacturaBl() {
        return facturaBl;
    }

    public InventarioBL getInventarioBl() {
        return inventarioBl;
    }

    public LineaBL getLineaBl() {
        return lineaBl;
    }

    public ProductoBL getProductoBl() {
        return productoBl;
    }

    public UsuarioBL getUsuarioBl() {
        return usuarioBl;
    }

    public static Model getUniqueInstance() {
        return uniqueInstance;
    }
 
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean isNumeric2(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

}