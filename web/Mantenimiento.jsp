
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Animated Sidebar Menu | CodingLab</title>
      <link href="css/sidvar.css" rel="stylesheet" type="text/css"/>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
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
      <div class="content">
         <div class="header">
               ECOTIENDA
         </div>      
      </div>
   </body>
</html>