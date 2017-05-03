package se.kth.iv1350.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.Inspection;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-02.
 */
public class CarDataBaseHandlerTest {
    private CarDataBaseHandler dbhandler;
    Inspection inspection;
    VehicleDTO vehicle = new VehicleDTO("ABC 123");

    @Before
    public void setUp() throws Exception {
        dbhandler = new CarDataBaseHandler();
    }

    @After
    public void tearDown() throws Exception {
        inspection = null;
    }

    @Test
    public void testSaveInspectionResult() throws Exception {
        inspection = new Inspection(30, "Brakes", vehicle);
        inspection.setPassed(true);
        dbhandler.saveInspectionResult(inspection);
        Inspection[] inspections = dbhandler.getInspectionByVehicle(vehicle);
        boolean expected = true;
        boolean result = inspections[0].isPassed();
        assertEquals("Inspection result is not saved", expected, result);

    }

    @Test
    public void testFailSaveInspectionResult(){
        inspection = new Inspection (40, "Hand Break", new VehicleDTO("DEF 456"));
        inspection.setPassed(true);
        dbhandler.saveInspectionResult(inspection);
        Inspection[] inspections = dbhandler.getInspectionByVehicle(vehicle);
        boolean expected = false;
        boolean result = inspections[0].isPassed();
        assertEquals("Inspection that doesn't exist in the database is saved", expected, result);
    }

}