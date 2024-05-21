package com.citizentech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.log4j.Logger;

public class PostgreSQLConnection {
    final static Logger logger = Logger.getLogger(ConnectionHelper.class);
    private static ConnectionHelper instance;
    private Properties properties;


    private PostgreSQLConnection() throws Exception {
        loadProperties();
    }


    public static synchronized ConnectionHelper getInstance() throws Exception {
        if (instance == null) {
            instance = new ConnectionHelper();
        }
        return instance;
    }


    private void loadProperties() throws Exception {
        try (InputStream input = new FileInputStream("configcitizentech.properties")) {
            properties = new Properties();
            properties.load(input);
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            logger.error("Error loading properties", e);
            throw e;
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            properties.getProperty("db.url"),
            properties.getProperty("db.user"), 
            properties.getProperty("db.password")
        );
    }


    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }
    }
}