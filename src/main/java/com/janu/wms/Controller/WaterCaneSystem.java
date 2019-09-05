package com.janu.wms.Controller;



import java.util.Scanner;

import com.janu.wms.DAO.StockDAO;
import com.janu.wms.DAO.UserDAO;
import com.janu.wms.Model.User;




public class WaterCaneSystem {
	
	static Scanner sc = new Scanner(System.in);
	static UserDAO dao = new UserDAO();
	
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
              register();
              break;
		case 2:
			  login();
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
			  
			   System.out.println("1.Available stock");
			   System.out.println("2.Update stock");
			   System.out.println("3.Ordered stock");
			   System.out.println("4.Reserved stock");
			   System.out.println("5.Exit");
		   
			   System.out.println( "enter your choice");
			   int ch4=sc.nextInt();
			   switch(ch4)
			   {
			   case 1:
				   System.out.println("Set Availability of cans:");
				   cans=sc.nextInt();
				   System.out.println("Available cans are:"+cans);
				   StockDAO.availStock(cans);
				   break;
			   case 2:
				     StockUpdate.updateStock();
				     break;
			   case 3:
				   //OrderCan.orderCan(user);
				    break;
			   case 4:
				   
				    break;
			   case 5:
				
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
			User b= dao.login(name,password);
			
			if(b!=null){
			  do{
			
				System.out.println("Login  succesfull");
				System.out.println("Welcome to main page");
				
				//System.out.println("1.Available cans");
				System.out.println("1.Order cans ");
				System.out.println("2.Reserve Cans");
				System.out.println("3.exit");
				
				
				System.out.println("enter your choice");
				int ch2=sc.nextInt();
				switch(ch2)
				{
				/*case 1:
					  StockDAO.findavaiability();
					  System.out.println("Available cans are"+Stock.getCans_avail());
					  //StockDAO.availStock(cans);
					  break;*/
				case 1:
					  
					  OrderCan.orderCan(b);
					  break;
				case 2:
					 
					  break;
				case 3:
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
		   user=UserDAO.getUserID(name);
			System.out.println("Your User id is:"+user.getId());
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
		   System.out.println("Set your password");
		    password=sc.next();
		   
	       
	       user.setName(name);
	       user.setPhone_number(phone_number);
	       user.setPassword(password);
		   
		   
		   dao.register(user);
		   }
		   catch(Exception e)
		   {
		    e.printStackTrace();
		   }
		  
		   
}
}
