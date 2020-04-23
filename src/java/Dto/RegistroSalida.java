package Dto;
// Generated 11/04/2020 06:09:23 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * RegistroSalida generated by hbm2java
 */
public class RegistroSalida  implements java.io.Serializable {


     private Integer idRegistroSalida;
     private Insumos insumos;
     private Persona persona;
     private Date fecha;
     private int cantidad;

    public RegistroSalida() {
    }

    public RegistroSalida(Insumos insumos, Persona persona, Date fecha, int cantidad) {
       this.insumos = insumos;
       this.persona = persona;
       this.fecha = fecha;
       this.cantidad = cantidad;
    }
   
    public Integer getIdRegistroSalida() {
        return this.idRegistroSalida;
    }
    
    public void setIdRegistroSalida(Integer idRegistroSalida) {
        this.idRegistroSalida = idRegistroSalida;
    }
    public Insumos getInsumos() {
        return this.insumos;
    }
    
    public void setInsumos(Insumos insumos) {
        this.insumos = insumos;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}

