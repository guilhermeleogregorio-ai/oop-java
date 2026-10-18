package org.guilherme.ifsp.exercises.Simulado2.game;

class Cape implements MarioState {     // feather e mushroom: pontos; flower: Fire; damage: Big
    private final MarioGame mario;

    Cape(MarioGame mario) {
        this.mario = mario;
    }

    public void takeFlower(){
        mario.nextState(mario.getFireState());
    }

    public void takeFeather(){
        mario.incrementScore();
    }

    public void takeMushroom(){
        mario.incrementScore();
    }

    public void takeDamage(){
        mario.nextState(mario.getBigState());
    }
}
