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
        assertEquals("Juana De Arco", SampleTickets.ticket1.getPassengerName());
        Ticket ticketcopy1 = new Ticket("Juana De Arco", SampleReservations.reservation1);
        assertEquals("Juana De Arco", ticketcopy1.getPassengerName());
        ticketcopy1.setPassengerName("La loca");
        assertEquals("La loca", ticketcopy1.getPassengerName());
    }

    @Test
    public void testSetGetReservation() throws Exception {
        Ticket ticketcopy1 = new Ticket("Juana De Arco", new Reservation(SampleUsers.user2, 4,5,null));
        assertEquals("Reservation{expiryDate=null, seatsEconClass=4, seatsFirstClass=5, username=Mary Doe}",
                ticketcopy1.getReservation().toString());
        ticketcopy1.setReservation(new Reservation(SampleUsers.user1, 0,2,null));
        assertEquals("Reservation{expiryDate=null, seatsEconClass=0, seatsFirstClass=2, username=John Doe}",
                ticketcopy1.getReservation().toString());
    }

}