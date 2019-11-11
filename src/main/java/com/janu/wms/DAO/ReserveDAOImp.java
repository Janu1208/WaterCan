package com.janu.wms.dao;

import java.sql.SQLException;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.Reserve;

public interface ReserveDAOImp {
	 public int addReserveCans(Reserve reserve,int reserveCans) throws DBException;
	  public int ReserveId(Reserve reserve);
	  public int updateReserveCans(Reserve reserve,int reserveCans) throws SQLException;
	  public Reserve selectReserve(int userId) throws SQLException;
	  public void updateStatus(Reserve reserve,int reserveCans) throws SQLException;
	  public int getReserveCans(int userId);
	  public int findById(int id) throws SQLException;

}
