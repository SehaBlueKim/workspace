package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;

@WebServlet("/member/nicknameDupCheck")
public class NicknameDupCheckServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 비동기 통신으로 전달된 파라미터(data 속성의 key값) 얻어오기
		String memberNickname = req.getParameter("memberNickname");
		
		try {
			MemberService service = new MemberService();

			int result = service.nicknameDupCheck(memberNickname);
			
			resp.getWriter().print(result);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
