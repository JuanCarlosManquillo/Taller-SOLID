/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.com.hyunseda.market.service;

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
public class CategoryRepositoryTest {
    private CategoryRepository categoryRep;
    
    
    @Before
    public void setUp() throws SQLException {
        categoryRep = new CategoryRepository();
    }
    @After
    public void tearDown() {
        categoryRep.disconnect();
    }
    @Test
    public void testConnect() {
       categoryRep.connect();
    }
    
    @Test
    public void testInitDatabase(){
        categoryRep.initDatabase();
    }

/*
    @Test
    public void testDisconnect() {
        categoryRep.disconnect();
    }
*/

    @Test
    public void testSave() {
        // Crear una nueva categoria
        Category category = new Category(1L, "Test Category");

        // Guardar la categoria y verificar si se guardó correctamente
        assertTrue(categoryRep.save(category));
        
    }
    
    @Test
    public void testFindAll() {

        // Verificar que la lista de categorias esté vacía
        assertTrue(categoryRep.findAll().isEmpty());
    }
    

    @Test
    public void testEdit() {
 
        CategoryRepository categoryrepo = new CategoryRepository();
        Category originalCategory = new Category(1L, "Original Name");
        categoryrepo.save(originalCategory); 


        Long id = 1L;

        // Act
        boolean editResult = categoryrepo.edit(1L, originalCategory);

        // Assert
        assertTrue(editResult); // Verificar si la edición fue exitosa
    }
// TO DO
    @Test
    public void testDelete() {
        CategoryRepository categoryrepo = new CategoryRepository();
        Category category = new Category(1L, "Test Category");
        
        if(categoryrepo.findById(1L)!=null);
    
    }

    @Test
    public void testFindById() {
 
        Category category = new Category(1L, "Test Category");
        categoryRep.save(category);
        assertNotNull(categoryRep.findById(1L));
    }

   
    @Test
    public void testFindByName() {
        Category category = new Category(1L, "Test Category");
        categoryRep.save(category);
        assertNotNull(categoryRep.findByName("Test Category"));
    }
    
}
