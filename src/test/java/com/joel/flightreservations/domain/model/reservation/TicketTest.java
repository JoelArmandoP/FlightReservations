package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.user.SampleUsers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Ticket class.
 */
public class TicketTest {

    @Test
    public void testSetGetPassengerName() throws Exception {
        Ticket ticket = new Ticket(SampleTickets.ticket1);
        assertEquals("Juana De Arco", ticket.getPassengerName());
        ticket.setPassengerName("La loca");
        assertEquals("La loca", ticket.getPassengerName());
    }

    @Test
    public void testSetGetReservation() throws Exception {
        Ticket ticket = new Ticket(SampleTickets.ticket1);
        assertSame(SampleReservations.reservation1, ticket.getReservation());
        ticket.setReservation(SampleReservations.reservation2);
        assertSame(SampleReservations.reservation2, ticket.getReservation());
    }

    @Test
    public void testGetTicketNumber() throws Exception {
        assertEquals("AA-030-johndo-001", SampleTickets.ticket1.getTicketNumber());
        assertEquals("BA-149-marydo-004", SampleTickets.ticket2.getTicketNumber());
    }
}