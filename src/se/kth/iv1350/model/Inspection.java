package se.kth.iv1350.model;

import se.kth.iv1350.dto.VehicleDTO;

/**
 * Created by User on 2017-05-01.
 */
public class Inspection {

    private VehicleDTO vehicle;
    private double cost;
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

    /**
     * Compares two inspections to see if they equal each other
     * @param obj an instance of <code>Inspection</code>
     * @return true if they are equal, false if not
     */
   @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Inspection))
            return false;
        Inspection otherInspection = (Inspection) obj;
        if (otherInspection.getCost() == this.cost && otherInspection.getDescription().equalsIgnoreCase(description) &&
                otherInspection.getVehicle().equals(this.vehicle))
            return true;
        return false;
    }

    @Override
    public String toString(){
       String inspectionStringRepresentation = "INSPECTION\n" + "Description: " + this.description + "\n" +
               "Cost: " + this.cost + "\n" +
               "Vehicle: " + this.vehicle.getRegNumber() + "\n" +
               "Passed: " + this.passed + "\n";
       return inspectionStringRepresentation;
    }
    /**
     * Gets pass or fail result for a specific inspection
     * @return true if the inspection has passed, false if not
     */
    public boolean isPassed() {
        return passed;
    }

    /**
     * Sets pass or fail result for a specific <code>Inspection</code>
     * @param passed true if the inspection is passed, false if not
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    /**
     * Gets the cost for a specific inspection
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the description for an inspection
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the vehicle
     * @return the vehicle
     */
    public VehicleDTO getVehicle() {
        return vehicle;
    }
}
