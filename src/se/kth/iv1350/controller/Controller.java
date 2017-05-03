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

    /**
     * Creates an instance of controller
     * @param garage reference to an instance of garage
     * @param dbhandler reference to an instance of the database handler
     * @param inspectionHandler reference to an instance of <code>InspectionHandler</code>
     */
    public Controller(Garage garage, CarDataBaseHandler dbhandler, InspectionHandler inspectionHandler) {
        this.garage = garage;
        this.dbhandler = dbhandler;
        this.exPayAuthSys = exPayAuthSys;
        this.inspectionHandler = inspectionHandler;
    }

    /**
     * Increments the display number and opens the garage door
     */
    public void nextCustomer(){
        garage.nextCustomer();
    }

    /**
     * Opens the garage door
     */
    public void openDoor(){
        garage.openDoor();
    }

    /**
     * Closes the garage door
     */
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

    /**
     * Makes a card payment
     * @param cost  the total cost of the car inspection
     * @param creditCard a <code>CreditCardDTO</code> containing credit card information
     * @return return value is true if the payment is authorized
     */
    public boolean makeCardPayment(double cost, CreditCardDTO creditCard){
        Payment payment = new Payment(cost, creditCard);
        boolean authorized = payment.makeCardPayment();
        payment.printReceipt();
        return authorized;
    }

    /**
     * Makes a cash payment and returns the change to be paid back to customer
     * @param cost the total cost of the car inspection
     * @param amountPaid amount paid in cash by the customer
     * @return change to be paid back to the customer
     */
    public double makeCashPayment(double cost, double amountPaid){
        Payment payment = new Payment(cost, amountPaid);
        double change = payment.makeCashPayment();
        payment.printReceipt();
        return change;

    }

    /**
     * Fetches the next inspection in the <code>InspectionList</code>
     * @return an instance of <code>Inspection</code>
     */
    public Inspection nextInspection(){
        return inspectionHandler.getNextInspection();
    }

    /**
     * Saves pass or fail result for specified inspection
     * @param inspection inspection to update the result for
     */
    public void enterInspectionResults(Inspection inspection){
        inspectionHandler.saveInspectionResult(inspection);

    }


}
