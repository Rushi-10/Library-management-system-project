<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Student"%>
<%@ page import="Controller.cnt2"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Student List</title>
</head>
<body>

	<%!ArrayList<Student> studentList;%>
	<%
	studentList = (ArrayList<Student>) request.getAttribute("studentList");
	%>
	<%!Student s;%>
	<%!String issueBookId = null;%>
	<h2 class="text-center">Students List</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Contact</th>
				<th scope="col">Operation</th>
				<th scope="col">Issued Books</th>
				
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

				<td><button id="btn" value="123"
						onclick="window.location.href ='UpdateStudent.jsp;'">Edit</button>
					<form action="askForDelete" style="display: inline;">
						<button name="delete" type="submit" value="<%=s.getStudentId()%>">Delete</button>
					</form></td>

				<td><form action="StdBookList">
						<button name="stdId" type="submit" value="<%=s.getStudentId()%>">Check
							Here</button>
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