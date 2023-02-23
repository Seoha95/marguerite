package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.ProductVO;

public class CommandDetailCheck implements CommandImpl{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception, NumberFormatException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ProductVO plist = new ProductVO();
		
//		HttpSession session = request.getSession();
//		DAO dao = new DAO();
//		String userID = (String)session.getAttribute("userID");
		
		plist.setCategory(request.getParameter("category"));
		plist.setCode(request.getParameter("code"));
		plist.setPname(request.getParameter("pname"));
		plist.setPrice(Integer.parseInt(request.getParameter("price")));
		plist.setPimage(request.getParameter("pimage"));
		plist.setPsize(request.getParameter("psize"));
		
		
		
		request.setAttribute("plist", plist);
		
	}

}
