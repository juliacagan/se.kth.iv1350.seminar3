package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;

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

    /**
     * Creates an instance of payment for a credit card payment
     * @param cost the cost of the total inspection
     * @param creditCard credit card information
     */
    public Payment(int cost, CreditCardDTO creditCard) {
        this.cost = cost;
        this.creditCard = creditCard;
    }

    /**
     * Creates an instance of payment for cash payment
     * @param cost the cost of the total inspection
     * @param amountPaid the amount paid in cash by the customer
     */
    public Payment(int cost, int amountPaid) {
        this.cost = cost;
        this.amountPaid = amountPaid;
    }

    /**
     * Makes a credit card payment
     * @return returns true if the payment is authorized
     */
    public boolean makeCardPayment(){
        boolean paymentStatus = ExPayAuthSys.authorizePayment(this);
        dateOfTransaction = new Date();
        Receipt receipt = new Receipt(this.dateOfTransaction, this.cost, this.creditCard);
        return paymentStatus;
    }

    /**
     * Makes a cash payment
     * @return the change to be given to customer
     */
    public double makeCashPayment(){
        change = cost - amountPaid;
        Receipt receipt = new Receipt(this.dateOfTransaction, this.cost, this.amountPaid, this.change);
        return change;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }
}
