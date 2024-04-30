<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Your Info</title>
<style type="text/css">
#EditBox{
width: 50%;
margin: auto;
background-color: bisque;
margin-top:20px;
border-radius: 14px;
height: 500px;;
}
#header{
 text-align: center;
 font-size: 30px;
 }
 input{
 width: 50%;
 float: right;
 margin-right: 20px;
 }
 label{
 margin-left: 20px;
 }
 #instruction{
 margin-left: 30px;
 font-style: italic;
 font-size: 15px;
 }
 #submitButton{
 margin-left: 30px;
 margin-top: 10px; }
</style>
</head>
<body>
<div id="EditBox" >
<p id="header">Edit Information</p>
<form action="EditLibInfo">
<label> User Name</label>
<input type="text" name="libNewName"/><br><br><br><br>
<label> Contact</label>
<input type="number" name="libNewContact"/><br><br><br><br>
<label> Old Password</label>
<input type="text" name="libOldPassword"/><br><br><br><br>
<label>New Password</label>
<input type="text" name="libNewPassword"/><br><br><br><br>
<p id="instruction">** Enter Same Password in 'New Password' field If you do not want to change Password !</p>
<button type="submit" id="submitButton">Update</button>
</form> 
</div>
</body>
</html>