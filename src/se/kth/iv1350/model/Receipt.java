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

    /**
     * Creates an instance of <code>Receipt</code> for a credit card payment
     * @param dateOfTransaction the date of the transaction
     * @param cost  the total cost of the inspection
     * @param creditCard the credit card used to pay
     */
    public Receipt(Date dateOfTransaction, double cost, CreditCardDTO creditCard) {
        this.dateOfTransaction = dateOfTransaction;
        this.cost = cost;
        this.creditCard = creditCard;
    }

    /**
     * Creates an instance of <code>Receipt</code> for a cash payment
     * @param dateOfTransaction the date of transaction
     * @param cost  the total cost of the inspection
     * @param amountPaid the amount paid by the customer in cash
     * @param change the change to be given back to the customer
     */
    public Receipt(Date dateOfTransaction, double cost, double amountPaid, double change) {
        this.dateOfTransaction = dateOfTransaction;
        this.cost = cost;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    /**
     * A toString method for the <code>Receipt</code>
     * @return the String representation to be printed as a <code>Receipt</code>
     */
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
