package se.kth.iv1350.model;

import org.junit.Before;
import se.kth.iv1350.dto.VehicleDTO;
import org.junit.Before;
import org.junit.BeforeClass;
import se.kth.iv1350.model.InspectionList;
import se.kth.iv1350.model.Inspection.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionListTest {
    Inspection[] inspections;
    InspectionList inspectionList;


    @Before
    public void setUp() throws Exception {
        inspections = new Inspection[] {
                new Inspection(30, "Brakes", new VehicleDTO("ABC 123")),
                new Inspection(50, "Lights", new VehicleDTO( "DEF 456")),
                new Inspection(120, "Engine", new VehicleDTO ("GHI 789"))};
        inspectionList = new InspectionList(inspections);
    }

    @After
    public void tearDown() throws Exception {
        inspectionList = null;
    }

    @Test
    public void testHasNext() throws Exception {
        inspectionList.getNextInspection();
        boolean result = inspectionList.hasNext();
        boolean expResult = true;
        assertEquals("Method returns false even though there are more inspections in the list.", expResult, result);
    }

    @Test
    public void testHasNoNext(){
        while(inspectionList.hasNext()) {
            inspectionList.getNextInspection();
        }
        boolean result = inspectionList.hasNext();
        boolean expResult = false;
        assertEquals("Method returns true even though there are no more inspections in the list.", expResult, result);
    }

}