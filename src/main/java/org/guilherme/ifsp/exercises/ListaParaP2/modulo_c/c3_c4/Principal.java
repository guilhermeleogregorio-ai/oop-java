package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c3_c4;

public class Principal {
    static void main(String[] args) {
        Porta porta = new Porta();


        porta.trancar();
        porta.imprimirEstado();
        porta.destrancar();
        porta.imprimirEstado();


        try { porta.destrancar(); } catch (AcaoInvalidaException e) { System.out.println(e.getMessage()); }
        System.out.println(porta);
    }
}
