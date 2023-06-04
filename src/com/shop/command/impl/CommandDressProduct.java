package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import vo.ProductVO;

public class CommandDressProduct implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		
		//DAO생성
		
		
		DAO sdao = new DAO();
		
		ArrayList<ProductVO> plist = null;
		
		plist = sdao.search(category);
		request.setAttribute("plist", plist);
		
		
	}
}
