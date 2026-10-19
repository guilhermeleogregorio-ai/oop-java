package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;

public class Dead implements MarioStates{
    private static void fail(){throw  new IllegalStateException("Mario está morto"); }
    @Override
    public void takeMushroom() {
        fail();
    }

    @Override
    public void takeDamage() {
        fail();
    }

    @Override
    public void takeFlower() {
        fail();
    }

    @Override
    public void takeFeather() {
        fail();
    }
}
