window.onload=function(){
		ajaxMemberView();
	}
	
	var xhr = new XMLHttpRequest();
	
	function ajaxMemberView(){
		var userId = document.getElementById("userId");
		var data = "userId="+userId.value;
		var url = "ajaxMemberView.mo";
		
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		
		xhr.onreadystatechange=function(){
			if(xhr.status==200 && xhr.readyState==4){
			var rs = JSON.parse(xhr.responseText);
				console.log(rs);
				console.log(rs.result[0].userId);
				
				
				document.getElementById("userPw").values=rs.result[0].userPw;
				document.getElementById("userName").values=rs.result[0].userName;
				document.getElementById("userAddr").values=rs.result[0].userAddr;
			}
			
		}
		xhr.send(data);
	}
	