package com.joel.flightreservations.util;

import javax.enterprise.inject.Alternative;
import java.time.Instant;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * A frozer TimeProvider for testing
 */
@Alternative
public class FixedTimeProvider implements TimeProvider {

    public Instant instant() {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        cal.set(1973, 10, 4, 8, 15, 0);
        return cal.getTime().toInstant();
    }

}
