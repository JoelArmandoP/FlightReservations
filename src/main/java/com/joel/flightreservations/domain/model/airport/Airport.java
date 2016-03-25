package com.joel.flightreservations.domain.model.airport;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * A place for planes to land. And take off. And do planey things. Not fly, though.
 * Uniquely identified with a three-letter code as described in
 * http://www.world-airport-codes.com/
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Airport.findAll", query = "Select a from Airport a"),
        @NamedQuery(name = "Airport.findByCode",
                query = "Select a from Airport a where a.iataCode = :iataCode")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private IataCode iataCode;
    @NotNull
    private String name;

    /**
     * @param iataCode Airport official code
     * @param name Airport name (say, "London Heathrow")
     * @throws IllegalArgumentException if IATA code or name are null
     */
    public Airport(IataCode iataCode, String name) {
        Validate.notNull(iataCode);
        Validate.notNull(name);

        this.iataCode = iataCode;
        this.name = name;
    }

    public Airport() {
    }

    /**
     * @return Airport's IATA code
     */
    public IataCode getIataCode() {
        return iataCode;
    }

    /**
     * @return Airport's name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;

        Airport airport = (Airport) o;

        return getIataCode().equals(airport.getIataCode()) && getName().equals(airport.getName());

    }

    @Override
    public String toString() {
        return name + " [" + iataCode + "]";
    }

    @Override
    public int hashCode() {
        return getIataCode().hashCode();
    }
}
