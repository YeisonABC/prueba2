package Dto;
// Generated 11/04/2020 06:09:23 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private Integer idFactura;
     private Persona persona;
     private String tipoFactura;
     private String formaPago;
     private String fecha;
     private Set detalleFacturas = new HashSet(0);

    public Factura() {
    }

	
    public Factura(Persona persona, String tipoFactura, String formaPago, String fecha) {
        this.persona = persona;
        this.tipoFactura = tipoFactura;
        this.formaPago = formaPago;
        this.fecha = fecha;
    }
    public Factura(Persona persona, String tipoFactura, String formaPago, String fecha, Set detalleFacturas) {
       this.persona = persona;
       this.tipoFactura = tipoFactura;
       this.formaPago = formaPago;
       this.fecha = fecha;
       this.detalleFacturas = detalleFacturas;
    }
   
    public Integer getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getTipoFactura() {
        return this.tipoFactura;
    }
    
    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Set getDetalleFacturas() {
        return this.detalleFacturas;
    }
    
    public void setDetalleFacturas(Set detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }




}


