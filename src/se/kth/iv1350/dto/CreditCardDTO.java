package se.kth.iv1350.dto;
import java.util.*;

/**
 * Created by User on 2017-05-01.
 */
public class CreditCardDTO {
    String cardHolder;
    String cardNumber;
    int cvc;
    Date expirationDate;

    public CreditCardDTO(String cardHolder, String cardNumber, int cvc, Date expirationDate) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationDate = expirationDate;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
