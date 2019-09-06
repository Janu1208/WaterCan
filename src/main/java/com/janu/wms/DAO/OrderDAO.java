package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Unable to order");
	}
	finally {
		ConnectionUtil.close(con, pst);
	}
	}

	
}
