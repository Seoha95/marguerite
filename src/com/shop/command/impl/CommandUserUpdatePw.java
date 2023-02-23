package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

public class CommandUserUpdatePw implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      
	      String id = request.getParameter("id");
	      String oripw = request.getParameter("oripw");
	      String chpw = request.getParameter("chpw");
	      
	      DAO udao = new DAO();
	      
	      boolean result = false;
	      
	      result = udao.userUpdatePw(id, oripw, chpw);

	      String str = null;
	      
	      if(result) {
	         str = "login.jsp";
	      }
	      else {
	         str = "updatePw.jsp";
	      }
	      
	      request.setAttribute("str", str);
	}

}
