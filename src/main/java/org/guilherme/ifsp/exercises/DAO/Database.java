package org.guilherme.ifsp.exercises.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String url = "jdbc:sqlite:employeedb.db";
    private static String user = "root";
    private  static String passowrd = "password";

    private Database() {
    }

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,passowrd);

        return connection;
    }
}
