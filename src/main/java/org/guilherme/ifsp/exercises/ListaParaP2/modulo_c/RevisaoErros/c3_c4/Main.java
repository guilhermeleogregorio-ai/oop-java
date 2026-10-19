package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.RevisaoErros.c3_c4;

public class Main {
    static void main(String[] args) {
        Porta porta = new Porta();

        porta.abrir();
        porta.fechar();
        porta.trancar();
        porta.destrancar();

        try {
            porta.destrancar();
        } catch (AcaoInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println(porta);
    }
}

