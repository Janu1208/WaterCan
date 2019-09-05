package com.janu.wms.Model;

import java.time.LocalDateTime;

public class Stock{
	
	private static Integer cans_avail;
	
	private LocalDateTime createdDate;
	
	

	
	
	public static  Integer getCans_avail() {
		return cans_avail;
	}
	
	public void setCans_avail(Integer cans_avail) {
		this.cans_avail = cans_avail;
	}
	
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Stock [ canes_avail=" + cans_avail + ", createdDate="
				+ createdDate + "]";
	}

}
