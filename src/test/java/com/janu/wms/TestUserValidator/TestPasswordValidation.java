package com.janu.wms.TestUserValidator;


import org.junit.Test;

import com.janu.wms.validator.UserValidator;

public class TestPasswordValidation {

	@Test
	public void test() {
		String name = "na";
        String password = "12345678A";
        try {
            UserValidator.passwordValidation(name, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
	}
	

}
