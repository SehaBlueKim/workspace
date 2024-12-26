package edu.kh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderer = req.getParameter("orderer");
		
		System.out.println("주문자 : " + orderer);
		System.out.println("주문한 음료 : " + req.getParameter("coffee"));
	}
}
