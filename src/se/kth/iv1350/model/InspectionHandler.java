package se.kth.iv1350.model;

import se.kth.iv1350.integration.CarDataBaseHandler;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionHandler {
    private InspectionList inspectionList;
    private CarDataBaseHandler dbhandler;

    public InspectionHandler(InspectionList inspectionlist, CarDataBaseHandler dbhandler) {
        this.inspectionList = inspectionlist;
        this.dbhandler = dbhandler;
    }

    public int calculateCost(){
        int totalCost = 0;
        inspectionList.resetCurrentIndex();
        while(inspectionList.hasNext()){
            totalCost += inspectionList.getNextInspection().getCost();
        }
        return totalCost;
    }

    public void saveInspectionResult (Inspection inspection){
        dbhandler.saveInspectionResult(inspection);
    }

    public void setInspectionList(Inspection[] inspections){
        this.inspectionList.setInspections(inspections);
    }

    public boolean hasNext(){
        return inspectionList.hasNext();
    }

    public Inspection getNextInspection(){
        return inspectionList.getNextInspection();
    }
}
