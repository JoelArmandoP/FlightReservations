package com.joel.flightreservations.domain.model.flight;

import com.joel.flightreservations.domain.model.airline.Airline;
import com.joel.flightreservations.domain.model.airport.Airport;
import com.joel.flightreservations.domain.model.reservation.Reservation;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * A specific flight between two Airports on a given date.
 * In real life, flights would be imported from data provided by the airlines.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Flight.findAll", query = "Select f from Flight f"),
        @NamedQuery(name = "Flight.findByAirlineCodeAndFlightNumber",
                query = "Select f from Flight f where f.airline.airlineCode = :airlineCode AND f.flightNumber = :flightNumber"),
        @NamedQuery(name = "Flight.findDirectFlight",
                query = "Select f from Flight f " +
                        "where f.departureAirport.airportCode = :departureAirportCode and f.arrivalAirport.airportCode = :arrivalAirportCode " +
                        "and f.departureTime >= :departureTime order by f.departureTime")
})
public class Flight implements Serializable{

    private static final long serialVersionUID = 1L;
    public static final int BUSINESS_VACANCIES = 10;
    public static final int ECONOMY_VACANCIES = 90;
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @ManyToOne
    private Airline airline;
    @NotNull
    @Pattern(regexp = "[0-9]{3}")
    private String flightNumber;
    private static final java.util.regex.Pattern VALID_FLIGHT_NUMBER_PATTERN
            = java.util.regex.Pattern.compile("[0-9]{3}");
    @ManyToOne
    @NotNull
    private Airport departureAirport;
    @ManyToOne
    @NotNull
    private Airport arrivalAirport;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date departureTime;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date arrivalTime;
    @NotNull
    private int businessClassVacancies;
    @NotNull
    private int economyClassVacancies;
    @NotNull
    private float price;
    @ManyToMany
    private Collection<Reservation> reservationCollection;

    public Flight(Airline airline, String flightNumber,
                  Airport departureAirport, Date departureTime,
                  Airport arrivalAirport, Date arrivalTime, float price) {
        if (arrivalAirport == departureAirport)
            throw new IllegalArgumentException("Flight can't go from " + arrivalAirport + "to itself.");
        if (arrivalTime.before(departureTime))
            throw new IllegalArgumentException("Flight can't arrive before it leaves.");
        this.setAirline(airline);
        this.setFlightNumber(flightNumber);
        this.setArrivalAirport(arrivalAirport);
        this.setArrivalTime(arrivalTime);
        this.setDepartureAirport(departureAirport);
        this.setDepartureTime(departureTime);
        this.setBusinessClassVacancies(BUSINESS_VACANCIES);
        this.setEconomyClassVacancies(ECONOMY_VACANCIES);
        this.setPrice(price);
    }

    public Flight() {
    }

    public Flight(Flight f) {
        this(f.getAirline(), f.getFlightNumber(), f.getDepartureAirport(), f.getDepartureTime(),
                f.getArrivalAirport(), f.getArrivalTime(), f.getPrice());    }
    public String getFlightCode() {
        return airline.getAirlineCode() + getFlightNumber();
    }

    /**
     * Reserves seats on a flight.
     * @param economy the number of seats to be reserved in economy class
     * @param business the number of seats to be reserved in business class
     * @throws SeatsUnavailableException
     */
    public synchronized void reserveSeats(int economy, int business) throws SeatsUnavailableException {
        if (economy < 0 || business < 0)
            throw new IllegalArgumentException("Can't reserve a negative number of seats");
        if (getEconomyClassVacancies() < economy || getBusinessClassVacancies() < business)
            throw new SeatsUnavailableException(
                    "Unable to reserve " + economy + " economy and " + business +
                            " business tickets (available: " + getEconomyClassVacancies() +
                            ", " + getBusinessClassVacancies());
        setEconomyClassVacancies(getEconomyClassVacancies() - economy);
        setBusinessClassVacancies(getBusinessClassVacancies() - business);
    }

    /**
     * Frees seats on a flight.
     * @param economy the number of seats to be freed in economy class
     * @param business the number of seats to be freed in business class
     * @throws IllegalArgumentException
     */
    public synchronized void unreserveSeats(int economy, int business) {
        if (economy < 0 || business < 0)
            throw new IllegalArgumentException("Can't unreserve a negative number of seats");
        setEconomyClassVacancies(getEconomyClassVacancies() + economy);
        setBusinessClassVacancies(getBusinessClassVacancies() + business);
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBusinessClassVacancies() {
        return businessClassVacancies;
    }

    public void setBusinessClassVacancies(int businessClassVacancies) {
        Validate.inclusiveBetween(0, BUSINESS_VACANCIES, businessClassVacancies);
        this.businessClassVacancies = businessClassVacancies;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getEconomyClassVacancies() {
        return economyClassVacancies;
    }

    public void setEconomyClassVacancies(int economyClassVacancies) {
        Validate.inclusiveBetween(0, ECONOMY_VACANCIES, economyClassVacancies);
        this.economyClassVacancies = economyClassVacancies;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        Validate.isTrue(VALID_FLIGHT_NUMBER_PATTERN.matcher(flightNumber).matches(),
                flightNumber + " is not a valid flight number (does not match pattern)");
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        SimpleDateFormat departureDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm z");
        departureDateFormat.setTimeZone(getDepartureAirport().getTimeZone());
        SimpleDateFormat arrivalDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm z");
        arrivalDateFormat.setTimeZone(getArrivalAirport().getTimeZone());
        return getFlightCode() + " " + getDepartureAirport().getAirportCode() +
                getArrivalAirport().getAirportCode() + " " +
                departureDateFormat.format(getDepartureTime()) + " - " + arrivalDateFormat.format(getArrivalTime());
    }

    @Override
    public boolean equals(Object o) {
        return (this == o) || (o instanceof Flight && (id.equals(((Flight)o).id)));
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
