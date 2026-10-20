package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.FrotaDeDronesDeEntrega;


public abstract class Drone implements Entregador, Comparable<Drone> {
    private final String id;
    protected int bateria;


    public Drone(String id, int bateria) {
        this.id = id;
        if(bateria < 0 || bateria > 100){
           throw new IllegalArgumentException ("O valor deve estar entre 0 e 100");
        } else{
            this.bateria = bateria;
        }
    }

    protected abstract double capacidadeKg();

    protected abstract double consumoPorKm();

    protected abstract double custoPorKm();

    private double bateriaNecessaria(Pedido p){
        return consumoPorKm() * p.getDistanciaKm() * 2; }
    public boolean podeEntregar(Pedido p){
        return p.getPesoKg() <= capacidadeKg() && bateria >= bateriaNecessaria(p); }
    public double custo(Pedido p){
        return custoPorKm() * p.getDistanciaKm() * 2; }

    public void entregar(Pedido pedido){
        try {
            if(this.podeEntregar(pedido)){
                bateria -= (int) Math.ceil(bateriaNecessaria(pedido));
            } else{
                throw new IllegalStateException ("Drone não pode entregar!");
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Drone outro) {
        int comparacaoBateria = Integer.compare(outro.getBateria(), this.getBateria());
        if (comparacaoBateria != 0) {
            return comparacaoBateria;
        }
        return this.getId().compareTo(outro.getId());
    }

    public void regarregar(){
        this.bateria = 100;
    }

    public String getId() {
        return id;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "Drone[" +
                "id='" + getId() + '\'' +
                ", bateria=" + getBateria() +
                ']';
    }
}
