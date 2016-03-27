package com.joel.flightreservations.domain.model.airport;

import java.util.TimeZone;

/**
 * Sample airports, for test purposes.
 */
public class SampleAirports {

    public static final Airport HONGKONG = new Airport(new AirportCode("HKG"), "Hong Kong", TimeZone.getTimeZone("UTC+8"));
    public static final Airport MELBOURNE = new Airport(new AirportCode("MEL"), "Melbourne", TimeZone.getTimeZone("GMT+10"));
    public static final Airport STOCKHOLM = new Airport(new AirportCode("ARN"), "Stockholm-Arlanda", TimeZone.getTimeZone("UTC+1"));
    public static final Airport HELSINKI = new Airport(new AirportCode("HEL"), "Helsinki-Vantaa", TimeZone.getTimeZone("UTC+1"));
    public static final Airport CHICAGO = new Airport(new AirportCode("ORD"), "Chicago-O'Hare", TimeZone.getTimeZone("UTC-6"));
    public static final Airport TOKYO = new Airport(new AirportCode("TYO"), "Tokyo", TimeZone.getTimeZone("UTC+9"));
    public static final Airport HAMBURG = new Airport(new AirportCode("HAM"), "Hamburg", TimeZone.getTimeZone("UTC+1"));
    public static final Airport SHANGHAI = new Airport(new AirportCode("SHA"), "Shanghai-Hongqiao",TimeZone.getTimeZone("UTC+8"));
    public static final Airport ROTTERDAM = new Airport(new AirportCode("RTM"), "Rotterdam", TimeZone.getTimeZone("UTC+1"));
    public static final Airport GOTHENBURG = new Airport(new AirportCode("GOT"), "Guttenburg", TimeZone.getTimeZone("UTC-6"));
    public static final Airport HANGZOU = new Airport(new AirportCode("HGH"), "Hangzhou", TimeZone.getTimeZone("UTC+8"));
    public static final Airport NYCJFK = new Airport(new AirportCode("JFK"), "New York-John F Kennedy", TimeZone.getTimeZone("UTC-5"));
    public static final Airport DALLASFW = new Airport(new AirportCode("DFW"), "Dallas-Forth Worth", TimeZone.getTimeZone("UTC-6"));
    public static final Airport LNDHR = new Airport(new AirportCode("LHR"), "London-Heathrow", TimeZone.getTimeZone("BST"));
    public static final Airport LNDGW = new Airport(new AirportCode("LGW"), "London-Gatwick", TimeZone.getTimeZone("BST"));
    public static final Airport LUTON = new Airport(new AirportCode("LTN"), "Luton", TimeZone.getTimeZone("BST"));
}
