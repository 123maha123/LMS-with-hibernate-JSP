<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.lms.beans.MagazineBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Magazine</title>
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
    <font face="Times New Roman" size=4 color="black"><b><u>Update Magazine : </u></b></font><br><br>
	</center>
    <form name="searchMagazineByIdForm" method="post" action="SearchMagazineById">
    	<table  align="center">
    		<tr>
    			<th><label>Reference ID : </label></th>
    			<td><input type="text" id="refID" name="refID"></td>
    			<td><span id="refIDSpan"></span></td>
    		</tr>
    		<tr>
    			<th><input type="hidden" value="searchMagazineById" name="action" /></th>
    			<td><input type="submit" id="submit" name="submit" value="Edit Details" onClick="return validateRefID()"></td>
    			<td></td>
    		</tr>
    	</table>
    	<br><br>
    </form>
    
    
	<% ArrayList<MagazineBean> magazineList = (ArrayList<MagazineBean>) request.getAttribute("magazineList");
	if (magazineList!=null && magazineList.size() > 0) 
	{
		for (MagazineBean m : magazineList) 
		{
	 %>
	<div id="disp">
	<center>
    <font face="Times New Roman" size=4 color="black"><b><u>Magazine Details : </u></b></font><br><br><br>
    </center>
	<form name="updateMagazineForm" method="post" action="UpdateMagazineByID">
    	<table align="center">
    	
			<tr>
    			<th><label>Reference ID : </label></th>
    			<td><%=m.getReferenceID()%></td>
    			<td><input type="hidden" id="refID" name="refID" value="<%=m.getReferenceID()%>"></td>
    		</tr>
			<tr>
				<th><label>Title : </label></th>
				<td><input type="text" name="title" id="title" value="<%=m.getTitle()%>" onBlur="return validateTitle()"/></td>
				<td><span id="titleSpan"></span></td>
			</tr>
			<tr>
				<th><label>Volume No : </label></th>
				<td><input type="text" name="volumeNo" id="volumeNo" maxlength="10" value="<%=m.getVolumeNo()%>" onBlur="return validateVolumeNo()"/></td>
				<td><span id="volumeNoSpan"></span></td>
			</tr>
			<tr>
		       	<th><label>Issue No : </label></th>
				<td><input type="text" name="issueNo" id="issueNo" value="<%=m.getIssueNO()%>" onBlur="return validateIssueNo()"/></td>
				<td><span id="issueNoSpan"></span></td>
			</tr>
			<tr>
			    <th><label>ISBN : </label></th>
				<td><input type="text" name="isbn" id="isbn" value="<%=m.getISBN()%>" onBlur="return validateIsbn()"/></td>
				<td><span id="isbnSpan"></span></td>
			</tr>
			<tr>
				<th><label>Cost : </label></th>
	            <td><input type="text" name="cost" id="cost" value="<%=m.getCost()%>" onBlur="return validateCost()"/></td>
	            <td><span id="costSpan"></span></td>
            </tr>
			<tr>
			<th><label>Date of Magazine : </label></th>
				<%
     			Date date=m.getDateOfMagazine();
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			String d=dateFormat.format(date);
    			%>
	            <td><input type="text" name="dateOfMagazine" id="dateOfMagazine" value="<%=d%>"/></td>
	            <td><span id="dateOfMagazineSpan" onBlur="return validateDateOfMagazine()"></span></td>
            </tr>
             <tr>
             <th><label>Receive Date : </label></th>
             	<%
     			date=m.getReceiveDate();
    			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			String receivedDate=dateFormat.format(date);
    			%>
	            <td><input type="text" name="receivedDate" id="receivedDate" value="<%=receivedDate%>" onBlur="return validateReceivedDateMagazine()"/></td>
	            <td><span id="receivedDateSpan"></span></td>
            </tr>
            <tr>
				<th><label>Subscription Type : </label></th>
				<%String subscriptionType=m.getSubscriptionType();  %>
				<td><select name="subscription" onBlur="return validateSubscriptionType()">
				<option value="">Select</option>
				<%if(subscriptionType.equals("F")){ %>
					<option value="F" selected>Fortnightly</option>
				<%}else{ %>
					<option value="F">Fortnightly</option>
				<%}if(subscriptionType.equals("W")){ %>
					<option value="W" selected>Weekly</option>
				<%}else{ %>
					<option value="W">Weekly</option>
				<%}if(subscriptionType.equals("M")){ %>
					<option value="M" selected>Monthly</option>
				<%}else{ %>
					<option value="M">Monthly</option>
				<%}if(subscriptionType.equals("Q")){ %>
					<option value="Q" selected>Quarterly</option>
				<%}else{ %>
					<option value="Q">Quarterly</option>
					<%} %>
				</select>
				</td>
				<td><span id="subscriptionSpan"></span></td>
			</tr>
            <tr>
             	<th><label>Quantity : </label></th>
	            <td><input type="text" name="quantity" id="quantity" value="<%=m.getQuantity()%>" onBlur="return validateQuantity()"/></td>
	            <td><span id="quantitySpan"></span></td>
            </tr>
             <tr>
             	<th></th>
	            <td><input type="hidden" name="softDelete" id="softDelete" value="<%=m.getSoftDelete()%>"/></td>
            </tr>
			<tr><th><input type="hidden" value="updateMagazine" name="action" >
    				<input type="submit" id="submit" value="Update Magazine" onClick="return validateMagazine()"></th>
    			<td></td>
    		</tr>
   		<% 
		} 
		%>
		</table>
	<%
	}
	%>
    </form>
	</div>
    </div>
    </body>
    </html>