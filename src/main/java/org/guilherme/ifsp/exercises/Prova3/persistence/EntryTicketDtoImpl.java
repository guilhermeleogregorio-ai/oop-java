package org.guilherme.ifsp.exercises.Prova3.persistence;

import org.guilherme.ifsp.exercises.Prova3.ticket.EntryTicketDto;
import org.guilherme.ifsp.exercises.Prova3.ticket.ExitTicketDto;
import org.guilherme.ifsp.exercises.Prova3.ticket.TicketDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class EntryTicketDtoImpl implements TicketDao {
    @Override
    public EntryTicketDto save(String id, String plate, String entry) throws SQLException {
        String sql = "INSERT INTO ticket(id, plate, entry) VALUES (?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getPreparedStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, plate);
            ps.setString(3, entry);
            ps.executeUpdate();
        }
        return new EntryTicketDto(id, plate, entry);
    }

    @Override
    public Optional<EntryTicketDto> findOpenTicket(String id, String plate, String entry) throws SQLException {
        String sql = "SELECT id, plate, entry FROM ticket WHERE plate = ? AND exit IS NULL";
        try (PreparedStatement ps = ConnectionFactory.getPreparedStatement(sql)) {
            ps.setString(1, plate);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new EntryTicketDto(
                            rs.getString("id"),
                            rs.getString("plate"),
                            rs.getString("entry")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public ExitTicketDto updateExit(String plate, String exit, double fee) throws SQLException {
        String sql = "UPDATE ticket SET exit = ?, fee = ? WHERE plate = ? AND exit IS NULL";
        try (PreparedStatement ps = ConnectionFactory.getPreparedStatement(sql)) {
            ps.setString(1, exit);
            ps.setDouble(2, fee);
            ps.setString(3, plate);
            ps.executeUpdate();
        }
        return new ExitTicketDto(plate, exit, fee);
    }
}
