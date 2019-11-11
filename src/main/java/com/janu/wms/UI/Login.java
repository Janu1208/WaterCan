package com.janu.wms.UI;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.dao.UserDAO;
import com.janu.wms.dao.UserDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;
import com.janu.wms.service.UserServices;

public class Login {
	ViewStock viewStock=new ViewStock();
	User users=new User();
	 Scanner sc=new Scanner(System.in);
	 StockDAOImp sdao=new StockDAO();
	 UserDAOImp udao=new UserDAO();
	 Stock stock=new Stock();
	 boolean validInput = true;
    int ch = 0;
	 User user=new User();
	 String name,password;
	 boolean exit=false;
	 int cans;
	 User login() {
		
		   System.out.println("Welcome to Login Page");
		   System.out.println("1.Admin Login");
		   System.out.println("2.User login");
		   System.out.println("Enter your choice");
		   ch = sc.nextInt();
		   
		   System.out.println("Enter your Name :");
		    String name=sc.next();
		   System.out.println("Enter your Password :");
		    String  password=sc.next();
		   if(name.equals("Admin")&& password.equals("$123"))
		   {
			   WaterCaneSystem.handleException();
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
				   viewStock.stockView();
					break;
			   case 2:
				  
				   StockUpdate.updateStock();
				   
				   break;
			  
			  
			   case 3:
				     System.out.println("Thank you for choosing our services");
					  WaterCaneSystem.waterCaneProject();

				    break;
			  
			   default:
			    	 System.out.println("please choose either  1 or 2 or 3 or 4 or 5");
			    	 break;
				}
				if(exit)
				{
					break;
				}
		   }while(!validInput);
		   }
	
		
		   else{	  
		    
		   try {
			   UserServices us=new UserServices();
			   User b=us.login(name,password);
			if(b!=null){
				   WaterCaneSystem.handleException();

			  do{
			
				System.out.println("Login  succesfull");
				System.out.println("Welcome to main page");
				
				System.out.println("1.Order cans ");
				System.out.println("2.Reserve Cans");
				System.out.println("3.Order Reserved Cans");
				System.out.println("4.Cancel ordered cans");
				System.out.println("5.exit");
				
				
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
					  
					  break;
				case 5:
					  System.out.println("Thank you for using our services");
					  WaterCaneSystem.waterCaneProject();
					  break;
				default:
					 System.out.println("Please choose either 1 or 2 or 3 or 4");
				}
				if(exit)
				{
					break;
				}
			  
			}while(!validInput);
			}
			else{
				System.out.println("Invalid username or password");
			}
		   }
			catch (Exception e) {
         e.printStackTrace();
		   }	
		   user=udao.getUserID(name);
			System.out.println("Your User id is:"+users.getId());
			
		   }
		return user;		
	}
}
