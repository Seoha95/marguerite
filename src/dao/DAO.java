package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConn;
import vo.ProductVO;
import vo.ShippingVO;
import vo.UserInfoVO;
import vo.BasketVO;
import vo.OrderListVO;
import vo.UserVO;

public class DAO {
   
   private Connection con;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   public DAO() throws ClassNotFoundException, SQLException {
      con = new DBConn().getConnection();
   }
   
   // 회원가입 
   public boolean userJoin(String id, String name, String pw, String tel) throws SQLException {
      
      String sql = "INSERT INTO SIGNUP3 VALUES(?, ?, ?, ?)";
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, id);
         pstmt.setString(2, pw);
         pstmt.setString(3, tel);
         pstmt.setString(4, name);
         
         pstmt.executeUpdate();
      
      } catch (SQLException e) {
         e.printStackTrace();
          return false;
      }
      
      return true;
   }
   
   // 회원가입시 shipping DB 초기화
   public boolean userInsertAddr(String id) throws SQLException {
      
      String sql = "INSERT INTO Shipping VALUES(?, ?)";
      String addr = "등록전";
      
      try {
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, id);
            pstmt.setString(2, addr);
            
            pstmt.executeUpdate();
            
      } catch (SQLException e) {
         e.printStackTrace();
          return false;
         }
         
      return true;
   }

   // 로그인 기능
   public int userLogin(String id, String pw) throws SQLException {
      
      String sql = "SELECT * FROM SIGNUP3 WHERE id = ?";
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, id);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            if(rs.getString("id").equals(id) && rs.getString("pw").equals(pw)) {
               if(id.equals("admin")) {
                  return 3;
               }
               return 2;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
          return 0;
      }
      return -1;
   }

   // 회원 정보 삭제 
   public boolean userDelete(String id, String pw) throws SQLException {
      
      String sql = "DELETE FROM SIGNUP3 WHERE id = ? AND pw = ?";
      int flag = 0;
      
      try {
         pstmt = con.prepareStatement(sql);
            
         pstmt.setString(1, id);
         pstmt.setString(2, pw);
            
         flag = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      if(flag == 1)
         return true;
      else
         return false;
   }
   
   // 사용자 아이디 찾기 
   public String userFindId(String name, String tel) throws SQLException {

      String sql = "SELECT * FROM SIGNUP3 WHERE name = ? AND tel = ?";
      
      String id1 = null;
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, name);
         pstmt.setString(2, tel);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            if(rs.getString("name").equals(name) && rs.getString("tel").equals(tel)) {
               id1 = rs.getString("id");
               return id1;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return id1;
      
   }
   
   // 사용자 비밀번호 찾기 
   public String userFindPw(String id, String tel) throws SQLException {

      String sql = "SELECT * FROM SIGNUP3 WHERE id = ? AND tel = ?";
      
      String pw1 = null;
      
      try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, id);
         pstmt.setString(2, tel);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            if(rs.getString("id").equals(id) && rs.getString("tel").equals(tel)) {
               pw1 = rs.getString("pw");
               return pw1;
            }
         }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return pw1;
   }
   
   // 비밀번호 변경
   public boolean userUpdatePw(String id, String oripw, String chpw) throws SQLException {
      
        String sql = "UPDATE SIGNUP3 SET pw = ? WHERE id = ? AND pw = ?";
         
         int flag = 0;
         
         try {
            pstmt = con.prepareStatement(sql);
               
            pstmt.setString(1, chpw);
            pstmt.setString(2, id);
            pstmt.setString(3, oripw);
               
            flag = pstmt.executeUpdate();
            
         } catch (SQLException e) {
             e.printStackTrace();
         }
         
         if(flag == 1)
            return true;
         else
            return false;
      }

   // 상품 검색 
   public ArrayList<ProductVO> searchProductInfo(String searchItem) throws SQLException {
      ArrayList<ProductVO> scarray = new ArrayList<ProductVO>();
      
      String sql = "SELECT * FROM product3 WHERE pname LIKE '%'||?||'%'";
      
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, searchItem);
      rs = pstmt.executeQuery();
      
      
      while(rs.next()) {
         String code = rs.getString("code");
         String pname = rs.getString("pname");
         String category = rs.getString("category");
         String color = rs.getString("color");
         int quantity = rs.getInt("quantity");
         String psize = rs.getString("psize");
         int amount = rs.getInt("amount");
         int price = rs.getInt("price");
         String pimage = rs.getString("pimage");
   
         ProductVO sv = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
         scarray.add(sv);
      }
      
      return scarray;
   }
   
   // 유저정보 조회
   public UserVO getUserInfo(String userID) throws SQLException {
     UserVO userVO = new UserVO();      
      String sql = "select * from signup3 where id=?";
      
      
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userID);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
         
         userVO.setId(userID);
         userVO.setPw(rs.getString("pw"));
         userVO.setTel(rs.getString("tel"));
         userVO.setName(rs.getString("name"));
      }
      
      return userVO;
   }
   
   // 신상품
   public ArrayList<ProductVO> newProductInfo() throws SQLException {
      ArrayList<ProductVO> narray = new ArrayList<ProductVO>();
      
      String sql = "SELECT * FROM product3 order by TO_NUMBER(code) desc";
      
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
         String code = rs.getString("code");
         String pname = rs.getString("pname");
         String category = rs.getString("category");
         String color = rs.getString("color");
         int quantity = rs.getInt("quantity");
         String psize = rs.getString("psize");
         int amount = rs.getInt("amount");
         int price = rs.getInt("price");
         String pimage = rs.getString("pimage");
   
         ProductVO sv = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
         narray.add(sv);
      }
      
      return narray;
   }
   
   // 베스트 상품
   public ArrayList<ProductVO> bestProductInfo() throws SQLException {
      ArrayList<ProductVO> siarray = new ArrayList<ProductVO>();
      
      String sql = "SELECT * FROM PRODUCT3 WHERE rownum < 11 ORDER BY QUANTITY desc, price desc";
      
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
         String code = rs.getString("code");
         String pname = rs.getString("pname");
         String category = rs.getString("category");
         String color = rs.getString("color");
         int quantity = rs.getInt("quantity");
         String psize = rs.getString("psize");
         int amount = rs.getInt("amount");
         int price = rs.getInt("price");
         String pimage = rs.getString("pimage");
   
         ProductVO sv = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
         siarray.add(sv);
      }
      
      return siarray;
   }
   
   // 카테고리별 상품 보여주는 기능
   public ArrayList<ProductVO> search(String category) throws SQLException {
      ArrayList<ProductVO> siarray = new ArrayList<ProductVO>();
      
      String sql = "SELECT * FROM PRODUCT3 WHERE category = ?";
      
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, category);
      rs = pstmt.executeQuery();
      while(rs.next()) {
         String code = rs.getString("code");
         String pname = rs.getString("pname");
         String color = rs.getString("color");
         int quantity = rs.getInt("quantity");
         String psize = rs.getString("psize");
         int amount = rs.getInt("amount");
         int price = rs.getInt("price");
         String pimage = rs.getString("pimage");
   
         ProductVO sv = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
         siarray.add(sv);
      }
      return siarray;
   }
    
    // 주문내역DB에 결제정보 넣기 
   public boolean insertOrderList(OrderListVO tvo) {
    
       String sql = "INSERT INTO orderList VALUES(?,?,?,?,?,?)";
       
       try {
       pstmt = con.prepareStatement(sql); 
       pstmt.setString(1, tvo.getId());
       pstmt.setString(2, tvo.getPimage()); 
       pstmt.setString(3, tvo.getPname());
       pstmt.setInt(4, tvo.getCount()); 
       pstmt.setString(5, tvo.getPsize());
       pstmt.setInt(6, tvo.getPrice());
       
       pstmt.executeUpdate();
        
        } catch (SQLException e) { 
          e.printStackTrace();
          return false;
          }
          return true;
    }
    
   // 주문 완료 시 product3 테이블 수정
   public boolean updateProduct3(String code, int count) throws SQLException {
      
       String sql = "UPDATE product3 SET amount = amount - ?, quantity =  quantity + ? WHERE code = ?";
       
       pstmt = con.prepareStatement(sql);   
       pstmt.setInt(1, count);
       pstmt.setInt(2, count);
       pstmt.setString(3, code);
       
       pstmt.executeUpdate();
       
       return true;
   }
   
   // 장바구니 DB에 데이터 저장
      public ArrayList<BasketVO> insertBasket(BasketVO bvo) throws SQLException {
         ArrayList<BasketVO> barray = new ArrayList<BasketVO>();
         
         String sql = "MERGE INTO JBASKET USING DUAL ON (PNAME=? AND PSIZE=?) "
                     + "WHEN MATCHED THEN "
                     + "UPDATE SET COUNT = COUNT + ?, PRICE = PRICE+? "
                     + "WHEN NOT MATCHED THEN "
                     + "INSERT VALUES(?,?,?,?,?,?,?,?)";
         
         try {
            pstmt = con.prepareStatement(sql);
            
            
            pstmt.setString(1, bvo.getPname());
            pstmt.setString(2, bvo.getPsize());
            pstmt.setInt(3, bvo.getCount());
            pstmt.setInt(4, bvo.getPrice());
            
            pstmt.setString(5, bvo.getId());
            pstmt.setString(6, bvo.getCode());
            pstmt.setString(7, bvo.getPname());
            pstmt.setString(8, bvo.getCategory());
            pstmt.setInt(9, bvo.getCount());
            pstmt.setString(10, bvo.getPsize());
            pstmt.setInt(11, bvo.getPrice());
            pstmt.setString(12, bvo.getPimage());
            
            pstmt.executeUpdate();
            BasketVO bvo1 = new BasketVO(bvo.getId(),bvo.getCode(),bvo.getPname(),bvo.getCategory(),bvo.getCount(),bvo.getPsize(),bvo.getPrice(),bvo.getPimage());
            barray.add(bvo1);
            //return barray;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return barray;
      }
   
      
      // 장바구니 목록 조회 
      public ArrayList<BasketVO> selectBasket(String id) throws SQLException {
         ArrayList<BasketVO> barray = new ArrayList<BasketVO>();
         
      String sql = "SELECT * FROM JBASKET WHERE ID = ?";
      
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            if(rs.getString("id").equals(id)) {
               String code = rs.getString("code");
               String pname = rs.getString("pname");
               String category = rs.getString("category");
               int count = rs.getInt("count");
               String psize = rs.getString("psize");
               int price = rs.getInt("price");
               String pimage = rs.getString("pimage");
               
               BasketVO bvo = new BasketVO(id, code, pname, category, count, psize, price, pimage);
               barray.add(bvo);
               //return barray;
            }
         }
      } catch(SQLException e) {
          e.printStackTrace();
      }
      return barray;
   }
      
      // 장바구니 수량 늘리기
      public boolean countUpBasket(String id, String pname, String psize) throws SQLException {

         String sql = "UPDATE JBASKET SET count=count+1, price=price+(price/count) WHERE id = ? AND pname = ? AND psize = ?";

         try {
            
            pstmt = con.prepareStatement(sql);
               
               pstmt.setString(1, id);
               pstmt.setString(2, pname);
               pstmt.setString(3, psize);
               
               pstmt.executeUpdate();
            
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
         return true;
         
      }
      
      // 장바구니 수량 줄이기 
      public boolean countDownBasket(String id, String pname, String psize) throws SQLException {

         String sql = "UPDATE JBASKET SET count=count-1, price=price-(price/count) WHERE id = ? AND pname = ? AND psize = ?";

         try {
            
            pstmt = con.prepareStatement(sql);
               
               pstmt.setString(1, id);
               pstmt.setString(2, pname);
               pstmt.setString(3, psize);
               
               pstmt.executeUpdate();
            
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
         return true;
         
      }
      
         // 장바구니 삭제
         public boolean deleteBasket(String id, String pname, String psize) throws SQLException {

            String sql = "DELETE FROM JBASKET WHERE id = ? AND pname = ? AND psize = ?";
            
            try {
               pstmt = con.prepareStatement(sql);
               
               pstmt.setString(1, id);
               pstmt.setString(2, pname);
               pstmt.setString(3, psize);
               
               pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
         }
   
   
   // 일반사용자용 주문내역확인
   public ArrayList<OrderListVO> myOrderList(String userID) throws SQLException {
      ArrayList<OrderListVO> orderListVO = new ArrayList<>();
      
      String sql = "SELECT * FROM orderList WHERE id=?";
      
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userID);
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
      
         String pimage = rs.getString("pimage");
         String pname = rs.getString("pname");
         int count = rs.getInt("count");
         String psize = rs.getString("psize");
         int price = rs.getInt("price");
         
         OrderListVO oVO = new OrderListVO(userID, pimage, pname, count, psize, price);
         orderListVO.add(oVO);
      }
      
      return orderListVO;
   }
   
   
   //배송지 정보
   public ShippingVO shippingInfo(String userID) throws SQLException {
      ShippingVO shippingVO = new ShippingVO();
      
       String sql = "SELECT * FROM shipping WHERE id = ?";
      
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userID);
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
         shippingVO.setId(userID);
         shippingVO.setAddress(rs.getString("address"));
      }
      
      return shippingVO;
      
   }
   
   
   // 배송지 관리
    public boolean insertAddr(String id, String address) throws SQLException {
    
       String sql = "UPDATE shipping SET address = ? WHERE id = ?";
       
         try {
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, address);
         pstmt.setString(2, id);         
         pstmt.executeUpdate();
         
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
      
         return true;
      
    }   
    
    // 관리자회원정보
    public ArrayList<UserInfoVO> getMemberInfo() throws SQLException{
       ArrayList<UserInfoVO> ulist = new ArrayList<>();
       
       String sql = "SELECT s.id, s.pw, s.tel, s.name, p.address "
                    +"FROM SIGNUP3 s, shipping p " 
                    +"WHERE s.id = p.id";
       
       pstmt = con.prepareStatement(sql);
       rs = pstmt.executeQuery();
      
      while(rs.next()) {
      
         String id = rs.getString("id");
         String pw = rs.getString("pw");
         String tel = rs.getString("tel");
         String name = rs.getString("name");
         String address = rs.getString("address");
         
         UserInfoVO vo = new UserInfoVO(id, pw, tel, name, address);
         ulist.add(vo);
         
      }
       
       return ulist;
       
    }
    
   // 관리자용 주문내역확인
    public ArrayList<OrderListVO> adminOrderList() throws SQLException {       
       ArrayList<OrderListVO> orderListVO = new ArrayList<>();
       
       String sql = "SELECT * FROM orderList";
       
       pstmt = con.prepareStatement(sql);
       rs = pstmt.executeQuery();
       
       while(rs.next()) {
       
          String userID = rs.getString("ID");
          String pimage = rs.getString("pimage");
          String pname = rs.getString("pname");
          int count = rs.getInt("count");
          String psize = rs.getString("psize");
          int price = rs.getInt("price");
          
          OrderListVO oVO = new OrderListVO(userID, pimage, pname, count, psize, price);
          orderListVO.add(oVO);
       }
       
       return orderListVO;
    }

    // 관리자 상품 등록
   public boolean adminProductInsert(String code, String category, String color, int price, String pname) throws SQLException {
       
       String sql = "INSERT INTO product3 VALUES(?,?,?,0,'free',100,?,?,'img/'||?||'.jpg')";
       
       try {
          
          pstmt = con.prepareStatement(sql);
          
          pstmt.setString(1, code);
          pstmt.setString(2, category); 
          pstmt.setString(3, color);
//          pstmt.setInt(4, quantity);      // 판매량
//          pstmt.setString(5, psize);
//          pstmt.setInt(6, amount);      // 상품재고
          pstmt.setInt(4, price);
          pstmt.setString(5, pname);
          pstmt.setString(6, pname);
          
          pstmt.executeUpdate();
        
       } catch (SQLException e) { 
          e.printStackTrace();
          return false;
       }
           return true;
      
   }
    
}