package kr.co.mlec.member.vo;

public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;;
	private String type;

	public MemberVO(String id, String pw, String name, String email, String tel,
			String type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.type = type;
	}
	
	
	public MemberVO(String id, String pw, String name, String email, String tel ) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
		
		
	}
	
	

	public MemberVO() {

	}



	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", tel=" + tel + ", type="
				+ type + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String gettel() {
		return tel;
	}

	public void settel(String tel) {
		this.tel = tel;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
