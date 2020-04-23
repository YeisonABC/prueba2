/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.loginDAO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "controladorCambioContrasena", urlPatterns = {"/controladorCambioContrasena"})
public class controladorCambioContrasena extends HttpServlet {

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
            HttpSession sesion = request.getSession(true);

        try {
            String usuario = (String)sesion.getAttribute("usuario");
            int codigoLogeado = (int)sesion.getAttribute("codigoLogeado");
            String claveActual = request.getParameter("claveActual");
            String nuevaClave = request.getParameter("nuevaClave");
            String confimacionClave = request.getParameter("confimacionClave");
           int i=0;

            loginDAO login = new loginDAO();
            ResultSet rs = login.cambioContasena(usuario, claveActual);
            if (rs.absolute(1)) {   //verifica que este logeado el usuario correcto
                if (nuevaClave.equals(confimacionClave)) {//compara las contraseñas ingresadas que sean correctas
                   i=login.updateContrsena(confimacionClave, codigoLogeado);
                }
            }
            if(i==1){
                RequestDispatcher rd= request.getRequestDispatcher("inicioSesion.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            System.out.println("Error al conectarse " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la sentencia " + ex);
        }

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
        processRequest(request, response);
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
