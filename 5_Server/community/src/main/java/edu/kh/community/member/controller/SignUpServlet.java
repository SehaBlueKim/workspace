package edu.kh.community.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.dto.Member;
import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	// GET 방식 요청 시 JSP로 응답할 수 있도록 요청 위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp").forward(req, resp);
		
	}
	
	// POST 방식 요청 시 회원가입 진행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 모두 변수에 저장
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		String memberNickname = req.getParameter("memberNickname");
		String memberTel= req.getParameter("memberTel");
		
		// 주소 3개의 input으로 이루어져 있으므로 배열로 전달 받아야함
		// -> DB 컬럼은 1개이므로 배열을 하나의 문자열로 합칠 예정
		String[] address = req.getParameterValues("memberAddress");
		
		// System.out.println(Arrays.toString(address));
		
		String memberAddress = null;
		
		// 주소 입력 안된 경우 빈칸 3개
		if(!address[0].equals("")) { // 우편번호가 빈칸이 아니라면(== 주소를 작성했다면)
			memberAddress = String.join(",,", address);
					
			// String.join("구분자", 배열)
			// -> 배열 요소를 하나의 문자열로 반환
			//	  요소 사이에 "구분자" 추가
		}
		
		// 파라미터를 하나의 Member 객체에 저장
		Member mem = new Member();
		mem.setMemberEmail(memberEmail);
		mem.setMemberPw(memberPw);
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			// 회원가입 서비스 호출 후 결과 반환 받기
			MemberService service = new MemberService();
			int result = service.signUp(mem);
			
			// Session 객체 얻어오기
			HttpSession session = req.getSession();
			
			if(result > 0) {
				session.setAttribute("message", "회원가입 성공!");
			}else {
				session.setAttribute("message", "회원가입 실패");
			}
			
			// 최상위주소로 재요청
			resp.sendRedirect(req.getContextPath());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
