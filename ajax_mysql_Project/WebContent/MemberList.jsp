<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 페이지</title>
<style>
*{
	margin: 0;
	padding:0;
}
ul,li{
list-style:none;
}
#close{
float:right;
width: 20px;
background: #3ae848;
   background-clip: content-box;
}
#memberView{
	width:100%;
	height:100%;
	position :fixed;
	left:0;
	top:0;
	background: #62cbd77d;
	display:none;
}

#contentView{
	position:absolute;
	left:20%;
	top:20%;
	width:60%;
	max-width:600px;
	height:400px;
	background:#fff;
}

#contentView ul li{
border:5px solid #fff;
background:#ccc;
overflow:hidden;
}
#contentView ul li span{
	display:block;
	width:50%;
	float:left;
	background:#sss;
	clor:#fff;
	text-indent:10px;
	border: 3px solid #999;
	box-sizing:border-box;
}
</style>
</head>
<body>
<c:import url="search.jsp"></c:import>
<table >
		

		<tbody id = "tBody">
		
		</tbody>

</table>

<div id ="memberView">

	<div id="contentView" >
		
		<ul>
		<li class="c1"> <span>아이디</span><span id ="userId"></span></li>
		<li class="c2"> <span>비밀번호</span><span id ="userPw"></span></li>
		<li class="c3"> <span>이름</span><span id ="userName"></span></li>
		<li class="c4"> <span>나이</span><span id ="userAddr"></span></li>
	
		</ul>
		<div>
		<p id="close" onclick="viewClose();">X</p>
		</div>
	</div>
</div>

<script>
	function viewClose(){
		var memberView = document.getElementById("memberView");
		memberView.style.display="none";
	}


var xhr = new XMLHttpRequest();

	function memberView(userId){
		event.stopPropagation();
		
		var data = "userId="+userId;
		var url = "ajaxMemberView.mo";
		
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
			var rs = JSON.parse(xhr.responseText);
			
				
			document.getElementById("userId").textContent=rs.result[0].userId;
			document.getElementById("userPw").textContent=rs.result[0].userPw;
			document.getElementById("userName").textContent=rs.result[0].userName;
			document.getElementById("userAddr").textContent=rs.result[0].userAddr;
			}
			
		}
		xhr.send(data);
		
		var memberView = document.getElementById("memberView");
		memberView.style.display="block";
		
	}
</script>


<script src = "js/ajaxMemberList.js"></script>

</body>
</html>