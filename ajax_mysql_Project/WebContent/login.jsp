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

<div id="login">
	<form action="#" method="post" id="loginForm">
	ID : <input type="text" name = "userId" id= "userId" onkeyup = "enterkey()" >
	PW : <input type="text" name = "userPw" id= "userPw" onkeyup = "enterkey()"><br>
	<input type = "button" onclick = "ajaxlogin()" value="로그인">
	
	</form>
	
	
<script src="${pageContext.request.contextPath}/js/ajaxLogin.js"></script> 
<script>
function enterkey(){
	   if (window.event.keyCode == 13) {
		   
		   ajaxlogin();
   }
}
</script>
	


</div>



</body>
</html>