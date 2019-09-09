package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.User;
import com.janu.wms.util.ConnectionUtil;

public class OrderDAO implements OrderDAOImp
{
	public  void addOrder(User user,int cans_avail)
	{
	Connection con = ConnectionUtil.getConnection();
	String sql="insert into order_det(user_id,order_cans) values(?,?)";
	PreparedStatement pst = null;
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1, User.getId());
		pst.setInt(2,cans_avail);
		//pst.setInt(3, User.getReserve_id());
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Unable to order");
	}
	finally {
		ConnectionUtil.close(con, pst);
	}
	}
public void addReserveOrder(User user,int order_cans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "insert into order_det(user_id,reserve_id,order_cans) values"
				+ "(?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, User.getId());
			pst.setInt(2, User.getReserve_id());
			pst.setInt(3,order_cans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to order Reserved Cans",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
	
	
}
