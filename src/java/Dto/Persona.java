package Dto;
// Generated 11/04/2020 06:09:23 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer idPersona;
     public Cargo cargo;
     private String nombres;
     private String apellidos;
     private String razonSocial;
     private String genero;
     private String tipoIdentificacion;
     private Date fechaVinculacion;
     private String telefono;
     private String tipoPersona;
     private String direccion;
     private Set facturas = new HashSet(0);
     private Set logins = new HashSet(0);
     private Set registroSalidas = new HashSet(0);

    public Persona() {
    }

    public Persona(Cargo cargo, String nombres, String apellidos, String razonSocial, String genero, String tipoIdentificacion, Date fechaVinculacion, String telefono, String tipoPersona, String direccion, Set facturas, Set logins, Set registroSalidas) {
       this.cargo = cargo;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.razonSocial = razonSocial;
       this.genero = genero;
       this.tipoIdentificacion = tipoIdentificacion;
       this.fechaVinculacion = fechaVinculacion;
       this.telefono = telefono;
       this.tipoPersona = tipoPersona;
       this.direccion = direccion;
       this.facturas = facturas;
       this.logins = logins;
       this.registroSalidas = registroSalidas;
    }
   
    public Integer getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public Date getFechaVinculacion() {
        return this.fechaVinculacion;
    }
    
    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipoPersona() {
        return this.tipoPersona;
    }
    
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getLogins() {
        return this.logins;
    }
    
    public void setLogins(Set logins) {
        this.logins = logins;
    }
    public Set getRegistroSalidas() {
        return this.registroSalidas;
    }
    
    public void setRegistroSalidas(Set registroSalidas) {
        this.registroSalidas = registroSalidas;
    }




}


