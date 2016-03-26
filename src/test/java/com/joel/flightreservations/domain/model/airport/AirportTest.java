package com.joel.flightreservations.domain.model.airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the AirportCode class
 */
public class AirportTest {
    AirportCode lhr;
    AirportCode ltn;
    AirportCode lgw;
    Airport london;
    Airport lutton;
    Airport gatwick;

    @Before
    public void setUp() throws Exception {
        this.lhr = new AirportCode("LHR");
        this.ltn = new AirportCode("LTN");
        this.lgw = new AirportCode("lGW");
        this.london = new Airport(lhr, "London Heathrow");
        this.lutton = new Airport(ltn, "Lutton");
        this.gatwick = new Airport(lgw,"London Gatwick");
    }


    @Test
    public void testGetAirportCode() throws Exception {
        assertEquals("LHR", this.lhr.toString());
        assertEquals("LTN", this.ltn.toString());
        assertEquals("LGW", this.lgw.toString());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("London Heathrow", this.london.getName());
        assertEquals("Lutton", this.lutton.getName());
        assertEquals("London Gatwick", this.gatwick.getName());
    }

    @Test
    public void testEquals() throws Exception {
        Airport airport1 = new Airport(new AirportCode("LHR"), "London Heathrow");
        assertTrue(this.london.getName().equals(airport1.getName()) && this.london.getAirportCode().equals(airport1.getAirportCode()));
        assertFalse(this.gatwick.getName().equals(airport1.getName()) && this.gatwick.getAirportCode().equals(airport1.getAirportCode()));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("London Heathrow [LHR]", this.london.toString());
        assertEquals("Lutton [LTN]", this.lutton.toString());
        assertEquals("London Gatwick [LGW]", this.gatwick.toString());
    }
}