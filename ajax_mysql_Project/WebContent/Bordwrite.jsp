<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:import url="header.jsp"></c:import> 
 <c:if test="${empty sessionScope.sessionId}">
 <script>
 
 	var rs = confirm("로그인 후 이용 하세요.");
 	if(rs==true)
 	{
 		location.href="login.jsp";	
 	} 
 	else
 	{
 		history.go(-1);	
 	}
 </script>
 
 
 </c:if>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id = "write">
		<form action ="BordWrite.bo" method = "post" name = "writeForm">
		
		아이디${sessionScope.sessionId}
		<input type = "hidden" name="userId" id="userId" value="${sessionScope.sessionId}"><br>
		닉네임 <input type = "text" name="nickName" id="nickName"><br>
		비밀번호 <input type = "password" name="mPw" id="mPw"><br>
		글제목 <input type = "text" name="title" id="title"><br>
		글내용:<br> 
		<textarea type = "text" name="memo" id="memo"></textarea><br>
		<input type="button" onclick = "ajaxWrite()"value ="글 작성">
		</form>	
	</div>
	
	<script>
	
	var xhr = new XMLHttpRequest();
	
	function ajaxWrite(){
		var nickName = document.getElementById("nickName");
		var userId = document.getElementById("userId");
		var mPw = document.getElementById("mPw");
		var title = document.getElementById("title");
		var memo = document.getElementById("memo");
		var url = "BordWrite.bo";
		var data ="nickName="+nickName.value+"&userId="+userId.value+"&mPw="+mPw.value+"&title="+title.value+"&memo="+memo.value;
		
		if(nickName.value==null || nickName.value=="")
		{
			alert("닉네임 입력 오류");
			nickName.focus();
			return;
		}
		if(userId.value==null || userId.value=="")
		{
			alert("아이디 입력 오류");
			userId.focus();
			return;
		}
		if(mPw.value==null || mPw.value=="")
		{
			alert("비밀번호 입력 오류");
			mPw.focus();
			return;
		}
		if(title.value==null || title.value=="")
		{
			alert("제목 입력 오류");
			title.focus();
			return;
		}
		if(memo.value==null || memo.value=="")
		{
			alert("내용 입력 오류");
			memo.focus();
			return;
		}
		
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.onreadystatechange=ajaxWriteOk;
		xhr.send(data);
	}
	function ajaxWriteOk(){
		var result = xhr.responseText;
		if(xhr.status==200 && xhr.readyState==4){
			
			if(result==1){
				alert("글작성 성공");	
				location.href = "BordList.jsp";
				return;
			}else{
				alert("글작성 실패");
				return;
			}
		}
	}
	</script>
	
	

</body>
</html>