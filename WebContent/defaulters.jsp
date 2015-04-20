<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lms.beans.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>defaulters.jsp</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body bgcolor="#e1f2f8">  
    
    <div id="header" >
		<div id="logo"><img id="logoImage" src="logo.png" width="200px" height="200px"></div>
		<div id="projectname">
			<b><font face="Times New Roman Bold" color="black" size=6>
			LIBRARY MANAGEMENT SYSTEM</font></b>
		</div>
	</div>
	<div id="content">
		<div id="menu">
		<center>
			<ul>
  				<li>Book Administration
    				<ul>
      					<li><a href="AddBook.jsp">Add Book</a></li>
    					<li><a href="UpdateBook.jsp">Update Book</a></li>
    					<li><a href="DeleteBook.jsp">Delete Book</a></li>
    					<li><a href="ViewBookDetails.jsp">View Book Details</a></li>
    				</ul>
  				</li>
  				<li>Magazine Administration
    				<ul>
    					<li><a href="AddMagazine.jsp">Add Magazine</a></li>
    					<li><a href="UpdateMagazine.jsp">Update Magazine</a></li>
    					<li><a href="DeleteMagazine.jsp">Delete Magazine</a></li>
    					<li><a href="ViewMagazineDetails.jsp">View Magazine Details</a></li>
    				</ul>
  				</li>
  				<li>CD Administration
    				<ul>
    					<li><a href="AddCD.jsp">Add CD</a></li>
    					<li><a href="UpdateCD.jsp">Update CD</a></li>
    					<li><a href="DeleteCD.jsp">Delete CD</a></li>
    					<li><a href="ViewCDDetails.jsp">View CD Details</a></li>
    				</ul>
  				</li>
  				<li>Book Transaction
    				<ul>
      					<li><a href="search.jsp">Issue Book</a></li>
      					<li><a href="return.jsp">Return Book</a></li>
      					<li><a href="renewal.jsp">Renew Book</a></li>
    				</ul>
				</li>
  				<li>Fine Calculation
  					<ul>
      					<li><a href="SearchMemberDetails.jsp">SearchMemberDetails</a></li>
      					<li><a href="ViewDefaulters.jsp">View Defaulters</a></li>
      				</ul>
      			</li>
  			</ul>
		</center>
		</div>

<form action="FineController" method="post">

<% 
ArrayList<Member> dlist =(ArrayList<Member>) request.getAttribute("dlist");
if (dlist != null && dlist.size()>0)
{
  
%>
<h4></h4> 
<center><h5>DEFAULTERS LIST </h5></center>
<table  border="2" align="center">

<tr>
   
    <th>Member ID</th>
    <th>ISBN</th>
    <th>Category</th>
     <th>DueDate</th>
     <th>Status</th>
    <th>Fine</th>
</tr>
<%
for(Member member:dlist)
{ 
%>
<tr>
   <td><%=member.getMemberId() %></td>
   <td><%=member.getItemId() %></td>
   <td><%=member.getCategory() %></td>
   <td><%=member.getDueDate() %></td>
   <td><%=member.getStatus() %></td>
   <td><%=member.getFine() %></td>
</tr>
<%
 }%>
</table>
<% }
%>
<br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<center><input type="button" value="GO BACK TO SEARCH PAGE" onclick="parent.location='SearchMemberDetails.jsp'"></center>


</form>
</div>



</body>
</html>