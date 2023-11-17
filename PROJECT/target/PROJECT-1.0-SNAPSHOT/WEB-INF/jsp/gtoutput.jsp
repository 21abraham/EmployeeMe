<%-- 
    Document   : base
    Created on : 21-Jan-2023, 7:56:17 pm
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Grade Table Details</title>
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
                background-image: url(https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;
            }
            #edit{
                    font-size: 24px;
            }
            #edit input[type=date]{
                    height: 53px;
                    width: 70%;
                    padding: 0 30px;
                    margin: 0 250px 0 380px;
                    float: right;
                    border: none;
                    font-size: 14px;
            }
            #edit input[type=text],
            #edit input[type=email],
            #edit input[type=number]{
                    height: 53px;
                    width: 70%;
                    padding: 0 30px;
                    margin: 0 250px 0 500px;
                    float: right;
                    border: none;
                    font-size: 14px;
            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
                font-size: 14px;
              }
              th{
                  color: white;
                  background-color: black;
              }
              td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
              }

              tr:nth-child(even) {
                background-color: #03d3fc;
              }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Employee Manager</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="welcome.htm">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="signout.htm">Sign Out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
        <div class="container" style="text-align: center;">
            <b style="font-size:50px;">Welcome Admin</b>
    </div>
        <div class="container" style="text-align: center;">
            <b style="font-size:50px;">Display Grade Table Details</b>
    </div>
        <div class="container" style="padding: 0 0 200px 50px;">
        <div align="center" style="padding: 20px 20px 20px 20px;background-color: white;">
        <table>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Short Name</th>
              <th>Basic</th>
              <th>TA</th>
              <th>DA</th>
              <th>HRA</th>
              <th>MA</th>
              <th>Bonus</th>
              <th>PF</th>
              <th>PT</th>
            </tr>
            <tr>
              <td>${gradeid}</td>
              <td>${gradename}</td>
              <td>${gradeshname}</td>
              <td>${gradebasic}</td>
              <td>${gradeta}</td>
              <td>${gradeda}</td>
              <td>${gradehra}</td>
              <td>${gradema}</td>
              <td>${gradebonus}</td>
              <td>${gradepf}</td>
              <td>${gradept}</td>
            </tr>
          </table>
    </div>
        </div>
         
        
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>