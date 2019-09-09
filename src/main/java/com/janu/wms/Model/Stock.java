package com.janu.wms.model;

import java.time.LocalDate;

//import java.time.LocalDateTime;

public class Stock{
	
	private static Integer cans_avail;
	private LocalDate date;
	//private LocalDateTime createdDate;
	
	

	
	
	
	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public static  Integer getCans_avail() {
		return cans_avail;
	}
	
	public void setCans_avail(Integer cans_avail) {
		Stock.cans_avail = cans_avail;
	}
	
	
	/*public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}*/
	

}
