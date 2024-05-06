

package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerGetProductByIdTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductController productController;

	//Compilation Failure: The MockitoJUnitRunner.class import is not handled properly, It will fail the test compilation because Junit 5 (Jupiter) does not use a runner for running the tests, it uses @ExtendWith().
        //To fix this issue, replace @RunWith(MockitoJUnitRunner.class) with @ExtendWith(MockitoExtension.class).
	@Test
	public void getProductByIdWithValidId() {
		Long productId = 1L;
		Product product = new Product();
		product.setId(productId);
		when(productRepository.findById(productId)).thenReturn(Optional.of(product));
		ResponseEntity<Product> response = productController.getProductById(productId);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(product, response.getBody());
	}

        // Compilation Failure: If a null value is passed into the getProductById function it won't compile due to a NullPointerException because the function is not handling null values. A null check is missing in the code.
        //To fix this, add the null check inside the function before the findById call.
	@Test
	public void getProductByIdWithNullId() {
		assertThrows(IllegalArgumentException.class, () -> {
			productController.getProductById(null);
		});
	}

	@Test
	public void getProductByIdWithNonExistingId() {
		Long productId = 1L;
		when(productRepository.findById(productId)).thenReturn(Optional.empty());
		ResponseEntity<Product> response = productController.getProductById(productId);
		assertNotNull(response);
		assertEquals(404, response.getStatusCodeValue());
	}

	@Test
	public void getProductByIdWithDeletedProductId() {
		Long productId = 1L;
		when(productRepository.findById(productId)).thenReturn(Optional.empty());
		ResponseEntity<Product> response = productController.getProductById(productId);
		assertNotNull(response);
		assertEquals(404, response.getStatusCodeValue());
	}
}
