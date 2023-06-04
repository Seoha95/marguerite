package com.shop.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

public class CommandAdminProduct implements CommandImpl {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      
      String code = request.getParameter("code");
      String category = request.getParameter("category");
      String color = request.getParameter("color");
      int price = Integer.parseInt(request.getParameter("price"));
      String pname = request.getParameter("pname");

      DAO dao = new DAO();
      dao.adminProductInsert(code, category, color, price, pname);
      

   }

}