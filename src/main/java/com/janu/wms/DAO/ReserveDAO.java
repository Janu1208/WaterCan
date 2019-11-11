package com.janu.wms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Reserve;
import com.janu.wms.util.ConnectionUtil;

public class ReserveDAO implements ReserveDAOImp{
	private final  Reserve reserve=new Reserve();
	 public int addReserveCans(Reserve reserve,int reserveCans) throws DBException
	  {
		 
		  Connection con = ConnectionUtil.getConnection();
			String sql="insert into reserve(user_id,reserve_cans,status) values(?,?,?)";
			PreparedStatement pst = null;
			 int reserveId=0;
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1, reserve.getUserId());
				pst.setInt(2,reserveCans);
				pst.setString(3,"Reserved");
				pst.executeUpdate();
				reserveId=ReserveId(reserve);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DBException("Unable to reserve");
			}
			finally {
				ConnectionUtil.close(con, pst);
			}
			return reserveId;
	  }
	  public int ReserveId(Reserve reserve) {
	      int reserveId = 0;
		  PreparedStatement pst = null;
		  Connection con=null;
	      try {
	          con = ConnectionUtil.getConnection();
	          String sql = "select reserve_id from reserve where user_id=?";
	          pst = con.prepareStatement(sql);
	          pst.setInt(1, reserve.getUserId());
	          ResultSet rs = pst.executeQuery();
	          if (rs.next()) {
	              reserveId = rs.getInt("reserve_id");
	          }
	      } catch (SQLException e) {
	          e.printStackTrace();
	      } finally {
	          ConnectionUtil.close(con, pst);
	      }
	      return reserveId;
	  }


	  
		public int updateReserveCans(Reserve reserve,int reserveCans) throws SQLException
		{
			int reserveId=0;
			Connection con = ConnectionUtil.getConnection();
			String sql="update reserve set reserve_cans=?,status='order pending' where reserve_id=?";
			PreparedStatement pst = null;
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1,reserveCans);
				pst.setInt(2, reserve.getId());
				pst.executeUpdate();
				 reserveId=ReserveId(reserve);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				ConnectionUtil.close(con, pst);
			}
			return reserveId;
		}
		
		public Reserve selectReserve(int userId) throws SQLException
		{
			Connection con = ConnectionUtil.getConnection();
	        String sql="select *from reserve  where user_id=? and status='Reserved', date =current_timestamp()";
	        PreparedStatement pst = null;
	        try {
				pst = con.prepareStatement(sql);
				pst.setInt(1,userId);
				ResultSet rs = pst.executeQuery();
			
				if(rs.next()) {
					reserve.setUserId(rs.getInt("user_id"));
					reserve.setId(rs.getInt("reserve_id"));
					reserve.setReserveCans(rs.getInt("reserve_cans"));
					reserve.setStatus(rs.getString("status"));
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	        finally {
				ConnectionUtil.close(con, pst);
			}
			return reserve;
		}
		
		   public void updateStatus(Reserve reserve,int reserveCans) throws SQLException
		   {
			   Connection con =null;
			    PreparedStatement pst = null;
				con = ConnectionUtil.getConnection();
				String sql = "update reserve set status ='Ordered',reserve_cans=? where reserve_id= ?";
				try {
					pst = con.prepareStatement(sql);
					pst.setInt(1,reserveCans);
					pst.setInt(2,reserve.getId());
					
					pst.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				finally {
					ConnectionUtil.close(con, pst);
				}
			}
	   
	   public int getReserveCans(int userId) {
	       int reserveCan = 0;
	       Connection con=null;
	       PreparedStatement pst=null;
	       try {
	           System.out.println("dao reserve cans");
	           con = ConnectionUtil.getConnection();
	           String sql = "select reserve_cans,status from reserve where user_id=?" ;
	           pst = con.prepareStatement(sql);
	           pst.setInt(1, userId);
	           ResultSet rs = pst.executeQuery();
	           if (rs.next()) {
	               reserveCan = rs.getInt("reserve_cans");
	               reserve.setStatus(rs.getString("status"));
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       } finally {
	           ConnectionUtil.close(con, pst);
	       }
	       return reserveCan;
	   }
	   
	   public int findById(int id) throws SQLException {
			int userId=0;
			Connection con =null;
			PreparedStatement pst = null;
		    con = ConnectionUtil.getConnection();
			String sql = "select * from reserve where User_id=? and status='Order Pending' ";
			try {
				pst = con.prepareStatement(sql);
				pst.setInt(1,id);
				ResultSet rs = pst.executeQuery();
			
				if(rs.next()) {
					 userId = rs.getInt("User_id");
				
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				ConnectionUtil.close(con, pst);
			}
			
			return userId;
		}
}
