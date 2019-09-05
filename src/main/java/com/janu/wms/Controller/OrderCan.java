package com.janu.wms.Controller;

import java.util.Scanner;

import com.janu.wms.DAO.OrderDAO;
import com.janu.wms.DAO.StockDAO;
import com.janu.wms.Model.Stock;
import com.janu.wms.Model.User;

public class OrderCan {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
public static void orderCan(User user)
{
	
	
	stock=StockDAO.findavaiability();
	System.out.println("Available cans are:"+Stock.getCans_avail());
	
	
	
	System.out.println("Enter the cans you want to order");
	int cansOrder=sc.nextInt();
	
	while(cansOrder > Stock.getCans_avail() && cansOrder>100) {
		System.out.println("Please order cans between 1 to 100");
		System.out.println("Re-Enter the No of cans Required");
		cansOrder=sc.nextInt();
		}
	
	
		OrderDAO.addOrder(user,cansOrder);
		
		int updateCans=Stock.getCans_avail()-cansOrder;
		
		StockDAO.updateStock(updateCans);
		System.out.println("ORDERED SUCCESSFULY");
		
	
}
}
