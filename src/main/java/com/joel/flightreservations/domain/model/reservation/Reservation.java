package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.flight.Flight;
import com.joel.flightreservations.domain.model.flight.SeatsUnavailableException;
import com.joel.flightreservations.domain.model.user.User;
import com.joel.flightreservations.util.TimeProvider;

import javax.inject.Inject;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * A reservation is an itinerary of flights reserved by one user with one or more passengers.
 * If it's confirmed it has a collections of tickets (one  per passenger).
 */
@Entity
public class Reservation {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @NotNull
    private int businessSeats;
    @NotNull
    private int economySeats;
    private Date expirationDate;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Flight> flightCollection;
    @OneToMany(mappedBy = "reservation")
    private Collection<Ticket> ticketCollection;

    public Reservation(User user, int economySeats, int businessSeats, Date expirationDate) {
        if (economySeats > 0 && businessSeats > 0)
            throw new IllegalArgumentException("Can't mix classes in a single reservation");
        if (economySeats < 0 || businessSeats < 0)
            throw new IllegalArgumentException("Can't reserve negative seats");
        this.setTicketCollection(new ArrayList<>());
        this.setFlightCollection(new ArrayList<>());
        this.setUser(user);
        this.setEconomySeats(economySeats);
        this.setBusinessSeats(businessSeats);
        this.setExpirationDate(expirationDate);
    }

    public Reservation() {}

    public Reservation(Reservation reservation) {
        this(reservation.getUser(), reservation.getEconomySeats(),
                reservation.getBusinessSeats(), reservation.getExpirationDate());
    }

    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flights) {
        this.flightCollection = flights;
    }

    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        if (ticketCollection.size() > 0 && expirationDate != null)
            return;
        this.expirationDate = expirationDate;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        if (getBusinessSeats() > 0 && economySeats > 0)
            throw new IllegalArgumentException("Can't add economy seats to a business reservation");
        if (economySeats < 0)
            throw new IllegalArgumentException("Can't reserve negative seats");
        this.economySeats = economySeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        if (getEconomySeats() > 0 && businessSeats > 0)
            throw new IllegalArgumentException("Can't add business seats to an economy reservation");
        if (businessSeats < 0)
            throw new IllegalArgumentException("Can't reserve negative seats");
        this.businessSeats = businessSeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void reserve(Date now) throws SeatsUnavailableException {
        for (Flight f: flightCollection) {
            f.reserveSeats(getEconomySeats(), getBusinessSeats());
        }
        setExpirationDate(Date.from(now.toInstant().plus(2, ChronoUnit.MINUTES)));
    }

    public void unreserve() {
        for (Flight f: flightCollection) {
            f.unreserveSeats(getEconomySeats(), getBusinessSeats());
        }
        setExpirationDate(null);
    }

    public boolean expired(Date now) {
        Date exp = getExpirationDate();
        return exp == null || exp.before(now);
    }

    public void emitTickets(List<String> passengerNames)  {
        if (passengerNames.size() != getBusinessSeats() + getEconomySeats())
            throw new IllegalArgumentException("Wrong number of passenger names.");
        for (Flight f: flightCollection) {
            int seqNo = 1;
            for (String passengerName: passengerNames) {
                ticketCollection.add(new Ticket(this, f, passengerName, seqNo));
                seqNo++;
            }
        }
        setExpirationDate(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;

        Reservation that = (Reservation) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "expirationDate=" + expirationDate +
                ", seatsEconClass=" + economySeats +
                ", seatsFirstClass=" + businessSeats +
                ", username=" + user.getFirstname() + " " + user.getLastname() +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
