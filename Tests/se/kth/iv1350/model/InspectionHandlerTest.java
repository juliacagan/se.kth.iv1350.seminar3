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
        inspectionList = new InspectionList();
        handler = new InspectionHandler(dbhandler);
        handler.setInspectionList(inspections);

    }

    @After
    public void tearDown() throws Exception {
        inspections = null;
        inspectionList = null;
        handler = null;
    }

    @Test
    public void calculateCost() throws Exception {
        double resultCost = handler.calculateCost();
        System.out.println(resultCost);
        double expResultCost = 30 + 50 + 120;
        boolean expected = true;
        boolean result = false;
        if (resultCost == expResultCost){
            result = true;
        }
        assertEquals("Same costs are not equal.", expected, result);
    }

    @Test
    public void calculateCostNotEqual() {
        double resultCost = handler.calculateCost();
        double expResultCost = 0;
        boolean expected = true;
        boolean result = false;
        if (!(resultCost == expResultCost)){
            result = true;
        }
        assertEquals("Different costs are equal.", expected, result);
    }

    @Test
    public void saveInspectionResult() throws Exception {
        Inspection inspection = new Inspection (30, "Brakes", new VehicleDTO("ABC 123"));
        inspection.setPassed(true);
        dbhandler.saveInspectionResult(inspection);
        boolean result = inspection.isPassed();
        boolean expected = true;
        assertEquals("Inspection result is not updated", expected, result);

    }

    @Test
    public void hasNext() throws Exception {
        boolean result = handler.hasNext();
        boolean expected = true;
        assertEquals("Has next returns false when there are more inspections", expected, result);
    }

    public void hasNextFalse(){
        while(handler.hasNext()){
            handler.getNextInspection();
        }
        boolean result = handler.hasNext();
        boolean expected = false;
        assertEquals("Has next returns true when there are no more inspections", expected, result);
    }

    @Test
    public void getNextInspection() throws Exception {
        Inspection inspectionActual = handler.getNextInspection();
        Inspection inspectionExpected = new Inspection (30, "Brakes", new VehicleDTO("ABC 123"));
        boolean expected = true;
        boolean result = false;
        if (inspectionActual.equals(inspectionExpected)){
            result = true;
        }
        assertEquals("The correct inspection is not fetched", expected, result);
    }

}