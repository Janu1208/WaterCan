package com.janu.wms.model;

public class Order {
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
	public int getOrderCans() {
		return orderCans;
	}
	public void setOrderCans(int orderCans) {
		this.orderCans = orderCans;
	}
	private int id;
    private int userId;
    private int orderCans;
    public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	private int reserveId;
}
