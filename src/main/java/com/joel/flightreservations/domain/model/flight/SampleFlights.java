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
    private static Date buildDate(TimeZone tz, int year, int month, int day, int hour, int minute) {
        GregorianCalendar cal = new GregorianCalendar(tz);
        cal.set(year, month, day, hour, minute, 0);
        return cal.getTime();
    }

    private static Date buildDate(String tzName, int year, int month, int day, int hour, int minute) {
        return buildDate(TimeZone.getTimeZone(tzName), year, month, day, hour, minute);
    }

    private static Date buildDate(int year, int month, int day, int hour, int minute) {
        return buildDate(TimeZone.getTimeZone("GMT+0"), year, month, day, hour, minute);
    }
    public static final Flight BA149 = new Flight(
            SampleAirlines.BRITISHAIRWAYS,"149", SampleAirports.LNDHR,
            buildDate(2016, 4, 15, 12, 30), SampleAirports.HAMBURG, buildDate(2016, 4, 15, 16, 30));
    public static final Flight AA030 = new Flight(
            SampleAirlines.AMERICANAIRLINES,"030", SampleAirports.DALLASFW,
            buildDate(2016, 5, 15, 12, 30), SampleAirports.CHICAGO, buildDate(2016, 5, 15, 16, 30));
    public static final Flight M8255 = new Flight(
            SampleAirlines.MEKONGAIRLINES,"255", SampleAirports.MELBOURNE,
            buildDate(2016, 5, 15, 8, 30), SampleAirports.HONGKONG, buildDate(2016, 5, 15, 16, 30));

}
