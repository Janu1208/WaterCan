package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;

public class Login {
	static Scanner sc=new Scanner(System.in);
	static StockDAOImp sdao=new StockDAO();
	static UserDAOImp udao=new UserDAO();
	static Stock stock=new Stock();
	
	static User user=new User();
	static String name,password;
	static boolean exit=false;
	static int cans;
	static User login() {
		
		   System.out.println("Welcome to Login Page");
		   System.out.println("1.Admin Login");
		   System.out.println("2.User login");
		   System.out.println("Enter your choice");
		   int ch = sc.nextInt();
		   
		   System.out.println("Enter your Name :");
		    String name=sc.next();
		   System.out.println("Enter your Password :");
		    String  password=sc.next();
		   if(name.equals("Admin")&& password.equals("$123"))
		   {
			  do{
			   System.out.println("Welcome Admin");
			   System.out.println("1:View stock");
			  
			   System.out.println("2.Set Available stock");
			  
			   System.out.println("3.Exit");
		   
			   System.out.println( "enter your choice");
			   int ch4=sc.nextInt();
			   switch(ch4)
			   {
			   case 1:
				  ViewStock.stockView();
					break;
			   case 2:
				  
				   StockUpdate.updateStock();
				   
				   break;
			  
			  
			   case 3:
				     System.out.println("Thank you for choosing our services");
				    break;
			  
			   default:
			    	 System.out.println("please choose either  1 or 2 or 3 or 4 or 5");
			    	 break;
				}
				if(exit)
				{
					break;
				}
		   }while(true);
		   }
	
		
		   else{	  
		    
		   try {
			User b= udao.login(name,password);
			//dao method which will checks registered name and password in database
			
			if(b!=null){
			  do{
			
				System.out.println("Login  succesfull");
				System.out.println("Welcome to main page");
				
				System.out.println("1.Order cans ");
				System.out.println("2.Reserve Cans");
				System.out.println("3.Order Reserved Cans");
				System.out.println("4.exit");
				
				
				System.out.println("enter your choice");
				int ch2=sc.nextInt();
				switch(ch2)
				{
				case 1:
					  //user can order cans
					  OrderCan.orderCan(user);
					  break;
				case 2:
					// user can reserve the cans   
					  OrderCan.reserveCan(b);
					  break;
				case  3:
					//reserved cans will get ordered according to the requirement of the user
					OrderCan.reserveCanOrder(b);
					break;
				case 4:
					  System.out.println("Thank you for using our services");
					  break;
				default:
					 System.out.println("Please choose either 1 or 2 or 3 or 4");
				}
				if(exit)
				{
					break;
				}
			  
			}while(true);
			}
			else{
				System.out.println("Invalid username or password");
			}
		   }
			catch (Exception e) {
         e.printStackTrace();
		   }	
		   user=udao.getUserID(name);
			System.out.println("Your User id is:"+User.getId());
			
		   }
		return user;		
	}
}
