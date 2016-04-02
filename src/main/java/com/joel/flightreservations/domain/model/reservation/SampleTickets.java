package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.flight.SampleFlights;
import com.joel.flightreservations.domain.model.user.SampleUsers;

/**
 * Sample of tickets for test purposes.
 */
public class SampleTickets {
    public static final Ticket ticket1 = new Ticket(SampleReservations.reservation1,
            SampleFlights.AA030, "Juana De Arco", 1);
    public static final Ticket ticket2 = new Ticket(SampleReservations.reservation2,
            SampleFlights.BA149, "John Doe", 4);
}
