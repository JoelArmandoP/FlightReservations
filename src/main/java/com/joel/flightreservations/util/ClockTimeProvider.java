package com.joel.flightreservations.util;

import java.time.Clock;
import java.time.Instant;

/**
 * A Clock-based time provider
 */
public class ClockTimeProvider implements TimeProvider {

    public Instant instant() {
        return Clock.systemUTC().instant();
    }

}
