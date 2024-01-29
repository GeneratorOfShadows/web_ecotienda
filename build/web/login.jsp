
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    
    <link rel="preconnect" href="https://fonts.googleapis.com" />
  </head>
  <body>
    <main class="maincontedor">
      <section class="reparticion">
        <div class="mitad1">
          <h1 class="id2">ECOT<strong>IENDA</strong></h1>
          <h2 class="idh2">LOGIN</h2>
          <p class="text-id">
            
          </p>
           
          <form class="formulario" action="Usuario" method="Post">
              
           <input type="hidden" name="accion" value="LOGIN">
           <label for="usuario">Usuario</label>
            <input class="input" type="text"  name="usuario" placeholder="Correo Electronico">
           <label for="clave">Contraseña</label>
            <input class="input" type="password"  name="clave" placeholder="contrasena">
            
            <button type="submit" class="boton">Submit</button>

            <p class="checkbox1">Al iniciar seccion usted acepte los siguientes</p>

            <a href="" class="checkbox2">Términos y condiciones & Politicas de privacidad</a>

          </form>
          <c:if test="${message != null}">
                <div class="text-danger">${message}</div>
            </c:if>
        </div>

        <div class="mitad2">
          <h1 class="id1">ECOT<strong>IENDA</strong></h1>
          <img class="img" src="svg/planta.svg" alt="" />
          <p>
            
          </p>
        </div>
      </section>
    </main>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  </body>
</html>
