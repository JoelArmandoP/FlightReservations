package com.joel.flightreservations.domain.model.airport;

import com.joel.flightreservations.domain.model.flight.Flight;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * A place for planes to land. And take off. And do planey things. Not fly, though.
 * Uniquely identified with a three-letter code as described at
 * http://www.world-airport-codes.com/
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Airport.findAll", query = "Select a from Airport a"),
        @NamedQuery(name = "Airport.findByCode",
                query = "Select a from Airport a where a.airportCode = :airportCode")})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private AirportCode airportCode;
    @NotNull
    private String name;
    @NotNull
    private TimeZone timeZone;

    @OneToMany(mappedBy = "departureAirport")
    private Collection<Flight> departingFlightCollection;

    @OneToMany(mappedBy = "arrivalAirport")
    private Collection<Flight> arrivingFlightCollection;


    /**
     * @param airportCode Airport official code
     * @param name Airport name (say, "London Heathrow")
     * @throws IllegalArgumentException if Airport code or name are null
     */
    public Airport(AirportCode airportCode, String name, TimeZone timeZone) {
        Validate.notNull(airportCode);
        Validate.notNull(name);

        this.airportCode = airportCode;
        this.name = name;
        this.timeZone = timeZone;
    }

    public Airport() {
    }

    /**
     * @return Airport's IATA code
     */
    public AirportCode getAirportCode() { return airportCode; }

    /**
     * @return Airport's name
     */
    public String getName() {
        return name;
    }

    public TimeZone getTimeZone() { return timeZone;  }

    /**
     * Takes a year, month, day, hour and minutes and returns the date in the timezone of the airport.
     */
    public Date getTimeStamp(int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal = new GregorianCalendar(this.timeZone);
        cal.set(year, month, day, hour, minute, 0);
        return cal.getTime();
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


    public Collection<Flight> getDepartingFlightCollection() {
        return departingFlightCollection;
    }

    public void setDepartingFlightCollection(Collection<Flight> departingFlightCollection) {
        this.departingFlightCollection = departingFlightCollection;
    }

    public Collection<Flight> getArrivingFlightCollection() {
        return arrivingFlightCollection;
    }

    public void setArrivingFlightCollection(Collection<Flight> arrivingFlightCollection) {
        this.arrivingFlightCollection = arrivingFlightCollection;
    }
}
