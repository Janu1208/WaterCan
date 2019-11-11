package com.janu.wms.service;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.User;

public class UserServices {
	static UserDAOImp userDao=new UserDAO();
public  void register(User user)
{
	
	try {
		userDao.register(user);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public  User login(String name,String password)
{
	User user=null;
     try {
		user=userDao.login(name,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return user;
	
}
}
