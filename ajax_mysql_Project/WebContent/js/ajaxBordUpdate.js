
var key=0;

function ajaxUpdate(event){
	var nickName=document.getElementById("nickName");
	var mPw=document.getElementById("mPw");
	var title=document.getElementById("title");
	var memo=document.getElementById("memo");
	
	event.preventDefault();
	if(key==0){ //글 수정 할 수 있게 활성화 key가 스위치기능을해줌
		nickName.disabled=false;
		mPw.disabled=false;
		title.disabled=false;
		memo.disabled=false;
		key=1;
	}else{ //key가 1인상태
		ajaxUpdateOk();
	}
		
}



var xhr = new XMLHttpRequest();

function ajaxUpdateOk(){
	var mId=document.getElementById("mId").value;
	var nickName=document.getElementById("nickName").value;
	var userId=document.getElementById("userId").value;
	var mPw=document.getElementById("mPw").value;
	var title=document.getElementById("title").value;
	var memo=document.getElementById("memo").value;
	var hit=document.getElementById("hit").textContent;
	
	var data = "mId="+mId+"&nickName="+nickName+
	"&userId="+userId+"&mPw="+mPw+"&title="+title+"&memo="+memo+"&hit="+hit;
	var url = "BordUpdateOk.bo";
	
	xhr.open("post",url,true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr.onreadystatechange=function(){
		
		if(xhr.status==200 && xhr.readyState==4){
			var result = JSON.parse(xhr.responseText);
			if(result==1){
				alert("글 수정 성공");
				location.href = "BordList.jsp";
			}else{
				alert("글 수정 실패");
				history.go(-1);
			}
		}
	}
	xhr.send(data);
}
