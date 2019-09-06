package com.janu.wms.controller;



import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;
import com.janu.wms.validator.UserValidator;




public class WaterCaneSystem {
	static StockDAOImp sdao=new StockDAO();
	static UserDAOImp udao=new UserDAO();
	static Scanner sc = new Scanner(System.in);
	static Stock stock=new Stock();
	
	static User user=new User();
	static String name,password;
	static boolean exit=false;
	static int cans;

	public static void main(String[] args) throws Exception {
		
		
		do {
		System.out.println("Welcome to Water cane management System");
		System.out.println("\n");
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.exit");
		System.out.println("Enter choice(press 1 or 2 or 3");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
              register(); // registration process will ve done here
              break;
		case 2:
			  login(); // login process will be done here...we will have admin login and user login
			  break;
		case 3:
			 System.out.println("Thank you  for choosing our services");
			 break;
	     default:
	    	 System.out.println("please choose either 1 or 2 or 3");
		}
		if(exit)
		{
			break;
		}
		
		}while(true);
	}
	private static User login() throws Exception {
		
		   System.out.println("Welcome to Login Page");
		   System.out.println("Enter your Name :");
		    String name=sc.next();
		   System.out.println("Enter your Password :");
		    String  password=sc.next();
		   if(name.equals("Admin")&& password.equals("$123"))
		   {
			  do{
			   System.out.println("Welcome Admin");
			   System.out.println("1:View stock");
			  
			   System.out.println("2.Available stock");
			   System.out.println("3.Update stock");
			  
			   System.out.println("4.Exit");
		   
			   System.out.println( "enter your choice");
			   int ch4=sc.nextInt();
			   switch(ch4)
			   {
			   case 1:
				   //admin will get  the cans availability
				   stock=sdao.findavaiability();
					System.out.println("Available cans are:"+Stock.getCans_avail());
					break;
			   case 2:
				  
				   System.out.println("Set Availability of cans:");
				   cans=sc.nextInt();
				   System.out.println("Available cans are:"+cans);
				   
				   sdao.availStock(cans); //this method is used to insert the available stock in database..
				   break;
			   case 3:
				   //admin  can update stock here by adding somemore cans
				     StockUpdate.updateStock();
				     break;
			  
			   case 4:
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
			User b= udao.login(name,password); //dao method which will checks registered name and password in database
			
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
					  OrderCan.orderCan(b);
					  break;
				case 2:
					// user can reserve the cans   
					  ReserveCan.reserveCan(b);
					  break;
				case  3:
					//reserved cans will get ordered according to the requirement of the user
					OrderReserveCan.reserveCanOrder(b);
					break;
				case 4:
					  System.out.println("Thank you for using our services");
					  break;
				default:
					 System.out.println("Please choose either 1 or 2 or 3 or 4");
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
			return user;
		   }
		return user;		
	}
	
		  private static void register() {
		   try {
		   System.out.println("Welcome to register page");
		   
		   System.out.println("Enter your name");
		    name=sc.next();
		   
		    System.out.println("Enter your phone number");
		   String phone_number=sc.next();
		   
		   //phone number validations
		   UserValidator.validPhone_number(phone_number);
		  
		   System.out.println("Set your password");
		    password=sc.next();
		    //password validations
		    UserValidator.passValid(name,password);
	       
	       user.setName(name);
	       user.setPhone_number(phone_number);
	       user.setPassword(password);
		   
		   
	       udao.register(user); // registered users details will insert into User_det table
		   }
		   catch(Exception e)
		   {
		    e.printStackTrace();
		   }
		  
		   
}
}
