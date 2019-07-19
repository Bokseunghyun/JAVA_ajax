
	var xhr = new XMLHttpRequest();
	//로그인 성공하면 세션값 설정
	
	function ajaxlogin(){
		var userId = document.getElementsByName("userId")[0];
		var userPw = document.getElementsByName("userPw")[0];
		var data = "userId="+userId.value+"&userPw="+userPw.value;
		var url ="ajaxlogin.mo";
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		xhr.onreadystatechange=ajaxloginOk;
		
		xhr.send(data);
	}
	
	function ajaxloginOk(){
		var result = JSON.parse(xhr.responseText);
		
		if(xhr.status==200 && xhr.readyState==4){
			
			if(result==1)
			{
				alert("로그인 성공");
				location.href="index.jsp";
				return;
			}else{
				alert("로그인 실패")
				return;
			}
		}
		
		
	}