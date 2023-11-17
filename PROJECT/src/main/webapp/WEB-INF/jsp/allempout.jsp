<%-- 
    Document   : base
    Created on : 21-Jan-2023, 7:56:17 pm
    Author     : hp
--%>
<%@page import="com.pack.allemployeetableclass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="org.springframework.stereotype.Controller"%>
<%@page import="com.pack.DBUtil"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="org.springframework.stereotype.Controller"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
<%@page import="org.springframework.web.bind.annotation.RequestMethod"%>
<%@page import="org.springframework.web.bind.annotation.RequestParam"%>
<%@page import="org.springframework.web.multipart.commons.CommonsMultipartFile"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Employee Details</title>
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
            <b style="font-size:50px;">Display Employee Details</b>
    </div>
        <div class="container" style="padding: 0 0 200px 50px;">
        <div align="center" style="padding: 20px 20px 20px 20px;background-color: white;">
        <table>
                <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Name</th>
              <th>Date of Birth</th>
              <th>Date of Joining</th>
              <th>Address</th>
              <th>City</th>
              <th>Pincode</th>
              <th>Mobile No.</th>
              <th>State</th>
              <th>Mail</th>
              <th>Pan Card No.</th>
              <th>Pan Card</th>
            </tr>
            <%
                ArrayList<allemployeetableclass> std
                        = (ArrayList<allemployeetableclass>) request.getAttribute("list");
                for (allemployeetableclass s : std) {%>
                <%
                    try{
                        Connection con=DBUtil.getDataSource().getConnection();
                        PreparedStatement stmt = con.prepareStatement("select emp_upload_pan from employeetable where emp_id="+s.getEmp_id());
                        ResultSet rs = stmt.executeQuery();

                        while(rs.next()){
                            Blob imageBlob = rs.getBlob("emp_upload_pan");
                            InputStream imageStream = imageBlob.getBinaryStream();
                            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                            byte[] buffer = new byte[4096];
                            int n = 0;
                            while (-1 != (n = imageStream.read(buffer))) {
                                outputStream.write(buffer, 0, n);
                            }
                            byte[] imageBytes = outputStream.toByteArray();
                %>
            <tr>
                <td><%=s.getEmp_id()%></td>
              <td><%=s.getEmp_title()%></td>
              <td><%=s.getEmp_name()%></td>
              <td><%=s.getEmp_dob()%></td>
              <td><%=s.getEmp_doj()%></td>
              <td><%=s.getEmp_address()%></td>
              <td><%=s.getEmp_city()%></td>
              <td><%=s.getEmp_pincode()%></td>
              <td><%=s.getEmp_mobile_no()%></td>
              <td><%=s.getEmp_state()%></td>
              <td><%=s.getEmp_mail_id()%></td>
              <td><%=s.getEmp_pan_no()%></td>
              <td><img style="object-fit: cover;width: 100%;height: 50%;" src="data:image/*;base64,<%= Base64.getEncoder().encodeToString(imageBytes) %>" alt="alt"/></td>
            </tr>
             <%
                }
                    con.close();
            }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
            %>
                <%
                    }%>
           
          </table>
    </div>
            <div style="padding: 100px 0 0 500px;">
                <button style="padding: 10px 100px 10px 100px;border: none; background-color: greenyellow;color: white;" onclick="window.print()" type="button">Print</button>
            </div>        
        </div>
                    
        
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>