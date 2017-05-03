package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;

/**
 * Created by User on 2017-05-01.
 */
public class Printer {

    /**
     * A static method that prints an instance of <code>Receipt</code>
     * @param receipt
     */
    public static void printReceipt(Receipt receipt){
        System.out.println(receipt);
    }
}
