/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class ProductTest {
    @Test
    public void testConstructor() {
        Product product = new Product(1L, "Test Product", "Test Description", 10.0);
        assertEquals(1L, (long) product.getProductId());
        assertEquals("Test Product", product.getName());
        assertEquals("Test Description", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.001);
    }
    @Test
    public void testGettersAndSetters() {
        Product product = new Product();
        product.setProductId(2L);
        product.setName("Updated Product");
        product.setDescription("Updated Description");
        product.setPrice(20.0);
        
        assertEquals(2L, (long) product.getProductId());
        assertEquals("Updated Product", product.getName());
        assertEquals("Updated Description", product.getDescription());
        assertEquals(20.0, product.getPrice(), 0.001);
       
    }

    
}
