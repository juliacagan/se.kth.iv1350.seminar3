package se.kth.iv1350.dto;

/**
 * Created by User on 2017-05-01.
 */
public class VehicleDTO {
    String regNumber;

    public VehicleDTO(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
