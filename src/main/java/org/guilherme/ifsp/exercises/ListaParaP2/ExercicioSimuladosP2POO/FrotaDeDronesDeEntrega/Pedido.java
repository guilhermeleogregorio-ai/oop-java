package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.FrotaDeDronesDeEntrega;

public class Pedido {
    private String id;
    private double pesoKg;
    private double distanciaKm;


    public Pedido(String id,double pesoKg, double distanciaKm) {
        this.id = id;
        this.distanciaKm = distanciaKm;
        this.pesoKg = pesoKg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    @Override
    public String toString() {
        return getId();
    }


}
