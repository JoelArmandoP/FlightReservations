package com.joel.flightreservations.domain.model.airline;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test the AirlineCode class.
 */
public class AirlineCodeTest {

    @Test(expected=NullPointerException.class)
    public void testConstructorValidationArgNull() throws Exception {
        AirlineCode c = new AirlineCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorValidationArgInvalid() throws Exception {
        AirlineCode c = new AirlineCode("not a IATA code");
    }


    @Test
    public void testToString() throws Exception {
        assertEquals("BA", SampleAirlines.BRITISHAIRWAYS.getAirlineCode().toString());
        assertEquals("LH", SampleAirlines.LUFTHANSA.getAirlineCode().toString());
        assertEquals("M8", SampleAirlines.MEKONGAIRLINES.getAirlineCode().toString());

    }

    @Test
    public void testGetIdString() throws Exception {
        assertEquals("BA", SampleAirlines.BRITISHAIRWAYS.getAirlineCode().getIdString());
        assertEquals("LH", SampleAirlines.LUFTHANSA.getAirlineCode().getIdString());
        assertEquals("M8", SampleAirlines.MEKONGAIRLINES.getAirlineCode().getIdString());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new AirlineCode("GQ").equals(SampleAirlines.BIGSKYAIRLINES.getAirlineCode()));
        assertFalse(new AirlineCode("GQ").equals(SampleAirlines.MEKONGAIRLINES.getAirlineCode()));
    }
}