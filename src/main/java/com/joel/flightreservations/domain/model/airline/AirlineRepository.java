package com.joel.flightreservations.domain.model.airline;

import java.util.List;

/**
 * An interface to find airlines
 */
public interface AirlineRepository {

    Airline find(AirlineCode airlineCode);

    List<Airline> findAll();
}
