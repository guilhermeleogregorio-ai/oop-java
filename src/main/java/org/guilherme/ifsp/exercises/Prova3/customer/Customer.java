package org.guilherme.ifsp.exercises.Prova3.customer;

import java.util.Objects;

public class Customer {
    private String plate;
    private String phoneNumber;
    private Type vehicleType;

    public Customer(String plate, String phoneNumber, Type vehicleType) {
        this.plate = plate;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Type getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Type vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getPlate() == customer.getPlate() && getPhoneNumber() == customer.getPhoneNumber() && getVehicleType() == customer.getVehicleType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlate(), getPhoneNumber(), getVehicleType());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "plate=" + plate +
                ", phoneNumber=" + phoneNumber +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
