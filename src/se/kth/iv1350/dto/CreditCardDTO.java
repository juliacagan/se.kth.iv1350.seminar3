package se.kth.iv1350.dto;
import java.util.*;

/**
 * Created by User on 2017-05-01.
 */
public class CreditCardDTO {
    private String cardHolder;
    private String cardNumber;
    private String cvc;
    private Date expirationDate;

    public CreditCardDTO(String cardHolder, String cardNumber, String cvc, Date expirationDate) {
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

    public String getCvc() {
        return cvc;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
