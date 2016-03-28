package com.joel.tools.jpa;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.Persistence;

import org.hibernate.jpa.AvailableSettings;

public class JpaSchemaExport {

    public static void main(String[] args) throws IOException {
        execute(args[0], args[1], args[2]);
        System.exit(0);
    }

    public static void execute(String persistenceUnitName, String path, String action) {
        System.out.println("Generating DDL create scripts to : " + path);

        final Properties persistenceProperties = new Properties();

        // XXX force persistence properties : remove database target
        persistenceProperties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, action);

        // XXX force persistence properties : define create script target from metadata to destination
        // persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SCHEMAS, "true");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, action);
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET, path + persistenceUnitName + "-create.sql");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_DROP_TARGET, path + persistenceUnitName + "-drop.sql");

        Persistence.generateSchema(persistenceUnitName, persistenceProperties);
    }
}
