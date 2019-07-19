
		function idChecked1(){
			
			//name,태그 ,class -> 배열
			var checked = document.getElementsByName("checked")[0];
			var userId = document.getElementsByName("userId")[0];
			
			if(checked.value=="unChecked"){
				alert("아이디 체크를 먼저 실행하세요");
				userId.focus();
				
				return;
			}
		}
		
		var xhr = new XMLHttpRequest();
		
		function ajaxidChecked1(){
			var userId = document.getElementsByName("userId")[0];
			var s1 = document.getElementById("s1");		
			var data = "userId="+userId.value;
			var url = "ajaxidChecked.mo";
			xhr.open("post",url,true);
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
			
			xhr.onreadystatechange=function(){
				if(xhr.status==200 && xhr.readyState==4){
					var result = JSON.parse(xhr.responseText);
				  //var result = eval('('+xhr.responseText+')');
				
					if(result==1){
						//alert("중복아이디");
						s1.style.color="#f00";
						s1.innerHTML="중복아이디 입니다";
						userId.focus();
						return;
					}else{
						//alert("사용할 수 있는 아이디");
						s1.style.color="#00f";
						s1.innerHTML="사용할 수 있는 아이디입니다.";
						var checked = document.getElementsByName("checked")[0];
						checked.value="OnChecked";
						return;
					}
				
				}
			}
			
			xhr.send(data);
		
		}
		

