/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.produccionDAO;
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

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "controladorEditaProduccion", urlPatterns = {"/controladorEditaProduccion"})
public class controladorEditaProduccion extends HttpServlet {

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
       int codigo = (int) miSesion.getAttribute("codigo");
       try{
            produccionDAO produccion = new produccionDAO();
            int i = produccion.borrar(codigo);
            if(i==1){
                RequestDispatcher rd =request.getRequestDispatcher("listaProduccion.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error" + ex);
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
        
        try {
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            String tipo = request.getParameter("tipo");
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            produccionDAO produccion = new produccionDAO();
            int p = produccion.insertProducccion(nombre, fecha, tipo, cantidad);
            if(p==1){
                RequestDispatcher rd =request.getRequestDispatcher("listaProduccion.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorEditaProduccion.class.getName()).log(Level.SEVERE, null, ex);
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
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            String tipo = request.getParameter("tipo");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String fecha = request.getParameter("fecha");
            
            produccionDAO produccion = new produccionDAO();
            int i = produccion.updateProducto(codigo, nombre, fecha, tipo, cantidad);
            if(i==1){
                RequestDispatcher rd =request.getRequestDispatcher("listaProduccion.jsp");
                rd.forward(request, response);
            }
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
