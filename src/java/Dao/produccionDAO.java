/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.produccionDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class produccionDAO extends conexion{
    public ArrayList<produccionDTO> listaProduccion() {
        conexion miConexion = new conexion();
        ArrayList<produccionDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produccion";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                produccionDTO productos = new produccionDTO();
                productos.setCodigoProduccion(rs.getInt(1));
                productos.setNombre(rs.getString(2));
                productos.setFecha(rs.getString(2));
                productos.setTipo(rs.getString(3));
                productos.setCantidad(rs.getInt(4));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error inexperado" + ex);
        }
        return miLista;
    }

    public int insertProducccion( String nombre, String fecha, String tipo, int cantidad) throws ClassNotFoundException {
        int insert = 1;
        try {
            this.conectandoBBDD();
              if(insert==1){
                 PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO produccion ( Nombre, Fecha, Tipo, Cantidad)"
                        + "VALUES (?,?,?,?)");
                st.setString(1, nombre);
                st.setString(2, fecha);
                st.setString(3, tipo);
                st.setInt(4, cantidad);
                insert=st.executeUpdate();                
              }               
            }
         catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return insert;
    }
              
    public int  updateProducto(int codigoProduccion, String nombre, String fecha, String tipo, int cantidad) throws ClassNotFoundException {
         this.conectandoBBDD();
        int update=1;
        try {
           if(update ==1){
            PreparedStatement st = this.miConexion.prepareStatement("UPDATE produccion SET Nombre=?, Fecha=?, Tipo=?, Cantidad=? WHERE Id_Produccion = '" + codigoProduccion + "'");
            st.setString(1, nombre);
            st.setString(2, fecha);
            st.setString(3, tipo);
            st.setInt(4, cantidad);
            update =st.executeUpdate();
           }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }
    
        public int  borrar(int codigoProduccion) throws ClassNotFoundException {
         this.conectandoBBDD();
        int update=1;
        try {
           if(update ==1){
            PreparedStatement st = this.miConexion.prepareStatement("DELETE FROM produccion  WHERE Id_Produccion = '" + codigoProduccion + "'");
            update =st.executeUpdate();
           }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }
}
