package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.OrderListVO;

public class CommandPaySuccess implements CommandImpl{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession();
      
      OrderListVO tempVO = (OrderListVO) session.getAttribute("tempVO");
      
      DAO dao = new DAO();
      
      
      dao.updateProduct3(tempVO.getCode(), tempVO.getCount());
      dao.deleteBasket(tempVO.getId(), tempVO.getPname(), tempVO.getPsize());
      dao.insertOrderList(tempVO);
   }

}