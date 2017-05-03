package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionHandlerTest {
    Inspection[] inspections;
    InspectionList inspectionList;
    InspectionHandler handler;
    CarDataBaseHandler dbhandler = new CarDataBaseHandler();

    @Before
    public void setUp() throws Exception {
        inspections = new Inspection[] {
                new Inspection(30, "Brakes", new VehicleDTO("ABC 123")),
                new Inspection(50, "Lights", new VehicleDTO( "DEF 456")),
                new Inspection(120, "Engine", new VehicleDTO ("GHI 789"))};
        inspectionList = new InspectionList(inspections);
        handler = new InspectionHandler(inspectionList, dbhandler);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateCost() throws Exception {
        int resultCost = handler.calculateCost();
        int expResultCost = 30 + 50 + 120;
        assertEquals("Same costs are not equal.", expResultCost, resultCost);
    }

    @Test
    public void calculateCostNotEquals() {
        int resultCost = handler.calculateCost();
        int expResultCost = 0;
        assertNotEquals("Different costs are equal.", expResultCost, resultCost);
    }

    @Test
    public void saveInspectionResult() throws Exception {

    }

    @Test
    public void hasNext() throws Exception {
    }

    @Test
    public void getNextInspection() throws Exception {
    }

}