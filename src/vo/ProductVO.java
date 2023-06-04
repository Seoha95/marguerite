package vo;

public class ProductVO {

	private String code;     //상품코드
	private String pname;    //상품명 
	private String category; //카테고리
	private String color;    //색상
	private int quantity;    // 판매량
	private String psize;    //상품사이즈
	private int amount;       //재고
	private int price;       //가격
	private String pimage;   //상품이미지
	
	
	
	public ProductVO() {}
	public ProductVO(String code, String pname, String category, String color, int quantity, String psize, int amount,
			int price, String pimage) {
		super();
		this.code = code;
		this.pname = pname;
		this.category = category;
		this.color = color;
		this.quantity = quantity;
		this.psize = psize;
		this.amount = amount;
		this.price = price;
		this.pimage = pimage;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	
	
	

	
	
	
	
	
	

}
