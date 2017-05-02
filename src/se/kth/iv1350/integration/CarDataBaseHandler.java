package se.kth.iv1350.integration;

import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.Inspection;

/**
 * Created by User on 2017-05-01.
 */
public class CarDataBaseHandler {

    Inspection[] dataBaseInspections;

    /**
     * Creates an instance of CarDataBaseHandler, a dummy implementation of a data base of cars and their respective
     * instructions.
     */
    public CarDataBaseHandler() {
        VehicleDTO vehicle = new VehicleDTO("dummyVehicle");
        dataBaseInspections = new Inspection[] {
                new Inspection(30, "Brakes", vehicle),
                new Inspection(50, "Lights", vehicle),
                new Inspection(120, "Engine", vehicle)};
    }

    /**
     * Returns an array of inspections for a given vehicle.
     * @param vehicle A vehicleDTO.
     * @return An array of inspections for the specified vehicle.
     */
    public Inspection[] getInspectionByVehicle(VehicleDTO vehicle){
        //Dummy implementation
        return dataBaseInspections;
    }

    /**
     * Finds the inspection in an array of inspections and then sets the result of that found inspection
     * to pass or fail based on the result entered in inspection.
     * @param inspection The inspection to update the results for.
     */
    public void saveInspectionResult(Inspection inspection){
        for (int i = 0; i < dataBaseInspections.length ; i++) {
            if (dataBaseInspections[i].equals(inspection)){
                dataBaseInspections[i].setPassed(inspection.isPassed());
            }

        }

    }
}
