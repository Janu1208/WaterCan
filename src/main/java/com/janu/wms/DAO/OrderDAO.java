package com.janu.wms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.janu.wms.Model.User;
import com.janu.wms.Util.ConnectionUtil;

public class OrderDAO 
{
	public static void addOrder(User user,int cans_avail)
	{
	Connection con = ConnectionUtil.getConnection();
	String sql="insert into order_det(user_id,order_cans) values(?,?)";
	PreparedStatement pst;
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1, user.getId());
		pst.setInt(2,cans_avail);
		pst.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException("Unable to order");
	}
	}
}
