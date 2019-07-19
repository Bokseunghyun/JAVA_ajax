var xhr = new XMLHttpRequest();
	function ajaxlogOut(event){
		event.preventDefault();
		var url = "logOutOk.mo";
		xhr.open("get",url,true);
		
		xhr.onreadystatechange=function(){
			var result = xhr.responseText;			
			
			if(xhr.status==200 && xhr.readyState==4){
				
				if(result==1){
					alert("로그아웃 성공");
					location.href = "login.jsp";
					return;
				}
				else{
					alert("로그아웃 실패");
					return;
				}
			}
		}
		
		xhr.send();
		
	}