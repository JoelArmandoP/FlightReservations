package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.user.SampleUsers;

import java.util.Date;

/**
 * Sample of reservations for test purposes.
 */
public class SampleReservations {
    public static final Reservation reservation1 = new Reservation(SampleUsers.user1, 0, 2, null);
    public static final Reservation reservation2 = new Reservation(SampleUsers.user2, 2, 0, null);
    public static final Reservation reservation3 = new Reservation(SampleUsers.user3, 0, 2, null);
    public static final Reservation reservation4 = new Reservation(SampleUsers.user4, 2, 0, null);
}
