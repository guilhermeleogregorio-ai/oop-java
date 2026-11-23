package org.guilherme.ifsp.exercises.Prova3.customer;

import java.sql.SQLException;

public class RegisterCustomerService {
    private final CustomerDao customerDao;


    public RegisterCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public CustomerDto register(String plate, String phone, String type) throws SQLException {
        if(plate == null || plate.isBlank()){
            throw new EntityAlreadyExistsException("Placa Invalida");
        }
        if(phone == null || phone.isBlank()){
            throw new EntityAlreadyExistsException("Telefone invalido");
        }
        if(type == null || type.isBlank()){
            throw new EntityAlreadyExistsException("Tipo de veiculo invalido");
        }

        if(customerDao.findOne(plate, phone, type) != null){
            throw new EntityAlreadyExistsException("Clinte já cadastrado");
        }

        return customerDao.save(plate, phone, type);
    }
}
