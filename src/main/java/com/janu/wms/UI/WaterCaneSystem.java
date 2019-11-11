package com.janu.wms.UI;

import java.util.Scanner;

public class WaterCaneSystem {
	  Scanner sc = new Scanner(System.in);
	 Register  register=new Register();
	 Login login=new Login();
      boolean validInput = true;
      String choice;
      int ch = 0;
		static WaterCaneSystem waterCan=new WaterCaneSystem();
	public static void main(String[] args) {
		waterCan.waterCaneProject();
	}
	public void handleException()
	{
		
		try {
			ch = Integer.parseInt(choice);
			validInput = true;
		} catch (Exception e) {
			System.out.println("Invalid Choice-..... Please try again");
			validInput = false;
		}
	}
    public void waterCaneProject()
    {
    	

		do {
			System.out.println("Welcome to Water cane management System");
			System.out.println("\n");
			System.out.println("1.Register");
			System.out.println("2.Login");
			System.out.println("3.exit");
			System.out.println("Enter choice(press 1 or 2 or 3)");
			 choice= sc.next();

			
			waterCan.handleException();
			switch (ch) {
			case 1:
				register.register(); // registration process will ve done
										// here
				break;
			case 2:
				login.login(); // login process will be done here...we will
								// have admin login and user login
				break;
			case 3:
				System.out.println("Thank you  for choosing our services");
				break;
			default:
				System.out.println("please choose either 1 or 2 or 3");
				validInput = false;
				break;
			}

		} while (!validInput);
    }
}
