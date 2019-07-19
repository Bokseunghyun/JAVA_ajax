function BordDeleteView(event){
	event.preventDefault();
	var deleteView=document.getElementById("deleteView");
	deleteView.style.display="block";
}

function closeFn(){
	var deleteView=document.getElementById("deleteView");
	deleteView.style.display="none";
}


var xhr = new XMLHttpRequest();

function ajaxBDelete(){
	var mId= document.getElementById("mId");
	var userId= document.getElementById("userId2");
	var mPw= document.getElementById("mPw2");
	var data = "mId="+mId.value+"&userId="+userId2.value+"&mPw="+mPw2.value;
	var url = "BordDeleteOk.bo";
	xhr.open("post",url,true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr.onreadystatechange=function(){
		
		if(xhr.status==200 && xhr.readyState==4){
		var result = xhr.responseText;
		
			if(result==1){
				alert("글 삭제 성공");
				location.href="BordList.jsp";
			}
			else{
				alert("글 삭제 실패");
				history.go(-1);
			}
		}
	}
	xhr.send(data);
}