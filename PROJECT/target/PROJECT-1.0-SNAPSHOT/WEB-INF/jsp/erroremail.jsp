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
               <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
  </symbol>
  <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
  </symbol>
  <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
</svg>
<div class="alert alert-danger d-flex align-items-center" role="alert">
  <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
  <div>
    Email is not registered
  </div>
</div>
  <form id="edit2" action="forgotform" method="post">
        <div id="id1"><h3>Email-ID</h3></div>
            <input placeholder="Enter Registered Email-ID" type="email" name="otp1"  required="required">
            <br>
            <br>
            <input style="width: 100%;border: none;" class="btn btn-success" type="submit" value="Send OTP">
            <!--<input style="color: white;background-color: greenyellow;border: none;" type="submit" value="Login">-->
            <br>
            <br>
        </form>
    <a href="login.htm" class="btn btn-danger">Cancel</a>
  </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>


