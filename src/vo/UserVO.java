package vo;

/*
CREATE TABLE SIGNUP3(
ID VARCHAR2(30),
PW VARCHAR2(30) NOT NULL,
TEL VARCHAR2(13) NOT NULL,
NAME VARCHAR2(30) NOT NULL,
constraints team3_id_pk PRIMARY KEY(ID)
);
*/

public class UserVO {
	private String id;
	private String pw;
	private String tel;
	private String name;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String id, String pw, String tel, String name) {
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.name = name;
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


	
	
}
