package com.janu.wms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.User;
import com.janu.wms.util.ConnectionUtil;



public class UserDAO implements UserDAOImp{
	private final User user=new User();
	 public void register(User user) throws DBException
	 {
	  Connection con=null;
	  
	  PreparedStatement pst = null;
	  String sql = "insert into User_det(Name,MobileNumber,password) values ( ?,?,?)";
	  
	  try {
	   con = ConnectionUtil.getConnection();
	   pst = con.prepareStatement(sql);
	   pst.setString(1, user.getName());
	   pst.setString(2, user.getPhoneNumber());
	   pst.setString(3, user.getPassword());
	   
	   int rows = pst.executeUpdate();
	   System.out.println("No of rows inserted:" + rows);
	  } catch (SQLException e) {
	   e.printStackTrace();
	   throw new DBException("Unable to insert user" , e);
	  }
	 }
	 
	 public User login(String name, String setPassword) throws DBException  {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			User user = null;
			
			try {
				con = ConnectionUtil.getConnection();
				String sql = "select * from User_det where Name = ? and password = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, setPassword);
				rs = pst.executeQuery();
				if(rs.next()) {
					user = new User();
					user.setId(rs.getInt("ID"));
					user.setName(rs.getString("Name"));
					user.setPassword(rs.getString("password"));
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new DBException("Unable to login",e);
			}
			
			return user;
}
	 
	 
	 public  User getUserID(String name) {

			Connection con = ConnectionUtil.getConnection();
			String sql = "select * from User_det where Name=?";
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, name);
				ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
					user.setId(rs.getInt("ID"));
					user.setName(rs.getString("Name"));
					user.setPhoneNumber(rs.getString("MobileNumber"));
					user.setPassword(rs.getString("password"));
					
					
					}
	         } catch (SQLException e) {

				e.printStackTrace();
			}
	        return user;

		}
}
