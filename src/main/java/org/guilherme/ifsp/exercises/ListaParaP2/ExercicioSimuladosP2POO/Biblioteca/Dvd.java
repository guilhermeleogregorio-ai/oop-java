package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.Biblioteca;


public class Dvd extends Item {

    public Dvd(String codigo, String titulo) {
        super(codigo, titulo);
    }

    public double calcularMulta(int diasComItem){
        if (diasComItem > prazoDias()){
            return  (diasComItem - prazoDias()) * multaPorDia() + 5.0;
        }  else {
            return 0;
        }
    }

    @Override
    public int prazoDias() {
        return 3;
    }

    @Override
    public double multaPorDia() {
        return 3.0;
    }
}
