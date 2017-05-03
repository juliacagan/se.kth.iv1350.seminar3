package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;

/**
 * Created by User on 2017-05-01.
 */
public class ExPayAuthSys {

    /**
     * A dummy implementation of an external authorization system
     * @param payment an instance of <code>Payment</code>
     * @return returns true if payment is authorized. This dummy implementation always returns true
     */
    public static boolean authorizePayment(Payment payment){
        return true;
    }
}
