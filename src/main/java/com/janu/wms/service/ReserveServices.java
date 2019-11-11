package com.janu.wms.service;

import java.sql.SQLException;

import com.janu.wms.dao.OrderDAO;
import com.janu.wms.dao.OrderDAOImp;
import com.janu.wms.dao.ReserveDAO;
import com.janu.wms.dao.ReserveDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.exception.ServiceException;
import com.janu.wms.model.Reserve;


public class ReserveServices {
	private ReserveDAOImp reserveDao = new ReserveDAO();
	private OrderDAOImp orderDao = new OrderDAO();
	private StockDAOImp stockDao = new StockDAO();
	public int reserveCan(Reserve reserve) throws ServiceException, SQLException{
		
		int availableStock = stockDao.findavaiability();
		int totalCanAfterReserve = 0;

		int reserveId = reserveDao.ReserveId(reserve);
		if (reserve.getReserveCans() <= availableStock) {
			if (reserveId == 0) {
				try {
					reserveId = reserveDao.addReserveCans(reserve);
				} catch (DBException e1) {
					e1.printStackTrace();
				}
				try {
					totalCanAfterReserve = availableStock - reserve.getReserveCans();
					stockDao.updateStock(totalCanAfterReserve);
				} catch (Exception e) {
					e.printStackTrace();
					throw new SQLException(e.getMessage());
				}
			} else if (reserveId != 0) {
				int userId = reserve.getUserId();
				int reserveCanValue = reserveDao.getReserveCans(userId);
				int totalCanReserve = reserveCanValue + reserve.getReserveCans();
				reserve.setReserveCans(reserveId);
				reserve.setId(reserveId);
				reserveId = reserveDao.updateReserveCans(reserve, totalCanReserve);
				totalCanAfterReserve = availableStock - reserve.getReserveCans();
				stockDao.updateStock(totalCanAfterReserve);

			}
		} else {
			throw new ServiceException("Invalid cans...please check available stock and re enter the value");
		}
		return reserveId;

	}

	public void reserveOrder(Reserve reserve) throws SQLException {
		int reserveId = reserveDao.ReserveId(reserve);
		if (reserveId == reserve.getId());
		{
			int userId = reserve.getUserId();
			int reserveCan = reserveDao.getReserveCans(userId);
			reserveDao.updateStatus(reserve,reserveCan);
			stockDao.updateStock(reserveCan);
			orderDao.addReserveOrder(reserve, reserveCan);
		}
		throw new SQLException("Invalid ReserveId");
	}
	public void modifyOrder(Reserve reserve) throws DBException
	{
		int reserveId = reserveDao.ReserveId(reserve);
		if (reserveId == reserve.getId());
		{
			int userId = reserve.getUserId();
			int reserveCan = reserveDao.getReserveCans(userId);
			orderDao.modifiedReservedCan(reserve,reserveCan);
		}

		throw new DBException("Invalid ReserveId");
	}

}