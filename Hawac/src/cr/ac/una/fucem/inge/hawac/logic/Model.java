/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.fucem.inge.hawac.logic;
import cr.ac.una.fucem.inge.hawac.bl.*;
import cr.ac.una.fucem.inge.hawac.domain.Usuario;
import java.util.Collection;
import java.util.List;

public class Model {
    private AbonoBL abonoBl;
    private ApartadoBL apartadoBl;
    private ApartadoproductoBL apartado_productoBl;
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
        apartado_productoBl = new ApartadoproductoBL();
        bitacoraBl = new BitacoraBL();
        clienteBl = new ClienteBL();
        facturaBl = new FacturaBL();
        inventarioBl = new InventarioBL();
        lineaBl = new LineaBL();
        productoBl = new ProductoBL();
        usuarioBl = new UsuarioBL();
    }
    
    public Usuario getUsuario(int id, String clave) throws Exception{
        Usuario u1 = usuarioBl.findById(id);
        if(u1.getPassword().equals(clave)){
            return u1;
        }else{
            throw new Exception ("Contraseña Incorrecta");
        }
    }

    public AbonoBL getAbonoBl() {
        return abonoBl;
    }

    public ApartadoBL getApartadoBl() {
        return apartadoBl;
    }

    public ApartadoproductoBL getApartado_productoBl() {
        return apartado_productoBl;
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

}
   


