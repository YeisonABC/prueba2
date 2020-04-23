/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.detalleFacturaDTO;
import Dto.detalleFacturaNombresDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class detalleFacturaDAO extends conexion {

    public ArrayList<detalleFacturaDTO> listaDetalle() {
        conexion miConexion = new conexion();
        ArrayList<detalleFacturaDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detalle_factura";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                detalleFacturaDTO productos = new detalleFacturaDTO();
                productos.setCodigoDetalle(rs.getInt(1));
                productos.setCodigoFactura(rs.getInt(2));
                productos.setCodigoInsumo(rs.getInt(3));
                productos.setCodigoProducto(rs.getInt(4));
                productos.setValorVenta(rs.getInt(5));
                productos.setCantidadRegistrada(rs.getInt(6));
                productos.setCantidadVenta(rs.getInt(7));
                productos.setUnidadVenta(rs.getString(8));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaDetalleDAO" + ex);
        }
        return miLista;
    }

    public ArrayList<detalleFacturaDTO> listaDetallePorCodigo(int codigo) {
        conexion miConexion = new conexion();
        ArrayList<detalleFacturaDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detalle_factura WHERE Id_Factura =" + codigo;
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                detalleFacturaDTO productos = new detalleFacturaDTO();
                productos.setCodigoDetalle(rs.getInt(1));
                productos.setCodigoFactura(rs.getInt(2));
                productos.setCodigoInsumo(rs.getInt(3));
                productos.setCodigoProducto(rs.getInt(4));
                productos.setValorVenta(rs.getInt(5));
                productos.setCantidadRegistrada(rs.getInt(6));
                productos.setCantidadVenta(rs.getInt(7));
                productos.setUnidadVenta(rs.getString(8));

                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaDetallePorCodigo " + ex);
        }
        return miLista;
    }

    public int insertDetalle(int codigoFactura, int codigoInsumo, int codigoPrecio, int valor) throws ClassNotFoundException {
        int insert = 1;
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO detalle_factura (Id_Factura, Id_Insumos, Id_Productos, Valor_Unitario)"
                        + "VALUES (?,?,?,?)");
                st.setInt(1, codigoFactura);
                st.setInt(2, codigoInsumo);
                st.setInt(3, codigoPrecio);
                st.setInt(4, valor);
                insert = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return insert;
    }

    public int updateDetalle(int codigoDetalle, int codigoFactura, int codigoInsumo, int codigoPrecio, int valor) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE detalle_factura SET Id_Factura=?, Id_Insumos=?, Id_Productos=?, Valor_Unitario=? WHERE Id_Produccion = '" + codigoDetalle + "'");
                st.setInt(1, codigoFactura);
                st.setInt(2, codigoInsumo);
                st.setInt(3, codigoPrecio);
                st.setInt(4, valor);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }

    //metodo encargado de proporcionar los nombres de los productos e insumos en la lista de detalle factura
    public ArrayList<detalleFacturaNombresDTO> listaDetalleporProducto(int codigo) {
        conexion miConexion = new conexion();
        ArrayList<detalleFacturaNombresDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detalle_factura df, productos p \n"
                    + "WHERE df.Id_Productos = p.Id_Productos AND df.Id_Factura = '" + codigo + "' \n"
                    + "ORDER BY df.Id_Detalle_Factura ASC";

            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                detalleFacturaNombresDTO productos = new detalleFacturaNombresDTO();
                productos.setCodigoDetalle(rs.getInt(1));
                productos.setCodigoFactura(rs.getInt(2));
                productos.setCodigoInsumo(rs.getInt(3));
                productos.setCodigoProducto(rs.getInt(4));
                productos.setValorVenta(rs.getInt(5));
                productos.setCantidadVenta(rs.getInt(6));
                productos.setCantidadRegistrada(rs.getInt(7));
                productos.setUnidadVenta(rs.getString(8));
                productos.setCodigoEstante(rs.getInt(10));
                productos.setDescripcionProducto(rs.getString(11));
                //productos.setCantidadProducto(rs.getInt(14));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaDetalleporProducto" + ex);
        }
        return miLista;
    }
        
        public ArrayList<detalleFacturaNombresDTO> listaDetallePorInsumo(int codigo) {
        conexion miConexion = new conexion();
        ArrayList<detalleFacturaNombresDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM detalle_factura df, insumos i \n"
                    + "WHERE df.Id_Insumos = i.Id_Insumos  AND df.Id_Factura = '" + codigo + "' \n"
                    + "ORDER BY df.Id_Detalle_Factura ASC";

            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                detalleFacturaNombresDTO productos = new detalleFacturaNombresDTO();
                productos.setCodigoDetalle(rs.getInt(1));
                productos.setCodigoFactura(rs.getInt(2));
                productos.setCodigoInsumo(rs.getInt(3));
                productos.setCodigoProducto(rs.getInt(4));
//                productos.setValorUnitario(rs.getInt(5));
//                productos.setCantidadDetalleFactura(rs.getInt(6));
                productos.setNombreInsumo(rs.getString(8));
                productos.setCantidadInsumo(rs.getInt(9));
                productos.setPrecioInsumo(rs.getInt(10));
                productos.setDescripcionInsumo(rs.getString(11));
                //productos.setFechaInsumo(rs.getDate(12));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaDetalleporInsumo" + ex);
        }
        return miLista;
    }
}
