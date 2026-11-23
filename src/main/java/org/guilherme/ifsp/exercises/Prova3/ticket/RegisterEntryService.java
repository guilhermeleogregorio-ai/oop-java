package org.guilherme.ifsp.exercises.Prova3.ticket;

import org.guilherme.ifsp.exercises.Prova3.customer.Customer;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDao;
import org.guilherme.ifsp.exercises.Prova3.customer.CustomerDto;
import org.guilherme.ifsp.exercises.Prova3.customer.Type;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class RegisterEntryService {
    private final CustomerDao customerDao;
    private final TicketDao ticketDao;

    public RegisterEntryService(CustomerDao customerDao, TicketDao ticketDao) {
        this.customerDao = customerDao;
        this.ticketDao = ticketDao;
    }

    public EntryTicketDto register(String plate) throws SQLException {
        if(plate == null || plate.isBlank()){
            throw new IllegalStateException("Placa nula ou vazia");
        }
        CustomerDto customerDto = customerDao.findOne(plate,null,null);
        if(customerDto == null){
            throw new NoSuchElementException("Cliente não encontrado pela placa");
        }

        Customer customer = toCustomer(customerDto);
        Ticket ticket = new Ticket(customer);

        EntryTicketDto entryTicketDto =  toEntryTicketDto(ticket);
        return ticketDao.save(entryTicketDto.getId(),entryTicketDto.getPlate(),entryTicketDto.getEntry());

    }

    private EntryTicketDto toEntryTicketDto(Ticket ticket) {
        return new EntryTicketDto(
                ticket.getID().toString(),
                String.valueOf(ticket.getCliente().getPlate()), ticket.getEntry().toString());
    }

    private Customer toCustomer(CustomerDto dto) {
        return new Customer(
                dto.getPlate(),
                dto.getPhone(),
                Type.valueOf(dto.getType().toUpperCase())
        );
    }


}
