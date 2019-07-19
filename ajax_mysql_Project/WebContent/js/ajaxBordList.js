
window.onload=function(){
	bordListView();
}

var xhr=new XMLHttpRequest();

function bordListView(){
	var mId = document.getElementById("mId");
	var url = "BordView.bo";
	var data ="mId="+mId.value;
	
	xhr.open("post",url,true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;charset=utf8');
	
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			var rs = JSON.parse(xhr.responseText);
			console.log(xhr.responseText);
			console.log(rs);
			if(rs!=null){
				document.getElementById("mGroup").textContent=rs.result1.mGroup;
				document.getElementById("hit").textContent=rs.result1.hit;
				document.getElementById("mIndent").textContent=rs.result1.mIndent;
				document.getElementById("mTime").textContent=rs.result1.mTimestamp;
				document.getElementById("userId").value=rs.result1.userId;
				document.getElementById("nickName").value=rs.result1.nickName;
				document.getElementById("title").value=rs.result1.title;
				document.getElementById("memo").value=rs.result1.memo;
			}
		}
	}
	xhr.send(data);
}