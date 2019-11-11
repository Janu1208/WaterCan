package com.janu.wms.UI;

import java.sql.SQLException;
import java.util.Scanner;

import com.janu.wms.dao.OrderDAO;
import com.janu.wms.dao.OrderDAOImp;
import com.janu.wms.dao.ReserveDAO;
import com.janu.wms.dao.ReserveDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.exception.DBException;
import com.janu.wms.model.Order;
import com.janu.wms.model.Reserve;
import com.janu.wms.model.Stock;

public class OrderCan {
	 Scanner sc=new Scanner(System.in);
	 Stock stock=new Stock();
	 StockDAOImp sdao=new StockDAO();
	 OrderDAOImp odao=new OrderDAO();
	 int rCans;
	 boolean b=true;
	 int updateCans;
	int availableCans;
	 ReserveDAOImp rdao=new ReserveDAO();

public void orderCan(Order order)
{
	availableCans=sdao.findavaiability();
	System.out.println("Available cans are:"+availableCans);
	System.out.println("Enter the cans you want to order");
	int cansOrder=sc.nextInt();
	
	while(cansOrder > stock.getCansAvail() && cansOrder>100) {
		System.out.println("Please order cans between 1 to 100");
		System.out.println("Re-Enter the No of cans Required");
		cansOrder=sc.nextInt();
		}
	
	try {
		odao.addOrder(order,cansOrder);
	} catch (DBException e) {
		e.printStackTrace();
	}
		
		int updateCans=stock.getCansAvail()-cansOrder;
		
		sdao.updateStock(updateCans);
		System.out.println("ORDERED SUCCESSFULY");
		
	
}
public void reserveCan(Reserve reserve)
{
	availableCans=sdao.findavaiability(); // it will just gets the available cans from stock table 
	System.out.println("Available cans are:"+availableCans);
	
	System.out.println("only 50 cans can be reserved at a time");
	
	System.out.println("How  many cans you want to reserve?:");
	 rCans=sc.nextInt();
	
	while(rCans>stock.getCansAvail()&& rCans>50)
	{
		System.out.println("Insufficient cans.....");
		System.out.println("Please reserve the available cans");
		rCans=sc.nextInt();
	}
	
	Reserve res = null;
	try {
		res = rdao.selectReserve(reserve.getUserId());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if(res!=null)
	{
		int reservedCans=stock.getCansAvail()+rCans;
		if(reservedCans<=50)
		{
			try {
				rdao.updateStatus(reserve,reservedCans);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			int updateCans=stock.getCansAvail()-rCans;
			sdao.updateStock(updateCans);
			try {
				res= rdao.selectReserve(reserve.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Reserved succesfully with id="+res);

		}
		else
		{
			System.out.println("You can reserve only upto 50 cans");
		}
	}
	else
	{
		try {
			rdao.addReserveCans(reserve, rCans);
		} catch (DBException e) {
			e.printStackTrace();
		}
		int updateCans=stock.getCansAvail()-rCans;
		sdao.updateStock(updateCans);
	    
	       try {
			res= rdao.selectReserve(reserve.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		   System.out.println("Reserved Succesfully with reserve_id:"+res);
		 }
	   
	   
	}
public  void reserveCanOrder(Reserve reserve)
{
	boolean b1=true;
	System.out.println("please enter your reservation_id");
	int reserve_id=sc.nextInt();
	Reserve res = null;
	try {
		res = rdao.selectReserve(reserve_id);
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	while(res==null )
	{
		
		System.out.println( "Invalid reservation id");
		System.out.println("Re  enter your reservation_id");
		reserve_id=sc.nextInt();
		try {
			res=rdao.selectReserve(reserve_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    int reserveCan=stock.getCansAvail();
    System.out.println("Reserved cans are:"+reserveCan);
    System.out.println( );
    
	 while(b1)
	 {
		 System.out.println("Enter the no.of cans to order");
		 int orderedCans=sc.nextInt();
		 if(orderedCans<=reserveCan)
		 {
			 availableCans=sdao.findavaiability();
			 int addCans=reserveCan-orderedCans;
			 updateCans=stock.getCansAvail()+addCans;
		 }
		 
		 try
		 {
			 rdao.updateStatus(reserve, orderedCans);
			 sdao.updateStock(updateCans);
			 odao.addReserveOrder(reserve, orderedCans);
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
