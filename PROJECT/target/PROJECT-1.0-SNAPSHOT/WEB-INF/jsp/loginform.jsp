<%-- 
    Document   : base
    Created on : 21-Jan-2023, 7:56:17 pm
    Author     : hp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
            #edit2 input[type=text],
            #edit2 input[type=email],
            #edit2 input[type=password]{
                    height: 53px;
                    width: 100%;
                    padding: 0 30px;
                    font-size: 14px;
                    background: transparent;outline: none;box-shadow: 0 0 10px white;border: none;color: white;
            }
            #id1{
                padding: 10px 0 0 10px;
                color: white;
            }
            ::placeholder {
                color: white;
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
      </ul>
    </div>
  </div>
</nav>
                <div class="container" style="text-align: center;">
            <b style="font-size:30px;color: white;">Employ Me</b>
    </div>
                <form:form id="edit2" action="processform" method="post" commandName="adminForm">
        <div id="id1"><h3>Username</h3></div>
            <form:input type="text" placeholder="Enter Username" path="name" required="required"/>
            <!--<input placeholder="Enter Username" type="text" name="a">-->
            <div id="id1"><h3>Password</h3></div>
            <form:input type="password" placeholder="Enter Password" path="pwd" required="required"/>
<!--            <input placeholder="Enter Password" type="password" name="b">-->
            <br>
            <br>
            <a href="forgot.htm" style="color: white;text-decoration: none;">Forgot Password?</a>
            <br>
            <br>
            <input style="width: 100%;border: none;" class="btn btn-success" type="submit" value="Login">
            <!--<input style="color: white;background-color: greenyellow;border: none;" type="submit" value="Login">-->
            <br>
            <br>
        </form:form>
    <a href="login.htm" class="btn btn-danger">Cancel</a>
  </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
