package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c1;

public class Apagada implements LampadaState {
    private Lampada lampada;

    Apagada(Lampada lampada) {
        this.lampada = lampada;
    }
    @Override
    public void apertar() {
        System.out.println("A lampada acendeu!");
        lampada.setEstado(new Acesa(lampada));
    }

    @Override
    public String toString() {
        return "Apagada";
    }
}
