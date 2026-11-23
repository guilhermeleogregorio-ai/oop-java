package org.guilherme.ifsp.exercises.Prova3.persistence;

import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDao;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public CustomerDto save(String plate, String phone, String type) throws SQLException {
        String sql = "INSERT INTO customer(plate, phone, type) VALUES (?,?,?)";

        try(PreparedStatement ps =  ConnectionFactory.getPreparedStatement(sql)){
            ps.setString(1,plate);
            ps.setString(2,phone);
            ps.setString(3,type);
            ps.executeUpdate();

            return new CustomerDto(plate,phone,type);
        }
    }

    @Override
    public CustomerDto findOne(String plate, String phone, String type) throws SQLException {
        String sql = "SELECT plate,phone,type FROM customer WHERE plate = ?";

        try (PreparedStatement ps = ConnectionFactory.getPreparedStatement(sql)) {
            ps.setString(1, plate);

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return new CustomerDto(rs.getString("plate"), rs.getString("phone"), rs.getString("type"));
                }
            }
        }
        return null;
    }

}
