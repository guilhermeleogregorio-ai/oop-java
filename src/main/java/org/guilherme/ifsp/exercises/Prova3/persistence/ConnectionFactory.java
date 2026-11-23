package org.guilherme.ifsp.exercises.Prova3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionFactory {
    static private Connection connection = null;
    static private final String url = "jdbc:sqlite:database.db";

    private ConnectionFactory() {
    }

    static public Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(url);
        }
        return connection;
    }

    static public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
