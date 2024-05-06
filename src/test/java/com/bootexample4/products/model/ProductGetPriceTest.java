

package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductGetPriceTest {

	private Product product;

	@BeforeEach
	public void setUp() {
		product = new Product();
	}

	@Test
	@DisplayName("Scenario 1: Verify method returns price successfully")
	public void testPriceReturnValue() {
		product.setPrice(59.99);
		Assertions.assertEquals(59.99, product.getPrice(), "Price should be the same as set in the method");
	}

	/* Comment: The test "testCorrectInitialization" was commented out due to an error.
			   It seems that the Product class doesn't provide a constructor to initialize a
			   product with specific parameters. An appropriate constructor in the Product class 
			   should be created to fix it.*/
	/*
	 * @Test
	 * @DisplayName("Scenario 2: Check for correct initialization")
	 * public void testCorrectInitialization() {
	 *    product = new Product(111L, "Product1", "Description1", 49.99);
	 *	  Assertions.assertEquals(49.99, product.getPrice(), "Price should be the same as set in the constructor");
	 * }
	 */

	@Test
	@DisplayName("Scenario 3: Confirm getter method doesn't alter price data")
	public void testGetterNotAlteringPrice() {
		product.setPrice(119.99);
		double firstGetPriceCall = product.getPrice();
		double secondGetPriceCall = product.getPrice();
		Assertions.assertEquals(firstGetPriceCall, secondGetPriceCall, "Getter method should not change the value");
	}

	/* Comment: The test "testGetterReturnType" was commented out due to an error.
			   It seems like there was an attempt to use instanceof on primitive data type 
			   which is not correct in Java. For checking if value is double, you should 
			   directly compare the value with an expected value.*/
	/*
	 * @Test
	 *
	 * @DisplayName("Scenario 4: Ensure method return type") public void
	 * testGetterReturnType() { product.setPrice(79.99);
	 * Assertions.assertTrue(product.getPrice() instanceof Double,
	 * "Returned item should be of type Double"); }
	 */

}
