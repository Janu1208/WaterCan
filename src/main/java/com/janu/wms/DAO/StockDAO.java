package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.janu.wms.model.Stock;
import com.janu.wms.util.ConnectionUtil;

public class StockDAO implements StockDAOImp {
public  Stock findavaiability(){
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from stock";
		PreparedStatement pst = null;
		Stock stock=null;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				stock = new Stock();
				stock.setCans_avail(rs.getInt("cans_avail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		return stock;
	}
	 public void  availStock(int cans) throws Exception
	 {
		 Connection con=null;
		  PreparedStatement pst = null;
		  String sql = "insert into stock(cans_avail) values ( ?)";
		  
		  try {
		   con = ConnectionUtil.getConnection();
		   pst = con.prepareStatement(sql);
		   pst.setInt(1, cans);
		  
		   int  rows= pst.executeUpdate();
		   System.out.println("No of rows inserted:" + rows);
		  } catch (SQLException e) {
		   e.printStackTrace();
		   throw new Exception("Unable to insert " , e);
		  }
		  finally {
				ConnectionUtil.close(con, pst);
			}
	 }
	 
	 public void updateStock(int cans) {
			
			Connection con = ConnectionUtil.getConnection();
			String sql = "update stock set cans_avail=? ";
			PreparedStatement pst = null;
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1,cans);
				pst.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			finally {
				ConnectionUtil.close(con, pst);
			}
			
		}
	 
}
