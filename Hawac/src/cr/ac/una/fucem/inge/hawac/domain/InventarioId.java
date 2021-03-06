package cr.ac.una.fucem.inge.hawac.domain;
// Generated 24-mar-2017 14:24:28 by Hibernate Tools 4.3.1



/**
 * InventarioId generated by hbm2java
 */
public class InventarioId  implements java.io.Serializable {


     private String local;
     private int producto;

    public InventarioId() {
    }

    public InventarioId(String local, int producto) {
       this.local = local;
       this.producto = producto;
    }
   
    public String getLocal() {
        return this.local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    public int getProducto() {
        return this.producto;
    }
    
    public void setProducto(int producto) {
        this.producto = producto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InventarioId) ) return false;
		 InventarioId castOther = ( InventarioId ) other; 
         
		 return ( (this.getLocal()==castOther.getLocal()) || ( this.getLocal()!=null && castOther.getLocal()!=null && this.getLocal().equals(castOther.getLocal()) ) )
 && (this.getProducto()==castOther.getProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocal() == null ? 0 : this.getLocal().hashCode() );
         result = 37 * result + this.getProducto();
         return result;
   }   


}


