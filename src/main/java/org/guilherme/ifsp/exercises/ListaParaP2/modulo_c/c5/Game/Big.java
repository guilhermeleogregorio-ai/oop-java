package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;

public class Big implements MarioStates{
    private final MarioGameLite mario;

    public Big(MarioGameLite mario) {
        this.mario = mario;
    }


    @Override
    public void takeMushroom() {
        this.mario.incrementScore();
    }

    @Override
    public void takeDamage() {
        this.mario.nextState(mario.getSmall());
    }

    @Override
    public void takeFlower() {
        mario.nextState(mario.getFire());
    }

    @Override
    public void takeFeather() {
        mario.nextState(mario.getCape());
    }
}
