package com.joel.flightreservations.domain.model.airport;

import java.util.List;

public interface AirportRepository {

    Airport find(AirportCode unLocode);

    List<Airport> findAll();
}
