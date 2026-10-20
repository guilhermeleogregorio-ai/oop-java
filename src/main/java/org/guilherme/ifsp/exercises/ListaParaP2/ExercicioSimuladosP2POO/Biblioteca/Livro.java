package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.Biblioteca;

public class Livro extends Item {
    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoDias() {
        return 14;
    }

    @Override
    public double multaPorDia() {
        return 1.0;
    }
}
