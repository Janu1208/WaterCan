package com.janu.WaterCaneManagementSystem.Controller;

import java.util.Scanner;

import com.janu.WaterCaneManagementSystem.DAO.StockDAO;
import com.janu.WaterCaneManagementSystem.Model.Stock;

public class StockUpdate {
	static Scanner sc=new Scanner(System.in);
	static Stock stock=new Stock();
public static  void updateStock()
{
	
	
	stock=StockDAO.findavaiability();
	System.out.println("Available cans are:"+Stock.getCans_avail());
	System.out.println("Enter the no of cans to be added:");
	int cansAdd=sc.nextInt();
	
	int total=Stock.getCans_avail()+cansAdd;
	StockDAO.updateStock(total);
	System.out.println("STOCK UPDATED SUCCESSFULLY");
	
	stock=StockDAO.findavaiability();
	System.out.println("Available cans after update:"+Stock.getCans_avail());
	
	
}
}
