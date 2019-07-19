<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="./css/bordView.css" media="all" />


<meta charset="UTF-8">
<title>글보기</title>

<c:if test="${empty sessionScope.sessionId }">
	<script>
		var con = confirm("로그인 후 이용 가능합니다."); //확인창
		
		if(con==true){
			location.href="login.jsp";
		}else{
			history.go(-1); 
		}
	</script>
</c:if>

</head>
<body>

	<div id = "view">
		<form action ="#" method = "post" name = "viewForm">
		
		글고유번호 : ${param.mId} <input  type= "hidden" name="mId" id="mId" value="${param.mId}"><br>
		현재그룹 <span id="mGroup"></span><br>
		조회수 <span id="hit"></span><br>
		Indent <span id="mIndent"></span><br>
		글작성시간 <span id="mTime"></span><br>
		로그인 아이디 <input type = "text" name="userId" id="userId" ><br>
		닉네임 <input type = "text" name="nickName" id="nickName" disabled><br>
		글제목 <input type = "text" name="title" id="title" disabled><br>
		글비밀번호 <input type = "password" name="mPw" id="mPw" disabled><br>
		글내용:<br> 
		<textarea name="memo" id = "memo" cols="30" rows="30" disabled></textarea><br>

		<a href ="BordList.jsp">글목록</a>
		<a href ="Bordwrite.jsp">글작성</a>
<c:choose>
	<%-- 로그인 세션과 글 아이디 --%>
	<c:when test="${sessionScope.sessionId eq param.userId}">
		<a href ="javascript:void(0)" onclick="BordDeleteView(event)">글삭제</a>
		<a href ="javascript:void(0)" onclick="ajaxUpdate(event)">글 수정</a>
		<a href ="javascript:void(0)" onclick="ajaxMbord(event)">본인글 목록</a>
		<a href ="replyView.bo?mId=${param.mId}">덧글 쓰기</a>
		<span style="color:#00f;">본인글 입니다.</span>
	
	</c:when>
	
	<c:otherwise>
		<a href ="replyView.bo?mId=${param.mId}">덧글 쓰기</a>
		<span style="color:#f00;">본인글이 아닙니다.</span>
	</c:otherwise>
	
</c:choose>	
	
		</form>	
	</div>

<div id="mBord">
		
</div>

<script>

var xhr3 = new XMLHttpRequest();

function ajaxMbord(event){
	event.preventDefault();
	var userId=document.getElementById("userId");
	var data ="&userId="+userId.value;
	var url = "ajaxMbordList.bo";
	xhr3.open("post",url,true);
	xhr3.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr3.onreadystatechange=function(){
		
		if(xhr3.status==200 && xhr3.readyState==4){
		var rs = JSON.parse(xhr3.responseText);
		var mBord = document.getElementById("mBord");
		var length = Object.keys(rs.result1).length;
		console.log(rs);
		
		var tTag="";
		if(rs!=null){
			
				for(var i=0; i<length; i++){
					tTag+="<table border='1'>";
					tTag+="<tr>";	
				
						tTag+="<td>";
							tTag+=rs.result1[i].mId;
						tTag+="</td>";
						tTag+="<td>";
							tTag+=rs.result1[i].mGroup;
						tTag+="</td>";
						tTag+="<td>";
							tTag+=rs.result1[i].mIndent;
					tTag+="</td>";
					tTag+="<td>";
							tTag+=rs.result1[i].step;
					tTag+="</td>";
					tTag+="<td>";
					tTag+=rs.result1[i].hit;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].nickName;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].userId;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].mPw;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].memo;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].title;
					tTag+="</td>";
					
					tTag+="<td>";
					tTag+=rs.result1[i].mTimestamp;
					tTag+="</td>";
					tTag+="<td>";
					tTag+="<a href='BordListView.jsp?mId="+rs.result1[i].mId+
							"&userId="+rs.result1[i].userId+"'>보기</a>";
					tTag+="</td>";
					tTag+="</tr>";
					tTag+="</table>";
		}
				mBord.innerHTML=tTag;
			}
			}
			
		}
	xhr3.send(data);
}


</script>



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


	
<script>

var key=0;

function ajaxUpdate(event){
	var nickName=document.getElementById("nickName");
	var mPw=document.getElementById("mPw");
	var title=document.getElementById("title");
	var memo=document.getElementById("memo");
	
	event.preventDefault();
	if(key==0){ //글 수정 할 수 있게 활성화 key가 스위치기능을해줌
		nickName.disabled=false;
		mPw.disabled=false;
		title.disabled=false;
		memo.disabled=false;
		key=1;
	}else{ //key가 1인상태
		ajaxUpdateOk();
	}
		
}



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





window.onload=function(){
	bordListView();
}

var xhr=new XMLHttpRequest();

function bordListView(){
	var mId = document.getElementById("mId");
	var url = "BordView.bo";
	var data ="mId="+mId.value;
	
	xhr.open("post",url,true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			var rs = JSON.parse(xhr.responseText);
			console.log(xhr.responseText);
			console.log(rs);
			if(rs!=null){
				document.getElementById("mGroup").textContent=rs.result1.mGroup;
				document.getElementById("hit").textContent=rs.result1.hit;
				document.getElementById("mIndent").textContent=rs.result1.mIndent;
				document.getElementById("mTime").textContent=rs.result1.mTimestamp;
				document.getElementById("nickName").value=rs.result1.nickName;
				document.getElementById("userId").value=rs.result1.userId;
				document.getElementById("title").value=rs.result1.title;
				document.getElementById("mPw").value=rs.result1.mPw;
				document.getElementById("memo").value=rs.result1.memo;
			}
		}
	}
	xhr.send(data);
}

</script>
</body>
</html>