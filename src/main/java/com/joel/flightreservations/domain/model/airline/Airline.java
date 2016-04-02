package com.joel.flightreservations.domain.model.airline;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Airlines uniquely identify aith a two letter code as described at http://en.wikipedia.org/wiki/List_of_airline_codes
 */

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Airline.findAll", query = "Select a from Airline a"),
        @NamedQuery(name = "Airline.findByCode",
                query = "Select a from Airline a where a.airlineCode = :airlineCode")})
public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private AirlineCode airlineCode;
    @NotNull
    private String name;

    /*
    * @param airlineCode Airline official code
    * @param name Airline official name
    * @throws IllegalArgumentException if Airline code or name are null
    */
    public Airline (AirlineCode airlineCode, String name) {
        Validate.notNull(airlineCode);
        Validate.notNull(name);

        this.airlineCode = airlineCode;
        this.name = name;
    }

    public Airline(){

    }

    /*
    * @return Airline's IATA code
    */

    public AirlineCode getAirlineCode() {
        return airlineCode;
    }

    /*
    * @return Airline's name
    */

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;

        Airline airport = (Airline) o;

        return getAirlineCode().equals(airport.getAirlineCode()) && getName().equals(airport.getName());

    }

    @Override
    public String toString() {
        return name + " [" + airlineCode + "]";
    }

    @Override
    public int hashCode() {
        return getAirlineCode().hashCode();
    }

}
