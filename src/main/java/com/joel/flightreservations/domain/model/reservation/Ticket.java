package com.joel.flightreservations.domain.model.reservation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A ticket is a confirmed reservation.
 */
@Entity
public class Ticket {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;
    @NotNull
    String passengerName;

    public Ticket(String passengerName, Reservation reservation) {
        this.passengerName = passengerName;
        this.reservation = reservation;
    }

    public Ticket() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (getReservation() != null ? !getReservation().equals(ticket.getReservation()) : ticket.getReservation() != null)
            return false;
        return getPassengerName() != null ? getPassengerName().equals(ticket.getPassengerName()) : ticket.getPassengerName() == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
