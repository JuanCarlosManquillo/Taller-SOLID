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
public class CategoryTest {
    
    @Test
    public void testConstructor(){
        Category category = new Category(1L, "Test Category");

        assertEquals(1L,(long) category.getCategoryId());
        assertEquals("Test Category", category.getName());
    }
    @Test
    public void testGettersAndSetters() {
        Category category = new Category();
        category.setName("Updated Category");
        category.setCategoryId(1L);
        assertEquals(1L,(long) category.getCategoryId());
        assertEquals("Updated Category",category.getName());
    }


  
    
}
