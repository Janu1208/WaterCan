package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Order;
import com.janu.wms.model.Reserve;
import com.janu.wms.util.ConnectionUtil;
import com.janu.wms.util.ErrorConstants;


public class OrderDAO implements OrderDAOImp
{
	Order order=new Order();
	Reserve reserve=new Reserve();
	Connection con=null;
	PreparedStatement pst = null;
	public  void addOrder(Order order,int cansAvail) throws DBException
	{
	 con = ConnectionUtil.getConnection();
	String sql="insert into order_det(user_id,order_cans) values(?,?)";
	
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1, order.getId());
		pst.setInt(2,cansAvail);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Unable to order");
	}
	finally {
		ConnectionUtil.close(con, pst);
	}
	}
public void addReserveOrder(Reserve reserve,int reserveCanValue) throws SQLException {
		
		
		con = ConnectionUtil.getConnection();
		String sql = "insert into order_det(user_id,reserve_id,order_cans) values (?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, reserve.getUserId());
			pst.setInt(2, reserve.getId());
			pst.setInt(3,reserveCanValue);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(ErrorConstants.ORDERRESERVEDCANS,e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
public void modifiedReservedCan(Reserve reserve,int reserveCan) throws DBException {

	try {
		con = ConnectionUtil.getConnection();
		String sql = "insert into order_det(user_id,order_cans) values(?,?)";
		pst = con.prepareStatement(sql);
		pst.setInt(1, reserve.getUserId());
		pst.setInt(2, reserve.getReserveCans());
		pst.executeUpdate();
	} catch (SQLException e) {
		throw new DBException("Unable to order",e);
	} finally {
		ConnectionUtil.close(con, pst);
	}
}
	
	
}
