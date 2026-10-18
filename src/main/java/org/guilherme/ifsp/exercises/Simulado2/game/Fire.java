package org.guilherme.ifsp.exercises.Simulado2.game;

class Fire implements MarioState {     // flower e mushroom: pontos; feather: Cape; damage: Big
    private final MarioGame mario;

    Fire(MarioGame mario) {
        this.mario = mario;
    }

    public void takeFlower(){
        mario.incrementScore();
    }

    public void takeFeather(){
        mario.nextState(mario.getCapeState());
    }

    public void takeMushroom(){
        mario.incrementScore();
    }

    public void takeDamage(){
        mario.nextState(mario.getBigState());
        }
}
