package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.OrderDAO;
import com.janu.wms.dao.OrderDAOImp;
import com.janu.wms.dao.ReserveDAO;
import com.janu.wms.dao.ReserveDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;

public class OrderCan {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
	static StockDAOImp sdao=new StockDAO();
	static OrderDAOImp odao=new OrderDAO();
	static int rCans;
	static boolean b=true;
	static int updateCans;
	static ReserveDAOImp rdao=new ReserveDAO();

public static void orderCan(User user)
{
	
	
	stock=sdao.findavaiability();
	System.out.println("Available cans are:"+Stock.getCans_avail());
	System.out.println("Enter the cans you want to order");
	int cansOrder=sc.nextInt();
	
	while(cansOrder > Stock.getCans_avail() && cansOrder>100) {
		System.out.println("Please order cans between 1 to 100");
		System.out.println("Re-Enter the No of cans Required");
		cansOrder=sc.nextInt();
		}
	
	odao.addOrder(user,cansOrder);
		
		int updateCans=Stock.getCans_avail()-cansOrder;
		
		sdao.updateStock(updateCans);
		System.out.println("ORDERED SUCCESSFULY");
		
	
}
public static void reserveCan(User user)
{
	stock=sdao.findavaiability(); // it will just gets the available cans from stock table 
	System.out.println("Available cans are:"+Stock.getCans_avail());
	
	System.out.println("only 50 cans can be reserved at a time");
	
	System.out.println("How  many cans you want to reserve?:");
	 rCans=sc.nextInt();
	
	while(rCans>Stock.getCans_avail()&& rCans>50)
	{
		System.out.println("Insufficient cans.....");
		System.out.println("Please reserve the available cans");
		rCans=sc.nextInt();
	}
	
	User u=rdao.selectReserve(User.getId());
	if(u!=null)
	{
		int reservedCans=User.getCans_avail()+rCans;
		if(reservedCans<=50)
		{
			rdao.updateStatus(user,reservedCans);
			int updateCans=Stock.getCans_avail()-rCans;
			sdao.updateStock(updateCans);
			u= rdao.selectReserve(User.getReserve_id());
			System.out.println("Reserved succesfully with id="+u);

		}
		else
		{
			System.out.println("You can reserve only upto 50 cans");
		}
	}
	else
	{
		rdao.addReserveCans(user, rCans);
		int updateCans=Stock.getCans_avail()-rCans;
		sdao.updateStock(updateCans);
	    
	       u= rdao.selectReserve(User.getId());
		  
		   System.out.println("Reserved Succesfully with reserve_id:"+u);
		 }
	   
	   
	}
public static void reserveCanOrder(User user)
{
	boolean b1=true;
	System.out.println("please enter your reservation_id");
	int reserve_id=sc.nextInt();
	User u=rdao.selectReserve(reserve_id);
	while(u==null )
	{
		
		System.out.println( "Invalid reservation id");
		System.out.println("Re  enter your reservation_id");
		reserve_id=sc.nextInt();
		u=rdao.selectReserve(reserve_id);

	}

    int reserveCan=User.getCans_avail();
    System.out.println("Reserved cans are:"+reserveCan);
    System.out.println( );
    
	 while(b1)
	 {
		 System.out.println("Enter the no.of cans to order");
		 int orderedCans=sc.nextInt();
		 if(orderedCans<=reserveCan)
		 {
			 stock=sdao.findavaiability();
			 int addCans=reserveCan-orderedCans;
			 updateCans=Stock.getCans_avail()+addCans;
		 }
		 
		 try
		 {
			 rdao.updateStatus(user, orderedCans);
			 sdao.updateStock(updateCans);
			 odao.addReserveOrder(user, orderedCans);
			b1=false;
		 }
	   catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		 System.out.println("Updated successfully in stock\n");
         System.out.println("------RESERVED CANS ORDERED SUCCCESSFULY-------");
         
         }
}
	
}
