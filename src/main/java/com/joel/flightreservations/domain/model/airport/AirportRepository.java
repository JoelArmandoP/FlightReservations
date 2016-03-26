package com.joel.flightreservations.domain.model.airport;

import java.util.List;

public interface AirportRepository {

    Airport find(IataCode unLocode);

    List<Airport> findAll();
}
