

package com.bootexample4.products.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductSetDescriptionTest {

	private Product product;

	@BeforeEach
	public void setup() {
		product = new Product();
	}

	@Test
	public void testSetDescriptionWithNormalInput() {
		String description = "Product description";
		product.setDescription(description);
		assertEquals(description, product.getDescription());
	}

	@Test
	public void testSetDescriptionWithNullInput() {
		product.setDescription(null);
		assertEquals(null, product.getDescription());
	}

	@Test
	public void testSetDescriptionWithEmptyString() {
		product.setDescription("");
		assertTrue(product.getDescription().isEmpty());
	}

}
