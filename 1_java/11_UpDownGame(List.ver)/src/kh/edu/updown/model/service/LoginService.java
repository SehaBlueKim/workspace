package kh.edu.updown.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Member> memberList = new ArrayList<>();

	// 업다운 게임 시작
	// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
	// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
	public void startGame(Member loginMember) {
		
		int answer = (int)(Math.random()*100+1);
		int count = 1;
		int highScore = loginMember.getHighScore();
		
		System.out.println("[Game Start...]");
		
		while(true) {
			System.out.print(count + "번째 입력 : ");
			int input = sc.nextInt();
			
			// 잘못 입력
			if (input<1 || input>100) {
				System.out.println("1~100 사이 수를 입력해주세요. \n");
				continue;
			}
			
			// 제대로 입력
			if(input > answer) {
				System.out.println("-- DOWN --");
			} else if(input < answer) {
				System.out.println("-- UP --");
			} else {
				System.out.println("정답!!");
				System.out.println("입력 시도 횟수 : " + count);
				
				if(count<highScore || highScore==0) {
					loginMember.setHighScore(count);
					System.out.println("*** 최고 기록 달성 ***");
				}
				break;
			}
			count++;
		}
	}
	
	
	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
		System.out.println("아이디 : " + loginMember.getMemberId()
		+ "\n이름 : " + loginMember.getMemberName()
		+ "\n최고기록 : " + loginMember.getHighScore());
	}
	
	
	
	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출력
	public void selectAllMember(List<Member> members) {
		
		System.out.println("[전체 회원 조회]");
		System.out.printf("%6s %6s %7s\n", "[아이디]", "[이름]", "[최고점수]");
		for(Member m : members) {
			if(m != null) {
				System.out.println(m.toString());
			}
		}
	}

	
	
	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		System.out.print("현재 비밀번호 입력 : ");
		String nowPw = sc.next();
		
		if(loginMember.getMemberPw().equals(nowPw)) {
			System.out.print("새 비밀번호 입력 : ");
			String newPw = sc.next();
			loginMember.setMemberPw(newPw);
			System.out.println("비밀번호가 변경되었습니다.");
		} else {
			System.out.println("현재 비밀번호가 일치하지 않습니다.");
		}
	}



	public List<Member> sortScore(List<Member> members) {
		Collections.sort(members);
		System.out.println(members);
		return members;
	}

	
	
}
