<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ADD Contract</title>
</head>
<body>
	<div class="page">
		<div class="header">
			<div class="title">
				<h1>Website Room Manager</h1>
			</div>
			<div class="loginDisplay">
				<form action="/login" method="post">
				<span style="font-family: Arial; font-size: 10pt">${username}</span> <input type="submit" value="Logout"
					style="font-weight: bold;wihth=66px">
					 </form>
			</div>
		</div>
		<div class="main">
			<div class="main1">
				<table>
					<tr>
						<td><a style="width: 50x; height: 50px"><img
				src="${pageContext.request.contextPath}/static/images/list.png"
				style="width: 15x; height: 15px">Category</a></td>
					</tr>
					<tr>
						<td><a href="/room/listRoom">Room Manager</a></td>
					</tr>
					<tr>
						<td><a href="/student/listStudent">Student Manager</a></td>
					</tr>
					<tr>
						<td><a href="/contract/listContract">Contract
								Manager</a></td>
					</tr>
				</table>
			</div>
			<div class="main2">
				<h3 align="justify">Add Contract</h3>
				<form:form method="post" action="/contract/addsaveContract"
					modelAttribute="contract">
					<table>
						<tr>
							<td><b>Name:</b></td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><b>student:</b></td>
							<td><select name="studentId">
									<c:forEach items="${students}" var="student">
										<option value="${student.id}" label="${student.name}">
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<br />
	<br />
	<div align="center">
		<a><b>NHóm thực hiên: Hồ Tưởng</b></a><br> <a>Copyright ©
			2017</a>
	</div>
</body>
</html>