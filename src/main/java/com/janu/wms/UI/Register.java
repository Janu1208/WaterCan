package com.janu.wms.UI;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;
import com.janu.wms.service.UserServices;
import com.janu.wms.validator.UserValidator;

public class Register {
	  Scanner sc=new Scanner(System.in);
	 StockDAOImp sdao=new StockDAO();
	 UserDAOImp udao=new UserDAO();
	 Stock stock=new Stock();
	Login login=new Login();
	 User user=new User();
	  String name;
	 String password;
	 boolean exit=false;
	 int cans;
	  User register() {
		   
		   System.out.println("Welcome to register page");
		   boolean b=false;
		   System.out.println("Enter your name");
		    name=sc.next();
		    try {
				UserValidator.validName(name);
				b=true;
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				System.out.println("Re-enter your name");
			    name=sc.next();
			}
		   
		    System.out.println("Enter your phone number");
		   String phone_number=sc.next();
		   try {
			UserValidator.validPhone_number(phone_number);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			System.out.println("Re-enter your phone number");
			   phone_number=sc.next();
		}
		  
		   System.out.println("Set your password");
		    password=sc.next();
		   
	       
	       user.setName(name);
	       user.setPhoneNumber(phone_number);
	       user.setPassword(password);
	       System.out.println(user);
		   if(b==true)
		   {
		   try{
			   UserServices us=new UserServices();
		   us.register(user);
	       b=true;
		   }
		   catch(Exception e)
		   {
		    System.out.println(e.getMessage());
		    System.out.println("Re-enter your password");
		    password=sc.next();
		   }
		   }
		   System.out.println("------REGISTERED SUCCESSFULLY-------");
			try {
				user=login.login();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		   
}
}
