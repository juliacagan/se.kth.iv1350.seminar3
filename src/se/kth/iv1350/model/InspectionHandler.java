package se.kth.iv1350.model;

import se.kth.iv1350.integration.CarDataBaseHandler;

/**
 * Created by User on 2017-05-01.
 */
public class InspectionHandler {
    private InspectionList inspectionlist;
    private CarDataBaseHandler dbhandler;

    public InspectionHandler(InspectionList inspectionlist, CarDataBaseHandler dbhandler) {
        this.inspectionlist = inspectionlist;
        this.dbhandler = dbhandler;
    }


}
