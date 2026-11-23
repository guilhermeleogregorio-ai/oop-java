package org.guilherme.ifsp.exercises.Prova3.ticket;

public class EntryTicketDto {
    private String id;
    private String plate;
    private String entry;

    public EntryTicketDto(String id, String plate, String entry) {
        this.id = id;
        this.plate = plate;
        this.entry = entry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
