package com.janu.wms.dao;

import com.janu.wms.exception.DBException;
import com.janu.wms.model.User;

public interface UserDAOImp {
	 public void register(User user) throws DBException; 
	 public User login(String name, String setPassword) throws DBException; 
	 public  User getUserID(String name);


	 

}
