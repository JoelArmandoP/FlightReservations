package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.user.SampleUsers;

/**
 * Sample of tickets for test purposes.
 */
public class SampleTickets {
    public static final Ticket ticket1 = new Ticket("Juana De Arco", SampleReservations.reservation1);
    public static final Ticket ticket2 = new Ticket("John Doe", SampleReservations.reservation1);
}
