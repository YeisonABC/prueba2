/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.cargoDTO;
import Dto.loginDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class loginDAO extends conexion {

    public ArrayList<cargoDTO> listaLogin() {
        ArrayList miLista = new ArrayList();
        conexion miConexion = new conexion();
        try {
            String sql = "SELECT * FROM login";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                loginDTO login = new loginDTO();
                login.setCodigoLogin(rs.getInt(1));
                login.setCodigoPersona(rs.getInt(2));
                login.setUsuario(rs.getString(3));
                login.setClave(rs.getString(4));
                login.setCorreo(rs.getString(5));
                miLista.add(login);
            }
        } catch (SQLException ex) {
            System.out.println("ocurrio un problema en la instruccion sql, dto o en la conexion" + ex);
        }
        return miLista;
    }

    public ResultSet pstmt(String nombre, String clave) throws ClassNotFoundException {
        this.conectandoBBDD();
        try {
            ps = miConexion.prepareStatement("SELECT  Id_Login, Usuario, Contrasena FROM login WHERE Usuario = ? and Contrasena = ?");
            ps.setString(1, nombre);
            ps.setString(2, clave);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("algo salio ma " + ex);
        }
        return rs;
    }

    public ResultSet cambioContasena(String usuario, String contrasena) throws SQLException, ClassNotFoundException {
        this.conectandoBBDD();
        st = miConexion.createStatement();
        rs = st.executeQuery("SELECT Usuario, Contrasena FROM login WHERE Usuario = '" + usuario + "' AND Contrasena = '" + contrasena + "'");
        return rs;
    }

    public int updateContrsena(String nuevaContrasena, int codigo) throws ClassNotFoundException {
        int i = 1;
        try {
            if (i == 1) {
                this.conectandoBBDD();
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE login SET contrasena = '" + nuevaContrasena + "' WHERE Id_Login='" + codigo + "'");
                i = st.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex);
        }
        return i;
    }

}
