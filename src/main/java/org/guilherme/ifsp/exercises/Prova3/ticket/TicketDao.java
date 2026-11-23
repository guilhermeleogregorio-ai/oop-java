package org.guilherme.ifsp.exercises.Prova3.ticket;

import java.sql.SQLException;
import java.util.Optional;

public interface TicketDao {


    EntryTicketDto save(String id, String plate, String entry) throws SQLException;
    Optional<EntryTicketDto> findOpenTicket(String id, String plate, String entry) throws SQLException;
    ExitTicketDto updateExit(String plate, String exit, double fee) throws SQLException;

}
