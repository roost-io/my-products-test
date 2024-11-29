
package com.bootexample4.products.model;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductGetIdTest {
    @Test
    @Tag("valid")
    public void testGetProductID() {
        // Arrange
        Product product = new Product();
        Long expectedId = 5L;
        product.setId(expectedId);
        // Act
        Long actualId = product.getId();
        // Assert
        assertEquals(expectedId, actualId);
    }
    @Test
    @Tag("boundary")
    public void testGetProductIDAtBoundaryConditions() {
        // Arrange
        Product productMin = new Product();
        productMin.setId(Long.MIN_VALUE);
        Product productMax = new Product();
        productMax.setId(Long.MAX_VALUE);
        // Act
        Long actualMinId = productMin.getId();
        Long actualMaxId = productMax.getId();
        // Assert
        assertEquals(Long.MIN_VALUE, actualMinId);
        assertEquals(Long.MAX_VALUE, actualMaxId);
    }
  
    @Test
    @Tag("invalid")
    public void testGetProductIdAgainstWrongExpectation() {
        // Arrange
        Product product = new Product();
        Long expectedId = 3L;
        product.setId(expectedId);
        // Act
        Long actualId = product.getId();
        // Assert
        assertNotEquals(4L, actualId);
    }
    @Test
    @Tag("valid")
    public void testGetProductIdWhenNull() {
        // Arrange
        Product product = new Product();
        // Act
        Long actualId = product.getId();
        // Assert
        assertNull(actualId);
    }
}