package com.joel.flightreservations.util;

import java.time.Instant;

/**
 * An object that can return the current time
 */
public interface TimeProvider {
    public Instant instant();
}
