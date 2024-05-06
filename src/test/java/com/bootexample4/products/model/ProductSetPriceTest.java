

package com.bootexample4.products.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductSetPriceTest {

	Product product;

	@BeforeEach
	public void setProductInstance() {
		product = new Product();
	}

	@Test
	public void testSetPriceOnNormalValues() {
		// Arrange
		double price = 100.0;
		// Act
		product.setPrice(price);
		// Assert
		Assertions.assertEquals(price, product.getPrice(), "The price set should be the same as the price gotten");
	}

	// Business logic needs to be updated to handle negative prices
	// Currently, the function does not throw IllegalArgumentException for negative prices
	// Suggest updating the setPrice function to throw IllegalArgumentException when price
	// is negative
	@Test
	public void testSetPriceOnNegativeValues() {
		// Arrange
		double price = -100.0;
		// Act
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			product.setPrice(price);
		}, "Should throw an IllegalArgumentException when the price set is negative");
	}

	@Test
	public void testSetPriceOnLargeValues() {
		// Arrange
		double price = Double.MAX_VALUE;
		// Act
		product.setPrice(price);
		// Assert
		Assertions.assertEquals(price, product.getPrice(), "The price set should be the same as the price gotten");
	}

	@Test
	public void testSetPriceOnZero() {
		// Arrange
		double price = 0.0;
		// Act
		product.setPrice(price);
		// Assert
		Assertions.assertEquals(price, product.getPrice(), "The price set should be the same as the price gotten");
	}

}
