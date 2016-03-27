package com.joel.flightreservations.domain.model.airport;

import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Test the Airport class
 */
public class AirportTest {


    @Test
    public void testGetAirportCode() throws Exception {
        assertEquals("LHR", SampleAirports.LNDHR.getAirportCode().toString());
        assertEquals("LTN", SampleAirports.LUTON.getAirportCode().toString());
        assertEquals("LGW", SampleAirports.LNDGW.getAirportCode().toString());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("London-Heathrow", SampleAirports.LNDHR.getName());
        assertEquals("Luton", SampleAirports.LUTON.getName());
        assertEquals("London-Gatwick", SampleAirports.LNDGW.getName());
    }

    @Test
    public void testEquals() throws Exception {
        Airport airport1 = new Airport(new AirportCode("LHR"), "London-Heathrow", TimeZone.getTimeZone("BST"));
        assertTrue(SampleAirports.LNDHR.getName().equals(airport1.getName()) &&
                SampleAirports.LNDHR.getAirportCode().equals(airport1.getAirportCode()));
        assertFalse(SampleAirports.LNDGW.getName().equals(airport1.getName()) &&
                    SampleAirports.LNDGW.getAirportCode().equals(airport1.getAirportCode()));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("London-Heathrow [LHR]", SampleAirports.LNDHR.toString());
        assertEquals("Luton [LTN]", SampleAirports.LUTON.toString());
        assertEquals("London-Gatwick [LGW]", SampleAirports.LNDGW.toString());
    }
}