package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.flight.Flight;
import com.joel.flightreservations.domain.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * A ticket is a confirmed reservation.
 */
@Entity
public class Ticket {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Pattern(regexp = "[A-Z0-9]{2}-[0-9]{3}-[a-z0-9]{6}-[0-9]*")
    private String ticketNumber;
    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;
    @NotNull
    private String passengerName;
    @NotNull
    private int sequence;

    public Ticket(Reservation reservation, Flight flight, String passengerName, int sequence) {
        this.setPassengerName(passengerName);
        this.setReservation(reservation);
        this.setFlight(flight);
        this.setSequence(sequence);
    }

    public String getTicketNumber() {
        return flight.getAirline().getAirlineCode() + "-" + flight.getFlightNumber() + "-" +
                reservation.getUser().getUsername().substring(0, 6) + "-"  + String.format("%03d", getSequence());
    }

    public Ticket() {
    }

    public Ticket(Ticket ticket) {
        this(ticket.getReservation(), ticket.getFlight(), ticket.getPassengerName(), ticket.getSequence());
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return this.id == ticket.id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
