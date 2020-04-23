<%-- 
    Document   : newjsp
    Created on : 1/12/2019, 08:31:28 PM
    Author     : Familia Beltran
--%>

<%@page import="modelo.conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesion</title>
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilosInicioSesion.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="cajaSesion">
            <div class="sesion text-center">
                <div class="logo">
                    <img src="">
                </div>
                <div class="titulo">
                    <h3>Acceder</h3>
                    <p>a Manzano</p>       
                </div>
                <form action="controladorLogin"  method="Post">
                    <i class="fas fa-user-alt"></i><input type="text" name="usuario" placeholder="Usuario" class="m-2" autocomplete="off"><br>
                    <i class="fas fa-unlock-alt"></i><input type="password" name="contrasena" placeholder="Clave" class="m-2" autocomplete="off" ><br>
                    <button type="submit" class="btn btn-primary mt-3">Iniciar</button>
                    <a href=""><button class="btn btn-link mt-3">Crear una Cuenta</button></a><br>
                </form>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
