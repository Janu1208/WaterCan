package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.OrderDAO;
import com.janu.wms.dao.OrderDAOImp;
import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.Stock;
import com.janu.wms.model.User;

public class OrderCan {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
	static StockDAOImp sdao=new StockDAO();
	static OrderDAOImp odao=new OrderDAO();
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
}
