package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

public class CommandBasketCountDown implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("userID");
	      String pname = request.getParameter("pname");
	      String psize = request.getParameter("psize");
	      
	     
	      
	      DAO dao = new DAO();
	      dao.countDownBasket(id, pname, psize);


	}

}
