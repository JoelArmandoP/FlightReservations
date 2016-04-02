package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.user.SampleUsers;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Test the reservation class.
 */
public class ReservationTest {

    public Date buildDate(int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        cal.set(year, month, day, hour, minute, 0);
        return cal.getTime();
    }

    @Test
    public void testSetGetExpiryDate() throws Exception {
        SampleReservations.reservation1.setExpiryDate(buildDate(2016, 10, 8, 6,30));
        assertEquals("Tue Nov 08 06:30:00 GMT 2016", SampleReservations.reservation1.getExpiryDate().toString());
    }

    @Test
    public void testSetGetSeatsEconClass() throws Exception {
        Reservation reservationcopy1 = new Reservation(SampleUsers.user1, 0,2,null);
        assertEquals(0, reservationcopy1.getSeatsEconClass());
        SampleReservations.reservation1.setSeatsEconClass(4);
        assertEquals(4, SampleReservations.reservation1.getSeatsEconClass());

    }

    @Test
    public void testSetGetSeatsFirstClass() throws Exception {
        assertEquals(0, SampleReservations.reservation1.getSeatsEconClass());
        SampleReservations.reservation1.setSeatsEconClass(4);
        assertEquals(4, SampleReservations.reservation1.getSeatsEconClass());

    }
    @Test
    public void testGetSetUser() throws Exception {
        Reservation reservationcopy1 = new Reservation(SampleUsers.user1, 0,2,null);
        assertEquals("JohnDoe",reservationcopy1.getUser().getUsername());
        reservationcopy1.setUser(SampleUsers.user2);
        assertEquals("MaryDoe",reservationcopy1.getUser().getUsername());
    }
}