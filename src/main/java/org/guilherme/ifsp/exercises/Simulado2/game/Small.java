package org.guilherme.ifsp.exercises.Simulado2.game;


class Small implements MarioState {
    private final MarioGame mario;
    Small(MarioGame mario) { this.mario = mario; }
    public void takeFlower()   {
        mario.nextState(mario.getFireState());
    }
    public void takeFeather()  {
        mario.nextState(mario.getCapeState());
    }
    public void takeMushroom() {
        mario.nextState(mario.getBigState());
    }
    public void takeDamage()   {
        mario.nextState(mario.getDeadState());
    }
}
