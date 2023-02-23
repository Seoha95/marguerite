package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

public class CommandUserDelete implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		DAO udao = new DAO();
		
		boolean result = false;
		
		result = udao.userDelete(id, pw);
		
		String str = null;
		
		if(result) {
			str = "index.jsp";
		}
		else {
			str = "userDelete.jsp";
		}
		
		request.setAttribute("str", str);

	}

}
