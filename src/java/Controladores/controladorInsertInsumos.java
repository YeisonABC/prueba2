/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.insumoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "controladorInsertInsumos", urlPatterns = {"/controladorInsertInsumos"})
public class controladorInsertInsumos extends HttpServlet {

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

        try {
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int precio = Integer.parseInt(request.getParameter("precio"));

            insumoDAO insumo = new insumoDAO();
            int i = insumo.insertInsumo(nombre, descripcion, cantidad, precio, fecha);
            if (i == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("listaInsumos.jsp");
                rd.forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Error " + ex);
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
//        try {
//            String nombre = request.getParameter("nombre");
//            String unidadMedida = request.getParameter("unidadMedida");
//
//            insumoDAO insumo = new insumoDAO();
//            int insert = insumo.insertInsumo(nombre, unidadMedida);
//            if (insert == 1) {
//                RequestDispatcher rd = request.getRequestDispatcher("listaInsumos.jsp");
//                rd.forward(request, response);
//            }
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Algo salio mal" + ex);
//        }
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
