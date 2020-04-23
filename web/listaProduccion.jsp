<%-- 
    Document   : listaProduccion
    Created on : 4/01/2020, 12:34:53 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.produccionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.produccionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
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
                            <p class="text-center"></p>
                            <hr>
                            <a class="dropdown-item" href="#">Cambiar Clave</a>
                            <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
                        </div>
                    </div> 
                </div>
            </div>
                                                                                  
                <%
                    produccionDAO lproduc = new produccionDAO();
                    ArrayList<produccionDTO> miLista = lproduc.listaProduccion();               
                %>
                
                <table class="table table-hover">
                <thead>
                <th>Codigo Produccion</th>
                <th>Nombre</th>
                <th>Tipo Factura</th>
                <th>Cantidad</th>
                 <th>Fecha</th>
                <th>Editar</th>
                <th>Eliminar</th>
                </thead>
                <tbody>
                    <%
                        for (produccionDTO Lista : miLista) {
                    %>
                    <tr>
                        <td>
                            <%
                                out.print(Lista.getCodigoProduccion());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(Lista.getNombre());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(Lista.getTipo());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(Lista.getCantidad());
                            %>
                        </td>
                        <td>
                            <%
                                out.print(Lista.getFecha());
                            %>
                        </td>
                        <td>
                            <a href="editarProduccion.jsp?codigo=<%=Lista.getCodigoProduccion()%>&&nombre=<%=Lista.getNombre()%>&&tipo=<%=Lista.getTipo()%>&&cantidad=<%=Lista.getCantidad()%>&&fecha=<%=Lista.getFecha()%>"><button>Editar</button></a>
                        </td>
                        <td>
                            <a href="borrarProduccion.jsp?codigo=<%=Lista.getCodigoProduccion()%>"><button>Borrar</button></a>
                        </td>
                        <%
                            }
                        %>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
