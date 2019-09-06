package com.janu.wms.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.janu.wms.model.User;

public class TestUserDAO {
	@Test
public  void testValidLogin()
{
	UserDAOImp udao=new UserDAO();
	String name="janshi";
	String password="janu";
	User user=null;
	
		try {
			user=udao.login( name, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    assertNotNull(user);

}
@Test
public void testInValidLogin() {

	String email = "";
	String password = "";
	UserDAO userDAO = new UserDAO();
	User user = null;
	
		try {
			user = userDAO.login(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	assertNull(user);
}
}
