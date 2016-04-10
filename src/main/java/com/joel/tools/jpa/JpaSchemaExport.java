package com.joel.tools.jpa;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.Persistence;

import org.hibernate.dialect.Sybase11Dialect;
import org.hibernate.jpa.AvailableSettings;

public class JpaSchemaExport {

    public static void main(String[] args) throws IOException {
        Persistence.generateSchema("com.joel.FlightReservations.jpa", null);
    }

}
