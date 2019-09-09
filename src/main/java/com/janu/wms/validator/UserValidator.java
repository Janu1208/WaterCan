package com.janu.wms.validator;

import java.util.Scanner;

public class UserValidator {
	static Scanner sc=new Scanner(System.in);

	public static void passwordValidation(String userName, String password) throws Exception
	   {
	        System.out.println("Username:" + userName + ",password:" + password);
	           if (password.length() > 15 || password.length() < 8)
	           {
	                   throw new Exception("Password should be less than 15 and more than 8 characters in length.");
	           }
	           if (password.indexOf(userName) > -1)
	           {
	                   throw new Exception("Password Should not be same as user name");
	           }
	           String upperCaseChars = "(.[A-Z].)";
	           if (!password.matches(upperCaseChars ))
	           {
	                   throw new Exception("Password should contain atleast one upper case alphabet");
	           }
	           String lowerCaseChars = "(.[a-z].)";
	           if (!password.matches(lowerCaseChars ))
	           {
	                   throw new Exception("Password should contain atleast one lower case alphabet");
	           }
	           String numbers = "(.[0-9].)";
	           if (!password.matches(numbers ))
	           {
	                   throw new Exception("Password should contain atleast one number.");
	           }
	           String specialChars = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
	           if (!password.matches(specialChars ))
	           {
	                   throw new Exception("Password should contain atleast one special character");
	           }
	   }


public static void validPhone_number(String phone_number) throws Exception
{
	if(phone_number.length() < 10 || phone_number.length() > 10)
	{
		throw new Exception("Invalid phone number");
		
	}
}
public static void validName(String name) throws Exception
{
	String numbers = "(.[0-9].)";
    if (name.matches(numbers ))
    {
            throw new Exception("Name should not contains numeric values");
    }
    String specialChars = "(.[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
    if (name.matches(specialChars ))
    {
            throw new Exception("Name should not contains special character");
    }
}
}

