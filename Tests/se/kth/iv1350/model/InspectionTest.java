package se.kth.iv1350.model;

import org.junit.*;
import se.kth.iv1350.dto.VehicleDTO;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionTest {
    Inspection instance;
    Inspection other;
    Inspection sameAsInstance;
    String regNumber1 = "ABC 123";
    String regNumber2 = "DEF 456";
    VehicleDTO vehicle1 = new VehicleDTO(regNumber1);
    VehicleDTO vehicle2 = new VehicleDTO(regNumber2);

    @Before
    public void setUp() throws Exception {
        instance = new Inspection(30,"Brakes", vehicle1);
        other = new Inspection(0, "Engine", vehicle2);
        sameAsInstance = new Inspection(30, "Brakes", vehicle1);
    }

    @After
    public void tearDown() throws Exception {
    instance = null;
    other = null;
    sameAsInstance = null;
    }


    @Test
    public void testEquals() throws Exception {
        boolean comparisonResult = instance.equals(sameAsInstance);
        boolean expResult = true;
        assertEquals("Inspection instances with the same parameters are not equal", expResult, comparisonResult);
    }

    @Test
    public void testNotEqual() {
        boolean comparisonResult = instance.equals(other);
        boolean expResult = false;
        assertEquals("Inspection instances with different parameters are equal", expResult, comparisonResult);
    }

}