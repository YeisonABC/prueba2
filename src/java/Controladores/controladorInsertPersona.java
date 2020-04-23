/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.personaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "controladorInsertPersona", urlPatterns = {"/controladorInsertPersona"})
public class controladorInsertPersona extends HttpServlet {

    RequestDispatcher rd;

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
        response.setContentType("text/html;charset=UTF-8");
        String genero = "";
        int cargo = Integer.parseInt(request.getParameter("cargos"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sujeto = request.getParameter("genero");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String fecha = request.getParameter("fecha");
        String direccion = request.getParameter("direccion");

        if (sujeto.equalsIgnoreCase("F")) {
            genero = "F";
        } else if (sujeto.equalsIgnoreCase("M")) {
            genero = "M";
        }

        personaDAO persona = new personaDAO();
        int insert = persona.insertEmpleado(cargo, nombre, apellido, genero, cedula, fecha, telefono, direccion);
        if (insert == 1) {
            RequestDispatcher rd = request.getRequestDispatcher("listaPersonaCliente.jsp");
            rd.forward(request, response);
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
        String genero = "";
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sujeto = request.getParameter("genero");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        if (sujeto.equalsIgnoreCase("F")) {
            genero = "F";
        } else if (sujeto.equalsIgnoreCase("M")) {
            genero = "M";
        }

        personaDAO persona = new personaDAO();
        int insert = persona.insertCliente(nombre, apellido, genero, cedula, telefono, direccion);
        if (insert == 1) {
            RequestDispatcher rd = request.getRequestDispatcher("listaPersona.jsp");
            rd.forward(request, response);
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
