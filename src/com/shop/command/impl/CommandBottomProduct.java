package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import vo.ProductVO;

public class CommandBottomProduct implements CommandImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		//DAO생성
		
		
		DAO bdao = new DAO();
		
		ArrayList<ProductVO> plist = null;
		
		plist = bdao.bottomProductInfo();
		request.setAttribute("plist", plist);
		

	}

}
