package com.bootexample4.products.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import java.util.Optional;

public class ProductController_getProductById_d22f3ea272_Test {

    private ProductRepository productRepository = mock(ProductRepository.class);
    private ProductController productController = new ProductController();

    @Test
    public void testGetProductById_validId() {
        Product product = new Product();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = productController.getProductById(1L);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getId(), 1L);
    }

    @Test
    public void testGetProductById_invalidId() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.getProductById(1L);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testGetProductById_nullId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productController.getProductById(null);
        });

        String expectedMessage = "id must not be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetProductById_wrongTypeId() {
        Exception exception = assertThrows(ClassCastException.class, () -> {
            productController.getProductById("a string instead of Long");
        });

        String expectedMessage = "Cannot cast String to Long";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetProductById_negativeId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            productController.getProductById(-1L);
        });

        String expectedMessage = "id must be a positive number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
