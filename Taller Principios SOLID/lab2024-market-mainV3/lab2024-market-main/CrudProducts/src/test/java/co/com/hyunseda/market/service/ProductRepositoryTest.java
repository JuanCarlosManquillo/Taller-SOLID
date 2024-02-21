/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Juan
 */
public class ProductRepositoryTest {
    private ProductRepository productRepository;
    
    @Before
    public void setUp() throws SQLException {
        productRepository = new ProductRepository();
    }
    @After
    public void tearDown() {
        productRepository.disconnect();
    }
    @Test
    public void testConnect() {
       productRepository.connect();
    }
    @Test
    public void testInitDatabase(){
        productRepository.initDatabase();
    }
  
// TO DO
    @Test
    public void testDeleteProduct() {
     
    }

    @Test
    public void testSave() {
        // Crear un nuevo producto
        Product product = new Product(1L, "Test Product", "Test Description", 10.0);

        // Guardar el producto y verificar si se guardó correctamente
        assertTrue(productRepository.save(product));
        
    }

    @Test
    public void testFindAll() {

        // Verificar que la lista de productos esté vacía
        assertTrue(productRepository.findAll().isEmpty());
    }



    @Test
    public void testEdit() {
 
        ProductRepository repository = new ProductRepository();
        Product originalProduct = new Product(1L, "Original Name", "Original Description", 10.0);
        repository.save(originalProduct); 


        Product updatedProduct = new Product(1L, "Updated Name", "Updated Description", 20.0);
        Long id = 1L;

        // Act
        boolean editResult = repository.edit(id, updatedProduct);

        // Assert
        assertTrue(editResult); // Verificar si la edición fue exitosa
    }
// TO DO
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ProductRepository instance = new ProductRepository();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindById() {
 
        Product product = new Product(1L, "Test Product", "Description", 10.0);
        productRepository.save(product);
        assertNotNull(productRepository.findById(1L));
    }

    @Test
    public void testFindByName() {
        Product product = new Product(1L, "Test Product", "Description", 10.0);
        productRepository.save(product);
        assertNotNull(productRepository.findByName("Test Product"));
    }
    
}
