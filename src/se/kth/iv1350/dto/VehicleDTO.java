package se.kth.iv1350.dto;

/**
 * Created by User on 2017-05-01.
 */
public class VehicleDTO {
    String regNumber;

    /**
     * Creates a new instance of VehicleDTO
     * @param regNumber the registration number for this particular vehicle
     */
    public VehicleDTO(String regNumber) {
        this.regNumber = regNumber;
    }

    /**
     * Compares two vehicles to see if they are equal
     * @param obj vehicle to compare to this instance of the vehicle
     * @return true if the vehicles are equal, false if not
     */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof VehicleDTO))
            return false;
        VehicleDTO vehicle = (VehicleDTO) obj;
        if (this.regNumber.equalsIgnoreCase(vehicle.getRegNumber()))
            return true;
        return false;
    }

    /**
     * Get registration number for this vehicle
     * @return registration number
     */
    public String getRegNumber() {
        return regNumber;
    }
}
