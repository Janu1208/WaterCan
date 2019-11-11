package com.janu.wms.service;
import java.util.List;

import com.janu.wms.dao.AdminDAO;
import com.janu.wms.dao.AdminDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.model.Admin;
import com.janu.wms.model.Stock;


public class AdminServices {
	AdminDAO admindao=new AdminDAOImp();
	public Admin login(String name,String password)
	{
		Admin admin =null;
	     try {
			admin=admindao.login(name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
		
	}
	/**
	 * to show the updated stock
	 * @return
	 * @throws 
	 */
	public List<Stock> stockView() throws DBException {

		StockDAOImp dao = new StockDAO();
		List<Stock> list = null;
		try {
			list = dao.viewStock();
		} catch (DBException e) {

			e.printStackTrace();
		}

		return list;
	}
	/**
	 * addCans should only be in integer value
	 * value should not be null
	 * value should be greater than zero
	 * @param addCans
	 * @throws Exception 
	 */
	public void setAvailableCans(int addCans) throws Exception 
	{
		int update;
		StockDAOImp stockDao = new StockDAO();
        update = stockDao.findavaiability();
    int updateCans=addCans+update;
   try {
	   stockDao.updateStock(updateCans);
	
} catch (Exception e) {
	e.printStackTrace();
}
				
	}
}
