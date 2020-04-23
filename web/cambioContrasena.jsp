<%-- 
    Document   : cambioContrasena
    Created on : 16/01/2020, 11:03:01 AM
    Author     : Familia Beltran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("usuario");
            int idUsuarioLogeado = (int) sesion.getAttribute("idLogin");
        %>
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <i class="fas fa-shield-alt fa-3x "></i>&nbsp;<h2 class="modal-title" id="exampleModalLabel">Cambio de Calve</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="controladorCambioContrasena">
                    <div class="modal-body">
                        <i class="fas fa-lock-open fa-2x m-4 contrasena">&nbsp;</i><input class="form-control-lg" type="password" placeholder="Clave actual" name="claveActual"><br>
                        <i class="fas fa-key fa-2x m-4 contrasena">&nbsp;</i><input class="form-control-lg" type="password" placeholder="Nueva Clave" name="nuevaClave"><br>
                        <i class="fas fa-lock fa-2x m-4 contrasena">&nbsp;</i><input class="form-control-lg" type="password" placeholder="Confirmar Clave" name="confimacionClave"><br>                 
                        <%
                            sesion.setAttribute("codigoLogeado", idUsuarioLogeado);
                            sesion.setAttribute("usuario", usuario);
                        %>
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-secondary" href="#">Cancelar</a>
                        <input class="btn btn-primary" type="submit" value="Confirmar">
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
</html>
