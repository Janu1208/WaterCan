package com.janu.wms.model;

public class Reserve {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReserveCans() {
		return reserveCans;
	}
	public void setReserveCans(int reserveCans) {
		this.reserveCans = reserveCans;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private int id;
    private int userId;
    private int reserveCans;
    private String status;	
}
