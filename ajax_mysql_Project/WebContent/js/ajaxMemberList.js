
window.onload=function(){
				ajaxList();
			}
			
			var xhr = new XMLHttpRequest();
			
			function ajaxList(){
					var url ="ajaxMemberList.mo";
					xhr.open("get",url,true);
					xhr.onreadystatechange=ajaxListOk;
					
					xhr.send(null);
				}
				
				function ajaxListOk(){
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