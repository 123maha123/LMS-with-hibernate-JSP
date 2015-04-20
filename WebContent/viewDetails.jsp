<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lms.beans.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>FINE PAYMENT</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script src="validationf.js"></script>
</head>
<style> 
 
caption{font-style:bold; }
</style>
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
<% 
ArrayList<Member> mlist =(ArrayList<Member>) request.getAttribute("mlist");
if (mlist!=null && mlist.size()>0) 
{
%>
<form action="FineController" method="post" >
<center>
<table  border="1">

<tr>
    <th></th>
    <th>Refernceid</th>
    <th>MemberID</th>
    <th>ISBN_VolNo_CdNo</th>
    <th>Category</th>
    <th>DueDate</th>
    <th>Status</th>
    <th>Fine</th>
</tr>
<%
for(int i=0;i<mlist.size();i++)
{
%>
<tr>
  <td>
  <%String appendedValues=""+mlist.get(i).getRef_id()+"/"+mlist.get(i).getFine();
  System.out.println("append value : "+appendedValues);%>
      <input type="checkbox" name="detail" id="detail" value="<%=appendedValues%>"> &nbsp;
  </td>
   <td><%=mlist.get(i).getRef_id() %></td>
   <td><%=mlist.get(i).getMemberId() %></td>
  <td><%=mlist.get(i).getItemId() %></td>
  <td><%=mlist.get(i).getCategory() %></td>
  <td><%=mlist.get(i).getDueDate() %></td>
  <td><%=mlist.get(i).getStatus() %></td>
  <td><%=mlist.get(i).getFine() %></td>
  </tr>
<%
 }%>
</table>
<% }
else
{%>
<%out.println("NO Such users Found");%>
<%} %>

</center>
<br>
<center><input type="submit" name="PAYMENT" value="PAYMENT" onclick="return  myfun(1);">  
<input type="submit" name="CANCEL FINE" value="CANCEL FINE" onclick="return myfun(2);">
 <input type="button" value="GO BACK TO SEARCH PAGE" onclick="parent.location='SearchMemberDetails.jsp'"/>
 <input type="hidden" name="action"  id="pay" value="PAYMENT"></center>
 </form>
 </div>
</body>
</html>