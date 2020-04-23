package Dao;

import Dto.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

public class cargoDAO extends conexion {

    public ArrayList<Cargo> listaCargos() {
        ArrayList miLista = new ArrayList();
        conexion miConexion = new conexion();
        try {
            String sql = "SELECT * FROM cargo";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                Cargo miCargo = new Cargo();
                miCargo.setIdCargo(rs.getInt("Id_Cargo"));
                miCargo.setNombre(rs.getString("Nombre"));
                miLista.add(miCargo);
            }
        } catch (SQLException ex) {
            System.out.println("ocurrio un problema en la instruccion sql, dto o en la conexion" + ex);
        }
        return miLista;
    }

    public int insertCliente(String nombre, String apellido, String genero, String cedula, String telefono, String tipoPer) {
        int insert = 1;
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona (Nombre, Apellido, Genero, Tipo_Identificacion, Telefono, Tipo_Persona)"
                        + "VALUES (?,?,?,?,?,?)");
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, genero);
                st.setString(4, cedula);
                st.setString(5, telefono);
                st.setString(6, tipoPer);
                insert = st.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {

        }
        return insert;
    }

    public int EditarCargo(int codigoCargo, String nombre) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE cargo SET Nombre=? WHERE Id_Cargo = '" + codigoCargo + "'");
                st.setString(1, nombre);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }

}
