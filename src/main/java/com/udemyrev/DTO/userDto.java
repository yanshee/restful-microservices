package com.udemyrev.DTO;

public class userDto {
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public userDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userDto(Long id2, String firstname2, String lastname2, String email2) {
		// TODO Auto-generated constructor stub
		super();
		this.id=id2;
		this.firstname=firstname2;
		this.lastname=lastname2;
		this.email=email2;
	}
	
}
