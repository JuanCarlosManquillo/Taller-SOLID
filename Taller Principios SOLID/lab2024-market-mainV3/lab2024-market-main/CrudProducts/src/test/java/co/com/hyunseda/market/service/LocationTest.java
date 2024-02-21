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
public class LocationTest {
    
    @Test
    public void testConstructor() {
        Location location = new Location(1, 1);
        assertEquals(1, location.getLatitude());
        assertEquals(1, location.getLongitude());
    }

    @Test
    public void testGettersAndSetters() {
        Location location = new Location();
        location.setLatitude(1);
        location.setLongitude(1);
        assertEquals(1,location.getLatitude());
        assertEquals(1,location.getLongitude());
    
    }



    
}
