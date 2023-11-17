package com.pack;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class SampleController {
    int flag=0;
    public static String NAME;
    @RequestMapping(value="/home")
    public String deleteUser()
    {
        return "Home";
    }
    @RequestMapping("/login")
    public String login(){
        System.out.println("value of flag before login flag = "+flag);
        flag=0;
        System.out.println("value of flag after login flag = "+flag);
        System.out.println("Entering Login");
        return "login";
    }
    @RequestMapping("/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response){
        System.out.println("value of flag before login flag = "+flag);
        request.getSession().invalidate();
        flag=0;
        System.out.println("value of flag after login flag = "+flag);
        System.out.println("Entering Login");
        return "login";
    }
    @Autowired  
    private EmailService emailService;
    @RequestMapping("/forgot")
    public String forgot(HttpSession session){
        return "forgotpwd";
    }
        String e=" ";
    @RequestMapping(value="/forgotform",method = RequestMethod.POST)
    public String forgotpwd(@RequestParam("otp1") String EMAIL,HttpSession session){
        int otp=ThreadLocalRandom.current().nextInt(100000,999999);
        String subject="OTP SENDING";
        String message="<div style='background-image: url(https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg);\n" +
"                background-repeat: no-repeat;\n" +
"                max-width: 100%;\n" +
"                background-size: cover;margin-bottom: 50px;'>"
                +"<img style='height: 50%;width: 100%;' src=\"https://cdn.careers.bloch.umkc.edu/wp-content/uploads/sites/130/2021/11/Business-Adm.png\" class=\"card-img-top\" alt=\"...\">"
                +"<div style='padding: 50px 0 50px 0;text-align: center;'>"
                +"<div>"
                +"<b style='font-size: 50px;'>"
                +"Employee Management System"
                +"</b>"
                +"</div>"
                +"<div>"
                +"<b style='font-size: 50px;'>"
                +"OTP IS: "
                +otp
                +"</b>"
                +"</div>"
                +"</div>"
                +"<div style='text-align: center;color: black;padding: 20px 0 20px 20px;font-size: 20px;background-color: white;'>"
        +"<div class='row' >"
        +"<div class='col-lg-6'>"
            +"<b style='font-size: 30px'>About Us:</b>"
        +"<br>"
        +"<ul class='list-unstyled'>"
        +"<li>Abraham Ahmed, student from Computer department.</li>"
        +"<li>Shubhan Ansari, student from Computer department.</li>"
        +"<li>Snehal Patil, student from ENTC department.</li>"
        +"<li>Sumer Ali, student from Computer department.</li>"
      +"</ul>"
        +"</div>"
    +"<div class='col-lg-6'>"
        +"<b style='font-size: 30px'>Instructor:</b>"
        +"<br>"
        +"<p>Mr. Suresh Pal, Instructor of Super 30 Batch.</p>"
        +"<br>"
    +"</div>"
  +"</div>"
    +"</div>"          
    +"<div style='color: white;font-size: 20px;text-align: center;background-color: black;'>"
        +"<h>"
            +"@MITAOE"
            +"</h>"
    +"</div>"    
                +"</div>";
        String to=EMAIL;
        session.setAttribute("EMAIL",EMAIL);
        try 
        {
            
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
  Connection con=DBUtil.getDataSource().getConnection();
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from admintable where email_id=?");  
  stmt.setString(1,EMAIL);//1 specifies the first parameter in the query    
ResultSet rs=stmt.executeQuery();      
while(rs.next())
       {
           e=rs.getString("email_id");
           if(e.equals(EMAIL)){
        boolean flag1=this.emailService.sendEmail(subject,message,to);
            if(flag1){
            session.setAttribute("myotp",otp);
            
            return "verify";
        }
        else{
         return "errorforgot";   
        }
        }

       }
con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      return "erroremail";
    }
    @RequestMapping(value="/verifyform",method = RequestMethod.POST)
    public String verifypwd(@RequestParam("otpnum") int otp,HttpSession session){
        int myOtp=(int)session.getAttribute("myotp");
        String EMAIL=(String)session.getAttribute("EMAIL");
       if(myOtp==otp){
           return "changepwd";
       }
       else{
           return "errorotp";
       }
        
    }
    @RequestMapping(value="/changeform",method = RequestMethod.POST)
    public String changepwd(@RequestParam("pwd") String pwd,HttpSession session,Model ob1){
        String EMAIL=(String)session.getAttribute("EMAIL");
       try 
        {
            
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
  Connection con=DBUtil.getDataSource().getConnection();
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update admintable set password=? where email_id=?");  
  stmt.setString(2,EMAIL);
stmt.setString(1,pwd);//1 specifies the first parameter in the query    
stmt.executeUpdate();
con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
       Admin adminForm = new Admin();  
 
       ob1.addAttribute("adminForm", adminForm);
        return "loginform";
    }
    String c=" ",d=" ";
    @RequestMapping(value = "/loginform")
    public String viewlogin(Model ob1) {
        Admin adminForm = new Admin();  
 
       ob1.addAttribute("adminForm", adminForm);
         
        return "loginform";
    }
     
    @RequestMapping(value="/processform",method = RequestMethod.POST)
    public String processLogin(@ModelAttribute("adminForm") Admin admin,Model ob) {
        try 
        {
            
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
  Connection con=DBUtil.getDataSource().getConnection();
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from admintable where user_name=? and password=?");  
  stmt.setString(1,admin.getName());
stmt.setString(2,admin.getPwd());//1 specifies the first parameter in the query    
ResultSet rs=stmt.executeQuery();      
while(rs.next())
       {
           c=rs.getString("user_name");
           d=rs.getString("password");
           ob.addAttribute("wname",admin.getName());
           if(c.equals(admin.getName()) && d.equals(admin.getPwd())){
               NAME=admin.getName();
               System.out.println("value of flag before loginfrom flag = "+flag);
               flag=1;
               System.out.println("value of flag after loginfrom flag = "+flag);
            return "welcome";
        }

       }
con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before errorlogin flag = "+flag);
      flag=0;
      System.out.println("value of flag after errorlogin flag = "+flag);
      //1
      return "forgot";
    }
    
    @RequestMapping(value = "/register")
    public String viewreg(Model ob1) {
        Adminreg adminregForm = new Adminreg();  
 
       ob1.addAttribute("adminregForm", adminregForm);
         
        return "register";
    }
    
    @RequestMapping(value="/registerform",method=RequestMethod.POST)
    public  String registerform( @ModelAttribute("adminregForm") Adminreg adminreg,Model object1) 
    {
        
               
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("insert into admintable values(?,?,?,?,?)");  
  stmt.setInt(1, adminreg.getUserid());
stmt.setString(2,adminreg.getUsername());//1 specifies the first parameter in the query  
stmt.setString(3,adminreg.getPassword());  
stmt.setString(4,adminreg.getEmail());  
stmt.setString(5,adminreg.getUsertype()); 
NAME=adminreg.getUsername();
object1.addAttribute("wname",adminreg.getUsername());
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        return "welcome";
    }
    @RequestMapping(value = "/gdetails")
    public String Insertgdetails(Model ob2) {
        gdetailClass gdForm=new gdetailClass();
 
       ob2.addAttribute("gdForm", gdForm);
         
        if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gdetails";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        //1
        return "forgot";
    }
    
    @RequestMapping(value="/gdetailsform",method=RequestMethod.POST)
    public  String Insertgdetailsform( @ModelAttribute("gdForm") gdetailClass gdc,Model ob1) 
    {
        
               
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
//  alter session set NLS_DATE_FORMAT='<my_format>';
PreparedStatement stmt=con.prepareStatement("insert into gradedetails values(?,?,?,?,?,?)");
  stmt.setLong(1, gdc.getTransaction_id());
stmt.setInt(2,gdc.getEmp_id());//1 specifies the first parameter in the query  
stmt.setLong(3,gdc.getEmp_dept_id());
stmt.setLong(4,gdc.getEmp_grade_id());  
stmt.setString(5,gdc.getEmp_from_date());  
stmt.setString(6,gdc.getEmp_to_date());  
            System.out.println(gdc.getEmp_to_date());
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping(value = "/grade")
    public String Insertgrade(Model ob2) {
        gradeClass gForm=new gradeClass();
 
       ob2.addAttribute("gForm", gForm);
         
        if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "grade";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    
    @RequestMapping(value="/gradeform",method=RequestMethod.POST)
    public  String Insertgradeform( @ModelAttribute("gForm") gradeClass gc,Model ob1) 
    {
        
               
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
//  alter session set NLS_DATE_FORMAT='<my_format>';
PreparedStatement stmt=con.prepareStatement("insert into gradetable values(?,?,?,?,?,?,?,?,?,?,?)");
  stmt.setInt(1, gc.getGrade_id());
stmt.setString(2,gc.getGrade_name());//1 specifies the first parameter in the query  
stmt.setString(3,gc.getGrade_short_name());
stmt.setLong(4,gc.getGrade_basic());  
stmt.setLong(5,gc.getGrade_ta());  
stmt.setLong(6,gc.getGrade_da());  
stmt.setLong(7,gc.getGrade_hra());
stmt.setLong(8,gc.getGrade_ma());
stmt.setLong(9,gc.getGrade_bonus());
stmt.setLong(10,gc.getGrade_pf());
stmt.setLong(11,gc.getGrade_pt());
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping("/empdetails")
public String Insertempdetails(Model ob2) {
        employeetableClass empForm=new employeetableClass();
 
       ob2.addAttribute("empForm", empForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "empdetails";
        }
            Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
@RequestMapping(value="/empdetailsform",method=RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public  String Insertempdetailsform( HttpServletRequest request, HttpServletResponse response,@ModelAttribute("empForm") employeetableClass etc,@RequestParam("file") CommonsMultipartFile file,Model ob1) throws IOException 
    {
        
               
      try 
        {
            HttpSession session = request.getSession();
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","root");  
//  alter session set NLS_DATE_FORMAT='<my_format>';
PreparedStatement stmt=con.prepareStatement("insert into employeetable(emp_id,emp_title,emp_name,emp_dob,emp_doj,emp_address,emp_city,emp_pincode,emp_mobile_no,emp_state,emp_mail_id,emp_pan_no,emp_upload_pan) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
  stmt.setInt(1, etc.getEmp_id());
stmt.setString(2,etc.getEmp_title());//1 specifies the first parameter in the query  
stmt.setString(3,etc.getEmp_name());
stmt.setString(4,etc.getEmp_dob());  
stmt.setString(5,etc.getEmp_doj());  
stmt.setString(6,etc.getEmp_address());  
stmt.setString(7,etc.getEmp_city());
stmt.setLong(8,etc.getEmp_pincode());
stmt.setLong(9,etc.getEmp_mobile_no());
stmt.setString(10,etc.getEmp_state());
stmt.setString(11,etc.getEmp_mail_id());
stmt.setLong(12,etc.getEmp_pan_no());
InputStream inputStream = null;

if (file != null) {
    inputStream = file.getInputStream();
}

String message = null;
if (inputStream != null) {
    stmt.setBlob(13, inputStream);
}
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
   
    @RequestMapping("/welcome")
    public String gowelcome(Model ob2){
        System.out.println("Entering Login");
        if(flag==1){
            ob2.addAttribute("wname", NAME);
            System.out.println("value of flag end flag = "+flag);
            return "welcome";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
   @RequestMapping(value = "/salary")
    public String Insertsalary(Model ob2) {
        salaryClass sForm=new salaryClass();
 
       ob2.addAttribute("sForm", sForm);
         
        if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "salary";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    
    @RequestMapping(value="/salaryform",method=RequestMethod.POST)
    public  String Insertsalaryform( @ModelAttribute("sForm") salaryClass sc,Model ob1) 
    {
        
               
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
//  alter session set NLS_DATE_FORMAT='<my_format>';
PreparedStatement stmt=con.prepareStatement("insert into employeesalarytable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
  stmt.setLong(1,sc.getTransaction_id());
stmt.setInt(2,sc.getEmp_id());//1 specifies the first parameter in the query  
stmt.setString(3,sc.getEmp_salary_month());
stmt.setString(4,sc.getEmp_salary_year());  
stmt.setString(5,sc.getEmp_name());  
stmt.setLong(6,sc.getEmp_dept_id());  
stmt.setLong(7,sc.getEmp_grade_id());
stmt.setLong(8,sc.getEmp_basic());
stmt.setLong(9,sc.getEmp_da());
stmt.setLong(10,sc.getEmp_ta());
stmt.setLong(11,sc.getEmp_hra());
stmt.setLong(12,sc.getEmp_ma());  
stmt.setLong(13,sc.getEmp_bonus());
stmt.setLong(14,sc.getEmp_pf());
stmt.setLong(15,sc.getEmp_pt());
stmt.setLong(16,sc.getEmp_gross());
stmt.setLong(17,sc.getEmp_total_salary());
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
     @RequestMapping("/depdetails")
public String Insertdepdetails(Model ob2) {
        departmentClass dForm=new departmentClass();
 
       ob2.addAttribute("dForm", dForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "depdetails";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
@RequestMapping(value="/depdetailsform",method=RequestMethod.POST)
    public  String Insertdepdetailsform( @ModelAttribute("dForm") departmentClass dc,Model ob1) 
    {
               
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
//  alter session set NLS_DATE_FORMAT='<my_format>';
PreparedStatement stmt=con.prepareStatement("insert into departmenttable values(?,?)");
  stmt.setInt(1, dc.getDept_id());
stmt.setString(2,dc.getDept_name());
         stmt.executeUpdate();
         con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
      System.out.println("value of flag before register flag = "+flag);
        flag=1;
        System.out.println("value of flag after register flag = "+flag);
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    
    //..................Display.....................
    @RequestMapping("/allgtdisplay")
    public  String allgtdisplay(Map<String, Object> ob1,Model object1) 
    {
        if(flag==1){
         
       List<allgradetableclass> list = new ArrayList();
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//           Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","root");  
  PreparedStatement stmt=con.prepareStatement("select * from gradetable");
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
              allgradetableclass agt= new allgradetableclass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),rs.getLong(5), rs.getLong(6), rs.getLong(7), rs.getLong(8), rs.getLong(9), rs.getLong(10),rs.getLong(11));
           list.add(agt);
           object1.addAttribute("list", list);
       }
       con.close();
        }
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "allgtout";
    }
        Admin adminForm = new Admin();  
 
       object1.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping("/allgddisplay")
    public  String allgddisplay(Map<String, Object> ob1,Model object1) 
    {
        if(flag==1){
         
       List<allgdetailclass> list = new ArrayList();
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from gradedetails");
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
              allgdetailclass agc= new allgdetailclass(rs.getLong(1), rs.getInt(2), rs.getLong(3), rs.getLong(4), rs.getString(5), rs.getString(6));
           list.add(agc);
           object1.addAttribute("list", list);
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "allgdout";
    }
        Admin adminForm = new Admin();  
 
       object1.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping("/allsdisplay")
    public  String allsdisplay2(Map<String, Object> ob1,Model object1) 
    {
        if(flag==1){
         
       List<allsalaryclass> list = new ArrayList();
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from employeesalarytable");
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
              allsalaryclass asc= new allsalaryclass(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getLong(7), rs.getLong(8), rs.getLong(9), rs.getLong(10), rs.getLong(11), rs.getLong(12), rs.getLong(13),rs.getLong(14),rs.getLong(15),rs.getLong(16),rs.getLong(17));
           list.add(asc);
           object1.addAttribute("list", list);
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "allsout";
    }
        Admin adminForm = new Admin();  
 
       object1.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping("/allempdisplay")
    public  String allempdisplay2(Map<String, Object> ob1,Model object1) 
    {
        if(flag==1){
         
       List<allemployeetableclass> list = new ArrayList();
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from employeetable");
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
              allemployeetableclass aetc= new allemployeetableclass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getLong(9), rs.getString(10), rs.getString(11), rs.getLong(12), rs.getBlob(13));
           list.add(aetc);
           object1.addAttribute("list", list);
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "allempout";
    }
        Admin adminForm = new Admin();  
 
       object1.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/alldepdisplay")
    public  String departmentdisplay2(Map<String, Object> ob1,Model object1) 
    {
        if(flag==1){
          List<alldepartmentclass> list = new ArrayList();
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from departmenttable");
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           alldepartmentclass adc= new alldepartmentclass(rs.getInt(1), rs.getString(2));
           list.add(adc);
           object1.addAttribute("list", list);
       }
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "alldeptout";
    }
        Admin adminForm = new Admin();  
 
       object1.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping("/depdisplay")
public String departmentdisplay1(Model ob2) {
        departmentClass ddForm=new departmentClass();
 
       ob2.addAttribute("ddForm", ddForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "depdisplay";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/depdisplayform",method=RequestMethod.POST)
    public  String departmentdisplay2(@ModelAttribute("ddForm") departmentClass dc,Model object1) 
    {
        
         
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from departmenttable where dept_id=?");  
  stmt.setInt(1, dc.getDept_id());
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
           object1.addAttribute("deptid", rs.getString("dept_id"));
             object1.addAttribute("deptname", rs.getString("dept_name"));
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "depoutput";
    }
    
    @RequestMapping("/empdisplay")
public String empdisplay1(Model ob2) {
        employeetableClass eeForm=new employeetableClass();
 
       ob2.addAttribute("eeForm", eeForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "empdisplay";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }

    @RequestMapping(value="/empdisplayform",method=RequestMethod.POST)
    public  String empdisplay2(@ModelAttribute("eeForm") employeetableClass etc,Model object1) 
    {
        
         
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from employeetable where emp_id=?");
  stmt.setInt(1, etc.getEmp_id());
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
             object1.addAttribute("empid", rs.getString("emp_id"));
//            object1.addAttribute("emptitle",rs.getString("emp_title"));//1 specifies the first parameter in the query  
//            object1.addAttribute("empname",rs.getString("emp_name"));
//            object1.addAttribute("empdob",rs.getString("emp_dob"));  
//            object1.addAttribute("empdoj",rs.getString("emp_doj"));  
//            object1.addAttribute("empadd",rs.getString("emp_address"));  
//            object1.addAttribute("empcity",rs.getString("emp_city"));
//            object1.addAttribute("emppin",rs.getString("emp_pincode"));
//            object1.addAttribute("empmobile",rs.getString("emp_mobile_no"));
//            object1.addAttribute("empstate",rs.getString("emp_state"));
//            object1.addAttribute("empmail",rs.getString("emp_mail_id"));
//            object1.addAttribute("emppan",rs.getString("emp_pan_no"));
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "empoutput";
    }
    
    @RequestMapping("/gtdisplay")
public String gtdisplay1(Model ob2) {
        gradeClass ggForm=new gradeClass();
 
       ob2.addAttribute("ggForm", ggForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gtdisplay";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gtdisplayform",method=RequestMethod.POST)
    public  String gtdisplay2(@ModelAttribute("ggForm") gradeClass gc,Model object1) 
    {
        
         
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from gradetable where grade_id=?");
  stmt.setInt(1, gc.getGrade_id());
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
             object1.addAttribute("gradeid", rs.getString("grade_id"));
            object1.addAttribute("gradename",rs.getString("grade_name"));//1 specifies the first parameter in the query  
            object1.addAttribute("gradeshname",rs.getString("grade_short_name"));
            object1.addAttribute("gradebasic",rs.getString("grade_basic"));  
            object1.addAttribute("gradeta",rs.getString("grade_ta"));  
            object1.addAttribute("gradeda",rs.getString("grade_da"));  
            object1.addAttribute("gradehra",rs.getString("grade_hra"));
            object1.addAttribute("gradema",rs.getString("grade_ma"));
            object1.addAttribute("gradebonus",rs.getString("grade_bonus"));
            object1.addAttribute("gradepf",rs.getString("grade_pf"));
            object1.addAttribute("gradept",rs.getString("grade_pt"));
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "gtoutput";
    }
    @RequestMapping("/sdisplay")
public String sdisplay1(Model ob2) {
        salaryClass ssForm=new salaryClass();
 
       ob2.addAttribute("ssForm", ssForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "sdisplay";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/sdisplayform",method=RequestMethod.POST)
    public  String sdisplay2(@ModelAttribute("ssForm") salaryClass sc,Model object1) 
    {
        
         
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from employeesalarytable where emp_id=?");
  stmt.setInt(1, sc.getEmp_id());
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
            object1.addAttribute("transactionid", rs.getString("transaction_id"));
            object1.addAttribute("empid", rs.getString("emp_id"));
            object1.addAttribute("empsalarymonth", rs.getString("emp_salary_month"));
            object1.addAttribute("empsalaryyear", rs.getString("emp_salary_year"));
            object1.addAttribute("empname", rs.getString("emp_name"));
            object1.addAttribute("empdeptid", rs.getString("emp_dept_id"));
            object1.addAttribute("empgradeid", rs.getString("emp_grade_id"));
            object1.addAttribute("empbasic", rs.getString("emp_basic"));
            object1.addAttribute("empda", rs.getString("emp_da"));
            object1.addAttribute("empta", rs.getString("emp_ta"));
            object1.addAttribute("emphra", rs.getString("emp_hra"));
            object1.addAttribute("empma", rs.getString("emp_ma"));
            object1.addAttribute("empbonus", rs.getString("emp_bonus"));
            object1.addAttribute("emppf", rs.getString("emp_pf"));
            object1.addAttribute("emppt", rs.getString("emp_pt"));
            object1.addAttribute("empgross", rs.getString("emp_gross"));
            object1.addAttribute("emptotalsalary", rs.getString("emp_total_salary"));
       }
        con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "soutput";
    }
    @RequestMapping("/gddisplay")
public String gddisplay1(Model ob2) {
        gdetailClass gdForm=new gdetailClass();
 
       ob2.addAttribute("gdForm", gdForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gddisplay";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gddisplayform",method=RequestMethod.POST)
    public  String gddisplay2(@ModelAttribute("gdForm") gdetailClass gdc,Model object1) 
    {
        
         
       
   
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("select * from gradedetails where emp_id=?");
  stmt.setInt(1, gdc.getEmp_id());
ResultSet rs=stmt.executeQuery();
       while(rs.next())
       {
            object1.addAttribute("transactionid", rs.getString("transaction_id"));
            object1.addAttribute("empid", rs.getString("emp_id"));
            object1.addAttribute("empdeptid", rs.getString("emp_dept_id"));
            object1.addAttribute("empgradeid", rs.getString("emp_grade_id"));
            object1.addAttribute("empfromdate", rs.getString("emp_from_date"));
            object1.addAttribute("emptodate", rs.getString("emp_to_date"));
       }
       con.close();
        }
        
        
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "gdoutput";
    }
    //........................Update.........................
    @RequestMapping("/depupdate")
public String departmentupdate1(Model ob2) {
        departmentClass ddForm=new departmentClass();
 
       ob2.addAttribute("ddForm", ddForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "depupdate";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/depupdateform",method=RequestMethod.POST)
    public  String departmentupdate1(@RequestParam("a") String  x,@ModelAttribute("ddForm") departmentClass dc,Model object1) 
    {
        
         
       
        object1.addAttribute("msg","record updateed Successfully ");
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update departmenttable set dept_id=?,dept_name =? where dept_id=?");  
  stmt.setInt(3, Integer.parseInt(x));
stmt.setInt(1,dc.getDept_id());//1 specifies the first parameter in the query  
stmt.setString(2,dc.getDept_name());  
object1.addAttribute("deptid", dc.getDept_id());
             object1.addAttribute("deptname", dc.getDept_name());
         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "depoutput";
    }
    
    @RequestMapping("/empupdate")
public String employeeupdate1(Model ob2) {
        employeetableClass eeForm=new employeetableClass();
 
       ob2.addAttribute("eeForm", eeForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "empupdate";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/empupdateform",method=RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public  String employeeupdate1(@RequestParam("b") String  x2,@ModelAttribute("eeForm") employeetableClass etc,Model object1,HttpServletRequest request, HttpServletResponse response,@RequestParam("file2") CommonsMultipartFile file) throws IOException 
    {
        
         
       
        object1.addAttribute("msg","record updateed Successfully ");
      try 
        {
            HttpSession session = request.getSession();
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update employeetable set emp_id=?,emp_title=?,emp_name=?,emp_dob=?,emp_doj=?,emp_address=?,emp_city=?,emp_pincode=?,emp_mobile_no=?,emp_state=?,emp_mail_id=?,emp_pan_no=?,emp_upload_pan=? where emp_id=?");  
  stmt.setInt(14, Integer.parseInt(x2));
stmt.setInt(1, etc.getEmp_id());
stmt.setString(2,etc.getEmp_title());//1 specifies the first parameter in the query  
stmt.setString(3,etc.getEmp_name());
stmt.setString(4,etc.getEmp_dob());  
stmt.setString(5,etc.getEmp_doj());  
stmt.setString(6,etc.getEmp_address());  
stmt.setString(7,etc.getEmp_city());
stmt.setLong(8,etc.getEmp_pincode());
stmt.setLong(9,etc.getEmp_mobile_no());
stmt.setString(10,etc.getEmp_state());
stmt.setString(11,etc.getEmp_mail_id());
stmt.setLong(12,etc.getEmp_pan_no());
InputStream inputStream = null;

if (file != null) {
    inputStream = file.getInputStream();
}

String message = null;
if (inputStream != null) {
    stmt.setBlob(13, inputStream);
} //it is used for all insert , update ,delete 
object1.addAttribute("empid", etc.getEmp_id());
stmt.executeUpdate();
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "empoutput";
    }
    @RequestMapping("/gtupdate")
public String gtupdate1(Model ob2) {
        gradeClass ggForm=new gradeClass();
 
       ob2.addAttribute("ggForm", ggForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gtupdate";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gtupdateform",method=RequestMethod.POST)
    public  String gtupdate1(@RequestParam("e") String  x3,@ModelAttribute("ggForm") gradeClass gc,Model object1) 
    {
        
         
       
        object1.addAttribute("msg","record updateed Successfully ");
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update gradetable set grade_id=?,grade_name=?,grade_short_name=?,grade_basic=?,grade_ta=?,grade_da=?,grade_hra=?,grade_ma=?,grade_bonus=?,grade_pf=?,grade_pt=? where grade_id=?");  
  stmt.setInt(12, Integer.parseInt(x3));
stmt.setInt(1, gc.getGrade_id());
stmt.setString(2,gc.getGrade_name());//1 specifies the first parameter in the query  
stmt.setString(3,gc.getGrade_short_name());
stmt.setLong(4,gc.getGrade_basic());  
stmt.setLong(5,gc.getGrade_ta());  
stmt.setLong(6,gc.getGrade_da());  
stmt.setLong(7,gc.getGrade_hra());
stmt.setLong(8,gc.getGrade_ma());
stmt.setLong(9,gc.getGrade_bonus());
stmt.setLong(10,gc.getGrade_pf());
stmt.setLong(11,gc.getGrade_pt());  
object1.addAttribute("gradeid", gc.getGrade_id());
            object1.addAttribute("gradename",gc.getGrade_name());//1 specifies the first parameter in the query  
            object1.addAttribute("gradeshname",gc.getGrade_short_name());
            object1.addAttribute("gradebasic",gc.getGrade_basic());  
            object1.addAttribute("gradeta",gc.getGrade_ta());  
            object1.addAttribute("gradeda",gc.getGrade_da());  
            object1.addAttribute("gradehra",gc.getGrade_hra());
            object1.addAttribute("gradema",gc.getGrade_ma());
            object1.addAttribute("gradebonus",gc.getGrade_bonus());
            object1.addAttribute("gradepf",gc.getGrade_pf());
            object1.addAttribute("gradept",gc.getGrade_pt());
         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "gtoutput";
    }
    @RequestMapping("/gdupdate")
public String gdupdate1(Model ob2) {
        gdetailClass gdForm=new gdetailClass();
 
       ob2.addAttribute("gdForm", gdForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gdupdate";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gdupdateform",method=RequestMethod.POST)
    public  String gdupdate2(@RequestParam("f") String  x4,@ModelAttribute("gdForm") gdetailClass gdc,Model object1) 
    {
        
         
       
        object1.addAttribute("msg","record updateed Successfully ");
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update gradedetailstable set transaction_id=?,emp_id=?,emp_dept_id=?,emp_grade_id=?,emp_from_date=?,emp_to_date=? where emp_id=?");  
  stmt.setInt(7, Integer.parseInt(x4));
stmt.setLong(1, gdc.getTransaction_id());
stmt.setInt(2,gdc.getEmp_id());//1 specifies the first parameter in the query  
stmt.setLong(3,gdc.getEmp_dept_id());
stmt.setLong(4,gdc.getEmp_grade_id());  
stmt.setString(5,gdc.getEmp_from_date());  
stmt.setString(6,gdc.getEmp_to_date());  
object1.addAttribute("transactionid", gdc.getTransaction_id());
object1.addAttribute("empid", gdc.getEmp_id());
object1.addAttribute("empdeptid", gdc.getEmp_dept_id());
object1.addAttribute("empgradeid", gdc.getEmp_grade_id());
object1.addAttribute("empfromdate", gdc.getEmp_from_date());
object1.addAttribute("emptodate", gdc.getEmp_to_date());
         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "gdoutput";
    }
    
    @RequestMapping("/supdate")
public String supdate1(Model ob2) {
        salaryClass ssForm=new salaryClass();
 
       ob2.addAttribute("ssForm", ssForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "supdate";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/supdateform",method=RequestMethod.POST)
    public  String supdate2(@RequestParam("g") String  x5,@ModelAttribute("ssForm") salaryClass sc,Model object1) 
    {
        
         
       
        object1.addAttribute("msg","record updateed Successfully ");
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("update employeesalarytable set transaction_id=?,emp_id=?,emp_salary_month=?,emp_salary_year=?,emp_name=?,emp_dept_id=?,emp_grade_id=?,emp_basic=?,emp_da=?,emp_ta=?,emp_hra=?,emp_ma=?,emp_bonus=?,emp_pf=?,emp_pt=?,emp_gross=?,emp_total_salary=? where emp_id=?");  
  stmt.setInt(18, Integer.parseInt(x5));
stmt.setLong(1,sc.getTransaction_id());
stmt.setInt(2,sc.getEmp_id());//1 specifies the first parameter in the query  
stmt.setString(3,sc.getEmp_salary_month());
stmt.setString(4,sc.getEmp_salary_year());  
stmt.setString(5,sc.getEmp_name());  
stmt.setLong(6,sc.getEmp_dept_id());  
stmt.setLong(7,sc.getEmp_grade_id());
stmt.setLong(8,sc.getEmp_basic());
stmt.setLong(9,sc.getEmp_da());
stmt.setLong(10,sc.getEmp_ta());
stmt.setLong(11,sc.getEmp_hra());
stmt.setLong(12,sc.getEmp_ma());  
stmt.setLong(13,sc.getEmp_bonus());
stmt.setLong(14,sc.getEmp_pf());
stmt.setLong(15,sc.getEmp_pt());
stmt.setLong(16,sc.getEmp_gross());
stmt.setLong(17,sc.getEmp_total_salary());
object1.addAttribute("transactionid", sc.getTransaction_id());
object1.addAttribute("empid", sc.getEmp_id());
object1.addAttribute("empsalarymonth", sc.getEmp_salary_month());
object1.addAttribute("empsalaryyear", sc.getEmp_salary_year());
object1.addAttribute("empname", sc.getEmp_name());
object1.addAttribute("empdeptid", sc.getEmp_dept_id());
object1.addAttribute("empgradeid", sc.getEmp_grade_id());
object1.addAttribute("empbasic", sc.getEmp_basic());
object1.addAttribute("empda", sc.getEmp_da());
object1.addAttribute("empta", sc.getEmp_ta());
object1.addAttribute("emphra", sc.getEmp_hra());
object1.addAttribute("empma", sc.getEmp_ma());
object1.addAttribute("empbonus", sc.getEmp_bonus());
object1.addAttribute("emppf", sc.getEmp_pf());
object1.addAttribute("emppt", sc.getEmp_pt());
object1.addAttribute("empgross", sc.getEmp_gross());
object1.addAttribute("emptotalsalary", sc.getEmp_total_salary());
         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        
        return "soutput";
    }
    //....................Delete....................
    @RequestMapping("/depdelete")
public String departmentdelete1(Model ob2) {
        departmentClass ddForm=new departmentClass();
 
       ob2.addAttribute("ddForm", ddForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "depdelete";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/depdeleteform",method=RequestMethod.POST)
    public  String departmentdelete2(@ModelAttribute("ddForm") departmentClass dc,Model ob1) 
    {
        
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("delete from departmenttable where dept_id=?");  
  stmt.setInt(1, dc.getDept_id());  

         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping("/empdelete")
public String employeedelete1(Model ob2) {
        employeetableClass eeForm=new employeetableClass();
 
       ob2.addAttribute("eeForm", eeForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "empdelete";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/empdeleteform",method=RequestMethod.POST)
    public  String employeedelete2(@ModelAttribute("eeForm") employeetableClass etc,Model ob1) 
    {
        
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("delete from employeetable where emp_id=?");  
  stmt.setInt(1, etc.getEmp_id());  

         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping("/gtdelete")
public String gtdelete1(Model ob2) {
        gradeClass ggForm=new gradeClass();
 
       ob2.addAttribute("ggForm", ggForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gtdelete";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gtdeleteform",method=RequestMethod.POST)
    public  String gtdelete2(@ModelAttribute("ggForm") gradeClass gc,Model ob1) 
    {
        
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("delete from gradetable where grade_id=?");  
  stmt.setInt(1, gc.getGrade_id());  

         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping("/gddelete")
public String gddelete1(Model ob2) {
        gdetailClass gdForm=new gdetailClass();
 
       ob2.addAttribute("gdForm", gdForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "gddelete";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/gddeleteform",method=RequestMethod.POST)
    public  String gddelete2(@ModelAttribute("gdForm") gdetailClass gdc,Model ob1) 
    {
        
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("delete from gradedetailstable where emp_id=?");  
  stmt.setInt(1, gdc.getEmp_id());  

         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
         
        
        
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
    @RequestMapping("/sdelete")
public String sdelete1(Model ob2) {
        salaryClass ssForm=new salaryClass();
 
       ob2.addAttribute("ssForm", ssForm);
            if(flag==1){
            System.out.println("value of flag end flag = "+flag);
            return "sdelete";
        }
        Admin adminForm = new Admin();  
 
       ob2.addAttribute("adminForm", adminForm);
        System.out.println("value of flag end flag = "+flag);
        return "errorlogin";
    }
    @RequestMapping(value="/sdeleteform",method=RequestMethod.POST)
    public  String sdelete2(@ModelAttribute("ssForm") salaryClass sc,Model ob1) 
    {
        
      try 
        {
            Connection con=DBUtil.getDataSource().getConnection();
//            Class.forName("oracle.jdbc.driver.OracleDriver");  
//  
////step2 create  the connection object  
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
  PreparedStatement stmt=con.prepareStatement("delete from employeesalarytable where emp_id=?");  
  stmt.setInt(1, sc.getEmp_id());  

         stmt.executeUpdate(); //it is used for all insert , update ,delete 
        con.close();
        }
        catch(SQLException k)
        {
            System.out.println(k.getMessage());
        }
        ob1.addAttribute("wname",NAME);
        return "welcome";
    }
}