<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Update Student Info</title>
</head>
<body>
<div style="font-size: 7vh; text-align:center;">Update Student Information</div>
<form style="margin: 80px;" action="UpdateStudent">
 <div class="form-group">
    <label for="id">Student ID</label>
    <input name="stdid" type="number" class="form-control" id="id" placeholder="ID">
  </div>
  <div class="form-group">
    <label for="name">Enter Name</label>
    <input name="stdname" type="text" class="form-control" id="name" aria-describedby="text" placeholder="Enter Name">
    <small id="Name" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="contact">Contact</label>
    <input name="stdcnt" type="number" class="form-control" id="contact" placeholder="Contact">
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary" style="margin-top: 40px;">Update</button>
</form>
</body>
</html>