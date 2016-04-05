package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.airport.SampleAirports;
import com.joel.flightreservations.domain.model.flight.Flight;
import com.joel.flightreservations.domain.model.flight.SampleFlights;
import com.joel.flightreservations.domain.model.user.SampleUsers;
import com.joel.flightreservations.util.FixedTimeProvider;
import org.junit.Test;

import java.time.temporal.ChronoUnit;
import java.util.*;

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
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        Date expiration = buildDate(2016, 10, 8, 6,30);
        reservation.setExpirationDate(expiration);
        assertEquals(expiration, reservation.getExpirationDate());
    }

    @Test
    public void testSetGetSeatsBusiness() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        assertEquals(2, reservation.getBusinessSeats());
        reservation.setBusinessSeats(4);
        assertEquals(4, reservation.getBusinessSeats());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantAddEconomyReservationToBusinessSeats() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        assertEquals(2, reservation.getBusinessSeats());
        reservation.setEconomySeats(4);
    }
    @Test
    public void testSetGetSeatsEconomy() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation2);
        assertEquals(2, reservation.getEconomySeats());
        reservation.setEconomySeats(4);
        assertEquals(4, reservation.getEconomySeats());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCantAddBusinessSeatsToEconomyReservation() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation2);
        assertEquals(2, reservation.getEconomySeats());
        reservation.setBusinessSeats(4);
    }

    @Test
    public void testGetSetUser() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        assertEquals("johndoe",reservation.getUser().getUsername());
        reservation.setUser(SampleUsers.user2);
        assertEquals("marydoe",reservation.getUser().getUsername());
    }

    @Test
    public void testEmitTicket() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        Date exp = buildDate(2016, 1, 30, 12, 0);
        reservation.setExpirationDate(exp);
        assertEquals(exp, reservation.getExpirationDate());
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(SampleFlights.AA030));
        flights.add(new Flight(SampleFlights.BA149));
        reservation.setFlightCollection(flights);
        List<String> passengerNames = new ArrayList<>();
        passengerNames.add("Mickey Mouse");
        passengerNames.add("Patoruzu");
        reservation.emitTickets(passengerNames);
        Collection<Ticket> tickets = reservation.getTicketCollection();
        assertEquals(4, tickets.size());
        assertNull(reservation.getExpirationDate());
        Ticket[] ticketArray = tickets.toArray(new Ticket[tickets.size()]);
        Arrays.sort(ticketArray, (a, b) -> a.getTicketNumber().compareTo(b.getTicketNumber()));
        String[] ticketNumbers = Arrays.stream(ticketArray).map(Ticket::getTicketNumber).toArray(String[]::new);
        assertArrayEquals(
                new String[] {"AA-030-johndo-001", "AA-030-johndo-002", "BA-149-johndo-001", "BA-149-johndo-002"},
                ticketNumbers);
        String[] ticketPassengerNames = Arrays.stream(ticketArray).map(Ticket::getPassengerName).
                toArray(String[]::new);
        assertArrayEquals(
                new String[] {"Mickey Mouse", "Patoruzu", "Mickey Mouse", "Patoruzu"},
                ticketPassengerNames);
    }

    @Test
    public void testReserveSeats() throws Exception {
        Reservation reservation = new Reservation(SampleReservations.reservation1);
        List<Flight> flights = new ArrayList<>();
        Flight f1 = new Flight(SampleFlights.AA030);
        flights.add(f1);
        Flight f2 = new Flight(SampleFlights.BA149);
        flights.add(f2);
        reservation.setFlightCollection(flights);
        reservation.reserve(buildDate(1973, 9, 4, 8, 30));
        assertEquals(Flight.BUSINESS_VACANCIES - reservation.getBusinessSeats(), f1.getBusinessClassVacancies());
        assertEquals(Flight.ECONOMY_VACANCIES, f1.getEconomyClassVacancies());
        assertEquals(Flight.BUSINESS_VACANCIES - reservation.getBusinessSeats(), f2.getBusinessClassVacancies());
        assertEquals(Flight.ECONOMY_VACANCIES, f2.getEconomyClassVacancies());
        assertTrue(Math.abs(buildDate(1973, 9, 4, 8, 32).getTime() - reservation.getExpirationDate().getTime()) < 100);
    }

}