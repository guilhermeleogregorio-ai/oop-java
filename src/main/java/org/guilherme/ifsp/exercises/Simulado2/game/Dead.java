package org.guilherme.ifsp.exercises.Simulado2.game;

class Dead implements MarioState {
    private static void fail(){
        throw new GameRuleViolationException("Mario is dead");
    }
    public void takeFlower(){
        fail();
    }
    public void takeFeather(){
        fail();
    }
    public void takeMushroom(){
        fail();
    }
    public void takeDamage(){
        fail();
    }
}
