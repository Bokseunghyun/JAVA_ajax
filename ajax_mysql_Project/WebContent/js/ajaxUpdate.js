var xhr2 = new XMLHttpRequest();
	
	function ajaxupdate(){
		var userId = document.getElementById("userId").value;
		var userPw = document.getElementById("userPw").value;
		var userName = document.getElementById("userName").value;
		var userAddr = document.getElementById("userAddr").value;
		var url = "ajaxMemberUpdate.mo";
		var data = "userId="+userId+"&userPw="+userPw+"&userName="+userName+"&userAddr="+userAddr;
		xhr2.open("post",url,true);
		xhr2.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		
		xhr2.onreadystatechange=function(){
			
			if(xhr2.status==200 && xhr2.readyState==4){
			var result = JSON.parse(xhr2.responseText);
				if(result==1){
					alert("회원수정 성공");
				}else{
					alert("회원수정 실패");
				}			
				
				
				
			}
			
		}
		
		xhr2.send(data);
	}