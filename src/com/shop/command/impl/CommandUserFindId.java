package com.shop.command.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class CommandUserFindId implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		DAO udao = new DAO();
		
		String result = null;
		
		String str = null;
		
		result = udao.userFindId(name, tel);	// id1
		
		System.out.println(name);
		System.out.println(tel);
		System.out.println(result);
		
		
		if(result != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("findId", result);
			session.setAttribute("findName", name);
			
			PrintWriter out = response.getWriter();
			out.print("<script>window.open('idCheckPopUp.jsp', '아이디찾기', 'width=500, height=500')</script>");
			// str = "idCheckPopUp.jsp";
		}
		else {
			str = "findId.jsp";
		}
		request.setAttribute("str", str);

	}

}
