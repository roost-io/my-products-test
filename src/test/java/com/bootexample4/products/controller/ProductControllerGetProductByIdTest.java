
package com.bootexample4.products.controller;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerGetProductByIdTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductController productController;
    private Product testProduct;
    @BeforeEach
    void setUp() {
        testProduct = new Product();
        testProduct.setId(1L);
    }
    @Test
    @Tag("valid")
    public void testGetProductByIdWhenProductExists() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        ResponseEntity<Product> response = productController.getProductById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testProduct, response.getBody());
    }
    @Test
    @Tag("invalid")
    public void testGetProductByIdWhenProductNotFound() {
        when(productRepository.findById(999L)).thenReturn(Optional.empty());
        ResponseEntity<Product> response = productController.getProductById(999L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    @Test
    @Tag("boundary")
    public void testGetProductByIdWithZeroId() {
        when(productRepository.findById(0L)).thenReturn(Optional.empty());
        ResponseEntity<Product> response = productController.getProductById(0L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    @Test
    @Tag("boundary")
    public void testGetProductByIdWithNegativeId() {
        when(productRepository.findById(-1L)).thenReturn(Optional.empty());
        ResponseEntity<Product> response = productController.getProductById(-1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    @Test
    @Tag("integration")
    public void testGetProductByIdWhenRepositoryThrowsException() {
        when(productRepository.findById(1L)).thenThrow(new RuntimeException("Database error"));
        assertThrows(RuntimeException.class, () -> productController.getProductById(1L));
    }
}