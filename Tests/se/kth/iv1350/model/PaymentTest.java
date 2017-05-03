package se.kth.iv1350.model;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.CreditCardDTO;


import static org.junit.Assert.*;

/**
 * Created by User on 2017-05-02.
 */
public class PaymentTest {
    CreditCardDTO creditCard;
    int cost;
    int amountPaid;

    @Before
    public void setUp() throws Exception {
        creditCard = new CreditCardDTO("Stefan", "008 100", "123", new Date());
        Payment payment = new Payment(cost, creditCard);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makeCardPayment() throws Exception {
    }

    @Test
    public void makeCashPayment() throws Exception {
    }

    @Test
    public void testCashPaymentReceipt(){
        String expected = "Car Inspection\n" +
                "Date: " + new Date() + "\n" +
                "Cost: " + cost + "\n";
    }

}