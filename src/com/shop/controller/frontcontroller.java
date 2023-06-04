package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.command.impl.CommandAdminMember;
import com.shop.command.impl.CommandAdminOrder;
import com.shop.command.impl.CommandAdminProduct;
import com.shop.command.impl.CommandBasket;
import com.shop.command.impl.CommandBasketCountDown;
import com.shop.command.impl.CommandBasketCountUp;
import com.shop.command.impl.CommandBasketDelete;
import com.shop.command.impl.CommandBasketList;
import com.shop.command.impl.CommandBestProduct;
import com.shop.command.impl.CommandBottomProduct;
import com.shop.command.impl.CommandDetailCheck;
import com.shop.command.impl.CommandDressProduct;
import com.shop.command.impl.CommandImpl;
import com.shop.command.impl.CommandInsertAddr;
import com.shop.command.impl.CommandMyOrderList;
import com.shop.command.impl.CommandNewProduct;
import com.shop.command.impl.CommandOuterProduct;
import com.shop.command.impl.CommandPaySuccess;
import com.shop.command.impl.CommandPayment;
import com.shop.command.impl.CommandSearchProduct;
import com.shop.command.impl.CommandShippingInfo;
import com.shop.command.impl.CommandShoes_BagProduct;
import com.shop.command.impl.CommandTopProduct;
import com.shop.command.impl.CommandUserDelete;
import com.shop.command.impl.CommandUserFindId;
import com.shop.command.impl.CommandUserFindPw;
import com.shop.command.impl.CommandUserInfo;
import com.shop.command.impl.CommandUserJoin;
import com.shop.command.impl.CommandUserLogin;
import com.shop.command.impl.CommandUserLogout;
import com.shop.command.impl.CommandUserUpdatePw;

@WebServlet("*.do")
public class frontcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public frontcontroller() {
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      String str = null;
      
      String c = request.getRequestURI().substring(request.getContextPath().length());
      
      CommandImpl u1 = null;
      
      switch (c) {
      
      case "/index.do":
         
         u1 = new CommandNewProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "main.do";
         
         break;
      
      case "/main.do":
         
         u1 = new CommandBestProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "index.jsp";
         
         break;
      
      case "/userJoin.do":
         
         u1 = new CommandUserJoin();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "login.jsp";
         
         break;
         
      case "/login.do":
         
         u1 = new CommandUserLogin();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "logCheck.jsp";
         
         break;
      
      case "/logout.do":
         
         u1 = new CommandUserLogout();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "index.do";
         
         break;
         
      case "/userDelete.do":
         u1 = new CommandUserDelete();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = (String) request.getAttribute("str");
         
         break;
         
      case "/findId.do":
         u1 = new CommandUserFindId();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = (String) request.getAttribute("str");
         
         break;
         
      case "/findPw.do":
         u1 = new CommandUserFindPw();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = (String) request.getAttribute("str");
         
         break;
         
      case "/updatePw.do":
         
          u1 = new CommandUserUpdatePw();
               
          try {
             u1.execute(request, response);
          } catch (Exception e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
          }
               
          str = (String) request.getAttribute("str");
          
          break;
         
      case "/search.do":
         
         u1 = new CommandSearchProduct();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "searchResult.jsp";
         
         break;
      
      
      case "/best.do":
         
         u1 = new CommandBestProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "Best.jsp";
         
         break;
         
      case "/outer.do":

         u1 = new CommandOuterProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "Outer.jsp"; 
         
         break;
         
      case "/top.do":
         
         u1 = new CommandTopProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "top.jsp";
         
         break;
         
      case "/bottom.do":

         u1 = new CommandBottomProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "Bottom.jsp"; 
         
         break;
      
      case "/shoes_bag.do":
         
         u1 = new CommandShoes_BagProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "shoes_bag.jsp";
         
         break;   
         
      case "/dress.do":
         
         u1 = new CommandDressProduct();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "dress.jsp";
         
         break;
         
      case "/userInfo.do":
         
         u1 =  new CommandUserInfo();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "userInfo.jsp";
         
         break;
         
      case "/detailCheck.do":
         
         u1 = new CommandDetailCheck();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "detailCheck.jsp";
         
         break;
         
      
      case "/payment.do":
         
         u1 = new CommandPayment();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = (String) request.getAttribute("str");
         
         break;
         
      case "/paySuccess.do":
         
         u1 = new CommandPaySuccess();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "paySuccess.jsp";
         
         break;
         
      case "/myOrderList.do":
         
         u1 = new CommandMyOrderList();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str="myOrderList.jsp";
         
         break;
         
      case "/shippingPopUp.do":
         
         u1 = new CommandShippingInfo();
         
         try {
            u1.execute(request, response);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "shippingPopUp.jsp";
         
         break;
         
      case "/insertAddr.do":

            u1 = new CommandInsertAddr();
            
            try {
               u1.execute(request, response);
            } catch(Exception e) {
            // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
            str = "userInfo.do";
         
            break;
         
      case "/basket.do":
         
         u1 = new CommandBasket();
            
           try {
              u1.execute(request, response);
           } catch (Exception e) {
            // TODO Auto-generated catch block
               e.printStackTrace();
           }

           str = (String) request.getAttribute("str");

           break;
            
      case "/basketList.do":
         
         u1 = new CommandBasketList();
         
         try {
            u1.execute(request, response);
         } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         str = "Basket.jsp";
         
         break;
            
         
      case "/adminMember.do":
         
         u1 = new CommandAdminMember();
            
            try {
               u1.execute(request, response);
            } catch(Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         
         str="adminMember.jsp";
         
         break;
         
      case "/adminOrder.do":
         
         u1 = new CommandAdminOrder();
            
            try {
               u1.execute(request, response);
            } catch(Exception e) {
            // TODO Auto-generated catch block
               e.printStackTrace();
            }
         
         str="adminOrder.jsp";
         
         break;
         
      case "/adminProduct.do":
         u1 = new CommandAdminProduct();
         
            try {
               u1.execute(request, response);
            } catch(Exception e) {
            // TODO Auto-generated catch block
               e.printStackTrace();
            }
         
         str="adminProduct.jsp";
         
         break;
         
         
      case "/basketCountUp.do":
         u1 = new CommandBasketCountUp();
         
          try {
             u1.execute(request, response);
           } catch (Exception e) {
               // TODO Auto-generated catch block
              e.printStackTrace();
           }
               
           str = "basketList.do";
            
           break;
            
      case "/basketCountDown.do":
         u1 = new CommandBasketCountDown();
         
          try {
             u1.execute(request, response);
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
               
           str = "basketList.do";
            
           break;
            
      case "/basketDelete.do":
         u1 = new CommandBasketDelete();
         
          try {
             u1.execute(request, response);
           } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
               
           str = "basketList.do";
               
           break;
         
      }
      
         
      
      RequestDispatcher rd1 = request.getRequestDispatcher(str);
      rd1.forward(request, response);
   }
      

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      
   }

}