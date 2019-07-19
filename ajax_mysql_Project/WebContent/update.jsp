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
	<div id="update">
	<form action="#" method="post" id="updateForm">
		
	ID : ${sessionScope.sessionId}님
	<input type="hidden" name = "userId" id= "userId" value="${sessionScope.sessionId}"><br>
	PW : <input type="text" name = "userPw" id= "userPw" ><br>
	NAME : <input type="text" name = "userName" id= "userName" ><br>
	ADDR : <input type="text" name = "userAddr" id= "userAddr" ><br>
	<input type = "button" onclick = "ajaxupdate()" value="회원수정">
	</form>
	
	<script src="js/ajaxMemberView.js"></script>
	<script src="js/ajaxUpdate.js"></script>
	
	
</div>

</body>
</html>