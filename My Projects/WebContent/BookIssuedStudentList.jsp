<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="model.Student"%>
<%@ page import="Controller.BookListController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Issued Student List</title>
</head>
<body>
<%!ArrayList<Student> studentList;%>
	<%
	studentList = (ArrayList<Student>) request.getAttribute("issuedStudentList");
	%>
	<%!Student s;%>
	<%!String issueBookId = null;%>
	<%issueBookId=request.getParameter("bookId"); %>
	<h2 class="text-center">Students List</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Contact</th>
				<th scope="col">Book Submit</th>
				
				
				<!--  <th scope="col">Operations</th>
      <th scope="col">Issued Books</th>-->
			</tr>
		</thead>
		<tbody>

			<%
			for (Student s : studentList) {
			%>
			<%-- Arranging data in tabular form 
  --%>
			<tr>
				<td><%=s.getStudentId()%></td>
				<td><%=s.getStudentName()%></td>
				<td><%=s.getStudentContact()%></td>

				<td>
					<form action="SubmitBook" style="display: inline;">
					<input type="hidden" name="bookIdForSubmit" value="<%=issueBookId%>">
						<button name="submitBookStudentId" type="submit" value="<%=s.getStudentId()%>">Submit</button>
					</form></td>

				
				
			</tr>
			<%} %>
		</tbody>
	</table>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>