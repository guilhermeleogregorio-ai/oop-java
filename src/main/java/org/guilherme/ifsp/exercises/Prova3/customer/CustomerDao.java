package org.guilherme.ifsp.exercises.Prova3.customer;

import java.sql.SQLException;

public interface CustomerDao {


    CustomerDto save(String plate, String phone, String type) throws SQLException;
    CustomerDto findOne(String plate, String phone, String type) throws SQLException;

}
