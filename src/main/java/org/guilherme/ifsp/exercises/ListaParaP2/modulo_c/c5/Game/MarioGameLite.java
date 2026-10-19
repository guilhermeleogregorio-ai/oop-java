package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c5.Game;

public class MarioGameLite {
    private final MarioStates small = new Small(this);
    private final MarioStates big = new Big(this);
    private final MarioStates dead = new Dead();
    private final MarioStates cape = new Cape(this);
    private final MarioStates fire = new Fire(this);
    private MarioStates state = small;
    private int score = 0;

    public void takeMushroom(){
        state.takeMushroom();
    }

    public void takeDamage(){
        state.takeDamage();
    }

    void incrementScore(){
        score += 1000;
    }

    public void takeMysteryBox(){
        switch (random.nexInt(2)){
            case 0 -> takeDamage();
            case 1 -> takeMushroom();
            default -> takeDamage();
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
