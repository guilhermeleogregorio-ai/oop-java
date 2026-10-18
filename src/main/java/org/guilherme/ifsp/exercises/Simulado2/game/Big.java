package org.guilherme.ifsp.exercises.Simulado2.game;

class Big implements MarioState {      // mushroom: pontos; damage: Small
    private final MarioGame mario;

    Big(MarioGame mario) { this.mario = mario; }
    public void takeFlower(){
        mario.nextState(mario.getFireState());
    }

    public void takeFeather(){
        mario.nextState(mario.getCapeState());
    }

    public void takeMushroom(){
        mario.incrementScore();
    }

    public void takeDamage(){
        mario.nextState(mario.getSmallState());
    }
}
