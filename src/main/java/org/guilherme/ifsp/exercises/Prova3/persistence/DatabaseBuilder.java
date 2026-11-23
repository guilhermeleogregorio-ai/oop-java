package org.guilherme.ifsp.exercises.Prova3.persistence;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.UUID;

public class DatabaseBuilder {

    public static void buildDatabase() {
        // Garante que um banco novo seja criado a cada execução
        File dbFile = new File("database.db");
        if (dbFile.exists()) {
            dbFile.delete();
        }

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            // 1. Criação das tabelas
            stmt.execute("""
                CREATE TABLE customer (
                    plate TEXT PRIMARY KEY,
                    phone TEXT NOT NULL,
                    type TEXT NOT NULL
                );
            """);

            stmt.execute("""
                CREATE TABLE ticket (
                    id TEXT PRIMARY KEY,
                    plate TEXT NOT NULL,
                    entry TEXT NOT NULL,
                    exit TEXT,
                    fee REAL,
                    FOREIGN KEY (plate) REFERENCES customer(plate)
                );
            """);

            stmt.execute("""
                CREATE TABLE costs (
                    hours INTEGER PRIMARY KEY,
                    fee REAL NOT NULL
                );
            """);

            // 2. Povoamento das faixas de preço (1h = 7, 2h = 10, 12h = 30)
            stmt.execute("INSERT INTO costs (hours, fee) VALUES (1, 7.0);");
            stmt.execute("INSERT INTO costs (hours, fee) VALUES (2, 10.0);");
            stmt.execute("INSERT INTO costs (hours, fee) VALUES (12, 30.0);");

            // 3. Povoamento dos clientes e tickets de teste (POO0007 e POO0015)
            stmt.execute("INSERT INTO customer (plate, phone, type) VALUES ('POO0007', '16991112222', 'CAR');");
            stmt.execute("INSERT INTO customer (plate, phone, type) VALUES ('POO0015', '16993334444', 'MOTORCYCLE');");

            // 7 horas incompletas = 6 horas e 30 minutos atrás (arredonda para 7h -> R$ 30,00)
            String entry7hIncompletas = LocalDateTime.now().minusHours(6).minusMinutes(30).toString();
            stmt.execute(String.format(
                    "INSERT INTO ticket (id, plate, entry) VALUES ('%s', 'POO0007', '%s');",
                    UUID.randomUUID(), entry7hIncompletas
            ));

            // 15 horas incompletas = 14 horas e 30 minutos atrás (arredonda para 15h -> 12h + 2h + 1h = R$ 47,00)
            String entry15hIncompletas = LocalDateTime.now().minusHours(14).minusMinutes(30).toString();
            stmt.execute(String.format(
                    "INSERT INTO ticket (id, plate, entry) VALUES ('%s', 'POO0015', '%s');",
                    UUID.randomUUID(), entry15hIncompletas
            ));

        } catch (SQLException e) {
            System.err.println("Erro ao construir o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
