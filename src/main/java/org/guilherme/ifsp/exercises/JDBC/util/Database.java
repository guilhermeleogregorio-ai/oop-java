package org.guilherme.ifsp.exercises.JDBC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "JDBC:sqlite:database.db";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL);
    }

    public static void init(){
        String sql = """
                CREATE TABLE IF NOT EXISTS products(
                    code TEXT NOT NULL PRIMARY KEY,
                    name TEXT, price REAL, quantity INTEGER)""";
        try(Connection c = connect(); Statement st = c.createStatement()){
            st.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
