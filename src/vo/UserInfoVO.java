package vo;

public class UserInfoVO {

	private String id;
	private String pw;
	private String tel;
	private String name;
	private String address;
	
	
	
	public UserInfoVO() {
		
	}

	public UserInfoVO(String id, String pw, String tel, String name, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.name = name;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
