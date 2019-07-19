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
	
	<table border="1">
		<tr>
		<th>글번호</th>
		<th>글고유번호</th>
		<th>Indent</th>
		<th>step</th>
		<th>조회수</th>
		<th>닉네임</th>
		<th>글비밀번호</th>
		<th>아이디</th>
		<th>내용</th>
		<th>제목</th>
		<th>글작성시간</th>
		<th>내용 보기</th>
		</tr>
		<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="dto" items="${lists}" varStatus="status">
		
		<tr>
		<td>${status.count}</td>
		<td>${dto.mId}</td>
		<td>${dto.mGroup}</td>
		<td>${dto.mIndent}</td>
		<td>${dto.step}</td>
		<td>${dto.hit}</td>
		<td>${dto.nickName}</td>
		<td>${dto.userId}</td>
		<td>${dto.mPw}</td>
		<td>
			<c:forEach begin ="1" end="${dto.mIndent}">
				->
			</c:forEach> ${dto.title}
		</td>
		
		<td>${dto.memo}</td>
		<td>${dto.mTimestamp}</td>
		<td><a href = "BordListView.jsp?mId=${dto.mId}">내용 보기</a></td>

		
		</tr>
		</c:forEach>
		</tr>
		
	</table>
	
</body>
</html>