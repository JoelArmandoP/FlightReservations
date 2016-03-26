package com.joel.flightreservations.domain.model.airport;

import java.util.List;
/**
 * An interface to find airports
 */

public interface AirportRepository {

    Airport find(AirportCode airportCode);

    List<Airport> findAll();
}
