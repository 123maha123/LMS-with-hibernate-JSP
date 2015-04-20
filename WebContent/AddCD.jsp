<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    <font face="Times New Roman" size=5 color="black"><b><u>Add CD : </u></b></font><br><br>
    </center>
    <form name="addCDForm" method="post" action="AddCD">
    	<table align="center">
    		<tr>
    			<th><label>Title : </label></th>
    			<td><input type="text" id="title" name="title" onBlur="return validateTitle()"></td>
    			<td><span id="titleSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Subject : </label></th>
    			<td><input type="text" id="subject" name="subject" onBlur="return validateSubject()"></td>
    			<td><span id="subjectSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Publisher : </label></th>
    			<td><input type="text" id="publisher" name="publisher" onBlur="return validatePublisher()"></td>
    			<td><span id="publisherSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Place of Publication : </label></th>
    			<td><input type="text" id="placeOfPublication" name="placeOfPublication" onBlur="return validatePlaceOfPublication()"></td>
    			<td><span id="placeOfPublicationSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Year of Publication : </label></th>
    			<td><input type="text" id="yearOfPublication" name="yearOfPublication" onBlur="return validateYearOfPublication()"></td>
    			<td><span id="yearOfPublicationSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Cost : </label></th>
    			<td><input type="text" id="cost" name="cost" onBlur="return validateCost()"></td>
    			<td><span id="costSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Received Date : </label></th>
    			<td><input type="text" id="receivedDate" name="receivedDate" onBlur="return validateReceivedDate()"></td>
    			<td><span id="receivedDateSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Quantity : </label></th>
    			<td><input type="text" id="quantity" name="quantity" onBlur="return validateQuantity()"></td>
    			<td><span id="quantitySpan"></span></td>
    		</tr>
    		<tr>
    			<th></th>
    			<td></td>
    			<td></td>
    		</tr>
    		<tr>
    			<th><input type="hidden" value="addCD" name="action" /></th>
    			<td><input type="submit" id="submit" name="submit" value="Add CD" onClick="return validateCD()"></td>
    			<td><input type="reset" value="reset" id="reset" name="reset" onClick="resetCDSpan()"></td>
    		</tr>
    	</table>
    </form>
	</div>
</body>
</html>