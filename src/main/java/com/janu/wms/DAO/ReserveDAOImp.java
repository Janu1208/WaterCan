package com.janu.wms.dao;

import com.janu.wms.model.User;

public interface ReserveDAOImp {
	  public void addReserveCans(User user,int reserve_cans);
		public void updateReserveCans(User user,int reserve_cans);
		public User selectReserve(int reserve_id);
		   public void updateStatus(User user,int order_cans);

}
