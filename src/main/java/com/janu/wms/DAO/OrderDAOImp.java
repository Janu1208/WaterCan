package com.janu.wms.dao;

import com.janu.wms.model.User;

public interface OrderDAOImp {
	public void addOrder(User user,int cans_avail);
	public  void addReserveOrder(User user,int order_cans) throws Exception;
}
