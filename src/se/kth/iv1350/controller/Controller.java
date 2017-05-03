package se.kth.iv1350.controller;

import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.*;

/**
 * Created by User on 2017-05-01.
 */
public class Controller {
    Garage garage;
    CarDataBaseHandler dbhandler;
    ExPayAuthSys exPayAuthSys;
    InspectionHandler inspectionHandler;

    public Controller(Garage garage, CarDataBaseHandler dbhandler, ExPayAuthSys exPayAuthSys, InspectionHandler inspectionHandler) {
        this.garage = garage;
        this.dbhandler = dbhandler;
        this.exPayAuthSys = exPayAuthSys;
        this.inspectionHandler = inspectionHandler;
    }

    public void nextCustomer(){
        garage.nextCustomer();
    }

    public void openDoor(){
        garage.openDoor();
    }

    public void closeDoor(){
        garage.closeDoor();
    }

    /**
     * Fetches the inspections for a specified vehicle and calculates the cost
     * @param regNo the registration number for the vehicle
     */
    public double enterRegNumber(String regNo){
        VehicleDTO vehicle = new VehicleDTO(regNo);
        Inspection[] inspections = dbhandler.getInspectionByVehicle(vehicle);
        inspectionHandler.setInspectionList(inspections);
        double cost = inspectionHandler.calculateCost();

        return cost;
    }

    public boolean makeCardPayment(double cost, CreditCardDTO creditCard){
        Payment payment = new Payment(cost, creditCard);
        boolean authorized = payment.makeCardPayment();
        payment.printReceipt();
        return authorized;
    }

    public double makeCashPayment(double cost, double amountPaid){
        Payment payment = new Payment(cost, amountPaid);
        double change = payment.makeCashPayment();
        return change;

    }

    public Inspection nextInspection(){
        return inspectionHandler.getNextInspection();
        //TODO null handling exception
    }

    public void enterInspectionResults(Inspection inspection){
        inspectionHandler.saveInspectionResult(inspection);

    }


}
