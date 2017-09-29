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
<title>List Student</title>
</head>
<body>
	<div class="page">
		<div class="header">
			<div class="title">
				<h1>Website Room Manager</h1>
			</div>
			<div class="loginDisplay">
				<form action="/Room" method="post">
				<span style="font-family: Arial; font-size: 10pt">${username}</span> <input type="submit" value="Logout"
					style="font-weight: bold;wihth=66px">
					 </form>
			</div>
		</div>
		<div class="main">
		 <div class="main1">
		      <table>
		      <tr><td><a style="width: 50x; height: 50px"><img
				src="${pageContext.request.contextPath}/static/images/list.png"
				style="width: 15x; height: 15px">Category</a></td></tr>
		      <tr><td><a href="/Room/room/listRoom">Room Manager</a></td></tr>
		      <tr><td><a href="/Room/student/listStudent">Student Manager</a></td></tr>
		      <tr><td><a href="/Room/contract/listContract">Contract Manager</a></td></tr>
		      </table>
		   </div>
		   <div class="main2">
			<h1><img
				src="${pageContext.request.contextPath}/static/images/list.png"
				style="width: 25x; height: 25px">List Student</h1>
			<a href="/Room/student/addStudent"><img
				src="${pageContext.request.contextPath}/static/images/add-name.jpg"
				style="width: 25x; height: 25px"></a>
			<table border="2" width="80%" cellpadding="2">
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Gender</td>
					<td>Address</td>
					<td>Phone</td>
					<td>Contract</td>
					<td>Tool</td>
				</tr>
				<c:forEach var="stu" items="${liststudent}">
					<tr>
						<td>${stu.id}</td>
						<td>${stu.name}</td>
						<td>${stu.gender}</td>
						<td>${stu.address}</td>
						<td>${stu.phone}</td>
						<td><a href="/Room/student/listContract/${stu.id}">${stu.contract}</a></td>
						<td><a href="/Room/student/editStudent/${stu.id}"><img
								src="${pageContext.request.contextPath}/static/images/edit.png"
								style="width: 12px; height: 12px"></a> &nbsp; <a
							href="/Room/student/deleteStudent/${stu.id}"><img
								src="${pageContext.request.contextPath}/static/images/delete.png"
								style="width: 15x; height: 15px"></a></td>
					</tr>
				</c:forEach>
			</table>
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