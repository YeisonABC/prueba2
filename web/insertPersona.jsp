<%-- 
    Document   : insertPersona
    Created on : 24-feb-2020, 15:16:02
    Author     : Sala300
--%>

<%@page import="Dto.cargoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.cargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="mostrando.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
            String caso1 = (String) sesion.getAttribute("caso1"); // esta tipo variable viene del controladorInsertPersona
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
            <div id="fromularios" class="container">
                <div class="card">
                    <div class="card-header" id="emp">
                        <h5 class="mb-0 text-center">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#empleado" aria-expanded="false" aria-controls="empleado">
                                Formulario de Empleados
                            </button>
                        </h5>
                    </div>
                    <div id="empleado" class="collapse show" aria-labelledby="emp" data-parent="#fromularios">
                        <div class="card-body">
                            <div class="container">
                                <form action="controladorInsertPersona"> 
                                    <label>Cargo</label><select name="cargos">
                                        <option>Seleccione un Cargo</option>
                                        <%
                                            cargoDAO miCargo = new cargoDAO();
                                            ArrayList<cargoDTO> miArray = miCargo.listaCargos();
                                            for (cargoDTO cargos : miArray) {
                                        %>
                                        <option value="<%=cargos.getCodioCargo()%>">
                                            <%
                                                out.print(cargos.getNombre());
                                            %>  
                                        </option>   
                                        <%
                                            }
                                        %>
                                    </select><br>
                                    <label>Nombres</label><input type="text" name="nombre"><br>
                                    <label>Apellidos</label><input type="text" name="apellido"><br>
                                    <label>Genero</label> 
                                    <select name="genero">
                                        <option value="0">Tipo</option>
                                        <option value="F">F</option>
                                        <option value="M">M</option>
                                    </select><br>
                                    <label>Cedula Ciudadania</label><input type="text" name="cedula"><br>
                                    <label>Fecha Vinculacion</label><input type="date" name="fecha"><br>
                                    <label>Telefono</label><input type="text" name="telefono"><br>
                                    <label>Direcion</label><input type="text" name="direccion"><br>
                                    <%--<label>Tipo Persona</label> 
                                    <select name="tPersona">
                                        <option value="C">C</option>
                                        <option value="E">E</option>
                                        <option value="P">P</option>
                                    </select><br>--%>
                                    <input type="submit" value="Registrar">
                                </form>
                            </div> 
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h5 class="mb-0 text-center">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Formulario Clientes
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#fromularios">
                        <div class="card-body">
                            <form action="controladorInsertPersona" method="post">
                                <label>Nombres</label><input type="text" name="nombre"><br>
                                <label>Apellidos</label><input type="text" name="apellido"><br>
                                <label>Genero</label> 
                                <select name="genero">
                                    <option value="0">Tipo</option>
                                    <option value="F">F</option>
                                    <option value="M">M</option>
                                </select><br>
                                <label>Cedula Ciudadania</label><input type="text" name="cedula"><br>
                                <%--<label>Fecha Vinculacion</label><input type="date" name="fecha"><br>--%>
                                <label>Telefono</label><input type="text" name="telefono"><br>
                                <label>Direcion</label><input type="text" name="direccion"><br>
                                <%--<label>Tipo Persona</label> 
                                <select name="tPersona">
                                    <option value="C">C</option>
                                    <option value="E">E</option>
                                    <option value="P">P</option>
                                </select><br>--%>
                                <input type="submit" value="Registrar">
                            </form>

                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h5 class="mb-0 text-center">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Formulario Proveedores
                            </button>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#fromularios">
                        <div class="card-body">
                            <form action="controladorInsertPersona">
                                <label>Razon Social</label><input type="text" name="razonSocial"><br>                              
                                <label>Nit </label><input type="text" name="cedula"><br>
                                <%--<label>Fecha Vinculacion</label><input type="date" name="fecha"><br>--%>
                                <label>Telefono</label><input type="text" name="telefono"><br>
                                <label>Direcion</label><input type="text" name="direccion"><br>
                                <%--<label>Tipo Persona</label> 
                                <select name="tPersona">
                                    <option value="C">C</option>
                                    <option value="E">E</option>
                                    <option value="P">P</option>
                                </select><br>--%>
                                <input type="submit" value="Registrar">
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