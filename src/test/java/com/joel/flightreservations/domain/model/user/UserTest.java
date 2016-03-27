package com.joel.flightreservations.domain.model.user;

import com.joel.flightreservations.domain.model.airport.SampleAirports;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Test the User class.
 */
public class UserTest {

    @Test
    public void testGetUsername() throws Exception {
        assertEquals("JohnDoe", SampleUsers.user1.getUsername());
        assertEquals("MaryDoe", SampleUsers.user2.getUsername());

    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("John Doe", SampleUsers.user1.getName());
        assertEquals("Mary Doe", SampleUsers.user2.getName());

    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("john123", SampleUsers.user1.getPassword());
        assertEquals("mary123", SampleUsers.user2.getPassword());
    }

    @Test
    public void testGetLastSearch() throws Exception {
        SampleUsers.user1.setLastSearch(new Search(
                SampleAirports.CHICAGO, SampleAirports.CHICAGO.getTimeStamp(2016, 12, 12, 6, 30),
                SampleAirports.NYCJFK, SampleAirports.NYCJFK.getTimeStamp(2016, 12, 20, 6,30)));
        assertEquals("Search{departureAirportSearch=New York-John F Kennedy [JFK], " +
                "departureDateSearch=Fri Jan 20 06:30:00 GMT 2017arrivalAirportSearch=Chicago-O'Hare [ORD]," +
                " arrivalDateSearch=Thu Jan 12 06:30:00 GMT 2017}",
                SampleUsers.user1.getLastSearch().toString());
    }

    @Test
    public void testEquals() throws Exception {
        User user1copy = new User("JohnDoe", "John Doe", "john123");
        assertTrue(SampleUsers.user1.getName().equals(user1copy.getName()) &&
        SampleUsers.user1.getUsername().equals(user1copy.getUsername()));
        assertFalse(SampleUsers.user2.getName().equals(user1copy.getName()) &&
                SampleUsers.user1.getUsername().equals(user1copy.getUsername()));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("User{ name='John Doe', username='JohnDoe', lastSearch=Search{" +
                "departureAirportSearch=null, departureDateSearch=nullarrivalAirportSearch=null, arrivalDateSearch=null}}",
                SampleUsers.user1.toString());
    }
}