package se.kth.iv1350.dto;

/**
 * Created by User on 2017-05-01.
 */
public class VehicleDTO {
    String regNumber;

    public VehicleDTO(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof VehicleDTO))
            return false;
        VehicleDTO vehicle = (VehicleDTO) obj;
        if (this.regNumber.equals(vehicle.getRegNumber()))
            return true;
        return false;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
