package com.janu.wms.model;

public class User {
	private static int id;
	private static String name;
	private String phone_number;
	private static String password;
	private int cans_avail;
	private int reserve_id;
	private String status;
	
	
	public String getStatus() {
		return status;
	}


	
	public void setStatus(String status) {
		this.status = status;
	}


	public int getReserve_id() {
		return reserve_id;
	}

	
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

	
	
	
	

	
	
	
	
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

	public static Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		User.id = id;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		User.name = name;
	}
	
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		User.password = password;
	}
	

	
}
