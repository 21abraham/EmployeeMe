<%-- 
    Document   : base
    Created on : 21-Jan-2023, 7:56:17 pm
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            html,body
                {
                    width: 100%;
                    height: 100%;
                    margin: 0px;
                    padding: 0px;
                    overflow-x: hidden; 
                }
            body{
                background-image: url(https://wallpaperaccess.com/full/656670.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <video autoplay loop muted plays-inline style="width: 100%;position: absolute;right: 0;bottom: 0;z-index: -1;">
  <source src="<c:url value="/resourses/videos/Background.mp4" />" type="video/mp4">
</video>
    
<div class="container" style="padding: 100px 0 0 350px;">
            <div class="card" style="padding: 20px 20px 20px 20px;width: 38rem;background: rgba(0,0,0,0.5);box-shadow: 0 0 10px rgba(0,0,0,0.5);">
    <nav class="navbar navbar-light" style="background-color: transparent;">
  <div class="container-fluid">
    <a style="color: white;" class="navbar-brand" href="#">Employee Manager</a>
    <button  style="background-color: white;" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a style="color: white;" class="nav-link" href="register.htm">Register</a>
        </li>
        <li class="nav-item">
          <a style="color: white;" class="nav-link" href="loginform.htm">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
                <img src="https://cdn.careers.bloch.umkc.edu/wp-content/uploads/sites/130/2021/11/Business-Adm.png" class="card-img-top" alt="...">
    
        <div class="container" style="text-align: center;color: white;">
            <b style="font-size:50px;">Employee Me</b>
    </div>
                
                </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
