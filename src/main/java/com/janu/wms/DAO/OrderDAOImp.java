package com.janu.wms.dao;

import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Order;
import com.janu.wms.model.Reserve;

public interface OrderDAOImp {
	public void addOrder(Order order,int cansAvail) throws DBException;
	public void addReserveOrder(Reserve reserve,int reserveCanValue) throws SQLException;
	public void modifiedReservedCan(Reserve reserve, int reserveCan) throws DBException;
	}
