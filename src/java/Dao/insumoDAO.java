/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.insumoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class insumoDAO extends conexion {
    
    public ArrayList<insumoDTO> listaInsumo() {
        conexion miConexion = new conexion();
        ArrayList<insumoDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM insumos";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                insumoDTO insumo = new insumoDTO();
                insumo.setCodigoInsumo(rs.getInt(1));
                insumo.setNombre(rs.getString(2));
                insumo.setCantidad(rs.getInt(3));
                insumo.setPrecio(rs.getInt(4));
                insumo.setDescripcion(rs.getString(5));
                insumo.setFecha(rs.getDate(6));
                miLista.add(insumo);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaInusmo DAO" + ex);
        }
        return miLista;
    }

    public int insertInsumo(String nombre, String unidadMedida, int cantidad, int precio, String fecha) throws ClassNotFoundException {
        int insert = 1;        
        try {
            this.conectandoBBDD();
              if(insert==1){
                 PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO insumos(Nombre, Cantidad, Precio, Descripcion, Fecha)"
                        + "VALUES (?,?,?,?,?);");
                st.setString(1, nombre);
                st.setInt(2, cantidad);
                st.setInt(3, precio);
                st.setString(4, unidadMedida);
                 st.setString(5, fecha);
                insert=st.executeUpdate();                
              }               
            }
         catch (Exception e) {
            System.out.println("Error inexperado" + e);
        }
        return insert;
    }
           
    public int  updateInsumo(int codigoInsumo, String nombre, String unidadMedida, String fecha, int cantidad, int precio) throws ClassNotFoundException {
        
        int update=1;
        try {
            this.conectandoBBDD(); 
           if(update ==1){
            PreparedStatement st = this.miConexion.prepareStatement("UPDATE insumos SET Nombre=?, Cantidad =?, Precio =?, Descripcion=?, Fecha =? WHERE Id_Insumos = '" + codigoInsumo + "';");
            st.setString(1, nombre);
            st.setInt(2, cantidad);
            st.setInt(3, precio);
            st.setString(4, unidadMedida);
            st.setString(5, fecha);
            update =st.executeUpdate();
           }
        } catch (SQLException e) {
            System.out.println("Error en el metodo updateInusmo DAO" + e);
        }
        return update;
    }  
}
