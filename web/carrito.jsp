<%-- 
    Document   : carrito
    Created on : 18/01/2020, 11:23:28 AM
    Author     : Familia Beltran
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dto.carritoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<carritoDTO> micarrito = (List<carritoDTO>) request.getAttribute("contadorCarrito");
            HttpSession miSesion = request.getSession(true);
        %>

        <form>
            <a href="agregaProductosCarrito?accion=home">Seguir Comprando</a>
            <a href="agregaProductosCarrito?accion=home">Home</a>           
        </form>

        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <table class=" table table-hover">
                        <thead>
                        <th>Item</th>                        
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Eliminar</th>
                        </thead>
                        <tbody>
                            <tr>
                                <%
                                    for (carritoDTO i : micarrito) {
                                %>
                                <td>
                                    <%
                                        out.print(i.getItem());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(i.getNombre());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(i.getPrecioCompra());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(i.getCantidad());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(i.getSubtotal());
                                    %>
                                </td>
                                <td>
                                    <form action="agregaProductosCarrito?accion=borrar&&ids=<%=i.getItem()%>" method="Post">                                                                          
                                        <input type="submit" value="Borrar">
                                    </form>
                                </td>                                                                                   
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-head">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" readonly="" class="form-control" value="">
                            <label>Descuento</label>
                            <input type="text" readonly="" class="form-control">
                            <label>total A Pagar</label>
                            <input type="text" readonly="" class="form-control">
                        </div>
                    </div>
                    <div class="card-footer">
                        <a  href="#" class="btn btn-info btn-block">Finalizar Compra</a> <br>
                        <form action="agregaProductosCarrito?accion=segirComprando" method="Post">
                            <input class="btn btn-info btn-block" type="submit" value="Seguir Comprando"> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
