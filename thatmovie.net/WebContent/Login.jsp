<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/thatmoviescript.js"></script>
<link rel="stylesheet" href="css/thatmoviestyle.css" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

</head>

<body id="LoginBody">






	<div id="container">
		
		<h2 id="logo"><span>thatmovie</span>.net</h2>
		
	<div id="loginContainer">
		
		<form name="login_frm" id="login_frm" action="" method="post">

			<p>
			  <label>Username</label> 
			  <input type="text" name="uName" id="uName">
            </p>
            <p>
              <label>Password</label> 
              <input type="password" name="pswrd" id="pswrd"> 
            </p>
     
            
			<div id="msgbox"></div>
		
             <div id="login_footer">
			   <p>
			   <input type="submit" value="Login" id="loginbtn"name="loginbtn">
               </p>			 
			 </div>

		</form>
	
	</div>	
	
	</div>


<!-- <img src="${pageContext.request.contextPath}/img/wallpaper2you_557127.jpg"/> -->


</body>
</html>