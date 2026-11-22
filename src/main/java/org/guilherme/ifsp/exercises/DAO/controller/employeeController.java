package org.guilherme.ifsp.exercises.DAO.controller;

import org.guilherme.ifsp.exercises.DAO.model.Employee;
import org.guilherme.ifsp.exercises.DAO.model.dao.EmployeeDAO;
import org.guilherme.ifsp.exercises.DAO.model.dao.EmployeeDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class employeeController {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public String cadastrar(int employeeId, String firstName, String lastName, int depId){
        if(firstName == null || firstName.isBlank()){
            return "Erro: O primeiro nome é obrigatorio";
        }
        try{
            Employee emp = new Employee(0, employeeId, firstName, lastName, depId);
            int linhas = employeeDAO.insert(emp);
            return linhas > 0 ? "Funcionario cadastrado com sucesso!" : "Não foi possível cadastrar ";
        }catch (SQLException e){ return "Eroo no banco de dados: " + e.getMessage();}
    }

    public List<Employee> listarTodos(){
        try{
            return employeeDAO.getAll();
        }catch (SQLException e){
            System.err.println("Erro ao listar: " + e.getMessage());
            return List.of();
        }
    }

    public String atualizar(int id,  int employeeId, String firstName, String lastName, int depId){
        if(id <= 0){
            return "Erro: ID inválido para atualização";
        }
        try {
            Employee emp = new Employee(id,employeeId,firstName,lastName,depId);
            int linhas = employeeDAO.update(emp);
            return linhas > 0 ? "Atualizado com sucesso!" : "Funcionario não encontrado";
        }catch (SQLException e){
            return "Erro  ao atualizar: " + e.getMessage();
        }
    }

    public String deletar(int id){
        try{
            Employee emp = new Employee(id,0,"","",0);
            int linhas = employeeDAO.delete(emp);
            return linhas > 0 ? "Deletado com sucesso! " : "Funcionario não encontrado!  ";
        }catch (Exception e){
            return "Erro ao deletar: " + e.getMessage();
        }
    }

}
