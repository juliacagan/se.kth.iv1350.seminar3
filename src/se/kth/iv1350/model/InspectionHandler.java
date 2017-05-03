package se.kth.iv1350.model;

import se.kth.iv1350.integration.CarDataBaseHandler;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionHandler {
    private InspectionList inspectionList;
    private CarDataBaseHandler dbhandler;

    /**
     * Creates a new instance of InspectionHandler
     * @param inspectionlist a list of inspections to be performed for a particular vehicle
     * @param dbhandler an instance of the database handler
     */
    public InspectionHandler(InspectionList inspectionlist, CarDataBaseHandler dbhandler) {
        this.inspectionList = inspectionlist;
        this.dbhandler = dbhandler;
    }

    /**
     * calculates the total cost for the car inspection
     * @return the cost
     */
    public double calculateCost(){
        double totalCost = 0;
        inspectionList.resetCurrentIndex();
        while(inspectionList.hasNext()){
            totalCost += inspectionList.getNextInspection().getCost();
        }
        return totalCost;
    }

    /**
     * Saves the result, pass or fail, of the inspection using the database handler
     * @param inspection the inspection for which the result is to be saved
     */
    public void saveInspectionResult (Inspection inspection){
        dbhandler.saveInspectionResult(inspection);
    }

    public void setInspectionList(Inspection[] inspections){
        this.inspectionList.setInspections(inspections);
    }

    /**
     * Checks if there are more inspections to be made on the list
     * @return true if there are more inspections on the list, false if not
     */
    public boolean hasNext(){
        return inspectionList.hasNext();
    }

    public Inspection getNextInspection(){
        return inspectionList.getNextInspection();
    }
}
