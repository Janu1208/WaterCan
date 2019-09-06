package com.janu.wms.controller;

import java.util.Scanner;

import com.janu.wms.dao.ReserveDAO;
import com.janu.wms.dao.ReserveDAOImp;
import com.janu.wms.model.User;

public class OrderReserveCan {
	static ReserveDAOImp rdao=new ReserveDAO();
	static Scanner sc=new Scanner(System.in);
public static void reserveCanOrder(User user)
{
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
	
	
	rdao.addReserveCans(u,User.getId());
	rdao.updateStatus(u);
	System.out.println("Reserved Cans ordered  succesfully...");
	
	
}
}
