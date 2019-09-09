package com.janu.wms.TestUserValidator;


import org.junit.Test;

import com.janu.wms.validator.UserValidator;

public class TestNameValidation {

	@Test
	public void test() {
		String name = "na123";
		try {
			UserValidator.validName(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
