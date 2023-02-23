package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.OrderListVO;

public class CommandMyOrderList implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//DAO생성
		DAO dao = new DAO();
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userID");
		
		ArrayList<OrderListVO> oVO = new ArrayList<>();
		
		oVO = dao.myOrderList(userID);
		
		request.setAttribute("plist", oVO);
		
	}
	
	

}
