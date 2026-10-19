package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;

public class Fire implements MarioStates {
    private final MarioGameLite mario;

    public Fire(MarioGameLite mario) {
        this.mario = mario;
    }

    @Override
    public void takeMushroom() {
        this.mario.incrementScore();
    }

    @Override
    public void takeDamage() {
        this.mario.nextState(mario.getBig());
    }

    @Override
    public void takeFlower() {
        this.mario.incrementScore();
    }

    @Override
    public void takeFeather() {
        this.mario.nextState(mario.getCape());
    }
}
