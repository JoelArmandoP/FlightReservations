package com.joel.flightreservations.domain.model.user;

import com.joel.flightreservations.domain.model.airport.Airport;

import javax.persistence.*;
import java.util.Date;

/**
 * A search made by a user.
 */
@Embeddable
public class Search {
    @ManyToOne
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirport;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @ManyToOne
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirport;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    public Search(Airport arrivalAirport, Date arrivalDate, Airport departureAirportSearch, Date departureDate) {
        this.arrivalAirport = arrivalAirport;
        this.arrivalDate = arrivalDate;
        this.departureAirport = departureAirportSearch;
        this.departureDate = departureDate;
    }

    public Search() {
        this.departureAirport = null;
        this.departureDate = null;
        this.arrivalAirport = null;
        this.arrivalDate = null;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirportSearch) {
        this.arrivalAirport = arrivalAirportSearch;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDateSearch) {
        this.arrivalDate = arrivalDateSearch;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirportSearch) {
        this.departureAirport = departureAirportSearch;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDateSearch) {
        this.departureDate = departureDateSearch;
    }

    @Override
    public String toString() {
        return "Search{" +
                "departureAirportSearch=" + departureAirport +
                ", departureDateSearch=" + departureDate +
                "arrivalAirportSearch=" + arrivalAirport +
                ", arrivalDateSearch=" + arrivalDate +
                '}';
    }
}
