package com.shop.command.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.BasketVO;

public class CommandBasket implements CommandImpl {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("userID");
      String pimage = request.getParameter("pimage");
      String code = request.getParameter("code");
      String category = request.getParameter("category");
      String pname = request.getParameter("pname");
      int price = Integer.parseInt(request.getParameter("price"));
      int deliveryFee = Integer.parseInt(request.getParameter("deliveryFee"));
      String psize = request.getParameter("psize");
      int count = Integer.parseInt(request.getParameter("count"));
      int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
      
      price = price*count;

      BasketVO bvo = new BasketVO(id, code, pname, category, count, psize, price, pimage);
      
      ArrayList<BasketVO> plist = null;
      DAO dao = new DAO();
      plist = dao.insertBasket(bvo);
      request.setAttribute("plist", plist);
    
      
      
      
      request.setAttribute("bvo", bvo);
      request.setAttribute("price", price);
      request.setAttribute("deliveryFee", deliveryFee);
      
      System.out.println(id);
      

   }

}