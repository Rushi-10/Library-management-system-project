<%@page import="javax.servlet.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Librarian"%>
    <%@ page import="Controller.cnt2"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<style type="text/css">

#accountBox{ 
            width: 50%;
            margin:auto;
            margin-top:20px;
            height:400px;
            background-color: bisque;
            border-radius: 14px; 
            }
 #header{
 text-align: center;
 font-size: 30px;
 }
 .keyword{
 padding-left: 180px;
 
 }
 .value{
  padding-left: 150px;
 } 
 table {
    border-collapse: separate;
    border-spacing: 0 3em;
} 
button {
	
} 
#edit{
margin-left: 270px;
margin-top: 50px;
display:inline-block;
width:45px;
background-color: white;
text-align: center;
text-decoration: none;
border-radius: 15px;
}  
#logout{
display:inline-block;
width:70px;
background-color: white;
text-align: center;
text-decoration: none;
border-radius: 15px;
}
</style>
</head>
<body>
<% 
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma",  "no-cache");
response.setHeader("Expires",  "0");


%>
<%Librarian l1=(Librarian)request.getAttribute("LibrarianInfo"); %>
<%String userName=l1.getUserName();
String contact=l1.getContact();
%>
<div id="accountBox">
<p id="header">Account</p>
<table>
<tr>
<td class="keyword">User Name</td>
<td class="value" ><%=userName%></td>
</tr>

<tr>
<td class="keyword">Contact</td>
<td class="value"><%=contact%></td>
</tr>
</table>
<a href="EditLibrarian.jsp" id="edit">Edit</a>
<a href="logout" id="logout">Logout</a>
</div>
</body>
</html>