package com.joel.flightreservations.domain.model.reservation;

import com.joel.flightreservations.domain.model.flight.Flight;
import com.joel.flightreservations.domain.model.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

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
    private int seatsFirstClass;
    @NotNull
    private int seatsEconClass;
    private Date expiryDate;
    @ManyToMany(mappedBy = "reservationCollection")
    private Collection<Flight> flights;
    @OneToMany(mappedBy = "reservation")
    private Collection<Ticket> ticketCollection;


    public Reservation(User user, int seatsEconClass, int seatsFirstClass, Date expiryDate) {
        this.setUser(user);
        this.setSeatsEconClass(seatsEconClass);
        this.setSeatsFirstClass(seatsFirstClass);
        this.setExpiryDate(expiryDate);
    }

    public Reservation() {
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }

    public Collection<Ticket> getTicketCollection() {

        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getSeatsEconClass() {
        return seatsEconClass;
    }

    public void setSeatsEconClass(int seatsEconClass) {
        this.seatsEconClass = seatsEconClass;
    }

    public int getSeatsFirstClass() {
        return seatsFirstClass;
    }

    public void setSeatsFirstClass(int seatsFirstClass) {
        this.seatsFirstClass = seatsFirstClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "expiryDate=" + expiryDate +
                ", seatsEconClass=" + seatsEconClass +
                ", seatsFirstClass=" + seatsFirstClass +
                ", username=" + user.getFirstname() + " " + user.getLastname() +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
