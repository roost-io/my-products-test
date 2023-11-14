package com.bootexample4.products.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.bootexample4.products.model.Product;
import com.bootexample4.products.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ProductController_updateProduct_9454a9af90_Test {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    @Test
    public void testUpdateProduct_idDoesNotExist() {
        Long id = 1L;
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(100.00);

        when(productRepository.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateProduct_allDetailsProvided() {
        Long id = 1L;
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(100.00);

        Product existingProduct = new Product();
        existingProduct.setName("Product2");
        existingProduct.setDescription("Description2");
        existingProduct.setPrice(200.00);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct_someDetailsMissing() {
        Long id = 1L;
        Product product = new Product();
        product.setName("Product1");

        Product existingProduct = new Product();
        existingProduct.setName("Product2");
        existingProduct.setDescription("Description2");
        existingProduct.setPrice(200.00);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct_noDetailsProvided() {
        Long id = 1L;
        Product product = new Product();

        Product existingProduct = new Product();
        existingProduct.setName("Product2");
        existingProduct.setDescription("Description2");
        existingProduct.setPrice(200.00);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct_productIsNull() {
        Long id = 1L;
        Product product = null;

        Product existingProduct = new Product();
        existingProduct.setName("Product2");
        existingProduct.setDescription("Description2");
        existingProduct.setPrice(200.00);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct_idIsNull() {
        Long id = null;
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(100.00);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateProduct_repositoryFailsToSave() {
        Long id = 1L;
        Product product = new Product();
        product.setName("Product1");
        product.setDescription("Description1");
        product.setPrice(100.00);

        Product existingProduct = new Product();
        existingProduct.setName("Product2");
        existingProduct.setDescription("Description2");
        existingProduct.setPrice(200.00);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(any(Product.class))).thenThrow(RuntimeException.class);

        ResponseEntity<Product> response = productController.updateProduct(id, product);

        assertEquals(500, response.getStatusCodeValue());
    }
}
