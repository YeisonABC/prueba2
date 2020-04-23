/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Cargo;
import Dto.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion;
import org.hibernate.*;

/**
 *
 * @author Familia Beltran
 */
public class personaDAO {

    public List<Persona> leer() {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query consulta = sesion.createQuery("from Persona, Cargo"); //la consulta va dirigida al objeto pojo o dto no a la bbdd
        List<Persona>  lista = consulta.list();
        return lista;
    }

    public ArrayList<Persona> listaPersona() {
        conexion miConexion = new conexion();
        ArrayList<Persona> miLista = new ArrayList<>();
        Cargo cargo = null;
        try {
            String sql = "SELECT * FROM cargo c, persona p WHERE p.Id_Cargo = c.Id_Cargo ORDER BY p.Id_Persona ASC";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt(3));
                persona.setCargo(cargo);
                persona.setNombres(rs.getString(5));
                persona.setApellidos(rs.getString(6));
                persona.setRazonSocial(rs.getString(7));
                persona.setGenero(rs.getString(8));
                persona.setTipoIdentificacion(rs.getString(9));
                persona.setFechaVinculacion(rs.getDate(10));
                persona.setTelefono(rs.getString(11));
                persona.setTipoPersona(rs.getString(12));
                persona.setDireccion(rs.getString(13));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo lista persona DAO " + ex);
        }
        return miLista;
    }

    public int insertEmpleado(int codigo, String nombre, String apellido, String genero, String cedula, String fecha, String telefono, String direccion) {
        int insert = 1;
        String tPersona = "E";
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona (Id_Cargo, Nombres, Apellidos, Genero, Tipo_Identificacion, Fecha_Vinculacion, Telefono, tipo_Persona, Direccion)"
                        + "VALUES (?,?,?,?,?,?,?,?,?)");
                st.setInt(1, codigo);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, genero);
                st.setString(5, cedula);
                st.setString(6, fecha);
                st.setString(7, telefono);
                st.setString(8, tPersona);
                st.setString(9, direccion);
                insert = st.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo insertEmpleado DAO" + e);
        }
        return insert;
    }

    public int insertCliente(String nombre, String apellido, String genero, String cedula, String telefono, String direccion) {
        int insert = 1;
        String tPersona = "C";
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona (Nombres, Apellidos, Genero, Tipo_Identificacion, Telefono, Tipo_Persona, Direccion)"
                        + "VALUES (?,?,?,?,?,?,?)");
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, genero);
                st.setString(4, cedula);
                st.setString(5, telefono);
                st.setString(6, tPersona);
                st.setString(7, direccion);
                insert = st.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("error en el metodo insertCliente DAO " + e);
        }
        return insert;
    }

    public int updateEmpleado(int codigoPer, int codigoCargo, String nombre, String apellido, String genero, String cedula, String fecha, String telefono) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE persona SET Id_Cargo =?, Nombres=?, Apellidos=?, Genero=?, Tipo_Identificacion=?, Fecha_Vinculacion=?, Telefono =? WHERE Id_Persona = '" + codigoPer + "'");
                st.setInt(1, codigoCargo);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, genero);
                st.setString(5, cedula);
                st.setString(6, fecha);
                st.setString(7, telefono);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo updateEmpleado DAO" + e);
        }
        return update;
    }

    public int updateCliente(int codigoPer, String nombre, String apellido, String genero, String cedula, String telefono, String direccion) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE persona SET Nombres=?, Apellidos=?, Genero=?, Tipo_Identificacion=?, Telefono =?, Direccion =? WHERE Id_Persona = '" + codigoPer + "'");
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, genero);
                st.setString(4, cedula);
                st.setString(5, telefono);
                st.setString(6, direccion);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error updateCliente DAO" + e);
        }
        return update;
    }

    public ArrayList<personaCargoDTO> listaPersonaCargo() {
        conexion miConexion = new conexion();
        ArrayList<personaCargoDTO> miLista = new ArrayList<>();
        try {

            String sql = "SELECT * FROM cargo c, persona p WHERE p.Id_Cargo = c.Id_Cargo ORDER BY p.Id_Persona ASC";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                personaCargoDTO persona = new personaCargoDTO();
                persona.setCodigoCargo(rs.getInt(1));
                persona.setNombreCargo(rs.getString(2));
                persona.setCodigoPersona(rs.getInt(3));
                persona.setNombrePersona(rs.getString(5));
                persona.setApellido(rs.getString(6));
                persona.setGenero(rs.getString(8));
                persona.setCedula(rs.getString(9));
                persona.setFechaVinculacion(rs.getDate(10));
                persona.setTelefono(rs.getString(11));
                persona.setTipoPersona(rs.getString(12));
                persona.setDireccion(rs.getString(13));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaPersonaCargo DAO " + ex);
        }
        return miLista;
    }

    public ArrayList<personaFacturaDTO> listaPersonaFactura() {
        conexion miConexion = new conexion();
        ArrayList<personaFacturaDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM factura f, persona p WHERE f.Id_Persona = p.Id_Persona ORDER BY f.Id_Factura ASC";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                personaFacturaDTO persona = new personaFacturaDTO();
                persona.setCodigoFactura(rs.getInt(1));
                persona.setCodigoPersona(rs.getInt(2));
                persona.setTipoFactura(rs.getString(3));
                persona.setFormaPago(rs.getString(4));
                persona.setFecha(rs.getDate(5));
                persona.setCodigoCargo(rs.getInt(7));
                persona.setNombrePersona(rs.getString(8));
                persona.setApellido(rs.getString(9));
                persona.setGenero(rs.getString(10));
                persona.setCedula(rs.getString(11));
                persona.setFechaVinculacion(rs.getDate(12));
                persona.setTelefono(rs.getString(13));
                persona.setTipoPersona(rs.getString(14));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaPersonaFactura" + ex);
        }
        return miLista;
    }

}
