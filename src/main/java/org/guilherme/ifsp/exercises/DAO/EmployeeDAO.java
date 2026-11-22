package org.guilherme.ifsp.exercises.DAO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    Employee get(int id) throws SQLException;

    List<Employee> getAll() throws SQLException;

    int save(Employee employee) throws SQLException;

    int insert(Employee employee) throws SQLException;

    int update(Employee employee) throws SQLException;

    int delete(Employee employee);
}
