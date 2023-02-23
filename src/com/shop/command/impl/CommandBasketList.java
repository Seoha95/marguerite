package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.DAO;
import vo.BasketVO;

public class CommandBasketList implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   	  
		      request.setCharacterEncoding("utf-8");
		      response.setCharacterEncoding("utf-8");

		      HttpSession session = request.getSession();
		      String id = (String) session.getAttribute("userID"); 
		      
		      ArrayList<BasketVO> plist = null;
		      DAO dao = new DAO();
		      plist = dao.selectBasket(id);
		      request.setAttribute("plist", plist);

	}

}
