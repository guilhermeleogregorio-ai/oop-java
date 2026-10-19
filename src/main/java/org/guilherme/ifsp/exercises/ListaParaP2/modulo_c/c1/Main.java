package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c1;

public class Main {
    static void main(String[] args) {
        Lampada lampada = new Lampada();

        System.out.println("-----------Estado inicial-----------\n");
        lampada.imprimirEstado();
        System.out.println();

        for(int i = 0 ; i < 5 ; i++){
            lampada.apertar();
            lampada.imprimirEstado();
            System.out.println();
        }
    }
}
