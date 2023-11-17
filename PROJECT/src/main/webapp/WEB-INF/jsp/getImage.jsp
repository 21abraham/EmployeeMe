<%@page import="com.pack.SampleController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String emp_id = request.getParameter("emp_id");
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
  
        //step2 create  the connection object  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
          PreparedStatement stmt=con.prepareStatement("select * from employeetable where emp_id=?");
          stmt.setInt(1, Integer.parseInt(emp_id));
        ResultSet rs=stmt.executeQuery();
        while(rs.next()) {
            Blob blob = rs.getBlob("emp_upload_pan");
            byte byteArray[] = blob.getBytes(1, (int) blob.length());
            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
        }
    } catch(Exception k)
        {
            System.out.println(k.getMessage());
        }
%>