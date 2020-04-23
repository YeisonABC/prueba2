<%-- 
    Document   : tiendaOnline
    Created on : 5/01/2020, 04:37:59 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.carritoDTO"%>
<%@page import="Dto.productosDTO"%>
<%@page import="Dao.productoDAO"%>
<%@page import="java.util.ArrayList"%>
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
        <div class="container">
            <%
                productoDAO miProducto = new productoDAO();
                ArrayList<productosDTO> miLista = miProducto.listaProducto();
            %>
            <form action="agregaProductosCarrito?accion=carrito" method="Post">
                (<label> <%out.print(request.getAttribute("contadorCarrito"));%></label>)
                <input type="submit" value="Carrito">
            </form>
            <hr>
            <div class="row">
                <%for (productosDTO lista : miLista) {%>
                <div class="col col-sm-6 col-md-6 col-lg-3">
                    <div class="card">
                        <div class="card-body">    
                            <img src="controladorIMG?id=<%=lista.getCodigoProducto()%>">
                            <div class="mt-4 text-center">
                                <%
                                    out.println(lista.getNombre() + "<br>");
                                    out.println(lista.getPrecio());
                                %>
                            </div>
                        </div>
                        <div class="card-footer">
                            <form action="agregaProductosCarrito?accion=agregaCarrito&&id=<%=lista.getCodigoProducto()%>" method="Post">
                                <input type="text" name="cantidad" value="1" style="width: 25px;">
                                <input class="btn btn-warning" type="submit" value="Agregar al carrito">
                            </form>    
                        </div>
                    </div>
                </div>         
                <%
                    }
                %>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
