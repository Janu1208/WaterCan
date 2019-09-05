package com.janu.wms.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.janu.wms.Model.User;
import com.janu.wms.Util.ConnectionUtil;



public class UserDAO {
	public static int id;
	static User user=new User();
	 public void register(User user) throws Exception
	 {
	  Connection con=null;
	  
	  PreparedStatement pst = null;
	  String sql = "insert into User_det(Name,MobileNumber,password) values ( ?,?,?)";
	  
	  try {
	   con = ConnectionUtil.getConnection();
	   pst = con.prepareStatement(sql);
	   pst.setString(1, user.getName());
	   pst.setString(2, user.getPhone_number());
	   pst.setString(3, user.getPassword());
	   
	   int rows = pst.executeUpdate();
	   System.out.println("No of rows inserted:" + rows);
	  } catch (SQLException e) {
	   e.printStackTrace();
	   throw new Exception("Unable to insert user" , e);
	  }
	 }
	 
	 public User login(String name, String setPassword) throws Exception  {
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
				throw new Exception("Unable to login",e);
			}
			
			return user;
}
	 
	 
	 public static User getUserID(String name) {

			Connection con = ConnectionUtil.getConnection();
			String sql = "select * from User_det where Name=?";
			PreparedStatement pst;
			id = 0;
			User user=null;
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, name);
				ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
					
					user = new User();
					user.setId(rs.getInt("User_id"));
					user.setName(rs.getString("name"));
					user.setPhone_number(rs.getString("phone_number"));
					user.setPassword(rs.getString("Password"));
					
					
					}
	         } catch (SQLException e) {

				e.printStackTrace();
			}
	        return user;

		}
}
