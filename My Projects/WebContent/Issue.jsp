<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.http.HttpServlet"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Issue Book</title>
</head>
<body>
<%!String bookId1=null; %>
<%bookId1=request.getParameter("bookId");%>
	<div style="font-size: 7vh; text-align: center;">Issue Book </div>
	<form style="margin: 80px;" action="IssueBook">
 <div class="form-group">
    <label for="id">Student ID</label>
    <input name="stdid" type="number" class="form-control" id="id" placeholder="ID">
    <input name="bookId1" value="<%=bookId1%>" type="hidden" class="form-control" id="id1" placeholder="ID">
  </div>
   <button type="submit" class="btn btn-primary" style="margin-top: 20px;">Issue</button>
  </form>
 
</body>
</html>