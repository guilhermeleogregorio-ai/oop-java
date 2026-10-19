package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c1;

public class Acesa implements LampadaState {
    private Lampada lampada;

    Acesa(Lampada lampada){
        this.lampada = lampada;
    }

    @Override
    public void apertar() {
        System.out.println("A lampada apagou");
        lampada.setEstado(new Apagada(lampada));
    }

    @Override
    public String toString() {
        return "Acesa";
    }
}
