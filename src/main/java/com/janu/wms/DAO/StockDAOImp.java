package com.janu.wms.dao;

import java.util.List;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Stock;

public interface StockDAOImp {
	public  int findavaiability();
	public void  availStock(int cans) throws DBException;
	public void updateStock(int cans);
	public List<Stock> viewStock() throws DBException;
   
}
