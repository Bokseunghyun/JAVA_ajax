<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색</title>
<style>

#search{
width:200px;
}

</style>

</head>
<body>

<input type="text" name = "search" id = "search" onkeyup="enterkey()">
<input type="button" onclick="ajaxSearch()" value="검색">

<table border="1">

<thead>
	<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>보기</th>
			
	</tr>
</thead>
<tbody id = "tBody">

</tbody>
</table>

<script>

var xhr = new XMLHttpRequest();

function enterkey(){
	   if (window.event.keyCode == 13) {
		   
		   ajaxSearch();
      }


}

function ajaxSearch(){

		var search = document.getElementById("search");
		var data = "userId="+search.value;
		var url ="ajaxSearch.mo";
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type',
		'application/x-www-form-urlencoded;charset=utf8');
		
		xhr.onreadystatechange=ajaxSearchOk;
		xhr.send(data);
	}
	
	function ajaxSearchOk(){
		
		if(xhr.status==200 && xhr.readyState==4){
	
		var rs = JSON.parse(xhr.responseText);
			console.log(rs)
		var tBody = document.getElementById("tBody");
			
		var length = Object.keys(rs.result).length;
			console.log(length);
		var tTag="";
		
		for(var i=0; i<length; i++){
			
			tTag+="<tr>";
				tTag+="<td>";
					tTag+=rs.result[i].userId;
				tTag+="</td>";
				tTag+="<td>";
					tTag+=rs.result[i].userPw;
				tTag+="</td>";
				tTag+="<td>";
					tTag+=rs.result[i].userName;
			tTag+="</td>";
			tTag+="<td>";
					tTag+=rs.result[i].userAddr;
			tTag+="</td>";
			tTag+="<td>";
			tTag+="<a href='#' onclick='memberView(\""+rs.result[i].userId+"\")'>보기</a>";
			tTag+="</td>";
				tTag+="</tr>";
				
	}
			tBody.innerHTML=tTag;
		}
	}
	


</script>
<script src="js/ajaxMemberList.js"></script>



</body>
</html>