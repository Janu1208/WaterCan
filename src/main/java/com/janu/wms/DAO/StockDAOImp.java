package com.janu.wms.dao;

import com.janu.wms.model.Stock;

public interface StockDAOImp {
	public  Stock findavaiability();
	public void  availStock(int cans) throws Exception;
	public void updateStock(int cans);
   
}
