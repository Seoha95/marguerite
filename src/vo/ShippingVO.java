package vo;

public class ShippingVO {
	
	private String id;
	private String address;
	
	public ShippingVO() {
		// TODO Auto-generated constructor stub
	}

	public ShippingVO(String id, String address) {
		this.id = id;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
