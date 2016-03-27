package com.joel.flightreservations.domain.model.flight;

import com.joel.flightreservations.domain.model.airline.SampleAirlines;
import com.joel.flightreservations.domain.model.airport.SampleAirports;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * A sample of flights for testing.
 */
public class SampleFlights {

    public static final Flight BA149 = new Flight(
            SampleAirlines.BRITISHAIRWAYS,"149", SampleAirports.LNDHR,
            SampleAirports.LNDHR.getTimeStamp(2016, 4, 15, 12, 30), SampleAirports.HAMBURG,
            SampleAirports.HAMBURG.getTimeStamp(2016, 4, 15, 16, 30));
    public static final Flight AA030 = new Flight(
            SampleAirlines.AMERICANAIRLINES,"030", SampleAirports.DALLASFW,
            SampleAirports.DALLASFW.getTimeStamp(2016, 5, 15, 12, 30),
            SampleAirports.CHICAGO, SampleAirports.CHICAGO.getTimeStamp(2016, 5, 15, 16, 30));
    public static final Flight M8255 = new Flight(
            SampleAirlines.MEKONGAIRLINES,"255", SampleAirports.MELBOURNE,
            SampleAirports.MELBOURNE.getTimeStamp(2016, 5, 15, 8, 30),
            SampleAirports.HONGKONG, SampleAirports.HONGKONG.getTimeStamp(2016, 5, 15, 16, 30));

}
