<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>marguerite</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>
<link rel="stylesheet" href="css/reset.css" />
<style>
   
   .headerArea {
      display:flex;
      align-items:center;
      background-color: #E4E5CA;
      padding: 40px 0;

   }
   
   .headerArea > div {
      padding: 0px 20px;
      display:flex;
   }
   
   
   .headerArea > div > a {
      color: black;
      text-decoration-line: none;
   }
   
   
   .headerArea > div > a > span {
      font-size:23px;
      font-weight: 550;
   }
   
   body {
      height: 100%;
      background-color: #F5F5DC;
      
   }
   
</style>   
</head>
<body>
<div class="headerArea">
            
         <div><a href="index.do"><span>marguerite</span></a></div>
         <div><a href="best.do"><span>best</span></a></div>
         <div><a href="outer.do?category=outer"><span>outer</span></a></div>
         <div><a href="top.do?category=top"><span>top</span></a></div>
         <div><a href="bottom.do?category=bottom"><span>bottom</span></a></div>
         <div><a href="shoes_bag.do?category=shoesbag"><span>shoes&bag</span></a></div>
         <div><a href="dress.do?category=dress"><span>dress</span></a></div>
         <div>
            <form action="search.do" >
               <input type="text" name="searchItem"/>
               <input type="submit" value="search" />
            </form>
         </div>
         
         <%
            int login = 0;
   
            if (session.getAttribute("login") != null) {
               login = (int) session.getAttribute("login");
            }
   
            if (login == 3) {
          %>
   
            <div>
               <a href="adminPage.jsp"><span>관리자</span></a>
            </div>
            <div>
               <a href="logout.do"><span>로그아웃</span></a>
            </div>
            
          <%
             } else if(login == 2){
          %>
   
            <div>
               <a href="userInfo.do"><span>유저정보</span></a>
            </div>
            <div>
               <a href="logout.do"><span>로그아웃</span></a>
            </div>
            <div><a href="basketList.do"><span>장바구니</span></a></div>
            
          <%
             } else {
          %>
               <div>
                  <a href="login.jsp"><span>로그인</span></a>
               </div>
               
          <%    } %>
          
      </div>