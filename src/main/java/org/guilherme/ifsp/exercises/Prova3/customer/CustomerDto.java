package org.guilherme.ifsp.exercises.Prova3.customer;

public class CustomerDto {
    private String plate;
    private String phone;
    private String type;

    public CustomerDto(String plate, String phone, String type) {
        this.plate = plate;
        this.phone = phone;
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
