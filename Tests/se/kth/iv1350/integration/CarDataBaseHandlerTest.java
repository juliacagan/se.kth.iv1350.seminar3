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

    /*
    new Inspection(30, "Brakes", new VehicleDTO("ABC 123")),
                new Inspection(50, "Lights", new VehicleDTO("DEF 456")),
                new Inspection(120, "Engine", new VehicleDTO("GHI 789"))};
     */

    @Test
    public void testGetInspectionsByVehicle(){
        Inspection[] inspections = dbhandler.getInspectionByVehicle(null);

        boolean expected = true;
        boolean calculated = inspections[0].equals(new Inspection (30, "Brakes", new VehicleDTO("ABC 123")));
        assertEquals("The correct inspection isnt fetched", expected, calculated);


        boolean expected2 = true;
        boolean calculated2 = inspections[1].equals(new Inspection (50, "Lights", new VehicleDTO("DEF 456")));
        assertEquals("The correct inspection isnt fetched", expected2, calculated2);


        boolean expected3 = true;
        boolean calculated3 = inspections[2].equals(new Inspection (120, "Engine", new VehicleDTO("GHI 789")));
        assertEquals("The correct inspection isnt fetched", expected3, calculated3);


        boolean expected4 = false;
        boolean calculated4 = inspections[0].equals(new Inspection (120, "Engine", new VehicleDTO("GHI 789")));
        assertEquals("The correct inspection isnt fetched", expected4, calculated4);




    }

}