package org.guilherme.ifsp.exercises.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    //CRUD
    //SELECT
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = (Connection) Database.getConnection();
        Employee employee = null;

        String sql = "SELECT id,employee_id,first_name,last_name,depto_id FROM employee WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("id");
            int employeeId = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int deptId = rs.getInt("depto_id");

            employee = new Employee(oid,employeeId,firstName,lastName,deptId);
        }
        return employee;
    }
    //SELECT
    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT id,employee_id,first_name,last_name,depto_id FROM employee  ";

        try(Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    list.add(new Employee(
                            rs.getInt("id"),
                            rs.getInt("employee_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("depto_id")));
                }
        }catch (SQLException e){ e.printStackTrace();}
            return list;
    }
    //CREATE - INSERT
    @Override
    public int save(Employee employee) throws SQLException {
        return insert(employee);
    }
    // INSERT
    @Override
    public int insert(Employee employee) throws SQLException {

        String sql = "INSERT INTO employee (employee_id,first_name,last_name,depto_id) VALUES (?,?,?,?)";

        try (Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setInt(1, employee.getEmployeeId());
                ps.setString(2, employee.getFirstName());
                ps.setString(3, employee.getLastName());
                ps.setInt(4, employee.getDepId());
                int rs = ps.executeUpdate();
                return rs;
            }
    }
    //UPDATE
    @Override
    public int update(Employee employee) throws SQLException {

        String sql = "UPDATE employee SET employee_id = ? ,first_name = ?,last_name = ?,depto_id = ? WHERE id = ?";
        try (Connection c = Database.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setInt(4, employee.getDepId());
            ps.setInt(5,employee.getId());
            return ps.executeUpdate();
        }
    }
    //DELETE
    @Override
    public int delete(Employee employee) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try(Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,employee.getId());
            return ps.executeUpdate();
        }catch (SQLException e){ e.printStackTrace();}
        return 0;
    }

}
