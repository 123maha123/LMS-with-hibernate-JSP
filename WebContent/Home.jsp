<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Library Management System </title>
	<link rel="stylesheet" type="text/css" href="logincss.css" />
	<script type="text/javascript" src="script.js"></script>
</head>
 <body bgcolor="#e1f2f8">  
    <div id="header" >
		<div id="logo"><img src="logo.png" width="200px" height="200px"></div>
		<div id="projectname">
			<b><font face="Times New Roman Bold" color="black" size=6>
			LIBRARY MANAGEMENT SYSTEM</font></b>
		</div>
	</div>

    <div id="menu">
		<div id="home"><font color="black" size=4>Home</font></div>
    </div>

    <div id="center">
    <div id="gap">
    <font face="time new roman" size="+2" color="#000">
    <span id="doubleunderline" class="doubleunderline">
    LIBRARY MANAGEMENT SYSTEM : 
    </span>
    </font>
    </div>
    <div id="content">
    <font face="time new roman" size="+1" color="#000">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Library Management System is a web application developed to reduce resources. This application saves time and energy and is very helpful for the librarian. 
    </font>
    </div>
    </div>
    
    <div id="right">
    <br>
    <br>
    
        <div id="userlogin">    
        <div id="upperlogin">
		<center><font face="times new roman" color=#e1f2f8 size=5>Login</font></center>
        </div>
        <br>
        <form name="loginForm" method="post" action="Login" >
		<label for="userID"> User ID :&nbsp;&nbsp; </label>
		<input type="text" id="userID" name="userID" onBlur="return validateUserID()"><br>
		<span id="userIDSpan" ></span>
		<label for="password">Password :</label>
		<input type="password" id="password" name="password" onBlur="return validatePassword()">
		<span id="passwordSpan" ></span>
		<div id="lower">
		<input type="hidden" value="login" name="action" />
    	<input type="submit" id="submit" name="submit" value="Login" onClick="return validateUser()">
    
		</div>
		</form>
		</div>    
    </div>
 </body>
</html>