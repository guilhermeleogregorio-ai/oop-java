package org.guilherme.ifsp.exercises.JDBC.dao;

import org.guilherme.ifsp.exercises.JDBC.model.Product;
import org.guilherme.ifsp.exercises.JDBC.util.Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    //READ(um) = SELECT
    public Optional<Product> findOne(String sku){
        String sql = "SELECT * FROM products WHERE code = ?";
        try(Connection c = Database.connect(); PreparedStatement st = c.prepareStatement(sql)){
            st.setString(1,sku);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return Optional.of(new Product(rs.getString("code"), rs.getString("name"),rs.getInt("quantity"),rs.getDouble("price")));
        }catch (SQLException e ){ e .printStackTrace();}
        return Optional.empty();
    }
    //READ(todos) = SELECT
    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        try(Connection c = Database.connect(); PreparedStatement st  = c.prepareStatement("SELECT * FROM products");
            ResultSet rs = st.executeQuery()){
                while (rs.next())
                    list.add(new Product(rs.getString("code"), rs.getString("name"),rs.getInt("quantity"),rs.getDouble("price")));
        }catch (SQLException e) {e.printStackTrace();}
        return  list;
    }
    //UPDATE
    public void update(Product p){
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        try(Connection c = Database.connect(); PreparedStatement st = c.prepareStatement(sql)) {
            st.setString(1,p.getName());
            st.setDouble(2,p.getPrice());
            st.setInt(3,p.getQuantity());
            st.setString(4,p.getSku()); //WHERE por último, como na ordem dos '?'
            st.executeUpdate();
        }catch (SQLException e ){e.printStackTrace();}
    }
    //DELETE
}
