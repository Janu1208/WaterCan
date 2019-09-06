package com.janu.wms.validator;

import java.util.Scanner;

public class UserValidator {
	static Scanner sc=new Scanner(System.in);
public static void passValid(String name,String password)
{
 
	 if(name.equals(password))
	 {
		 System.out.println( "User  name and passwword should  not be  equal....please re-enter your password");
		 password=sc.next();
	 }
	 if(password.length() < 8 )
	 {
		 System.out.println("Password should be greater than 8 characters");
		 System.out.println("please re-enter your password");
		 password=sc.next();
	 }
}

public static void validPhone_number(String phone_number)
{
	if(phone_number.length() < 10 || phone_number.length() > 10)
	{
		System.out.println("Invalid phone number");
		System.out.println("Please re-enter a valid phone number");
	}
}

}

