package com.joel.flightreservations.domain.model.flight;

import com.joel.flightreservations.domain.model.airline.Airline;
import com.joel.flightreservations.domain.model.airline.AirlineCode;
import com.joel.flightreservations.domain.model.airport.Airport;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.List;

/**
 * Interface to Flights.
 */
public interface FlightRepository {
    List<Flight> find(Airline airline, String flightNumber);
    List<List<Flight>> findFlightsConnecting(Airport origin, Airport destination, Date earliestDepartureTime);
    List<Flight> findAll();
}
