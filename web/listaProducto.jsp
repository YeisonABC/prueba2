<%-- 
    Document   : listaInsumos
    Created on : 2/01/2020, 02:22:31 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.productosDTO"%>
<%@page import="Dao.productoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
        %>
        <div class="p-3 panelIzquierdo">
            <div class="headLogo"></div>
            <div class="contenidoPanelIzquierdo mt-4">
                <div class="accordion" id="accordionExample">
                    <div id="headingOne">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                            Personas
                        </button>
                    </div>
                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">                      
                        <div class="botones mt-3 ml-4"><a href="listaPersona.jsp" >Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertPersona.jsp">¿Nueva persona?</a></div>
                    </div>
                    <div class="" id="headingdos">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapsedos" aria-expanded="false" aria-controls="collapsedos">
                            Cargos
                        </button>
                    </div>
                    <div id="collapsedos" class="collapse" aria-labelledby="headingdos" data-parent="#accordionExample">
                        <div class="botones mt-3 ml-4"><a href="listaCargo.jsp" class="botones">Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertCargo.jsp">¿Nuevo Cargo?</a></div>
                    </div>
                    <div class="" id="headingOne">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapsetres" aria-expanded="false" aria-controls="collapsetres">
                            Factura
                        </button>
                    </div>
                    <div id="collapsetres" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="botones mt-3 ml-4"><a href="listaFactura.jsp" class="botones">Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertFactura.jsp">¿Nueva Factura?</a></div>
                    </div>
                    <div class="" id="headingOne">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapsecuatro" aria-expanded="false" aria-controls="collapsecuatro">
                            Insumos
                        </button>
                    </div>
                    <div id="collapsecuatro" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="botones mt-3 ml-4"><a href="listaInsumos.jsp" class="botones">Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertInsumos.jsp">¿Nuevo Insumo?</a></div>
                    </div>
                    <div class="" id="headingOne">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapsecinco" aria-expanded="false" aria-controls="collapsecinco">
                            Productos
                        </button>
                    </div>
                    <div id="collapsecinco" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="botones mt-3 ml-4"><a href="listaProducto.jsp" class="botones">Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertProducto.jsp">¿Nuevo Producto?</a></div>
                    </div>
                    <div class="" id="headingOne">
                        <button class="btn p-0 mt-3" data-toggle="collapse" data-target="#collapseSeis" aria-expanded="false" aria-controls="collapseSeis">
                            Produccion
                        </button>
                    </div>
                    <div id="collapseSeis" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                        <div class="botones mt-3 ml-4"><a href="listaProduccion.jsp" class="botones">Lista</a></div>
                        <div class="botones mt-2 ml-4"><a href="insertProduccion.jsp">¿Produccion Nueva?</a></div>
                    </div>                   
                </div>
            </div>
        </div>

        <div class="paneldDerecho">
            <div class="headBarra p-3">
                <div class="justify-content-end d-flex">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tu Cuenta
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <p class="text-center"><%=usuario%></p>
                            <hr>
                            <a class="dropdown-item" href="#">Cambiar Clave</a>
                            <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
                        </div>
                    </div> 
                </div>
            </div>
            <%
                productoDAO producto = new productoDAO();
                ArrayList<productosDTO> lista = producto.listaProducto();
            %>
            <div class="">
                <table class="table table-hover">
                    <thead>
                    <th>cod.<br> Producto</th>
                    <th>cod.<br> Estante</th>
                    <th>cod.<br> Produccion</th>
                    <th>Precio inicial</th>
                    <th>Cantidad</th>
                    <th>Unidad de Medida</th>
                    <th>Editar</th>
                    <th>Borrar</th>
                    </thead>
                    <tbody>
                        <%
                            for (productosDTO produc : lista) {
                        %>
                        <tr>                  
                            <td><%
                                out.println(produc.getCodigoProducto());
                                %>
                            </td>
                            <td><%
                                out.println(produc.getCodigoEstante());
                                %>
                            </td>
                            <td><%
                                out.println(produc.getCodigoProduccion());
                                %>
                            </td>
                            <td><%
                                out.println(produc.getPrecio());
                                %>
                            </td>
                            <td><%
                                out.println(produc.getCantidadExistene());
                                %>
                            </td>
                            <td><%
                                out.println(produc.getUnidadMedida());
                                %>
                            </td>
                            <td>
                                <a href="editarProducto.jsp?codigo=<%=produc.getCodigoProducto()%>&&codigoEstante=<%=produc.getCodigoEstante()%>&&codigoProduccion=<%=produc.getCodigoProduccion()%>&&precio=<%=produc.getPrecio()%>&&unidadMedida=<%=produc.getUnidadMedida()%>">Editar
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-primary" href="borrarProducto.jsp?codigo=<%=produc.getCodigoProducto()%>">Borrar</a>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>

