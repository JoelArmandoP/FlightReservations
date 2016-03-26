package com.joel.flightreservations.domain.model.airline;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
* A two letter code as described at: http://en.wikipedia.org/wiki/List_of_airline_codes
 * */
@Embeddable
public class AirlineCode implements Serializable{
    private static final long serialVersionUID = 1L;
    @NotNull
    // IATA code is exactly two letters.
    @Pattern(regexp = "[a-zA-Z0-9]{2}")
    private String airlineCode;
    private static final java.util.regex.Pattern VALID_PATTERN
            = java.util.regex.Pattern.compile("[a-zA-Z0-9]{2}");

    /**
     * @param airlineCode Three-letter string code
     * @throws NullPointerException if iataCode null
     * @throws IllegalArgumentException if iataCode not valid as per regex
     */
    public AirlineCode(String airlineCode) {
        Validate.notNull( airlineCode, "IATA code may not be null");
        Validate.isTrue(VALID_PATTERN.matcher( airlineCode).matches(),
                 airlineCode + " is not a valid IATA code (does not match pattern)");
        this. airlineCode =  airlineCode.toUpperCase();
    }

    public AirlineCode() {
    }

    @Override
    public String toString() {
        return  airlineCode;
    }

    /**
     * @return IATA code string
     */
    public String getIdString() {
        return  airlineCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirlineCode)) return false;

        AirlineCode airportCode1 = (AirlineCode) o;

        return  airlineCode.equals(airportCode1.airlineCode);

    }

    @Override
    public int hashCode() {
        return  airlineCode.hashCode();
    }

}
