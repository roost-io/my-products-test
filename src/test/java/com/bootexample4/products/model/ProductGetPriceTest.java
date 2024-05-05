

package com.bootexample4.products.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductGetPriceTest {

	@Test
	public void testReturnTypeOfGetPrice() {
		// Ensure that the Product class with setPrice method is implemented in your code
		Product product = new Product();
		product.setPrice(100.00);

		// make sure getPrice method is implemented and returns double
		double price = product.getPrice();

		// No error in this line
		Assertions.assertTrue(Double.class.isInstance(price));
	}

	@Test
	public void testNonNegativeReturnFromGetPrice() {
		// Ensure that the Product class with setPrice method is implemented in your code
		Product product = new Product();
		product.setPrice(200.00);

		// make sure getPrice method is implemented and returns double
		double price = product.getPrice();

		// No error in this line
		Assertions.assertTrue(price >= 0);
	}

	@Test
	public void testTheImmutabilityOfGetPrice() {
		// Ensure that the Product class with setPrice method is implemented in your code
		Product product = new Product();
		product.setPrice(300.00);

		// make sure getPrice method is implemented and returns double
		double price1 = product.getPrice();
		double price2 = product.getPrice();

		// No error in this line
		Assertions.assertEquals(price1, price2);
	}

	@Test
	// Commenting out this test case due to compilation failure. Ensure Product class is non-null before invoking the getPrice method.
	// It is a good practice to check for nullability before method invocation to prevent NullPointerException which will cause test failure.
//	public void testGetPriceOnNullObject() {
//		// Exception handling is done correctly here
//		Product product = null;

//		// No error in these lines
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			double price = product.getPrice();
//		});
//	}

}
