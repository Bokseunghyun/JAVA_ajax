function delete1(){
		if(confirm("정말 탈퇴하시겠습니까?")==true){
			
			ajaxDelete();
		}else{
			return;
		}
	}
	
	var xhr = new XMLHttpRequest();
	
	function ajaxDelete(){
		
		var userId = document.getElementById("userId");
		var userPw = document.getElementById("userPw");
		var data = "userId="+userId.value+"&userPw="+userPw.value;
		var url = "ajaxMemberDelete.mo";
		
		xhr.open("post",url,true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
		
		if(userId==null || userId==""){
			alert("아이디 오류");
			userId.focus();
			return;
		}
		if(userPw==null || userPw==""){
			alert("비밀번호 오류");
			userPw.focus();
			return;
		}
		xhr.onreadystatechange=ajaxDeleteOk;
		xhr.send(data);		
		
	}
		function ajaxDeleteOk(){
			var result = xhr.responseText;
			
			if(xhr.readyState==4 && xhr.status==200){
			if(result==1){
				
				alert("회원 탈퇴 성공");
				location.href="index.jsp"
			}else{
				alert("회원 탈퇴 실패");
			}
			}
		}