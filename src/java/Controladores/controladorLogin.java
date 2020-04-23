/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.loginDAO;
import Dto.loginDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "controladorLogin", urlPatterns = {"/controladorLogin"})
public class controladorLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession(true);
        loginDAO login = new loginDAO();
        ArrayList errores = new ArrayList();
        loginDTO miLogin = new loginDTO();

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("contrasena");

        sesion.setAttribute("usuario", usuario);
        sesion.setAttribute("errores", errores);
        try {
            ResultSet rs = login.pstmt(usuario, clave);
            if (rs.absolute(1)) {
               miLogin.setCodigoLogin(rs.getInt(1));//encargado de proporcionar el codigo del usuario logeado
               int p=miLogin.getCodigoLogin();//se almacena en una variable para debolverlo
               sesion.setAttribute("idLogin", p);//se envia como parametro el idLogin del usuario logeado
                RequestDispatcher rd = request.getRequestDispatcher("inicioAdmin.jsp");
                rd.forward(request, response);
            } else {

                RequestDispatcher rd = request.getRequestDispatcher("inicioSesion.jsp");
                rd.forward(request, response);
                errores.add("contraseña o usuario incorrectos");
            }
        } catch (SQLException ex) {
            System.out.println("algo salio mal " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error" + ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
