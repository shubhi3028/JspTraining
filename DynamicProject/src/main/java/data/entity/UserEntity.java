package data.entity;

public class UserEntity {
	private int id;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private String phoneno;
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", fname=" + fname + ", lname=" + lname + ", password=" + password + ", email="
				+ email + ", phoneno=" + phoneno + "]";
	}


	public UserEntity(int id, String fname, String lname, String password, String email, String phoneno) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}

	
	
}
