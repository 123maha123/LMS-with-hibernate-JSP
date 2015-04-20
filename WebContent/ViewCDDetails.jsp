<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.lms.beans.CDBean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View CD Details</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="script.js"></script>
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
    <center>
    <br>
    <br>
    <font face="Times New Roman" size=4 color="black"><b><u>View CD Details : </u></b></font><br><br>
	</center>
    <form name="viewCDByIdForm" method="post" action="ViewCDById">
    	<table  align="center">
    		<tr>
    			<th><label>Reference ID : </label></th>
    			<td><input type="text" id="refID" name="refID"></td>
    			<td><span id="refIDSpan"></span></td>
    		</tr>
    		<tr>
    			<th><input type="hidden" value="viewCDById" name="action" /></th>
    			<td><input type="submit" id="submit" name="submit" value="Edit Details"  onClick="return validateRefID()"></td>
    			<td></td>
    		</tr>
    	</table>
    	<br><br>
    </form>
    
    
	
    <% ArrayList<CDBean> CDList = (ArrayList<CDBean>) request.getAttribute("CDList");
	if (CDList!=null && CDList.size() > 0) 
	{
		for (CDBean c : CDList) 
		{
	 %>
	 <div id="disp">
	<center>
    <font face="Times New Roman" size=4 color="black"><b><u>CD Details : </u></b></font><br><br><br>
    </center>
    	<table align="center">
	 		<tr>
    			<th><label>Reference ID : </label></th>
    			<td><%=c.getReferenceID()%></td>
    		</tr>
    		<tr>
    			<th><label>Title : </label></th>
    			<td><%=c.getTitle()%></td>
    		</tr>
    		<tr>
    			<th><label>Subject : </label></th>
    			<td><%=c.getSubject()%></td>
    		</tr>
    		<tr>
    			<th><label>Publisher : </label></th>
    			<td><%=c.getPublisher()%></td>
    		</tr>
    		<tr>
    			<th><label>Place of Publication : </label></th>
    			<td><%=c.getPop()%></td>
    		</tr>
    		<tr>
    			<th><label>Year of Publication : </label></th>
    			<td><%=c.getYop()%></td>
    		</tr>
    		<tr>
    			<th><label>Cost : </label></th>
    			<td><%=c.getCost()%></td>
    		</tr>
    		<tr>
    			<th><label>Received Date : </label></th>
    			<%
     			Date date=c.getReceivedDate();
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			String receivedDate=dateFormat.format(date);
    			%>
    			<td><%=receivedDate%></td>
    		</tr>
    		<tr>
    			<th><label>Quantity : </label></th>
    			<td><%=c.getQuantity()%></td>
    		</tr>
    		<tr>
    			<th>Inactive : </th>
    			<td><%=c.getSoftDelete()%></td>
    		</tr>
 		<% 
		} 
		%>
		</table>
	<%
	}
	%>
    </div>
	</div>
</body>
</html>