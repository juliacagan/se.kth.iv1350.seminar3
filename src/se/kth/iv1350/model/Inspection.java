package se.kth.iv1350.model;

import se.kth.iv1350.dto.VehicleDTO;

/**
 * Created by User on 2017-05-01.
 */
public class Inspection {

    private VehicleDTO vehicle;
    private int cost;
    private String description;
    private boolean passed;

    /**
     * Creates a new instance of Inspection.
     * @param cost  The cost of the inspection.
     * @param description  A description of the inspection.
     */
    public Inspection(int cost, String description, VehicleDTO vehicle) {
        this.cost = cost;
        this.description = description;
        this.vehicle = vehicle;
        this.passed = false;
    }

   @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Inspection))
            return false;
        Inspection otherInspection = (Inspection) obj;
        if (otherInspection.getCost() == this.cost && otherInspection.getDescription() == this.description)
            return true;
        return false;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }
}
