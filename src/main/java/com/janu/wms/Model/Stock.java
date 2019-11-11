package com.janu.wms.model;

import java.time.LocalDate;

public class Stock{
	private Integer cansAvail;
	private LocalDate date;
	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getCansAvail() {
		return cansAvail;
	}
	
	public void setCansAvail(Integer cansAvail) {
		this.cansAvail = cansAvail;
	}
}
