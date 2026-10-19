package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;

public class Small implements MarioStates{
    private final MarioGameLite mario;

    public Small(MarioGameLite mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom() {
        this.mario.nextState(mario.getBig());
    }

    @Override
    public void takeDamage() {
        this.mario.nextState(mario.getDead());
    }

    @Override
    public void takeFlower() {
        this.mario.nextState(mario.getFire());
    }

    @Override
    public void takeFeather() {
        this.mario.nextState(mario.getCape());
    }
}
