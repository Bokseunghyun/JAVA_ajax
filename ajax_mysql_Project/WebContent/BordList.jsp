<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="header.jsp"></c:import>
</head>
<body>
	
	<table border="1">
	<thead>
		<tr>
		<th>글번호</th>
		<!-- <th>글고유번호</th>
		<th>Indent</th>
		<th>step</th> -->
		<th>조회수</th>
		<th>닉네임</th>
<!-- 		<th>아이디</th>
		<th>글비밀번호</th>  -->
		<th>제목</th>
		<th>내용</th>
		<th>글작성시간</th>
		<th>내용 보기</th>
		</tr>
	</thead>
	<tBody id = "tBody">
	</tBody>
	<tr>
		<td colspan="13">
		
			<a href ="Bordwrite.jsp">글작성</a>
		</td>
	</tr>
	
	
	</table>
	
	
	
	
	
	<script>

	window.onload=function(){
		ajaxBordList();
	}
				
				var xhr = new XMLHttpRequest();
				
				function ajaxBordList(){
						var url ="BordList.bo";
						xhr.open("post",url,true);
						xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
						
						xhr.onreadystatechange=ajaxBordListOk;
						
						xhr.send();
					}
					
					function ajaxBordListOk(){
						if(xhr.status==200 && xhr.readyState==4){
						var rs = JSON.parse(xhr.responseText);
					
							console.log(rs);
					var tBody = document.getElementById("tBody");
						var num=1;
						var length = Object.keys(rs.result1).length;
						var tTag="";
						if(rs!=null){
						for(var i=0; i<length; i++){

							tTag+="<tr>";	
						
						 		tTag+="<td>";
									tTag+=rs.result1[i].mId;
								tTag+="</td>";
								/* tTag+="<td>";
									tTag+=rs.result1[i].mGroup;
								tTag+="</td>";
								tTag+="<td>";
									tTag+=rs.result1[i].mIndent;
							tTag+="</td>";
							tTag+="<td>";
									tTag+=rs.result1[i].step; */
							tTag+="</td>";
							tTag+="<td>";
							tTag+=rs.result1[i].hit;
							tTag+="</td>";
							
							tTag+="<td>";
							tTag+=rs.result1[i].nickName;
							tTag+="</td>";
							
							
							/*  tTag+="<td>";
							tTag+=rs.result1[i].userId;
							tTag+="</td>";
							
							tTag+="<td>";
							tTag+=rs.result1[i].mPw;
							tTag+="</td>"; */
							 
							tTag+="<td>";
							tTag+=rs.result1[i].title;
							tTag+="</td>";
							
							var t="";
							for(var k=0; k<rs.result1[i].mIndent; k++){
								
								t+="->";
								console.log(t);
							}							
							console.log("rs:"+t);
							
							tTag+="<td>";
							tTag+=rs.result1[i].memo;
							tTag+="</td>";
							
							tTag+="<td>";
							tTag+=rs.result1[i].mTimestamp;
							tTag+="</td>";
							tTag+="<td>";
							tTag+="<a href='BordListView.jsp?mId="+rs.result1[i].mId+
									"&userId="+rs.result1[i].userId+"'>보기</a>";
							tTag+="</td>";
							tTag+="</tr>";
								
					}
							tBody.innerHTML=tTag;
					 
						}
				}
					}
	</script>
</body>
</html>