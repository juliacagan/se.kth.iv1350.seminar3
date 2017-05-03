package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.Garage;
import se.kth.iv1350.model.Inspection;
import se.kth.iv1350.model.InspectionHandler;
import se.kth.iv1350.model.InspectionList;
import se.kth.iv1350.view.View;

/**
 * Created by User on 2017-05-01.
 */
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        CarDataBaseHandler dbhandler = new CarDataBaseHandler();
        InspectionHandler inspectionHandler = new InspectionHandler(dbhandler);
        Controller controller = new Controller(garage,dbhandler, inspectionHandler);
        View view = new View(controller);
    }
}
