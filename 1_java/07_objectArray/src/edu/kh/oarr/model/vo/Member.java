package edu.kh.oarr.model.vo;

public class Member {
	
	// 필드 (== 멤버 변수)
	private String memberId; // 아이디
	private String memberPw; // 패스워드
	private String memberName; // 이름
	private int memberAge; // 나이
	private String region; // 지역
	
	// 생성자
	public Member() {}
	
	public Member(String memberId, String memberPw, String memberName, 
			int memberAge, String region) {
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}
	
	// 메소드
	// getter / setter
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
		return;
		// 모든 메소드는 종료 시 호출한 곳으로 돌아가는
		// return 구문이 작성되어야 하지만
		// void일 경우 생략 가능하다
		// -> 생략 시 컴파일러가 자동으로 추가해줌
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
		return;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
		return;
	}
	
	public int getMemberAge() {
		return memberAge;
	}
	
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
		return;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
		return;
	}

	@Override
	public String toString() {
		return "이름 : " + memberName
			+ "\n아이디 : " + memberId
			+ "\n나이 : " + memberAge + "세"
			+ "\n지역 : " + region + "\n";
	}
	
	
	

}
