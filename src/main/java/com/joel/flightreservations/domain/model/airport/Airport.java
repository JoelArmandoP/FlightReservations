package com.joel.flightreservations.domain.model.airport;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * A place for planes to land. And take off. And do planey things. Not fly, though.
 * Uniquely identified with a three-letter code as described at
 * http://www.world-airport-codes.com/
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Airport.findAll", query = "Select a from Airport a"),
        @NamedQuery(name = "Airport.findByCode",
                query = "Select a from Airport a where a.airportCode = :iataCode")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private AirportCode airportCode;
    @NotNull
    private String name;

    /**
     * @param airportCode Airport official code
     * @param name Airport name (say, "London Heathrow")
     * @throws IllegalArgumentException if Airport code or name are null
     */
    public Airport(AirportCode airportCode, String name) {
        Validate.notNull(airportCode);
        Validate.notNull(name);

        this.airportCode = airportCode;
        this.name = name;
    }

    public Airport() {
    }

    /**
     * @return Airport's IATA code
     */
    public AirportCode getAirportCode() {
        return airportCode;
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

        return getAirportCode().equals(airport.getAirportCode()) && getName().equals(airport.getName());

    }

    @Override
    public String toString() {
        return name + " [" + airportCode + "]";
    }

    @Override
    public int hashCode() {
        return getAirportCode().hashCode();
    }
}
