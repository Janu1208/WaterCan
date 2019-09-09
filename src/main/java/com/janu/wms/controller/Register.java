package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;
import com.janu.wms.validator.UserValidator;

public class Register {
	static Scanner sc=new Scanner(System.in);
	static StockDAOImp sdao=new StockDAO();
	static UserDAOImp udao=new UserDAO();
	static Stock stock=new Stock();
	
	static User user=new User();
	static String name,password;
	static boolean exit=false;
	static int cans;
	static User register() {
		   
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
	       user.setPhone_number(phone_number);
	       user.setPassword(password);
	       System.out.println(user);
		   while(b==false)
		   {
		   try{
		   UserValidator.passwordValidation(name, password);
	       udao.register(user); // registered users details will insert into User_det table
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
				user=Login.login();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		   
}
}
