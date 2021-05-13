package kr.co.softcampus.beans;

public class UserBean {
	
	private String user_id;
	private String user_name;
	private String user_pw;
	private String email;
	private String phone;
	
	private boolean id_exist;
	private boolean log_in;
	
	public UserBean(){
		this.id_exist = false;
		this.log_in= false;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isId_exist() {
		return id_exist;
	}

	public void setId_exist(boolean id_exist) {
		this.id_exist = id_exist;
	}

	public boolean isLog_in() {
		return log_in;
	}

	public void setLog_in(boolean log_in) {
		this.log_in = log_in;
	}

}
