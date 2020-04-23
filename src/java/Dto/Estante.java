package Dto;
// Generated 11/04/2020 06:09:23 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estante generated by hbm2java
 */
public class Estante  implements java.io.Serializable {


     private Integer idEstante;
     private String nombre;
     private int existencia;
     private Set productoses = new HashSet(0);
     private Set bodegas = new HashSet(0);

    public Estante() {
    }

	
    public Estante(String nombre, int existencia) {
        this.nombre = nombre;
        this.existencia = existencia;
    }
    public Estante(String nombre, int existencia, Set productoses, Set bodegas) {
       this.nombre = nombre;
       this.existencia = existencia;
       this.productoses = productoses;
       this.bodegas = bodegas;
    }
   
    public Integer getIdEstante() {
        return this.idEstante;
    }
    
    public void setIdEstante(Integer idEstante) {
        this.idEstante = idEstante;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getExistencia() {
        return this.existencia;
    }
    
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public Set getProductoses() {
        return this.productoses;
    }
    
    public void setProductoses(Set productoses) {
        this.productoses = productoses;
    }
    public Set getBodegas() {
        return this.bodegas;
    }
    
    public void setBodegas(Set bodegas) {
        this.bodegas = bodegas;
    }




}


