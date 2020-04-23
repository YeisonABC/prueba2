/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.facturaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class facturaDAO extends conexion {

    public ArrayList<facturaDTO> lilstaFacturas() {
        conexion miConexion = new conexion();
        ArrayList<facturaDTO> miLista = new ArrayList();
        try {
            String sql = "SELECT * FROM factura";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                facturaDTO miFactura = new facturaDTO();
                miFactura.setCodigoFactura(rs.getInt("Id_Factura"));
                miFactura.setCodigoPersona(rs.getInt("Id_Persona"));
                miFactura.setTipoFactura(rs.getString("Tipo_Factura"));
                miFactura.setFormaPago(rs.getString("Forma_Pago"));
                miFactura.setFecha(rs.getDate("Fecha"));
                miLista.add(miFactura);
            }
        } catch (Exception e) {
            System.out.println("Algo salio mal verifica la sentencia " + e);
        }
        return miLista;
    }

    public int update(int codigoFac, int codigoPer, String tipoFactura, String formaPago, String fecha) throws ClassNotFoundException {
        int edita = 1;
        try {
            this.conectandoBBDD();
            if (edita == 1) {
                PreparedStatement ste = this.miConexion.prepareStatement("UPDATE factura SET Id_Persona =?, Tipo_Factura=?, Forma_Pago=?, Fecha=? WHERE Id_Factura ='" + codigoFac + "';");
                ste.setInt(1, codigoPer);
                ste.setString(2, tipoFactura);
                ste.setString(3, formaPago);
                ste.setString(4, fecha);
                edita=ste.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return edita;
    }
    
    public int insertar(int codigoFac, int codigoPer, String tipoFactura, String formaPago, String fecha) throws ClassNotFoundException {
        int edita = 1;
        this.conectandoBBDD();
        try {
            if (edita == 1) {
                PreparedStatement ste = this.miConexion.prepareStatement("INSERT INTO factura VALUES Id_Persona =?, Tipo_Factura=?, Forma_Pago=?, Fecha=? WHERE Id_Factura ='" + codigoFac + "'");
                ste.setInt(1, codigoPer);
                ste.setString(2, tipoFactura);
                ste.setString(3, formaPago);
                ste.setString(4, fecha);
                edita=ste.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return edita;
    }
}
