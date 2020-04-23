/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.productoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "controladorEditaProducto", urlPatterns = {"/controladorEditaProducto"})
public class controladorEditaProducto extends HttpServlet {

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
                try {
            HttpSession miSesion = request.getSession(true);
            int codigoPro= (int) miSesion.getAttribute("codigo");
            int codigoEstante = Integer.parseInt(request.getParameter("codigoEstante"));
            String nombre = request.getParameter("nombre");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String unidadMedida = request.getParameter("unidadMedida");
            
            productoDAO producto= new productoDAO();
            int update=producto.updateProductoSinProduccion(codigoPro, codigoEstante, nombre, precio, unidadMedida);
            if (update==1){
                RequestDispatcher rd =request.getRequestDispatcher("listaProducto.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorEditaProducto.class.getName()).log(Level.SEVERE, null, ex);
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
        
        int estante = Integer.parseInt(request.getParameter("estante"));
        int produccion = Integer.parseInt(request.getParameter("produccion"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        String nombre = request.getParameter("nombre");
        String medida = request.getParameter("medida");
        
        productoDAO produc = new productoDAO();
        int i = produc.insertProducto(estante, nombre, precio, medida, produccion);
        if(i==1){
            RequestDispatcher rd =request.getRequestDispatcher("listaProducto.jsp");
             rd.forward(request, response);
        }
        
        
        
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
            int codigoPro= (int) miSesion.getAttribute("codigo");
            int codigoEstante = Integer.parseInt(request.getParameter("codigoEstante"));
            int codigoProduccion = Integer.parseInt(request.getParameter("codigoProduccion"));
            String nombre = request.getParameter("nombre");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String unidadMedida = request.getParameter("unidadMedida");
            
            productoDAO producto= new productoDAO();
            int update=producto.updateProducto(codigoPro, codigoEstante, nombre, precio, unidadMedida, codigoProduccion);
            if (update==1){
                RequestDispatcher rd =request.getRequestDispatcher("listaProducto.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorEditaProducto.class.getName()).log(Level.SEVERE, null, ex);
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
