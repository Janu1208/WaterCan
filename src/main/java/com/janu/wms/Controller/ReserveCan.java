package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.ReserveDAO;
import com.janu.wms.dao.ReserveDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;

public class ReserveCan {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
	
public static void reserveCan(User user)
{
	StockDAOImp sdao=new StockDAO();
	stock=sdao.findavaiability(); // it will just gets the available cans from stock table 
	System.out.println("Available cans are:"+Stock.getCans_avail());
	
	System.out.println("only 50 cans can be reserved at a time");
	
	System.out.println("How  many cans you want to reserve?:");
	int rCans=sc.nextInt();
	
	while(rCans>Stock.getCans_avail()&& rCans>50)
	{
		System.out.println("Insufficient cans.....");
		System.out.println("Please reserve the available cans");
		rCans=sc.nextInt();
	}
	ReserveDAOImp rdao=new ReserveDAO();
	//User obj=new User();
	
	User u=rdao.selectReserve(User.getId());
	if(u!=null)
	{
		int reservedCans=user.getCans_avail()+rCans;
		if(reservedCans<=50)
		{
			rdao.updateStatus(user);
			int updateCans=Stock.getCans_avail()-rCans;
			sdao.updateStock(updateCans);
			u= rdao.selectReserve(User.getId());
			System.out.println("Reserved succesfully with id="+User.getId());

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
		  
		   System.out.println("Reserved Succesfully with reserve_id:"+User.getId());
		 }
	   
	   
	}
	
	
}




