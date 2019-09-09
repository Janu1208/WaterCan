package com.janu.wms.TestUserValidator;


import org.junit.Test;

import com.janu.wms.validator.UserValidator;

public class TestMobileNumberValidation {

	@Test
	public void test() {
		String phone_number="7550122996";
		try {
			UserValidator.validPhone_number(phone_number);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
