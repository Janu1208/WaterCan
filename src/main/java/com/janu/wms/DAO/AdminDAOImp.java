package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Admin;
import com.janu.wms.util.ConnectionUtil;
import com.janu.wms.util.ErrorConstants;

public class AdminDAOImp implements AdminDAO {
	 public Admin login(String Name, String Password) throws DBException  {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			Admin admin = null;
			
			try {
				con = ConnectionUtil.getConnection();
				String sql = "select * from Admin where Name = ? and Password = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, Name);
				pst.setString(2,Password );
				rs = pst.executeQuery();
				if(rs.next()) {
					admin = new Admin();
				
					admin.setName(rs.getString("Name"));
					admin.setPassword(rs.getString("Password"));
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new DBException(ErrorConstants.DBLOGIN,e);
			}
			
			return admin;
}
}