package com.janu.wms.dao;

import com.janu.wms.model.User;

public interface UserDAOImp {
	 public void register(User user) throws Exception; 
	 public User login(String name, String setPassword) throws Exception; 
	 public  User getUserID(String name);


	 

}
