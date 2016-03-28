package com.joel.flightreservations.domain.model.user;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * A class for the credit card information
 */
@Embeddable
public class CreditCard implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotNull
    @Pattern(regexp = "[0-9]{16}")
    private String creditCardNumber;
    @NotNull
    private String expDate;


    public CreditCard(String creditCardNumber, String expDate) {
        setCreditCardNumber(creditCardNumber);
        setExpDate(expDate);
    }

    public CreditCard() {
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;

        CreditCard that = (CreditCard) o;

        return getCreditCardNumber().equals(that.getCreditCardNumber())
                && getExpDate().equals(that.getExpDate());

    }

    @Override
    public int hashCode() {
        int result = getCreditCardNumber().hashCode();
        result = 31 * result + getExpDate().hashCode();
        return result;
    }
}
