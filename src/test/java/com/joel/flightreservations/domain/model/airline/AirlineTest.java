package com.joel.flightreservations.domain.model.airline;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the Airline class
 */
public class AirlineTest {

    @Test
    public void testGetAirlineCode() throws Exception {
        assertEquals(new AirlineCode("AR"), SampleAirlines.AEROLINEASARGENTINAS.getAirlineCode());
        assertEquals(new AirlineCode("AA"), SampleAirlines.AMERICANAIRLINES.getAirlineCode());
        assertEquals(new AirlineCode("BA"), SampleAirlines.BRITISHAIRWAYS.getAirlineCode());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Aerolineas Argentinas", SampleAirlines.AEROLINEASARGENTINAS.getName());
        assertEquals("Lufthansa", SampleAirlines.LUFTHANSA.getName());
        assertEquals("Mekong Airlines", SampleAirlines.MEKONGAIRLINES.getName());
    }

    @Test
    public void testEquals() throws Exception {
        Airline airline1 = new Airline(new AirlineCode("BA"), "British Airways");
        assertTrue(SampleAirlines.BRITISHAIRWAYS.getName().equals(airline1.getName()) && SampleAirlines.BRITISHAIRWAYS.getAirlineCode().equals(airline1.getAirlineCode()));
        assertFalse(SampleAirlines.AEROLINEASARGENTINAS.getName().equals(airline1.getName()) && SampleAirlines.AEROLINEASARGENTINAS.getAirlineCode().equals(airline1.getAirlineCode()));

    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Lufthansa [LH]", SampleAirlines.LUFTHANSA.toString());
        assertEquals("Lan Airlines [LA]", SampleAirlines.LANAIRLINES.toString());
        assertEquals("Mihin Lanka [MJ]", SampleAirlines.MIHINLANKA.toString());

    }
}