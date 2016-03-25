package com.joel.flightreservations.domain.model.airport;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the IataCode class.
 */
public class IataCodeTest {
    IataCode lhr;
    IataCode ltn;
    IataCode lgw;

    @Before
    public void setUp() throws Exception {
        this.lhr = new IataCode("lhr");
        this.ltn = new IataCode("LTN");
        this.lgw = new IataCode("lGW");
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorValidationArgNull() throws Exception {
        IataCode c = new IataCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorValidationArgInvalid() throws Exception {
        IataCode c = new IataCode("not a IATA code");
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
        assertTrue(this.lhr.equals(new IataCode("LHR")));
        assertFalse((this.lhr.equals(this.lgw)));
    }
}