package org.guilherme.ifsp.exercises.DAO.view;

import org.guilherme.ifsp.exercises.DAO.controller.employeeController;
import org.guilherme.ifsp.exercises.DAO.model.Employee;
import org.guilherme.ifsp.exercises.DAO.model.dao.EmployeeDAO;
import org.guilherme.ifsp.exercises.DAO.model.dao.EmployeeDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
            employeeController controller = new employeeController();

                // 1. CREATE (Insert)
                System.out.println("--- 1. INSERINDO ---");
                System.out.println(controller.cadastrar( 25564, "Jon", "Don", 5));

                // 2. READ ALL (GetAll) - Pega todos para descobrir o ID gerado pelo banco
                System.out.println("\n--- 2. LISTANDO TODOS ---");
                List<Employee> lista = controller.listarTodos();
                lista.forEach(System.out::println);

                // Pega o último funcionário inserido na lista para usar o ID real dele nos próximos testes
                int idReal =  lista.get(lista.size() - 1).getDepId();


                // 3. READ ONE (Get)
                System.out.println("\n--- 3. BUSCANDO POR ID (" + idReal + ") ---");
                System.out.println("Encontrado: " + controller.bu

                // 4. UPDATE
                System.out.println("\n--- 4. ATUALIZANDO ---");
                Employee paraAtualizar = new Employee(idReal, 25564, "Pedro", "Black", 5);
                int linhasAtualizadas = employeeDAO.update(paraAtualizar);
                System.out.println("Linhas atualizadas: " + linhasAtualizadas);
                System.out.println("Depois do update: " + employeeDAO.get(idReal));

                // 5. DELETE
                System.out.println("\n--- 5. DELETANDO ---");
                int linhasDeletadas = employeeDAO.delete(paraAtualizar);
                System.out.println("Linhas deletadas: " + linhasDeletadas);
                System.out.println("Busca após deletar (deve ser null): " + employeeDAO.get(idReal));

    }
}
