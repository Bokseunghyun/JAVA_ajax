<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="js/ajaxidChecked.js"> </script> -->
</head>
<body>
<c:import url="header.jsp"></c:import>
<div id="join">
	<form action="ajaxJoin.mo" method="post" id="joinForm">
	ID : <input type="text" name = "userId" id= "userId" >
		<input type="button" name = "idChecked" onclick = "ajaxidChecked1()" value = "아이디 체크">
		<span id="s1"></span>
		<input type="hidden" name ="checked" id = "checked" value = "unChecked"><br>
	PW : <input type="text" name = "userPw" id= "userPw" onfocus="idChecked1()"><br>
	NAME : <input type="text" name = "userName" id= "userName" onfocus="idChecked1()"><br>
	ADDR : <input type="text" name = "userAddr" id= "userAddr" onfocus="idChecked1()"><br>
	<input type = "button" onclick = "ajaxJoin()" value="회원가입">
	
	</form>
	
<script src="${pageContext.request.contextPath}/js/ajaxidChecked.js"></script> 
<script src="${pageContext.request.contextPath}/js/ajaxJoin.js"></script> 

</div>



</body>
</html>