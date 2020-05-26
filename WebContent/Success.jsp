<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>MiniBank - Login Success</title>

</head>
<body background ="minibankappbg.jpg">
<h7> <br>
Account Number : <%
 	String uid = (String) request.getAttribute("uid");
 	out.println(uid);
 %> <br>
Balance : $<%
 	String bl = (String) request.getAttribute("balance");
 	out.println(bl);
 %> </h7>

<br></br>
<form action="DepositServlet" method="get">
	<div class="form-row">
		<input type="text" style="text-align: center;" class="form-group"
			name="deposit" placeholder="Enter Amount" /> <input type="hidden"
			name="uid" value="<%=uid%>" /> &nbsp&nbsp <input type="submit"
			class="form-group btn btn-success" value="Deposit" />
	</div>
</form>

<br>

<form action="WithdrawServlet" method="get">
	<div class="form-row">
		<input type="text" style="text-align: center;" class="form-group"
			name="withdraw" placeholder="Enter Amount" />&nbsp&nbsp <input
			type="hidden" name="uid" value="<%=uid%>" /> <input type="submit"
			class="form-group btn btn-danger" value="Withdraw" />
	</div>
</form>
</body>

<br>


<form action="Index.html">
<input type="submit"  class="btn btn-secondary" value="Home" >
</form>
</html>
