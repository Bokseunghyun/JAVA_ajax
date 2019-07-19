<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:import url="header.jsp"/>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "replyView">
		<form action ="Bordreply.bo" method = "post" name = "replyViewForm">
		
		<input type= "hidden" name="mId"  value="${list.mId}"><br>
		<input type= "hidden" name="mGroup"  value="${list.mGroup}"><br>
		<input type= "hidden" name="step"  value="${list.step}"><br>
		<input type= "hidden" name="mIndent"  value="${list.mIndent}"><br>
		<input type= "hidden" name="userId"  value="${list.userId}"><br>
		<input type= "hidden" name="mPw"  value="${list.mPw}"><br>
		<ul>
			<li>답변글</li>
			<li class="nickName">
				<label for="nickName">nickname</label>
				<input type = "text" name="nickName" id="nickName" disabled value="${list.nickName}"><br>
				<input type = "hidden" name="nickName" value="${list.nickName}"><br>
			</li>
		
			<li class="title">
				<label for="title" id="labeltitle">게시글 제목</label>
				<input type = "text" name="title" value="${list.title}"><br>
			</li>
			
			<li class="memotitle">
				<label for="memo" id="memotitle">게시글 내용</label>
			</li>
				<li><textarea name="memo" cols="30" rows="30"></textarea><br>
				</li>
			<li class="b1">
			<input type ="submit" value="답변">
				<a href ="BordList.jsp">게시글 목록</a>
			</li>
		</ul>
		
</form>
</div>

</body>
</html>