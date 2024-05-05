

package com.bootexample4.products.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ProductTest{

	private Product product;

	@BeforeEach
	public void setUp() {
		product = new Product();
	}

	@Test
	public void testGetNameInNormalConditions(){
		String testName = "TestName";
		product.setName(testName);
		Assertions.assertEquals(testName, product.getName(), "The Name value does not match expected value!");
	}

	@Test
	public void testGetNameForDefaultValue(){
		Assertions.assertNull(product.getName(), "Default Name value is not null!");
	}

	@Test
	public void testGetNameWithEmptyValue(){
		product.setName("");
		Assertions.assertEquals("", product.getName(), "Name value is not an empty string!");
	}
}
