package org.web.memberdto;

public class MemberDto {

	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	
	public MemberDto() {
		super();
	}
	public MemberDto(String userId, String userPw, String userName, String userAddr) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddr = userAddr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	
	
	
}
