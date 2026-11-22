package org.guilherme.ifsp.exercises.JDBC.dao;

import org.guilherme.ifsp.exercises.JDBC.model.Product;
import org.guilherme.ifsp.exercises.JDBC.util.Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepository {
    //CRUD
    //CREATE = INSERT
    public void save(Product p){
        String sql = "INSERT INTO products(code,name,price, quantity) VALUES(?,?,?,?)";
        try(Connection c = Database.connect(); PreparedStatement st = c.prepareStatement(sql)){
            st.setString(1,p.getSku());
            st.setString(2,p.getName());
            st.setDouble(3,p.getPrice());
            st.setInt(4,p.getQuantity());
            st.executeUpdate();
        }catch (SQLException e ){ e .printStackTrace(); }
    }
    //READ = SELECT
    //UPDATE
    //DELETE
}
