package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.StockDAO;
import com.janu.wms.dao.StockDAOImp;
import com.janu.wms.model.User;

public class Cancelled_order {
	static StockDAOImp sdao=new StockDAO();
	static Scanner sc=new Scanner(System.in);
public static void cancellOrder()
{
	do{
	System.out.println("Do you want to cancel the order for sure if Yes(1)/No(2)");
	System.out.println("Enter your choice :"); 
	int  ch=sc.nextInt();
	switch(ch)
	{
	case 1:
		 System.out.println("how many cans you want to cancel?");
		 int cancel_cans=sc.nextInt();
		 int updateCans=User.getCans_avail()+cancel_cans;
		 System.out.println("your ordered cancelled succesfully....");
		 sdao.updateStock(updateCans);
		 break;
	case 2:
		 Login.login();
		 break;
	 default:
		System.out.println("please choose either 1 or 2");
		break;
		 
	}
	}while(true);
}
}
