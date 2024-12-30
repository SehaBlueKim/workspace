package edu.kh.jdbc.member.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.member.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

public class MemberView { // 회원 관련 화면 입출력

	private Scanner sc = new Scanner(System.in);

	// 회원 관련 서비스 제공 객체 생성 및 참조
	private MemberService service = new MemberService();



	/**
	 * 회원 가입 화면 출력용 메소드
	 */
	public void signUp() {

		System.out.println("[회원 가입]");

		try {
			String memberId = null;
			String memberPw = null;
			String memberPw2 = null;
			String memberName = null;
			char memberGender = ' ';

			while(true) {
				System.out.print("아이디 : ");
				memberId = sc.next();

				// 아이디 중복 검사 (DB에 일치하는 아이디가 있으면 "중복" -> 다시 아이디 입력 받기)
				int result = service.duplicateCheck(memberId);

				if(result == 0) {
					System.out.println("사용 가능한 아이디 입니다.");
					break;
				} else {
					System.out.println("이미 사용중인 아이디 입니다. 다시 입력해주세요.");
				}
			} // 아이디 중복 검사 while 종료

			// 비밀번호, 비밀번호 확인을 각각 입력 받아서
			// 일치할 때 까지 무한 반복
			while(true) {
				System.out.print("비밀번호 입력 : ");
				memberPw = sc.next();

				System.out.print("비밀번호 확인 : ");
				memberPw2 = sc.next();

				if(memberPw.equals(memberPw2)) {
					break;

				} else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				}
			}

			// 이름 입력
			System.out.print("이름 입력 : ");
			memberName = sc.next();

			// 성별이 'M' 또는 'F'가 입력될 때까지 반복
			while(true) {
				System.out.print("성별(M/F) : ");
				memberGender = sc.next().toUpperCase().charAt(0);

				if(memberGender != 'M' && memberGender != 'F') {
					System.out.println("M 또는 F만 입력해주세요.");

				} else {
					break;
				}
			}

			// 입력 받은 값을 하나의 객체(Member)에 저장해보자
			Member signUpMember = new Member(memberId, memberPw, memberName, memberGender);

			// 회원 가입 Service 호출 후 결과 반환 받기
			int result = service.signUp(signUpMember);

			// service 결과에 따른 화면 처리
			if(result == 0) {
				System.out.println("회원 가입 실패");
			} else {
				System.out.println("회원 가입 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/** 로그인 메소드
	 * @return loginMember
	 */
	public Member login() {

		Member loginMember = null;

		System.out.println("\n[로그인]");

		System.out.print("아이디 : ");
		String inputId = sc.next();

		System.out.print("비밀번호 : ");
		String inputPw = sc.next();

		try{
			loginMember = service.login(inputId, inputPw);

			if(loginMember != null) { // 로그인 성공 시
				System.out.println("\n*** " + loginMember.getMemberName() + "님 환영합니다. ***");

			} else { // 로그인 실패 (아이디/비밀번호 불일치 또는 탈퇴한 회원)
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginMember;
	}



	public void myInfo(Member loginMember) {
		System.out.println("\n[내 정보 조회]");

		System.out.println("회원 번호 : " + loginMember.getMemberNo());
		System.out.println("회원 아이디 : " + loginMember.getMemberId());
		System.out.println("회원 이름 : " + loginMember.getMemberName());
		System.out.println("회원 성별 : " + loginMember.getMemberGender());
		System.out.println("회원 가입일 : " + loginMember.getEnrollDate());
	}



	public void selectAll() {
		System.out.println("[전체 회원 정보 조회]");

		try {
			List<Member> memberList = service.selectAll();

			if(memberList.isEmpty()) { // 비어있음 == 조회 결과 없음
				System.out.println("조회 결과가 없습니다.");

			} else { 
				for(Member mem : memberList) {
					System.out.printf("%10s %10s    %10s\n",
							mem.getMemberId(), mem.getMemberName(), mem.getEnrollDate().toString());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/** 내 정보 수정
	 * @param loginMember
	 * @return
	 */
	public void updateMyInfo(Member loginMember) {

		System.out.println("\n[내 정보 수정(이름, 성별)]");

		System.out.print("변경할 이름 : ");
		String memberName = sc.next();

		System.out.print("변경할 성별(M/F) : ");
		char memberGender = sc.next().toUpperCase().charAt(0);

		try {
			int result = service.updateMyInfo(memberName, memberGender, loginMember);

			if(result == 1) {
				System.out.println("\n회원 정보가 수정되었습니다.");

				// DB에 있는 정보는 수정 됐는데 java에 있는 loginMember 는 수정이 안된 상태
				// -> 일치 시키기
				// 얕은 복사 : 참조 주소만 복사하여 같은 객체를 참조
				// -> 특징 : 복사된 주소(매개변수로 받은 loginMember)를 참조하여 수정하면
				//			원본 객체(MainView에 있는 loginMember)가 수정된다.
				loginMember.setMemberName(memberName);
				loginMember.setMemberGender(memberGender);

			} else {
				System.out.println("\n회원 정보 수정에 실패했습니다.\n");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	/** 비밀번호 변경
	 * @param loginMember
	 */
	public void updatePw(Member loginMember) {

		int result = 0;
		String updatePw = null;
		String updatePw2 = null;

		System.out.println("[비밀번호 변경]");


		System.out.print("현재 비밀번호 : ");
		String currentPw = sc.next();

		// 새 비밀번호, 새 비밀번호 확인이 서로 일치할 때 까지 입력 받기
		while(true) {
			System.out.print("새 비밀번호 : ");
			updatePw = sc.next();

			System.out.print("새 비밀번호 확인 : ");
			updatePw2 = sc.next();

			if(updatePw.equals(updatePw2)) {
				break;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		}

		try{
			result = service.updatePw(loginMember.getMemberNo(), currentPw, updatePw);

			// 성공 : "비밀번호가 변경되었습니다."
			if(result > 0) {
				System.out.println("비밀번호가 변경되었습니다.");
				loginMember.setMemberPw(updatePw);

			// 실패 : "비밀번호 변경 실패"
			} else {
				System.out.println("비밀번호 변경 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/** 회원 탈퇴
	 * @param loginMember
	 */
	public int secession(Member loginMember) {
		// loginMember = null; 을 할 경우
		// 매개변수로 전달 받은 값(주소 복사본)을 저장할 뿐
		// -> 복사본이 사라진다고 해도 원본(MainView의 loginMember)는 사라지지 않는다!!
		// --> 로그아웃이 안된다.

		int result = 0;

		System.out.println("[회원 탈퇴]");

		// 1. 현재 비밀번호 입력 받기
		System.out.print("비밀번호 입력 : ");
		String currentPw = sc.next();

		// 2. 정말 탈퇴하시겠습니까?(Y/N)
		System.out.print("정말 탈퇴하시겠습니까?(Y/N)");
		char input = sc.next().toUpperCase().charAt(0);

		try{
			// 3. (Y 입력 시) 탈퇴 Service 수행
			if(input == 'Y') {
				// 4. 성공 : "탈퇴 되었습니다." -> 로그아웃
				// 5. 실패 : "비밀번호가 일치하지 않습니다."
				result = service.secession(loginMember.getMemberNo(), currentPw);

				if(result > 0) {
					System.out.println("탈퇴 되었습니다.");
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("\n회원 탈퇴 취소\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



}
