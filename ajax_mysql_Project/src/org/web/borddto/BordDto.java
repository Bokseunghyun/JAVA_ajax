package org.web.borddto;
import java.sql.Timestamp;

public class BordDto {
	private int mId; //글번호(고유값)
	private int mGroup; //처음글(그룹)
	private int mIndent; //들여쓰기
	private int step; //한 그룹 내의 글순서
	private int hit; //조회수
	private String nickName; //작성글 닉네임
	private String userId; //로그인 아이디
	private String mPw; //작성글 비밀번호
	private String memo; //글 내용
	private String title; //글 제목
	private Timestamp mTimestamp; //글 작성시간
	
	public BordDto() {
		super();
	}

	public BordDto(int mId, int mGroup, int mIndent, int step, int hit, String nickName, String userId, String mPw,
			String memo, String title, Timestamp mTimestamp) {
		super();
		this.mId = mId;
		this.mGroup = mGroup;
		this.mIndent = mIndent;
		this.step = step;
		this.hit = hit;
		this.nickName = nickName;
		this.userId = userId;
		this.mPw = mPw;
		this.memo = memo;
		this.title = title;
		this.mTimestamp = mTimestamp;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getmGroup() {
		return mGroup;
	}

	public void setmGroup(int mGroup) {
		this.mGroup = mGroup;
	}

	public int getmIndent() {
		return mIndent;
	}

	public void setmIndent(int mIndent) {
		this.mIndent = mIndent;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getmTimestamp() {
		return mTimestamp;
	}

	public void setmTimestamp(Timestamp mTimestamp) {
		this.mTimestamp = mTimestamp;
	}

	
	
	
}