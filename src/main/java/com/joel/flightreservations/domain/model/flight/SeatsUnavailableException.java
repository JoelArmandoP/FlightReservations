package com.joel.flightreservations.domain.model.flight;

/**
 * Thrown when there was an attempt to reserve more seats than available.
 */
public class SeatsUnavailableException extends Exception {
    public SeatsUnavailableException() {
        super("Not enough seats to satisfy reservation.");
    }

    public SeatsUnavailableException(String message) {
        super(message);
    }
}
