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
	public boolean userInsertAddr(String id) {
		
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

	public int userLogin(String id, String pw) {
		
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


	public boolean userDelete(String id, String pw) {
		
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

	public String userFindId(String name, String tel) {

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
	
	public String userFindPw(String id, String tel) {

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
	
	public boolean userUpdatePw(String id, String oripw, String chpw) {
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

	
	public ArrayList<ProductVO> searchProductInfo(String searchItem) throws SQLException{
		
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
	
	public UserVO getUserInfo(String userID) throws SQLException {
		
		String sql = "select * from signup3 where id=?";
		UserVO userVO = new UserVO();
		
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
	
	
	
	public ArrayList<ProductVO> bestProductInfo() throws SQLException{
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
	
	
	public ArrayList<ProductVO> outerProductInfo() throws SQLException {
		ArrayList<ProductVO> oparray = new ArrayList<ProductVO>();
		
		String sql = "SELECT * FROM PRODUCT3 WHERE category = 'outer'";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String code = rs.getString("code");
			String category = rs.getString("category");
			String color = rs.getString("color");
			int quantity = rs.getInt("quantity");
			String psize = rs.getString("psize");
			int amount = rs.getInt("amount");
			int price = rs.getInt("price");
			String pname = rs.getString("pname");
			String pimage = rs.getString("pimage");
			
			ProductVO ov = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
			oparray.add(ov);
			
		}
		
		return oparray;
	}
	
	public ArrayList<ProductVO> topProductInfo()  throws SQLException{
		ArrayList<ProductVO> tiarray = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM PRODUCT3 WHERE CATEGORY = 'top'";
		
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
			tiarray.add(sv);
		}
		
		return tiarray;
	
	}

	public ArrayList<ProductVO> bottomProductInfo() throws SQLException {
		ArrayList<ProductVO> bparray = new ArrayList<ProductVO>();
		
		String sql = "SELECT * FROM PRODUCT3 WHERE category = 'bottom'";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String code = rs.getString("code");
			String category = rs.getString("category");
			String color = rs.getString("color");
			int quantity = rs.getInt("quantity");
			String psize = rs.getString("psize");
			int amount = rs.getInt("amount");
			int price = rs.getInt("price");
			String pname = rs.getString("pname");
			String pimage = rs.getString("pimage");
			
			ProductVO bv = new ProductVO(code, pname, category, color, quantity, psize, amount, price, pimage);
			bparray.add(bv);
			
		}
		
		return bparray;
	}
	
	public ArrayList<ProductVO> dressProductInfo() throws SQLException{
		ArrayList<ProductVO> diarray = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM PRODUCT3 WHERE category = 'dress'";
		
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
			diarray.add(sv);
		
		}
		return diarray;
	}
	
	public ArrayList<ProductVO>shoes_BagProductInfo() throws SQLException{
		ArrayList<ProductVO> siarray = new ArrayList<ProductVO>();
		String sql = "SELECT * FROM PRODUCT3 WHERE category = 'shoesbag'";
		
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
	
	
	
	
	
	 // 주문내역DB에 결제정보 넣기 
	public boolean insertOrderList(OrderListVO tvo) {
	 
	 String sql = "INSERT INTO orderList VALUES(?,?,?,?,?,?)";
	 
	 try { pstmt = con.prepareStatement(sql); 
	 pstmt.setString(1, tvo.getId());
	 pstmt.setString(2, tvo.getPimage()); 
	 pstmt.setString(3, tvo.getPname());
	 pstmt.setInt(4, tvo.getCount()); 
	 pstmt.setString(5, tvo.getPsize());
	 pstmt.setInt(6, tvo.getPrice());
	 
	  pstmt.executeUpdate();
	  
	  }catch (SQLException e) { 
		  e.printStackTrace(); 
		  return false; 
		  } 
	 return true;
	 }
	 
	
	/*
	 * public boolean insertOrderList(OrderListVO tvo) {
	 * 
	 * String sql =
	 * "INSERT ALL INTO orderList VALUES(?,?,?,?,?,?) SELECT * FROM DUAL";
	 * 
	 * try { pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, tvo.getId()); pstmt.setString(2, tvo.getPimage());
	 * pstmt.setString(3, tvo.getPname()); pstmt.setInt(4, tvo.getCount());
	 * pstmt.setString(5, tvo.getPsize()); pstmt.setInt(6, tvo.getPrice());
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * }catch (SQLException e) { e.printStackTrace(); return false; } return true; }
	 */
	
	
	
	// 주문완료시 product3 테이블 수정
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
	   public ArrayList<BasketVO> insertBasket(BasketVO bvo) {
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
	
	   
	   public ArrayList<BasketVO> selectBasket(String id) {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return barray;
	}
	   
	   public boolean countUpBasket(String id, String pname, String psize) {

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
	   

		public boolean countDownBasket(String id, String pname, String psize) {

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
		   public boolean deleteBasket(String id, String pname, String psize) {

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
	
	
//	배송지 정보
	
	public ShippingVO shippingInfo(String userID) throws SQLException {
		
		String sql = "SELECT * FROM shipping WHERE id = ?";
		ShippingVO shippingVO = new ShippingVO();
		
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
    public boolean insertAddr(String id, String address) {
      
    	String sql = "MERGE INTO shipping USING DUAL ON (id = ?) "
    			+ "WHEN MATCHED THEN "
    			+ "UPDATE SET address = ? "
    			+ "WHEN NOT MATCHED THEN "
    			+ "INSERT VALUES (?, ?)";
    	
	      try {
	      pstmt = con.prepareStatement(sql);
	      
	      pstmt.setString(1, id);
	      pstmt.setString(2, address);
	      pstmt.setString(3, id);
	      pstmt.setString(4, address);
	      
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
 	
}
