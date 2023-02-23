package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import vo.ProductVO;

public class CommandSearchProduct implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String searchItem = request.getParameter("searchItem");
		
		System.out.println(searchItem);
		
		
		//DAO생성
		
		DAO sdao = new DAO();
		
		ArrayList<ProductVO> sclist = null;
		
		sclist = sdao.searchProductInfo(searchItem);
		request.setAttribute("sclist", sclist);
		
		
		
		
	}

}
