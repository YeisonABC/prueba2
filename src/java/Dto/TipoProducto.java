package Dto;
// Generated 11/04/2020 06:09:23 PM by Hibernate Tools 4.3.1



/**
 * TipoProducto generated by hbm2java
 */
public class TipoProducto  implements java.io.Serializable {


     private int idTipoProducto;
     private Produccion produccion;
     private Productos productos;
     private String nombre;

    public TipoProducto() {
    }

    public TipoProducto(Produccion produccion, Productos productos, String nombre) {
       this.produccion = produccion;
       this.productos = productos;
       this.nombre = nombre;
    }
   
    public int getIdTipoProducto() {
        return this.idTipoProducto;
    }
    
    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }
    public Produccion getProduccion() {
        return this.produccion;
    }
    
    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


