package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.Stock;

public class StockUpdate {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
	static StockDAOImp sdao =new StockDAO();
public static  void updateStock()
{
	
	
	stock=sdao.findavaiability();
	System.out.println("Available cans are:"+Stock.getCans_avail());
	System.out.println("Enter the no of cans to be added:");
	int cansAdd=sc.nextInt();
	
	int total=Stock.getCans_avail()+cansAdd;
	sdao.updateStock(total);
	System.out.println("STOCK UPDATED SUCCESSFULLY");
	
	stock=sdao.findavaiability();
	System.out.println("Available cans after update:"+Stock.getCans_avail());
	
}
}
