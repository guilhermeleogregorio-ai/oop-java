package org.guilherme.ifsp.exercises.DAO.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    //Cria a tabela se ela não existir
    public static void init() throws SQLException{
        String sql = """
                CREATE TABLE IF NOT EXISTS employee(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                employee_id INTEGER,
                first_name TEXT,
                last_name TEXT,
                depto_id INTEGER
                )
                """;
        try(Connection con = getConnection();
        Statement st = con.createStatement()){
            st.execute(sql);
        }
    }
}
