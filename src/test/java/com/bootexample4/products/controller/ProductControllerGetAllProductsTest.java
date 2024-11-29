
package com.bootexample4.products.controller;
import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerGetAllProductsTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductController productController;
    @Test
    @Tag("valid")
    public void testGetAllProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        // Arrange
        when(productRepository.findAll()).thenReturn(products);
        // Act
        List<Product> result = productController.getAllProducts();
        // Assert
        assertEquals(products, result);
    }
    @Test
    @Tag("boundary")
    public void testEmptyProductList() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        // Act
        List<Product> result = productController.getAllProducts();
        // Assert
        assertTrue(result.isEmpty());
    }
    @Test
    @Tag('valid')
    public void testProductListOrder() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        // Arrange
        when(productRepository.findAll()).thenReturn(products);
        // Act
        List<Product> result = productController.getAllProducts();
        // Assert
        assertArrayEquals(products.toArray(), result.toArray());
    }
    @Test
    @Tag('invalid')
    public void testProductRetrievalFailure() {
        // Arrange
        when(productRepository.findAll()).thenThrow(new RuntimeException("Database error"));
        // Act and Assert
        assertThrows(RuntimeException.class, () -> productController.getAllProducts());
    }
    @Test
    @Tag('valid')
    public void testProductListSize() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);
        // Arrange
        when(productRepository.findAll()).thenReturn(products);
        // Act
        List<Product> result = productController.getAllProducts();
        // Assert
        assertEquals(products.size(), result.size());
    }
}