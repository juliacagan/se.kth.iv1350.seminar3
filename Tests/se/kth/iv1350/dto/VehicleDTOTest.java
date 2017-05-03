package se.kth.iv1350.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-03.
 */
public class VehicleDTOTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testNotEquals() throws Exception {
        VehicleDTO vehicle1 = new VehicleDTO("ABC 123");
        VehicleDTO vehicle2 = new VehicleDTO("ABC 123");
        boolean expectedResult = true;
        boolean result = vehicle1.equals(vehicle2);
        assertEquals("Not equal vehicles are equal", expectedResult, result);
    }

    @Test
    public void testEquals() throws Exception {
        VehicleDTO vehicle1 = new VehicleDTO("ABC 123");
        VehicleDTO vehicle2 = new VehicleDTO("ABC 555");
        boolean expectedResult = false;
        boolean result = vehicle1.equals(vehicle2);
        assertEquals("Equal vehicles not equal", expectedResult, result);
    }

}