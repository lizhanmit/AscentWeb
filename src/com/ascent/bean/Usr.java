package com.ascent.bean;

public class Usr implements java.io.Serializable {

	private Integer id; 
	private String username; 
	private String password; 
	private String fullname; 
	private String title; 
	private String superuser;
	
	public Usr() {
		
	}

	public Usr(String username, String password, String fullname, String title, String superuser) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.superuser = superuser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuperuser() {
		return superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	} 
	
	
}
