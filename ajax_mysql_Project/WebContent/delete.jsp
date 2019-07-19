<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"></c:import>

<div id="delete">
	<form action="#" method="post" id="deleteForm">
	ID : <input type="text" name = "userId" id= "userId" >
	PW : <input type="text" name = "userPw" id= "userPw"><br>
	<input type = "button" onclick = "delete1()" value="회원 탈퇴">
	
	</form>
	
	<script src ="js/ajaxDelete.js"></script>
	
	
	
	</div>
</body>
</html>