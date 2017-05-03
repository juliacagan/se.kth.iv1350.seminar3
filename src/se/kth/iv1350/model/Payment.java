package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.integration.Printer;

import java.util.Date;

/**
 * Created by User on 2017-05-01.
 */
public class Payment {
    private double cost;
    private CreditCardDTO creditCard;
    private double amountPaid;
    private double change;
    private Date dateOfTransaction;
    private Receipt receipt;

    /**
     * Creates an instance of payment for a credit card payment
     * @param cost the cost of the total inspection
     * @param creditCard credit card information
     */
    public Payment(double cost, CreditCardDTO creditCard) {
        this.cost = cost;
        this.creditCard = creditCard;
        this.dateOfTransaction = new Date();
    }

    /**
     * Creates an instance of payment for cash payment
     * @param cost the cost of the total inspection
     * @param amountPaid the amount paid in cash by the customer
     */
    public Payment(double cost, double amountPaid) {
        this.cost = cost;
        this.amountPaid = amountPaid;
        this.dateOfTransaction = new Date();
    }

    /**
     * Makes a credit card payment and prints a receipt
     * @return returns true if the payment is authorized
     */
    public boolean makeCardPayment(){
        boolean paymentStatus = ExPayAuthSys.authorizePayment(this);
        dateOfTransaction = new Date();
        receipt = new Receipt(this.dateOfTransaction, this.cost, this.creditCard);
        return paymentStatus;
    }

    /**
     * Makes a cash payment and prints a receipt
     * @return the change to be given to customer
     */
    public double makeCashPayment(){
        change = amountPaid - cost;
        receipt = new Receipt(this.dateOfTransaction, this.cost, this.amountPaid, this.change);
        return change;
    }

    /**
     * prints a receipt
     */
    public void printReceipt(){
        Printer.printReceipt(this.receipt);
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }
}
