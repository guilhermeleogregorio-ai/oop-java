package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5;

import org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game.MarioGameLite;

public class Principal {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            MarioGameLite game = new MarioGameLite();
            while (!game.isDone()) game.takeMysteryBox();
            System.out.println("Partida " + i + " | Score = " + game.getScore());
        }
    }
}
