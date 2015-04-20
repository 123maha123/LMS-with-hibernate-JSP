<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.lms.beans.BookBeans"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Book</title>
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
    <font face="Times New Roman" size=4 color="black"><b><u>Update Book : </u></b></font><br><br>
	</center>
    <form name="searchBookByIdForm" method="post" action="SearchBookById">
    	<table  align="center">
    		<tr>
    			<th><label>Reference ID : </label></th>
    			<td><input type="text" id="refID" name="refID"></td>
    			<td><span id="refIDSpan"></span></td>
    		</tr>
    		<tr>
    			<th><input type="hidden" value="searchBookById" name="action" /></th>
    			<td><input type="submit" id="submit" name="submit" value="Edit Details" onClick="return validateRefID()"></td>
    			<td></td>
    		</tr>
    	</table>
    	<br><br>
    </form>
    
    
	
    <% ArrayList<BookBeans> bookList = (ArrayList<BookBeans>) request.getAttribute("bookList");
	if (bookList!=null && bookList.size() > 0) 
	{
		for (BookBeans b : bookList) 
		{
	 %>
	 <div id="disp">
	<center>
    <font face="Times New Roman" size=4 color="black"><b><u>Book Details : </u></b></font><br><br><br>
    </center>
    
    <form name="updateBookForm" method="post" action="UpdateBookByID">
    	<table align="center">
	 		<tr>
    			<th><label>Reference ID : </label></th>
    			<td><%=b.getReferenceID()%></td>
    			<td><input type="hidden" id="refID" name="refID" value="<%=b.getReferenceID()%>"></td>
    		</tr>
    		<tr>
    			<th><label>ISBN : </label></th>
    			<td><input type="text" id="isbn" name="isbn" value="<%=b.getISBN()%>" onBlur="return validateIsbn()"></td>
    			<td><span id="isbnSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Title : </label></th>
    			<td><input type="text" id="title" name="title" value="<%=b.getTitle()%>" onBlur="return validateTitle()"></td>
    			<td><span id="titleSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Subject : </label></th>
    			<td><input type="text" id="subject" name="subject" value="<%=b.getSubject()%>" onBlur="return validateSubject()"></td>
    			<td><span id="subjectSpan"></span></td>
    			
    		</tr>
    		<tr>
    		<%String ctype=b.getCategory();%>
    			<th><label>Category : </label></th>
    			<td><select name="category" id="category" onBlur="return validateCategory()">
    					<option value="">Select</option>
    					<%if(ctype.equals("T")){ %>
    						<option value="T" selected>Technical</option>
						<%}else{ %>
 							<option value="T">Technical</option>
 						<%}if(ctype.equals("N")){%>
 							<option value="N" selected>Non-Technical</option>
 						<%}else{ %>
							<option value="N">Non-Technical</option>
							<%} %>
					</select></td>
				<td><span id="categorySpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Edition : </label></th>
    			<td><input type="text" id="edition" name="edition" value="<%=b.getEdition()%>" onBlur="return validateEdition()"></td>
    			<td><span id="editionSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Author : </label></th>
    			<td><input type="text" id="author" name="author" value="<%=b.getAuthor()%>" onBlur="return validateAuthor()"></td>
    			<td><span id="authorSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Editor : </label></th>
    			<td><input type="text" id="editor" name="editor" value="<%=b.getEditor()%>" onBlur="return validateEditor()"></td>
    			<td><span id="editorSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Publisher : </label></th>
    			<td><input type="text" id="publisher" name="publisher" value="<%=b.getPublisher()%>" onBlur="return validatePublisher()"></td>
    			<td><span id="publisherSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Place of Publication : </label></th>
    			<td><input type="text" id="placeOfPublication" name="placeOfPublication" value="<%=b.getPop()%>" onBlur="return validatePlaceOfPublication()"></td>
    			<td><span id="placeOfPublicationSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Year of Publication : </label></th>
    			<td><input type="text" id="yearOfPublication" name="yearOfPublication" value="<%=b.getYop()%>" onBlur="return validateYearOfPublication()"></td>
    			<td><span id="yearOfPublicationSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Cost : </label></th>
    			<td><input type="text" id="cost" name="cost" value="<%=b.getCost()%>" onBlur="return validateCost()"></td>
    			<td><span id="costSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Received Date : </label></th>
    			<%
     			Date date=b.getReceiveDate();
    			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			String receivedDate=dateFormat.format(date);
    			%>
    			<td><input type="text" id="receivedDate" name="receivedDate" value="<%=receivedDate%>" onBlur="return validateReceivedDate()"></td>
    			<td><span id="receivedDateSpan"></span></td>
    		</tr>
    		<tr>
    			<th><label>Quantity : </label></th>
    			<td><input type="text" id="quantity" name="quantity" value="<%=b.getQuantity()%>" onBlur="return validateQuantity()"></td>
    			<td><span id="quantitySpan"></span></td>
    		</tr>
    		<tr>
    			<th></th>
    			<td><input type="hidden" id="softDelete" name="softDelete" value="<%=b.getSoftDelete()%>"></td>
    			<td></td>
    		</tr>
    		<tr>
    			<th></th>
    			<td></td>
    			<td></td>
    		</tr>
    		<tr>
    			<th><input type="hidden" value="updateBook" name="action" />
    				<input type="submit" id="submit" name="submit" value="Update Book" onClick="return validateBook()"></th>   
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