package org.guilherme.ifsp.exercises.Prova3.Main;

import org.guilherme.ifsp.exercises.Prova3.costs.PeriodCostDao;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDao;
import org.guilherme.ifsp.exercises.Prova3.customer.RegisterCustomerService;
import org.guilherme.ifsp.exercises.Prova3.persistence.CustomerDaoImpl;
import org.guilherme.ifsp.exercises.Prova3.persistence.DatabaseBuilder;
import org.guilherme.ifsp.exercises.Prova3.persistence.EntryTicketDtoImpl;
import org.guilherme.ifsp.exercises.Prova3.persistence.PeriodCostDaoImpl;
import org.guilherme.ifsp.exercises.Prova3.ticket.RegisterEntryService;
import org.guilherme.ifsp.exercises.Prova3.ticket.RegisterExitService;
import org.guilherme.ifsp.exercises.Prova3.ticket.TicketDao;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DatabaseBuilder.buildDatabase();

        // 1. Instanciação dos repositórios (DAOs)
        CustomerDao customerDao = new CustomerDaoImpl();
        TicketDao ticketDao = new EntryTicketDtoImpl();
        PeriodCostDao periodCostDao = new PeriodCostDaoImpl();

        // 2. Instanciação dos três services com injeção de dependência
        RegisterCustomerService registerCustomerService = new RegisterCustomerService(customerDao);
        RegisterEntryService registerEntryService = new RegisterEntryService(customerDao, ticketDao);
        RegisterExitService registerExitService = new RegisterExitService(customerDao, ticketDao, periodCostDao);

        try {
            // 3. Registra um customer, uma entrada e uma saída
            String novaPlaca = "ABC1234";
            registerCustomerService.register(novaPlaca, "16999998888", "CAR");
            registerEntryService.register(novaPlaca);
            double valorNovoCliente = registerExitService.register(novaPlaca);
            System.out.printf("Placa %s - Valor pago (menos de 1h): R$ %.2f%n", novaPlaca, valorNovoCliente);

            // 4. Testa a placa POO0007 (7h incompletas -> menor valor: plano 12h = R$ 30,00)
            double valorPoo0007 = registerExitService.register("POO0007");
            System.out.printf("Placa POO0007 - Valor pago (7h incompletas): R$ %.2f%n", valorPoo0007);

            // 5. Testa a placa POO0015 (15h incompletas -> menor valor: 12h + 2h + 1h = R$ 47,00)
            double valorPoo0015 = registerExitService.register("POO0015");
            System.out.printf("Placa POO0015 - Valor pago (15h incompletas): R$ %.2f%n", valorPoo0015);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
