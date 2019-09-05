package com.janu.WaterCaneManagementSystem.Model;

public class User {
	private Integer id;
	private String name;
	private String phone_number;
	private String password;
	private Integer cans_avail;
	
	
	
	public Integer getCans_avail() {
		return cans_avail;
	}
	
	public void setCans_avail(int cans_avail) {
		this.cans_avail = cans_avail;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone_number=" + phone_number + ", password=" + password  + "]";
	}
	
}
