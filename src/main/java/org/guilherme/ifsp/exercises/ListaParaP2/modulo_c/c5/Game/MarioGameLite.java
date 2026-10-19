package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;
import java.util.Random;

public class MarioGameLite {
    private final MarioStates small = new Small(this);
    private final MarioStates big = new Big(this);
    private final MarioStates dead = new Dead();
    private final MarioStates cape = new Cape(this);
    private final MarioStates fire = new Fire(this);
    private MarioStates state = small;
    private int score = 0;
    private final Random random = new Random();

    public void takeMushroom(){
        state.takeMushroom();
    }

    public void takeDamage(){
        state.takeDamage();
    }

    void incrementScore(){
        score += 1000;
    }

    public void takeFlower()  { state.takeFlower(); }
    public void takeFeather() { state.takeFeather(); }
    public boolean isDone()   { return state == dead; }
    public int getScore()     { return score; }

    public void takeMysteryBox() {
        switch (random.nextInt(4)) {
            case 0 -> takeMushroom();
            case 1 -> takeDamage();
            case 2 -> takeFlower();
            default -> takeFeather();
        }
    }

    MarioStates getBig(){ return big;}
    MarioStates getSmall(){return small;}
    MarioStates getDead(){return dead;}
    MarioStates getCape(){return cape;}
    MarioStates getFire(){return fire;}

    void nextState(MarioStates next){
        state = next;
    }

}
