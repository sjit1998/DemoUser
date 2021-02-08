package com.example.demo.userresponse;

public class UserRequest {
	private String name;

	public UserRequest(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String email;

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

}
