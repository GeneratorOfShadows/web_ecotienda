<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="css/sidvar.css" rel="stylesheet" type="text/css"/>
        <script src="js/cliente.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>



    <body>
<div class="wrapper">
         <input type="checkbox" id="btn" hidden>
         <label for="btn" class="menu-btn">
         <i class="fas fa-bars"></i>
         <i class="fas fa-times"></i>
         </label>
         <nav id="sidebar">
            <div class="title">
               Side Menu
            </div>
            <ul class="list-items">
               <li><a href="index.jsp"><i class="fas fa-home"></i>Home</a></li>
               <li><a href="proveedor.jsp"><i class="fas fa-sliders-h"></i>Proveedor</a></li>
               <li><a href="articulo.jsp"><i class="fas fa-address-book"></i>Articulos</a></li>
               <li><a href="almacen.jsp"><i class="fas fa-address-book"></i>Almacen</a></li>
              <li><a href="cliente.jsp"><i class="fas fa-address-book"></i>Clientes</a></li>

               <div class="icons">
                  <a href="#"><i class="fab fa-facebook-f"></i></a>
                  <a href="#"><i class="fab fa-twitter"></i></a>
                  <a href="#"><i class="fab fa-github"></i></a>
                  <a href="#"><i class="fab fa-youtube"></i></a>
               </div>
            </ul>
         </nav>
      </div>
        <hr />
        <c:if test="${mensaje != null}">
            <p>${mensaje}</p>
        </c:if>   


        <div class="container"> 
            <h1>Lista de clientes</h1>
            <table class="table">
                <thead>
                    <tr>

                        <th>ID</th>                
                        <th>NOMBRES</th>      
                        <th>APELLIDO</th>
                        <th>CORREO</th>
                        <th>DIRECCION</th>
                        <th colspan="2">Acciones</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="f" items="${clientes}">
                        <tr>
                            <td >${f.id}</td>
                            <td>${f.nombre}</td>
                            <td>${f.apellido}</td>
                            <td>${f.correo}</td>
                            <td>${f.direccion}</td>

                            <td><a class="btn btn-danger" href="Cliente?accion=GET&id=${f.id}">Editar</a></td>
                            <td><a class="btn btn-warning r" href="Cliente?accion=DEL&id=${f.id}"onclick="return ConfirmDelete();" >Eliminar</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
                <th><a type="button" class="btn btn-success" href="clienteIns.jsp">Cliente nuevo</a></th>      
            </table>  
        </div> 

    </body>


</html>