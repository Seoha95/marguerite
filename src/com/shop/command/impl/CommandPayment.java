package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.OrderListVO;

public class CommandPayment implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		 HttpSession session = request.getSession(); 
		 String userID = (String)session.getAttribute("userID");
		 String pimage = request.getParameter("pimage");
		 String pname = request.getParameter("pname");
		 String code = request.getParameter("code");
		 String category = request.getParameter("category");
		 int count = Integer.parseInt(request.getParameter("count"));
		 String psize = request.getParameter("psize");
		 int price = Integer.parseInt(request.getParameter("totalPrice"));
		 
		 
		 OrderListVO tvo = new OrderListVO(userID, pimage, pname, code, category, count, psize, price );
		 
		 session.setAttribute("tempVO", tvo);
		 
		 
	}

}
