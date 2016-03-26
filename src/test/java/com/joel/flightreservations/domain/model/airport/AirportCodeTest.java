package com.joel.flightreservations.domain.model.airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the AirportCode class.
 */
public class AirportCodeTest {
    AirportCode lhr;
    AirportCode ltn;
    AirportCode lgw;

    @Before
    public void setUp() throws Exception {
        this.lhr = new AirportCode("lhr");
        this.ltn = new AirportCode("LTN");
        this.lgw = new AirportCode("lGW");
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorValidationArgNull() throws Exception {
        AirportCode c = new AirportCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorValidationArgInvalid() throws Exception {
        AirportCode c = new AirportCode("not a IATA code");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("LHR", this.lhr.toString());
        assertEquals("LTN", this.ltn.toString());
        assertEquals("LGW", this.lgw.toString());
    }

    @Test
    public void testGetIdString() throws Exception {
        assertEquals("LHR", this.lhr.getIdString());
        assertEquals("LTN", this.ltn.getIdString());
        assertEquals("LGW", this.lgw.getIdString());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(this.lhr.equals(new AirportCode("LHR")));
        assertFalse((this.lhr.equals(this.lgw)));
    }
}