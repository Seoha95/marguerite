package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.ShippingVO;

public class CommandShippingInfo implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		
		
		DAO dao = new DAO();
		
		ShippingVO shippingVO = dao.shippingInfo(userID);
		request.setAttribute("shippingVO", shippingVO);

	}

}
