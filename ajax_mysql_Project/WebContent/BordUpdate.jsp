<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

var xhr2 = new XMLHttpRequest();

function ajaxUpdateOk(){
	var mId=document.getElementById("mId").value;
	var nickName=document.getElementById("nickName").value;
	var userId=document.getElementById("userId").value;
	var mPw=document.getElementById("mPw").value;
	var title=document.getElementById("title").value;
	var memo=document.getElementById("memo").value;
	var hit=document.getElementById("hit").textContent;
	
	var data = "mId="+mId+"&nickName="+nickName+
	"&userId="+userId+"&mPw="+mPw+"&title="+title+"&memo="+memo+"&hit="+hit;
	var url = "BordUpdateOk.bo";
	
	xhr2.open("post",url,true);
	xhr2.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr2.onreadystatechange=function(){
		
		if(xhr2.status==200 && xhr2.readyState==4){
			var result = JSON.parse(xhr2.responseText);
			if(result==1){
				alert("글 수정 성공");
				location.href = "BordList.jsp";
			}else{
				alert("글 수정 실패");
				history.go(-1);
			}
		}
	}
	xhr2.send(data);
}



</script>
</body>
</html>