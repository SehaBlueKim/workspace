package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.dto.Member;
import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet{
	
	// 메인 -> 닉네임 클릭 시 내정보수정으로 화면전환
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/myPage-info.jsp").forward(req, resp);
	}
	
	// 내정보 -> 수정하기 버튼 클릭 시
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기 + 배열 -> 문자열로 만들기
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		String[] address = req.getParameterValues("memberAddress");
		
		String memberAddress = null;
		
		// 주소 입력 안된 경우 빈칸 3개
		if(!address[0].equals("")) { // 우편번호가 빈칸이 아니라면(== 주소를 작성했다면)
			memberAddress = String.join(",,", address);
					
			// String.join("구분자", 배열)
			// -> 배열 요소를 하나의 문자열로 반환
			//	  요소 사이에 "구분자" 추가
		}
		// *** 세션에서 로그인한 회원의 정보 얻어오기 ***
		HttpSession session = req.getSession();
		
		// 얕은 복사(세션에 있는 회원정보 객체의 주소를 얕은 복사 했삼)
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo(); // 회원 번호 얻어오기
		
		// 업데이트에 필요한 Member 객체 생성
		Member mem = new Member();
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		mem.setMemberNo(memberNo);
		
		try {
			MemberService service = new MemberService();
			int result = service.updateMember(mem);
			
			if(result > 0) {
				// 수정 성공 시 "회원 정보가 수정되었습니다." 알림창
				session.setAttribute("message", "회원 정보가 수정되었습니다.");
				
				// DB는 수정되었지만
				// 로그인한 회원 정보가 담겨있는 Session의 정보는 그대로이기 때문에
				// 회원정보 수정에 성공해도 바로 반영이 안됨
				// -> 동기화 작업이 필요하다!
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
				
			}else { 
				// 수정 실패 시 "회원 정보 수정 실패 ㅠㅠ" 알림창 -> footer.jsp 참고
				session.setAttribute("message", "회원 정보 수정 실패 ㅠㅠ");
			}
			// 수정/실패 여부 관계없이 "내 정보" 화면 재요청
			
			// 절대경로
			// resp.sendRedirect(req.getContextPath() + "/member/myPage/info");
			
			// 상대경로
			resp.sendRedirect("info");
			
		} catch (Exception e) {
			
		}
	}
}
