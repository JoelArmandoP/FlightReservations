package com.joel.flightreservations.domain.model.airport;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * A three-letter code as described in http://www.world-airport-codes.com/
 */
@Embeddable
public class AirportCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    // IATA code is exactly three letters.
    @Pattern(regexp = "[a-zA-Z]{3}")
    private String airportCode;
    private static final java.util.regex.Pattern VALID_PATTERN
            = java.util.regex.Pattern.compile("[a-zA-Z]{3}");

    /**
     * @param idString Three-letter string code
     * @throws NullPointerException if iataCode null
     * @throws IllegalArgumentException if iataCode not valid as per regex
     */
    public AirportCode(String idString) {
        Validate.notNull(idString, "IATA code may not be null");
        Validate.isTrue(VALID_PATTERN.matcher(idString).matches(),
                idString + " is not a valid IATA code (does not match pattern)");
        this.setIdString(idString);
    }

    public AirportCode() {
    }

    @Override
    public String toString() {
        return  airportCode;
    }

    /**
     * @return IATA code string
     */
    public String getIdString() {
        return  airportCode;
    }

    public void setIdString(String idString) {
        this.airportCode = idString.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportCode)) return false;

        AirportCode airportCode1 = (AirportCode) o;

        return  airportCode.equals(airportCode1.airportCode);

    }

    @Override
    public int hashCode() {
        return  airportCode.hashCode();
    }
}
