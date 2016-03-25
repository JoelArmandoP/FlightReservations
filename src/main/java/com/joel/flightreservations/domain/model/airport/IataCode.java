package com.joel.flightreservations.domain.model.airport;

import org.apache.commons.lang3.Validate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ValidateOnExecution;
import java.io.Serializable;

/**
 * A three-letter code as described in http://www.world-airport-codes.com/
 */
@Embeddable
public class IataCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    // IATA code is exactly three letters.
    @Pattern(regexp = "[a-zA-Z]{3}")
    private String iataCode;
    private static final java.util.regex.Pattern VALID_PATTERN
            = java.util.regex.Pattern.compile("[a-zA-Z]{3}");

    /**
     * @param iataCode Three-letter string code
     * @throws NullPointerException if iataCode null
     * @throws IllegalArgumentException if iataCode not valid as per regex
     */
    public IataCode(String iataCode) {
        Validate.notNull(iataCode, "IATA code may not be null");
        Validate.isTrue(VALID_PATTERN.matcher(iataCode).matches(),
                iataCode + " is not a valid IATA code (does not match pattern)");
        this.iataCode = iataCode.toUpperCase();
    }

    public IataCode() {
    }

    @Override
    public String toString() {
        return iataCode;
    }

    /**
     * @return IATA code string
     */
    public String getIdString() {
        return iataCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IataCode)) return false;

        IataCode iataCode1 = (IataCode) o;

        return iataCode.equals(iataCode1.iataCode);

    }

    @Override
    public int hashCode() {
        return iataCode.hashCode();
    }
}
