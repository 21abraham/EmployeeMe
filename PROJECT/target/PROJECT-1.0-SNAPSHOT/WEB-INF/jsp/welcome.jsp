<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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
                :root{
                    --one-color: #faf9f5;
                    --two-color: #000000;
                    --three-color: #63e9f7;
                    --four-color: #037ffc;
                    --five-color: #778396;
                    --six-color: #22c751;
                    --seven-color: #d6ffef;
                    --eight-color: #d6ffef;
                }
                .light-mode{
                    --one-color: #faf9f5;
                    --two-color: #000000;
                    --three-color: #63e9f7;
                    --four-color: #037ffc;
                    --five-color: #778396;
                    --six-color: #22c751;
                    --seven-color: #d6ffef;
                    --eight-color: #f1fa8c;
                }
                .dracula-mode{
                    --one-color: #44475a;
                    --two-color: #ff79c6;
                    --three-color: #282a36;
                    --four-color: #ff5555;
                    --five-color: #8be9fd;
                    --six-color: #50fa7b;
                    --seven-color: #44475a;
                    --eight-color: #ff79c6;
                }
                .dark-mode{
                    --one-color: #000000;
                    --two-color: #faf9f5;
                    --three-color: #000000;
                    --four-color: #faf9f5;
                    --five-color: #faf9f5;
                    --six-color: #faf9f5;
                    --seven-color: #000000;
                    --eight-color: #faf9f5;
                }
            body{
                background-image: url(https://cdn-i.pageflow.io/_a411/_e30429/main/video_files/posters/000/069/737/v1/medium/poster-0.JPG);
                /*https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg*/
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;
               
            }
            .card-header{
                color: var(--five-color);
            }
            #card1{
                background-color: var(--one-color);
                color: var(--four-color);
            }
            #card2{
                background-color: var(--one-color);
                color: var(--five-color);
            }
            #card3{
                background-color: var(--one-color);
                color: var(--six-color);
            }
            #card1:hover{
                background-color: var(--four-color);
                background-image: url(https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg);background-repeat: no-repeat;max-width: 100%;background-size: cover;
            }
            #card1:hover .card-header,
            #card1:hover .card-text,
            #card1:hover .card-title{
                color: var(--one-color);
            }
            #card2:hover{
                background-color: var(--five-color);
                background-image: url(https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg);background-repeat: no-repeat;max-width: 100%;background-size: cover;
            }
            #card2:hover .card-header,
            #card2:hover .card-text,
            #card2:hover .card-title{
                color: var(--one-color);
            }
            #card3:hover{
                background-color: var(--six-color);
                background-image: url(https://wallpapersmug.com/download/1920x1080/4d7d03/light-colors-geometric-pattern-abstract.jpg);background-repeat: no-repeat;max-width: 100%;background-size: cover;
            }
            #card3:hover .card-header,
            #card3:hover .card-text,
            #card3:hover .card-title{
                color: var(--one-color);
            }
            .card-body{
                margin-bottom: 50px;
            }
        </style>
    </head>
    <body>
        <%
     String m=(String)  request.getAttribute("wname");
           %>
        <nav style="background-color: var(--three-color);" class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a style="color: var(--two-color);" class="navbar-brand" href="#">Employee Manager</a>
    <button style="background-color: var(--eight-color);" class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a style="color: var(--two-color);" class="nav-link" href="https://mitaoe.ac.in/">MITAOE</a>
        </li>
        <li class="nav-item">
          <a style="color: var(--two-color);" class="nav-link" href="signout.htm">Sign Out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4" aria-label="Slide 5"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="4000">
        <a href="empdetails.htm" style="text-decoration: none;"><img src="https://www.betterup.com/hubfs/Blog%20Images/employee%20benefits%20liability%20coverage%201.jpg" class="d-block w-100" alt="..."></a>
      <div class="carousel-caption d-none d-md-block">
        <h5>Add New Employee</h5>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="4000">
      <a href="depdetails.htm" style="text-decoration: none;"><img src="https://images.wallpaperscraft.com/image/single/office_work_interior_walls_80538_1920x1080.jpg" class="d-block w-100" alt="..."></a>
      <div class="carousel-caption d-none d-md-block">
        <h5>Add New Department</h5>
      </div>
    </div>
      <div class="carousel-item" data-bs-interval="4000">
      <a href="grade.htm" style="text-decoration: none;"><img src="https://www.gradar.com/frontend/gradar/images/video-thumb-new.jpg" class="d-block w-100" alt="..."></a>
      <div class="carousel-caption d-none d-md-block">
        <h5>Add New Grade</h5>
      </div>
    </div>
      <div class="carousel-item" data-bs-interval="4000">
      <a href="gdetails.htm" style="text-decoration: none;"><img src="https://wallpaperaccess.com/full/4242576.jpg" class="d-block w-100" alt="..."></a>
      <div class="carousel-caption d-none d-md-block">
        <h5>Employee Grade Details</h5>
      </div>
    </div>
      <div class="carousel-item">
      <a href="salary.htm" style="text-decoration: none;"><img src="https://www.incimages.com/uploaded_files/image/1920x1080/getty_466092235_86722.jpg" class="d-block w-100" alt="..."></a>
      <div class="carousel-caption d-none d-md-block">
        <h5>Prepare Monthly Salary</h5>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
        <div style="background-color: var(--three-color);">
  <div class="row">
    <div class="col-lg-4" style="color: var(--two-color);text-align:center;padding-top: 10px;">
      <h3>5,000 Employees</h3>
      <p>Set your targets</p>
    </div>
    <div class="col-lg-4" style="color: var(--two-color);text-align:center;padding-top: 10px;">
      <h3>Expert Advice</h3>
      <p>Email will auto fill data</p>
    </div>
    <div class="col-lg-4" style="color: var(--two-color);text-align:center;padding-top: 10px;">
      <h3>Update Details</h3>
      <p>Get all information up to date</p>
    </div>
  </div>
</div>
        <div style="background-color: var(--seven-color);text-align: center;padding-top: 50px;padding-bottom: 50px;">
            <b style="font-size:50px;color: var(--two-color);"><b>Welcome </b><b><%=m%></b></b>
    </div>

        <div>
            <div>
                <div class="row">
                   
            <div class="col-lg-6" style="text-align: center;">
                <div style="background-color: var(--three-color);width: 110%;"><b style="color: var(--two-color);font-size: 40px;">Employee Details</b></div>
                    <div class="row" style="padding-top: 50px;padding-bottom: 50px;">
        <div class="col-md-4">
            <a href="empupdate.htm" style="text-decoration: none;">
          <div class="container">
          <div id="card1" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Edit</div>
  <div  class="card-body">
    <h5 class="card-title">Employee Details</h5>
    <p class="card-text">In this section you can edit each and every employee record.</p>
  </div>
</div>
          </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="empdisplay.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card2" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">View</div>
  <div  class="card-body">
    <h5 class="card-title">Employee Details</h5>
    <p class="card-text">In this section you can view each and every record of all employees.</p>
  </div>
</div>
      </div>
            </a>
    </div>
    <div class="col-md-4">
        <a href="empdelete.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card3" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Delete</div>
  <div class="card-body">
    <h5 class="card-title">Employee Details</h5>
    <p class="card-text">In this section you can delete the required employee record.</p>
  </div>
</div>
      </div>
            </a>
    </div>
  </div>
                    </div>
                    <div class="col-lg-6" style="background-image: url(https://wallpaperaccess.com/full/4321838.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;">
                       
                    </div>
            </div>
        </div>
            <div>
                <div class="row">
                    <div class="col-lg-6" style="background-image: url(https://free4kwallpapers.com/uploads/originals/2015/10/11/well-furnished-office-wallpaper.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;">
                       
                    </div>
            <div class="col-lg-6" style="padding-left: 0;text-align: center;">
                <div style="background-color: var(--three-color);width: 110%;"><b style="color: var(--two-color);font-size: 40px;">Department Details</b></div>
            <div class="row" style="padding: 50px 0 50px 0;">
        <div class="col-md-4">
            <a href="depupdate.htm" style="text-decoration: none;">
          <div class="container">
          <div id="card1" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Edit</div>
  <div class="card-body">
    <h5 class="card-title">Department</h5>
    <p class="card-text">In this section you can edit each and every department's record.</p>
  </div>
</div>
          </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="depdisplay.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card2" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">View</div>
  <div class="card-body">
    <h5 class="card-title">Department</h5>
    <p class="card-text">In this section you can view each and every record of all the departments.</p>
  </div>
</div>
      </div>
            </a>
    </div>
    <div class="col-md-4">
        <a href="depdelete.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card3" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Delete</div>
  <div class="card-body">
    <h5 class="card-title">Department</h5>
    <p class="card-text">In this section you can delete the record of any department.</p>
  </div>
</div>
      </div>
            </a>
    </div>
  </div>
        </div>
    </div>
</div>
            <video autoplay loop muted plays-inline style="position: absolute;right: 0;bottom: 0;z-index: -1;">
                <source src="<c:url value="/resourses/videos/video1.mp4" />" type="video/mp4">
                </video>
                <div style="background: var(--seven-color);padding: 20px 20px 20px 20px;"><video autoplay loop muted plays-inline style="width: 100%;height: 50%;">
                    <source src="<c:url value="/resourses/videos/videoplayback.webm" />" type="video/webm">
                </video></div>
            <div>
                <div class="row">
                   
            <div class="col-lg-6" style="text-align: center;">
                <div style="background-color: var(--three-color);width: 110%;"><b style="color: var(--two-color);font-size: 40px;">Grade Table</b></div>
            <div class="row" style="padding-top: 50px;padding-bottom: 50px;">
        <div class="col-md-4">
            <a href="gtupdate.htm" style="text-decoration: none;">
          <div class="container">
          <div id="card1" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Edit</div>
  <div style="margin-bottom: 70px;" class="card-body">
    <h5 class="card-title">Grade Table</h5>
    <p class="card-text">In this section you can edit each and every grade record.</p>
  </div>
</div>
          </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="gtdisplay.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card2" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">View</div>
  <div style="margin-bottom: 70px;" class="card-body">
    <h5 class="card-title">Grade Table</h5>
    <p class="card-text">In this section you can view each and every grade record.</p>
  </div>
</div>
      </div>
            </a>
    </div>
    <div class="col-md-4">
        <a href="gtdelete.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card3" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Delete</div>
  <div class="card-body">
    <h5 class="card-title">Grade Table</h5>
    <p class="card-text">In this section you can delete the required grade record.</p>
  </div>
</div>
      </div>
            </a>
    </div>
  </div>
        </div>
                    <div class="col-lg-6" style="background-image: url(https://www.smartbusinessdaily.com/wp-content/uploads/2022/10/PaaS-platform.webp);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;">
                       
                    </div>
    </div>
</div>
            <div class="row">
                    <div class="col-lg-6" style="background-image: url(https://wallpaperaccess.com/full/1199303.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;">
                       
                    </div>
            <div class="col-lg-6" style="padding-left: 0;text-align: center;">
                <div style="background-color: var(--three-color);width: 110%;"><b style="color: var(--two-color);font-size: 40px;">Grade Details</b></div>
            <div class="row" style="padding: 50px 0 50px 0;">
        <div class="col-md-4">
            <a href="gdupdate.htm" style="text-decoration: none;">
          <div class="container">
          <div id="card1" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Edit</div>
  <div class="card-body">
    <h5 class="card-title">Grade Details</h5>
    <p class="card-text">In this section you can edit each and every record of grade details.</p>
  </div>
</div>
          </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="gddisplay.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card2" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">View</div>
  <div class="card-body">
    <h5 class="card-title">Grade Details</h5>
    <p class="card-text">In this section you can view each and every record of grade details.</p>
  </div>
</div>
      </div>
            </a>
    </div>
    <div class="col-md-4">
        <a href="gddelete.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card3" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Delete</div>
  <div class="card-body">
    <h5 class="card-title">Grade Details</h5>
    <p class="card-text">In this section you can delete the required grade details record .</p>
  </div>
</div>
      </div>
            </a>
    </div>
  </div>
        </div>
    </div>
            <div class="row" >
                <div class="col-lg-6" style="text-align: center;">
                <div style="background-color: var(--three-color);width: 110%;"><b style="color: var(--two-color);font-size: 40px;">Salary Details</b></div>
            <div class="row" style="padding-top: 50px;padding-bottom: 50px;">
        <div class="col-md-4">
            <a href="supdate.htm" style="text-decoration: none;">
          <div class="container">
          <div id="card1" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Edit</div>
  <div class="card-body">
    <h5 class="card-title">Salary Details</h5>
    <p class="card-text">In this section you can edit each and every record of salary details.</p>
  </div>
</div>
          </div>
            </a>
        </div>
    <div class="col-md-4">
        <a href="sdisplay.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card2" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">View</div>
  <div class="card-body">
    <h5 class="card-title">Salary Details</h5>
    <p class="card-text">In this section you can view all the records of employee salary.</p>
  </div>
</div>
      </div>
            </a>
    </div>
    <div class="col-md-4">
        <a href="sdelete.htm" style="text-decoration: none;">
      <div class="container">
        <div id="card3" class="card border mb-3" style="max-width: 18rem;">
  <div class="card-header">Delete</div>
  <div class="card-body">
    <h5 class="card-title">Salary Details</h5>
    <p class="card-text">In this section you can delete the required salary details record.</p>
  </div>
</div>
      </div>
            </a>
    </div>
  </div>
</div>
                <div class="col-lg-6" style="background-image: url(https://www.corporatevision-news.com/wp-content/uploads/2022/02/Employee-Salary.jpg);
                background-repeat: no-repeat;
                max-width: 100%;
                background-size: cover;">
                       
                    </div>
      </div>
        </div>
        <div style="background-color: var(--one-color);text-align: center;padding: 50px;">
            <b style="color: var(--two-color);font-size: 50px;">Themes</b>
  </div>
        <div>
            <div class="card-group">
               <div style="background-color: var(--one-color);" id="icon3" class="card">
    <img src="https://wallpapercave.com/wp/wp3439738.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 style="color: var(--two-color);text-align: center;" class="card-title">Light mode</h5>
    </div>
  </div>
  <div style="background-color: var(--one-color);" id="icon2" class="card">
    <img src="https://i.imgur.com/22JZRPa.png" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 style="color: var(--two-color);text-align: center;" class="card-title">Dracula mode</h5>
    </div>
  </div>
  <div style="background-color: var(--one-color);" id="icon" class="card">
    <img src="https://wallpaperaccess.com/full/2562648.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 style="color: var(--two-color);text-align: center;" class="card-title">Dark Mode</h5>
    </div>
  </div>
</div>
        </div>
    <div style="text-align: center;color: var(--two-color);padding: 20px 0 20px 20px;font-size: 20px;background-color: var(--one-color);">
        <div class="row" >
        <div class="col-lg-6">
            <b style="font-size: 30px">About Us:</b>
        <br>
        <ul class="list-unstyled">
        <li>Abraham Ahmed, student from Computer department.</li>
        <li>Shubhan Ansari, student from Computer department.</li>
        <li>Snehal Patil, student from ENTC department.</li>
        <li>Sumer Ali, student from Computer department.</li>
      </ul>
        </div>
    <div class="col-lg-6">
        <b style="font-size: 30px">Instructor:</b>
        <br>
        <p>Mr. Suresh Pal, Instructor of Super 30 Batch.</p>
        <br>
    </div>
  </div>
    </div>          
    <div style="color: var(--one-color);font-size: 20px;text-align: center;background-color: var(--two-color);">
        <h>@MITAOE</h>
    </div>          
       
       
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    
    <script>
    var enabledark=false;    
    const icon=document.getElementById("icon");
        icon.onclick=function()
        {
            if(document.body.classList.contains("light-mode")){
            document.body.classList.remove("light-mode");
            document.body.classList.add("dark-mode");
            localStorage.setItem("theme","dark-mode");
            enabledark=true;
            }
            else if(document.body.classList.contains("dracula-mode")){
             document.body.classList.remove("dracula-mode");
            document.body.classList.add("dark-mode");
            localStorage.setItem("theme","dark-mode");
            enabledark=true;
            }
            else{
                document.body.classList.add("dark-mode");
            localStorage.setItem("theme","dark-mode");
            enabledark=true;
        }
            document.getElementById("currenttheme").innerHTML = localStorage.theme;
        };
        document.body.classList.add(localStorage.getItem("theme"));
    document.getElementById("currenttheme").innerHTML = localStorage.theme;
</script>
<script>
        const icon2=document.getElementById("icon2");
        icon2.onclick=function()
        {
            if(document.body.classList.contains("light-mode")){
            document.body.classList.remove("light-mode");
            document.body.classList.add("dracula-mode");
            localStorage.setItem("theme","dracula-mode");
            }
            else if(document.body.classList.contains("dark-mode")){
            document.body.classList.remove("dark-mode");
            document.body.classList.add("dracula-mode");
            localStorage.setItem("theme","dracula-mode");
            }
            else{
                document.body.classList.add("dracula-mode");
            localStorage.setItem("theme","dracula-mode");
            }
            document.getElementById("currenttheme").innerHTML = localStorage.theme;
        };
        document.body.classList.add(localStorage.getItem("theme"));
    document.getElementById("currenttheme").innerHTML = localStorage.theme;
</script>
<script>
        const icon3=document.getElementById("icon3");
        icon3.onclick=function()
        {
            if(document.body.classList.contains("dracula-mode")){
            document.body.classList.remove("dracula-mode");
            document.body.classList.add("light-mode");
            localStorage.setItem("theme","light-mode");
            }
            else if(document.body.classList.contains("dark-mode")){
            document.body.classList.remove("dark-mode");
            document.body.classList.add("light-mode");
            localStorage.setItem("theme","light-mode");
            }
            else{
                document.body.classList.toggle("light-mode");
            localStorage.setItem("theme","light-mode");
        }
            document.getElementById("currenttheme").innerHTML = localStorage.theme;
        };
        document.body.classList.add(localStorage.getItem("theme"));
    document.getElementById("currenttheme").innerHTML = localStorage.theme;
</script>
    </body>
</html>