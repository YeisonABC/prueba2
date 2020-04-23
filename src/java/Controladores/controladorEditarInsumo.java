/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.insumoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "controladorEditarInsumo", urlPatterns = {"/controladorEditarInsumo"})
public class controladorEditarInsumo extends HttpServlet {

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
        conexion miConexion = new conexion();
        HttpSession miSesion = request.getSession(true);
        try {
            int codigo = (int) miSesion.getAttribute("codigo");
            String sql = "DELETE FROM insumos WHERE Id_Insumos ='" + codigo + "'; ";
            int delete = miConexion.update(sql);
            if (delete == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("listaInsumos.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("borrarInsumo.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("problema con el sql " + e);
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
        try {
            HttpSession miSesion = request.getSession(true);
            int codigoCargo = (int) miSesion.getAttribute("codigo");
            String nombre = request.getParameter("nombre");
            String unididadMedida = request.getParameter("unidadMedida");
            int precio = Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String fecha = request.getParameter("fecha");

            insumoDAO insumo = new insumoDAO();
            int editar = insumo.updateInsumo(codigoCargo, nombre, unididadMedida, fecha, cantidad, precio);
            if (editar == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("listaInsumos.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ocurrio un error " + ex);
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
