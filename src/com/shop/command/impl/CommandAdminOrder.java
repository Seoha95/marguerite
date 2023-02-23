package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import vo.OrderListVO;

public class CommandAdminOrder implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		DAO dao = new DAO();
		
		ArrayList<OrderListVO> oVO = new ArrayList<>();
		
		oVO = dao.adminOrderList();
		
		request.setAttribute("plist", oVO);
		
	}

}
