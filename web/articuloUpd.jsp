<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        <div class="container">
            <h1>Actualizar articulo </h1>
            <form action="Articulo" method="POST">
                <input type="hidden" name="accion" value="UPD">
                <input type="hidden" name="id" value="${articulo.id}">
                
                 <div class="mb-3">
                    <label  class="form-label">Codigo: </label> 
                    <input class="form-control" type="text" name="codigo" value="${articulo.codigo}" />
                </div > 
                <div class="mb-3">
                    <label  class="form-label">Nombre:  </label> 
                    <input class="form-control" type="text" name="nombre" value="${articulo.nombre}" />
                </div>
                <div class="mb-3">
                    <label  class="form-label">Precio: </label> 
                    <input class="form-control" type="number" name="precio" step="0.01" value="${articulo.precio}" />
                </div>
                <div class="mb-3">
                    <label  class="form-label">Cantidad: </label> 
                    <input class="form-control" type="number" name="cantidad" value="${articulo.cantidad}" />
                </div>
                <div class="mb-3">
                    <label  class="form-label">RUC del proveedor: </label> 
                    <select name="proveedor" class="form-control">
                        <c:forEach var="p" items="${proveedores}">                    
                            <option value="${p.id}" <c:if test="${p.id == articulo.proveedor}">selected</c:if>>${p.ruc}</option>
                        </c:forEach>                
                    </select>
                </div>
            
                <br /><br />
                <input  class="btn btn-dark" type="submit" value="Actualizar">   
                <a type="button" class="btn btn-secondary" href="articulo.jsp">Atras</a>
            </form> 

        </div>




        <c:if test="${mensaje != null}">
            <p>${mensaje}</p>
        </c:if>    
    </body>
</html>
