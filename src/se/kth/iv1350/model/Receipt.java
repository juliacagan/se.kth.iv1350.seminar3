package se.kth.iv1350.model;
import se.kth.iv1350.dto.CreditCardDTO;

import java.util.*;
/**
 * Created by User on 2017-05-03.
 */
public class Receipt {
    private Date dateOfTransaction;
    private double cost;
    private CreditCardDTO creditCard;
    private double amountPaid;
    private double change;

    public Receipt(Date dateOfTransaction, double cost, CreditCardDTO creditCard) {
        this.dateOfTransaction = dateOfTransaction;
        this.cost = cost;
        this.creditCard = creditCard;
    }

    public Receipt(Date dateOfTransaction, double cost, double amountPaid, double change) {
        this.dateOfTransaction = dateOfTransaction;
        this.cost = cost;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Car Inspection\n");
        builder.append("Date: " + this.dateOfTransaction + "\n");
        builder.append("Cost: " + cost + "\n");
        if (creditCard == null){
            builder.append("Paid amount :" + amountPaid + "\n");
            builder.append("Change: " + change + "\n");
        }
        else{
            builder.append("Credit Card Company\n");
        }
        return builder.toString();
    }
}
