/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.personaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "controladorEditarPersona", urlPatterns = {"/controladorEditarPersona"})
public class controladorEditarPersona extends HttpServlet {

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

        HttpSession miSesion = request.getSession(true);
        int codigoPer = (int) miSesion.getAttribute("codigo");
        //int codigoCargo = Integer.parseInt(request.getParameter("cargo"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String genero = request.getParameter("genero");
        String cedula = request.getParameter("cedula");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
       //int codigoCargo2 = Integer.parseInt(request.getParameter("cCargo"));
       if(genero.equalsIgnoreCase("F")){
           genero="F";
       }else if(genero.equalsIgnoreCase("M")){
           genero="M";
       }
            
        personaDAO miPer = new personaDAO();
        try {
            int update = miPer.updateCliente(codigoPer, nombre, apellido, genero, cedula, telefono, direccion);
            if (update == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("listaPersonaCliente.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ocurrio el siguiente problema " + ex);
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
