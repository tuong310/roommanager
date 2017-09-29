<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/login.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login</title>
</head>
<body>
     <div id="bg"><img src="${pageContext.request.contextPath}/static/images/aaa.jpg" width="100%" height="100%" /></div>  
	<div class="container">
		<img src="${pageContext.request.contextPath}/static/images/avatar.png">
		<h4 align="center">${message}</h4>
		<form:form method="post" action="" commandName="lg">
			<div class="form-input">
					<i class="fa fa-user fa-2x cust" aria-hidden="true"></i>
			      <input type="text" name="username" value="" placeholder="Enter Username"><br>
			      <i class="fa fa-lock fa-2x cust" aria-hidden="true"></i>
			      <input type="password" name="password" value="" placeholder="Enter PassWord"><br>
			       <input type="submit" name="submit" value="LOGIN"><br>
			</div>
		</form:form>
	</div>
</body>
</html>