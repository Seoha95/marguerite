package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class CommandUserLogin implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		DAO udao = new DAO();
		
		int login = udao.userLogin(id, pw);
		System.out.println("login" + login);
		
		String str = null;
		
		if(login == 2 || login == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("userID", id);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
		}
	}
}
