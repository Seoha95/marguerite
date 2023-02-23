package com.shop.command.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class CommandUserFindPw implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		
		DAO udao = new DAO();
		
		String result = null;
		
		String str = null;
		
		result = udao.userFindPw(id, tel);	// pw1
		
		System.out.println(result);
		
		
		if(result != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("findPw", result);
			session.setAttribute("findId", id);
			PrintWriter out = response.getWriter();
			out.print("<script>window.open('pwCheckPopUp.jsp', '비밀번호찾기', 'width=500, height=500')</script>");
		}
		else {
			str = "findPw.jsp";
		}
		request.setAttribute("str", str);

	}

}
