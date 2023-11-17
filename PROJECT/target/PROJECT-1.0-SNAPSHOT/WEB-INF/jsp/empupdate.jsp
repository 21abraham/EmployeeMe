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
        <title>Update Employee details</title>
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
            <b style="font-size:50px;">Employee Details</b>
    </div>
        <div class="container" style="padding: 0 0 200px 50px;">
        <form:form id="edit" action="empupdateform" method="post" commandName="eeForm" enctype="multipart/form-data">
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Old Employee-ID <input placeholder="Enter Old Employee-ID" type="number" name="b" required="required"></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
            <label>New Employee-ID <form:input placeholder="Enter New Employee-ID" type="number" path="emp_id" required="required"/></label>
        
        </div>
    </div>
  </div>
        <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Employee Title <form:input placeholder="Enter Employee Title" type="text" path="emp_title" required="required"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>Employee Name <form:input placeholder="Enter Employee Name" type="text" path="emp_name" required="required"/></label>
        </div>
    </div>
  </div>
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Date of Birth <form:input placeholder="YYYY-MM-DD" type="text" path="emp_dob" required="required"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>Date of Joining <form:input placeholder="YYYY-MM-DD" type="text" path="emp_doj" required="required"/></label>
        </div>
    </div>
  </div>
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Address <form:input placeholder="Enter Employee Address" type="text" path="emp_address" required="required"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>City <form:input placeholder="Enter Employee City" type="text" path="emp_city" required="required"/></label>
        </div>
    </div>
  </div>
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>State <form:input placeholder="Enter Employee State" type="text" path="emp_state"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>Pincode <form:input placeholder="Enter Employee Pincode" type="number" path="emp_pincode" required="required"/></label>
        </div>
    </div>
  </div>
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Mobile Number <form:input placeholder="Enter Employee Mobile Number" type="number" path="emp_mobile_no" required="required"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>Email-ID <form:input placeholder="Enter Employee Email" type="email" path="emp_mail_id" required="required"/></label>
        </div>
    </div>
  </div>
            <div class="row" >
        <div class="col-lg-2">
            <div style="padding: 20px 0 0 0;">
            <label>Pan Card No. <form:input placeholder="Enter Employee Pan Card No."  type="number" path="emp_pan_no" required="required"/></label>
            </div>
        </div>
    <div class="col-lg-2" style="margin-left: 500px">
        <div style="padding: 20px 0 0 0;">
        <label>Upload Pan Card Image <input type="file" name="file2" accept="image/*" required="required"/></label>
        </div>
    </div>
  </div>
            
            <div class="container" style="padding: 100px 0 0 400px;">
                <input style="padding: 10px 100px 10px 100px;border: none;background-color: greenyellow; color: white;" type="submit" value="Submit">
                <a style="text-decoration: none;" href="empupdate.htm"><button style="padding: 10px 100px 10px 100px;border: none; background-color: greenyellow;color: white;" type="button">Clear</button></a>
            </div>
            </form:form>
        </div>
        
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>