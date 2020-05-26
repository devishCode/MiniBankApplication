<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>MiniBank</title>
</head>
<body background ="minibankappbg.jpg">
<br>
<h6> Balance for Account No <%String uid = (String)request.getAttribute("uid"); out.println(uid); %>
after withdrawal is $
<%
	String newBal1 = (String)request.getAttribute("newBal1");
    out.println(newBal1);
%>
</h6></body>
<br><br>
<form action="Index.html">
<input type="submit"  class="btn btn-secondary" value="Home" >
</form>
</html>