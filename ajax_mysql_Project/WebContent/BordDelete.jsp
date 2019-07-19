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
function BordDeleteView(event){
	event.preventDefault();
	var deleteView=document.getElementById("deleteView");
	deleteView.style.display="block";
}

function closeFn(){
	var deleteView=document.getElementById("deleteView");
	deleteView.style.display="none";
}
</script>

<div id="deleteView">

	<div id="deleteCon">
	<span id="close" onclick="closeFn()">X</span>
		<table border="1">
			<tr>
				<th colspan="2">글삭제</th>
			</tr>
			
		<tr>
			<td>글 고유번호</td>		
			<td>${param.mId}</td>		
		</tr>
						
		<tr>
			<td>글 아이디</td>		
			<td id= "bId">
			<input type="text" name="userId2" id= "userId2">
			</td>		
		</tr>
		
		<tr>
			<td>글 비밀번호</td>		
			<td id= "bPw">
			<input type="text" name="mPw2" id= "mPw2">	
			</td>	
		</tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick ="ajaxBDelete()" value="글 삭제">
				</td>
			</tr>			
		</table>
	</div>
</div>
<script>

var xhr = new XMLHttpRequest();

function ajaxBDelete(){
	var mId= document.getElementById("mId");
	var userId= document.getElementById("userId2");
	var mPw= document.getElementById("mPw2");
	var data = "mId="+mId.value+"&userId="+userId2.value+"&mPw="+mPw2.value;
	var url = "BordDeleteOk.bo";
	xhr.open("post",url,true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr.onreadystatechange=function(){
		
		if(xhr.status==200 && xhr.readyState==4){
		var result = xhr.responseText;
		
			if(result==1){
				alert("글 삭제 성공");
				location.href="BordList.jsp";
			}
			else{
				alert("글 삭제 실패");
				history.go(-1);
			}
		}
	}
	xhr.send(data);
}


</script>
</body>
</html>