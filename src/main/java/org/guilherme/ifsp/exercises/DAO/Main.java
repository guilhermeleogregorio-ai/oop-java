package org.guilherme.ifsp.exercises.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       // Employee employee = new Employee(1, 12365, "Sam", "Spade", 3);

        //System.out.println(employee);

//        Connection con = Database.getConnection();
//
//        if(con != null){
//            System.out.println("Database connection sucessfull");
//        }
        Database.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = employeeDAO.get(1);

        System.out.println(employee);
    }
}
