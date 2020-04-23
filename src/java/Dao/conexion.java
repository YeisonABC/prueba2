package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia Beltran
 */
public class conexion {

    protected Connection miConexion;
    protected ResultSet rs;
    protected Statement st;
    protected PreparedStatement ps;

    public void conectandoBBDD() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagranja", "root", "");
            System.out.println("la conexion a sido establecida");
        } catch (SQLException e) {
            System.out.println("verificar la url o el controlador " + e);
        }
    }

    public void cerrandoBBDD() throws SQLException {
        if (miConexion != null) {
            if (!miConexion.isClosed()) {
                miConexion.close();
            }
        }
    }

    public ResultSet ConsultaSelect(String sql) {
        try {//metodo getters o captador caotar o roporcionar esas propiedad
            conectandoBBDD();
            try {
                st = miConexion.createStatement();
                rs = st.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println("Ocurrio un Error " + e);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int update(String sql) throws ClassNotFoundException {
        conectandoBBDD();
        int update = 0;
        try {
            st = miConexion.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("se produjo un error " + e);
        }
        return update;
    }

}
