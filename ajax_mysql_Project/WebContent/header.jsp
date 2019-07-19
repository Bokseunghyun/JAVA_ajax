<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div id="header">

${session.sessionId} <br>

<!-- empty <-> null -->
<c:choose>
	
	<c:when test="${empty sessionId}">
	<a href ="index.jsp">HOME</a>
	<a href ="BordList.jsp">게시글보기</a>
	<a href ="MemberList.jsp">회원 목록</a>
	<a href ="join.jsp">회원가입</a>
	<a href ="login.jsp">로그인</a>
	</c:when>
	
	<c:otherwise>
		<a href ="index.jsp">HOME</a>
		<a href ="BordList.jsp">게시글보기</a>
		<a href ="MemberList.jsp">회원 목록</a>
		<a href ="delete.jsp">회원탈퇴</a>
		<a href ="update.jsp">회원수정</a>
		<a href ="#" onclick = "ajaxlogOut(event)">로그아웃</a>
	
	</c:otherwise>
</c:choose>
	<script src="js/ajaxlogOut.js"></script>
	
	
</div>

</body>
</html>