/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.productoDAO;
import Dto.carritoDTO;
import Dto.productosDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "agregaProductosCarrito", urlPatterns = {"/agregaProductosCarrito"})
public class agregaProductosCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    productoDAO productoDao = new productoDAO();
    productosDTO productoDto = new productosDTO();
    ArrayList<carritoDTO> listacarrito = new ArrayList();
    RequestDispatcher rd=null;

    int item;
    double totalPagar = 0.0;
    //int cantidad = 1;
    int posicion;

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
        try {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "agregaCarrito":// este caso es para que almacene los productos en el icono carrito
                    // variable encargada de la posicion del producto en la lista del carrito                  
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    int id = Integer.parseInt(request.getParameter("id"));
                    productoDto = productoDao.listaId(id);
                    if (listacarrito.size() > 0) {
                        for (int i = 0; i < listacarrito.size(); i++) {
                            if (id == listacarrito.get(i).getIdProducto()) {//si el id del formulario es igual al id del producto del carrito
                                posicion = i;//se conoce la posicion del producto que contiene el id del formulario
                                System.out.println("se cumple la accion del id " + id);
                            } else {
                                System.out.println("No se cumple la accion del Id " + id);
                            }
                        }
                        if (id == listacarrito.get(posicion).getIdProducto()) {//verificar logica del codigo pues presenta problemas
                            cantidad = listacarrito.get(posicion).getCantidad() + cantidad;//se encarga de que en cada ciclo sume los productos cada vez que sean agregados.
                            double subtotal = listacarrito.get(posicion).getPrecioCompra() * cantidad;
                            listacarrito.get(posicion).setCantidad(cantidad);
                            listacarrito.get(posicion).setSubtotal(subtotal);
                            System.out.println("se cumple el segundo ciclo");
                        } else {
                            item = item + 1;//encargada de hacer la sumatoria como id de la lista del carrito
                            carritoDTO carritoDto = new carritoDTO();//es para agregar al carrito los productos que el cliente seleccione
                            carritoDto.setItem(item);
                            carritoDto.setIdProducto(productoDto.getCodigoProducto());
                            carritoDto.setNombre(productoDto.getNombre());
                            //carrito.setDescripcion(pro.getDescripcion);
                            carritoDto.setPrecioCompra(productoDto.getPrecio());
                            carritoDto.setCantidad(cantidad);
                            carritoDto.setSubtotal(cantidad * productoDto.getPrecio());
                            listacarrito.add(carritoDto);
                            System.out.println("esta agregando");
                        }
                    } else {
                        item = item + 1;//encargada de hacer la sumatoria como id de la lista del carrito
                        carritoDTO carritoDto = new carritoDTO();//es para agregar al carrito los productos que el cliente seleccione
                        carritoDto.setItem(item);
                        carritoDto.setIdProducto(productoDto.getCodigoProducto());
                        carritoDto.setNombre(productoDto.getNombre());
                        //carrito.setDescripcion(pro.getDescripcion);
                        carritoDto.setPrecioCompra(productoDto.getPrecio());
                        carritoDto.setCantidad(cantidad);
                        carritoDto.setSubtotal(cantidad * productoDto.getPrecio());
                        listacarrito.add(carritoDto);
                        System.out.println("se agrego al carrito "+ item);
                    }
                    request.setAttribute("contadorCarrito", listacarrito.size());
                    rd = request.getRequestDispatcher("tiendaOnline.jsp");
                    rd.forward(request, response);
                    //request.getRequestDispatcher("agregaProductosCarrito?accion=home").forward(request, response);

                    //request.setAttribute("contador", carrito.size());este es para que muestre la cantidad de productos que hay
                    //request.getRequestDispatcher("controlador?accion=home").forward(request, response);
                    break;

                case "carrito":
                    totalPagar = 0.0;
                    request.setAttribute("contadorCarrito", listacarrito);
                    rd = request.getRequestDispatcher("carrito.jsp");
                    rd.forward(request, response);
                    for (int i = 0; i < listacarrito.size(); i++) {
                        totalPagar = totalPagar + listacarrito.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);

                    //request.setAttribute("carrito", listacarrito);
                    //request.getRequestDispatcher("tiendaOnline.jsp").forward(request, response);
                    break;
                case "segirComprando":
                    request.setAttribute("contadorCarrito", listacarrito.size());
                    rd = request.getRequestDispatcher("tiendaOnline.jsp");
                    rd.forward(request, response);
                    break;

                case "borrar":
                    Iterator<carritoDTO> iterator = listacarrito.iterator();
                    int  ids = Integer.parseInt(request.getParameter("ids"));
                    while (iterator.hasNext()) {
                        int codigo=iterator.next().getItem();
                        if (ids==codigo) {
                            iterator.remove();
                        }
                    }
                    request.setAttribute("contadorCarrito", listacarrito);
                    rd = request.getRequestDispatcher("carrito.jsp");
                    rd.forward(request, response);
                    break;

                default:
                //request.setAttribute("producto", lista); se utliza para enviar la lista a las jstl
                //request.getRequestDispatcher("tiendaOnline.jsp").forward(request, response);

            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el switch metodo post" + ex);
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
