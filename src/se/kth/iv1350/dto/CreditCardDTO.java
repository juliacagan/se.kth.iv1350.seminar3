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


    /**
     * Creates a new instance of CreditCardDTO
     * @param cardHolder the name of the card holder
     * @param cardNumber the card number for this credit card
     * @param cvc the cvc number for this credit card
     * @param expirationDate expiration date for this credit card
     */
    public CreditCardDTO(String cardHolder, String cardNumber, String cvc, Date expirationDate) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expirationDate = expirationDate;
    }

    /**
     * Get card holder name
     * @return name of the card holder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * Get card number
     * @return card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Get cvc
     * @return cvc number
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Get expiration date
     * @return expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }
}
