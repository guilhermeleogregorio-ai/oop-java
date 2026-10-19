package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c2;

public class Main {
    static void main(String[] args) {
        Semaforo semaforo = new Semaforo();

        System.out.println("------------Semaforo--------------");
        semaforo.imprimirEstado();
        System.out.println();


        for(int i = 0; i < 10 ; i++){
            System.out.println("--- Avanço " + i +"-----");
            semaforo.avancar();
            semaforo.imprimirEstado();
            System.out.println();
        }
    }
}
