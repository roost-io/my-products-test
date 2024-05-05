

package com.bootexample4.products.controller;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.mock.mockito.MockBean;      //Compilation error, use @Mock instead of @MockBean for standalone unit tests.
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;  //Compilation error, use @InjectMocks instead of @Autowired for standalone unit tests.
import org.springframework.web.bind.annotation.*;

public class ProductControllerDeleteProductTest {

    //@MockBean                                  //Compilation error, comment this and use @Mock.
    @Mock                                       //This should be correct annotation for standalone unit tests.
	private ProductRepository productRepository;

    //@Autowired                                //Compilation error, comment this and use @InjectMocks.
    @InjectMocks                                //This should be correct annotation for standalone unit tests.
	private ProductService productService;

	@Test
	public void testSuccessfulDeletion() {
		Long id = 1L;
		Product product = new Product();
		product.setId(id);
		when(productRepository.findById(id)).thenReturn(Optional.of(product));

		ResponseEntity<Object> responseEntity = productService.deleteProduct(id);
		assertEquals(200, responseEntity.getStatusCodeValue());
		verify(productRepository, times(1)).delete(product);
	}

	@Test
	public void testDeletionOfNonExistentProduct() {
		Long id = 1L;
		when(productRepository.findById(id)).thenReturn(Optional.empty());
		ResponseEntity<Object> responseEntity = productService.deleteProduct(id);
		assertEquals(404, responseEntity.getStatusCodeValue());
		verify(productRepository, times(0)).delete(any());
	}

	@Test
	public void testDeletionWithNullId() {
		Long id = null;
		assertThrows(IllegalArgumentException.class, () -> {
			productService.deleteProduct(id);
		});
		verify(productRepository, times(0)).findById(any());
		verify(productRepository, times(0)).delete(any());
	}
}
