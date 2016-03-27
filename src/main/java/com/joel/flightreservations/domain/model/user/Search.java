package com.joel.flightreservations.domain.model.user;

import com.joel.flightreservations.domain.model.airport.Airport;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * A search made by a user.
 */
@Embeddable
public class Search {
    @ManyToOne
    @JoinColumn(name = "departureAirportId")
    private Airport departureAirportSearch;
    private Date departureDateSearch;
    @ManyToOne
    @JoinColumn(name = "arrivalAirportId")
    private Airport arrivalAirportSearch;
    private Date arrivalDateSearch;

    public Search(Airport arrivalAirportSearch, Date arrivalDateSearch, Airport departureAirportSearch, Date departureDateSearch) {
        this.arrivalAirportSearch = arrivalAirportSearch;
        this.arrivalDateSearch = arrivalDateSearch;
        this.departureAirportSearch = departureAirportSearch;
        this.departureDateSearch = departureDateSearch;
    }

    public Search() {
        this.departureAirportSearch = null;
        this.departureDateSearch = null;
        this.arrivalAirportSearch = null;
        this.arrivalDateSearch = null;
    }

    public Airport getArrivalAirportSearch() {
        return arrivalAirportSearch;
    }

    public void setArrivalAirportSearch(Airport arrivalAirportSearch) {
        this.arrivalAirportSearch = arrivalAirportSearch;
    }

    public Date getArrivalDateSearch() {
        return arrivalDateSearch;
    }

    public void setArrivalDateSearch(Date arrivalDateSearch) {
        this.arrivalDateSearch = arrivalDateSearch;
    }

    public Airport getDepartureAirportSearch() {
        return departureAirportSearch;
    }

    public void setDepartureAirportSearch(Airport departureAirportSearch) {
        this.departureAirportSearch = departureAirportSearch;
    }

    public Date getDepartureDateSearch() {
        return departureDateSearch;
    }

    public void setDepartureDateSearch(Date departureDateSearch) {
        this.departureDateSearch = departureDateSearch;
    }

    @Override
    public String toString() {
        return "Search{" +
                "departureAirportSearch=" + departureAirportSearch +
                ", departureDateSearch=" + departureDateSearch +
                "arrivalAirportSearch=" + arrivalAirportSearch +
                ", arrivalDateSearch=" + arrivalDateSearch +
                '}';
    }
}
