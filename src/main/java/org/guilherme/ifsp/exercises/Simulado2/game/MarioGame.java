package org.guilherme.ifsp.exercises.Simulado2.game;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarioGame {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final MarioState small = new Small(this);
    private final MarioState big = new Big(this);
    private final MarioState fire = new Fire(this);
    private final MarioState cape = new Cape(this);
    private final MarioState dead = new Dead();
    private MarioState state = small;
    private int score = 0;
    private String event = "";
    private final List<String> events = new ArrayList<>();
    private final Random random = new Random();

    MarioState getSmallState(){
        return small;
    }
    MarioState getBigState(){
        return big;
    }
    MarioState getFireState(){
        return fire;
    }
    MarioState getCapeState(){
        return cape;
    }
    MarioState getDeadState(){
        return dead;
    }
    public int getScore(){
        return score;
    }

    public void takeFlower(){
        event = "Took a flower";
        state.takeFlower();
    }
    public void takeFeather(){
        event = "Took a feather";
        state.takeFeather();
    }
    public void takeMushroom(){
        event = "Took a mushroom";
        state.takeMushroom();
    }
    public void takeDamage(){
        event = "Took damage";
        state.takeDamage();
    }

    public void takeMysteryBox(){
        switch (random.nextInt(4)) {
            case 0 -> takeFlower();
            case 1 -> takeFeather();
            case 2 -> takeMushroom();
            default -> takeDamage();
        }
    }

    void nextState(MarioState next){
        String before = state.getClass().getSimpleName();
        state = next;
        log(before, next.getClass().getSimpleName());
    }

    void incrementScore(){
        score += 1000;
        String name = state.getClass().getSimpleName();
        log(name, name);
    }

    private void log(String from, String to){
        events.add(String.format("[%s] %s | %s => %s | Score = %d",
                LocalDateTime.now().format(FMT), event, from, to, score));
    }

    public boolean isDone() {
        return state == dead;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (String e : events) sb.append(e).append("\n");
        return sb.toString();
    }
}



