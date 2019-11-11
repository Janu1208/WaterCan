package com.janu.wms.UI;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.Stock;

public class StockUpdate {
	 Scanner sc=new Scanner(System.in);
	 Stock stock=new Stock();
	 StockDAOImp sdao =new StockDAO();
	 int availableCans;
public void updateStock()
{	
	availableCans=sdao.findavaiability();
	System.out.println("Available cans are:"+availableCans);
	System.out.println("Enter the no of cans to be added:");
	int cansAdd=sc.nextInt();
	
	int total=stock.getCansAvail()+cansAdd;
	sdao.updateStock(total);
	System.out.println("STOCK UPDATED SUCCESSFULLY");
	
	availableCans=sdao.findavaiability();
	System.out.println("Available cans after update:"+stock.getCansAvail());
	
}
}
