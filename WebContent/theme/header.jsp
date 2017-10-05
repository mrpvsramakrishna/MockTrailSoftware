
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
	<title>MOCK TRAIL SOFTWARE</title>
		<link rel="stylesheet" href="css/style.css">
	
<style type="text/css">
    ul{
        padding: 0;
        list-style: none;
        background: #fff;
    }
    ul li{
        display: inline-block;
        position: relative;
        line-height: 21px;
        text-align: left;
    }
    ul li a{
        display: block;
        padding: 8px 25px;
        color: #333;
        text-decoration: none;
    }
    ul li a:hover{
        color: #000;
        background: #fff;
    }
    ul li ul.dropdown-menu{
       /* Set width of the dropdown */
       min-width:150px;
        background:transparent;
        display: none;
        position: absolute;
        z-index: 999;
        left: 0;
    }
    ul li ul.dropdown-menu li{
        display: block;
    }
    
 .header img {
  float: left; 
  width: 100px;
  height: 100px;

  background: #fff;
  display: inline;
}

.header h1 {
    display: inline;     
      position: relative;
      top:30px;
      left: -105px;
    padding-bottom: 50px; 
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        // Show hide popover
        $(".dropdown").click(function(){
            $(this).find(".dropdown-menu").slideToggle("fast");
        });
    });
    $(document).on("click", function(event){
        var $trigger = $(".dropdown");
        if($trigger !== event.target && !$trigger.has(event.target).length){
            $(".dropdown-menu").slideUp("fast");
        }            
    });
</script>
</head>
<body>
<!-- <img src="images/logo.jpg" style="margin-bottom:-90px;"> -->
<br/>
<h1 style="text-align: center">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
Mock Trail Software System</h1>

<br/>

<ul>
        <li style="float:left"><a href="index.jsp" ><strong>Home</strong></a></li>
             
            
             <li  style="float:left" class="dropdown">
            <a href="#"><strong>Login &#9662;</strong></a>
            <ul class="dropdown-menu">
          <a href="adminlogin.jsp">Admin</a>
				<a href="login.jsp">Attorney</a>
          </ul>
          </li>
               <li  style="float:left" class="dropdown">
            <a href="#"><strong>Registration &#9662;</strong></a>
            <ul class="dropdown-menu">
                 <a href="adminregistration.jsp">Admin</a>
				<a href="registration.jsp">Attorney</a>
            </ul>
        </li>
          
      
           
         <li style="float:right"><a href="contact-us.jsp" target="_self"><strong>Contact Us</strong></a></li>       
        <li style="float:right"><a href="about-us.jsp" target="_self"><strong>About Us</strong></a></li>
         
         <li style="float:right" class="dropdown">
             <a href="#"><strong>Reports &#9662;</strong></a>
             <ul class="dropdown-menu">
                 <a href="#">My Account</a>
				<a href="#">DB Update</a>
      
            </ul>
            </li>
             
    
             </ul>
    <br>

</body>
</html>
