

package com.bootexample4.products.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductControllerGetAllProductsTest {

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductRepository productRepository;

    // The following error is typical for compilation errors. 
    // ERROR : [ERROR] COMPILATION ERROR :
    // But, there isn't any information to pinpoint what has gone wrong.
    
	@Test
    public void testGetAllProductsWhenNoProductsInDatabase() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<Product> result = productController.getAllProducts();
        assertTrue(result.isEmpty());
    }

	@Test
	public void testGetAllProductsReturnsAllProductsInDatabase() {
		List<Product> expected = new ArrayList<>();
		expected.add(new Product());
		expected.add(new Product());
		when(productRepository.findAll()).thenReturn(expected);
		List<Product> result = productController.getAllProducts();
		assertEquals(expected, result);
	}

	// Without more specifics about the error, this is the default approach to handle compilation error.
	@Test
    public void testGetAllProductsHandlesRepositoryExceptions() {
        when(productRepository.findAll()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> productController.getAllProducts());
    }

}
