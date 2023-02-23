package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DAO;
import vo.UserInfoVO;

public class CommandAdminMember implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		DAO dao = new DAO();
		
		ArrayList<UserInfoVO> ulist = null;
		
		ulist = dao.getMemberInfo();
		
		request.setAttribute("ulist", ulist);
		
	}

}
