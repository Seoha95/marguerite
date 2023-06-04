package com.shop.command.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import vo.OrderListVO;

public class CommandPayment implements CommandImpl{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      
       HttpSession session = request.getSession(); 
       String userID = (String)session.getAttribute("userID");
       String pimage = request.getParameter("pimage");
       String pname = request.getParameter("pname");
       String code = request.getParameter("code");
       String category = request.getParameter("category");
       int count = Integer.parseInt(request.getParameter("count"));
       String psize = request.getParameter("psize");
       int price = Integer.parseInt(request.getParameter("totalPrice"));
       
       String str = null;
       
       if(userID == null) {
          response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('로그인 해주세요.'); location.href='login.jsp';</script>");
       }
       else {
          
    	   
          OrderListVO tvo = new OrderListVO(userID, pimage, pname, code, category, count, psize, price);
       
          session.setAttribute("tempVO", tvo);
          
          str = "payment.jsp";
       }
       request.setAttribute("str", str);
   }

}