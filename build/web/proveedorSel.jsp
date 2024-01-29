<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="js/proveedor.js" type="text/javascript"></script>
        <link href="css/sidvar.css" rel="stylesheet" type="text/css"/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
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
            <h1>Lista de proveedores</h1>
            <table class="table">
                <thead>
                    <tr>

                        <th>ID</th>                
                        <th>NOMBRES</th>      
                        <th>RUC</th>
                        <th>DIRECCION</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        
                        <th colspan="2">Acciones</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="f" items="${proveedores}">
                        <tr>
                            <td >${f.id}</td>
                            <td>${f.nombre}</td>      
                            <td>${f.ruc}</td>
                            <td>${f.direccion}</td>
                            <td>${f.telefono}</td>
                            <td>${f.correo}</td>

                            <td><a class="btn btn-danger" href="Proveedor?accion=GET&id=${f.id}">Editar</a></td>
                            <td><a class="btn btn-warning r" href="Proveedor?accion=DEL&id=${f.id}"onclick="return ConfirmDelete();" >Eliminar</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
                <th><a type="button" class="btn btn-success" href="proveedorIns.jsp">Proveedor nuevo</a></th>      
            </table>  
        </div> 

    </body>


</html>