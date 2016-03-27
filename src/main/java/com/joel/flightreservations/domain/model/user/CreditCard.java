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
        this.creditCardNumber = creditCardNumber;
        this.expDate = expDate;
    }

    public CreditCard() {
    }
}
