package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.Biblioteca;

public class Revista extends Item {
    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoDias() {
        return 7;
    }

    @Override
    public double multaPorDia() {
        return 0.5;
    }
}
