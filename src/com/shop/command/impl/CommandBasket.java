package com.shop.command.impl;

import java.io.PrintWriter;
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

      System.out.println(id);
      
      
      String str = null;
      
      if (id == null) {
         response.setContentType("text/html; charset=utf-8");
         PrintWriter out = response.getWriter();
         out.print("<script>alert('로그인 해주세요.'); location.href='login.jsp';</script>");

//         str = "login.jsp";
         
      }
      else {
          
          plist = dao.insertBasket(bvo);
          request.setAttribute("plist", plist);          
          request.setAttribute("bvo", bvo);
          request.setAttribute("price", price);
          request.setAttribute("deliveryFee", deliveryFee);
          
          str = "basketList.do";
      }

      request.setAttribute("str", str);
      

   }

}