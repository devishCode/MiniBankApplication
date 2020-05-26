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
<h6>Current Balance for Account No <% String uid = (String)request.getAttribute("uid");
out.println(uid);%> after Deposit is $
<%
	String newBal = (String)request.getAttribute("newBal");
    out.println(newBal);
%>
</h6>
<h6>Your Deposit amount is $
<%
	String addBal = (String)request.getAttribute("addBal");
    out.println(addBal);
%>
</h6>
</body>
<form action="Index.html">
<input type="submit"  class="btn btn-secondary" value="Home" >
</form>
</html>