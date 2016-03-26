package com.joel.flightreservations.domain.model.flight;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the flight class.
 */
public class FlightTest {

    @Test
    public void testReserveSeats() throws Exception {
        Flight f = new Flight(SampleFlights.BA149);
        f.reserveSeats(10, 0);
        Integer seats = 80;
        assertEquals(seats, f.getEconomyClassVacancies());
        f.unreserveSeats(10, 0);
        seats = 90;
        assertEquals(seats, f.getEconomyClassVacancies());
        f.reserveSeats(90, 0);
        seats = 0;
        assertEquals(seats, f.getEconomyClassVacancies());
        f.unreserveSeats(90, 0);
        f.reserveSeats(0, 10);
        seats = 0;
        assertEquals(seats, f.getBusinessClassVacancies());
        f.unreserveSeats(0, 10);
        f.reserveSeats(0, 8);
        seats = 2;
        assertEquals(seats, f.getBusinessClassVacancies());
        f.unreserveSeats(0, 8);
        f.reserveSeats(10, 5);
        seats = 80;
        Integer seats1 = 5;
        assertEquals(seats, f.getEconomyClassVacancies());
        assertEquals(seats1, f.getBusinessClassVacancies());
    }

    @Test(expected = SeatsUnavailableException.class)
    public void testReserveSeatsTooManyEconomy() throws Exception {
        Flight f = new Flight(SampleFlights.BA149);
        f.reserveSeats(92, 0);
    }

    @Test(expected = SeatsUnavailableException.class)
    public void testReserveSeatsTooManyBusiness() throws Exception {
        Flight f = new Flight(SampleFlights.BA149);
        f.reserveSeats(0, 15);
    }

    @Test
    public void testToString() throws Exception {
        Flight f = new Flight(SampleFlights.AA030);
        assertEquals("AA030 DFWORD Wed Jun 15 13:30:00 BST 2016-Wed Jun 15 17:30:00 BST 2016", f.toString());
        Flight f1 = new Flight(SampleFlights.M8255);
        assertEquals("M8255 MELHKG Wed Jun 15 09:30:00 BST 2016-Wed Jun 15 17:30:00 BST 2016", f1.toString());
    }
}