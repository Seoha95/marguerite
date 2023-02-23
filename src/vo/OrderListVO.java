package vo;

public class OrderListVO {
	
	private String id;
	private String pimage;
	private String pname;
	private String code;
	private String category;
	private int count;
	private String psize;
	private int price;
	
	public OrderListVO () {}
	
	public OrderListVO (String id, String pimage, String pname, int count, String psize, int price) {
		this.id = id;
		this.pimage = pimage;
		this.pname = pname;
		this.count = count;
		this.psize = psize;
		this.price = price;
	}
	
	public OrderListVO(String id, String pimage, String pname, String code, String category, 
				int count, String psize, int price) {
		this.id = id;
		this.pimage = pimage;
		this.pname = pname;
		this.code = code;
		this.category = category;
		this.count = count;
		this.psize = psize;
		this.price = price;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
