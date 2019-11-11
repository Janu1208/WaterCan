package com.janu.wms.service;

import com.janu.wms.dao.OrderDAO;
import com.janu.wms.dao.OrderDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.exception.ServiceException;
import com.janu.wms.model.Order;
import com.janu.wms.util.Logger;

public class OrderServices {
	private static final Logger logger=Logger.getInstance();

	/**
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws Exception 
	 * it will give facility for the user to add cans
	 * ordered cans should be greater than zero and it should not be null
	 * @param order
	 * @throws  
	 */
	public void orderCan( Order order) throws ServiceException {

		StockDAOImp stockdao =new StockDAO();
		int availableStock = stockdao.findavaiability();
		logger.info("Available"+availableStock + ",orderCans:"+order.getOrderCans());
		int totalCanAfterOrder=0;
		if (order.getOrderCans() <= availableStock ) {
			OrderDAOImp odao=new OrderDAO();
			try {
				odao.addOrder(order,availableStock);
			} catch (DBException e) {
				e.printStackTrace();
			}
			totalCanAfterOrder=availableStock - order.getOrderCans();
		}
		else
		{
			throw new ServiceException("Invalid cans...please check available stock and re enter the value");
		}
			try {
				stockdao.updateStock(totalCanAfterOrder);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			} 
		
		
	}
}