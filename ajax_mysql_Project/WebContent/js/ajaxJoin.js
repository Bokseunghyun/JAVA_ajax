/**
 * 
 */


	function ajaxJoin(){
		idChecked1();
		
		var userPw = document.getElementsByName("userPw")[0];
		var userName = document.getElementsByName("userName")[0];
		var userAddr = document.getElementsByName("userAddr")[0];
		
		if(userPw.value==null || userPw.value=="")
		{
			alert("비밀번호 입력 오류");
			userPw.focus();
			return;
		}
		if(userName.value==null || userName.value=="")
		{
			alert("이름 입력 오류");
			userName.focus();
			return;
		}
		if(userAddr.value==null || userAddr.value=="")
		{
			alert("주소 입력 오류");
			userAddr.focus();
			return;
		}
		ajaxJoinOk();
	}
	
	var xhr2 = new XMLHttpRequest();
	
	function ajaxJoinOk(){
		var userId = document.getElementsByName("userId")[0];
		var userPw = document.getElementsByName("userPw")[0];
		var userName = document.getElementsByName("userName")[0];
		var userAddr = document.getElementsByName("userAddr")[0];
		var data = "userId="+userId.value+"&userPw="+userPw.value+"&userName="+userName.value+"&userAddr="+userAddr.value;
		var url = "ajaxJoin.mo";
		xhr2.open("post",url,true);
		xhr2.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		
		xhr2.onreadystatechange=function(){
			if(xhr2.status==200 && xhr2.readyState==4){
				var result = JSON.parse(xhr2.responseText);
			  //var result = eval('('+xhr.responseText+')');
			
				if(result==1){
					alert("회원가입 성공");
					location.href="login.jsp";
					return;
				}
				else{
					alert("회원가입 실패")
					return;
				}
			}else{
				
			}
			
			}
		xhr2.send(data);
		}
	
	
		
