package org.guilherme.ifsp.exercises.Simulado2.main;

import org.guilherme.ifsp.exercises.Simulado2.game.MarioGame;
import org.guilherme.ifsp.exercises.Simulado2.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= 5; i++) players.add(new Player("Player" + i));

        for (Player p : players) {
            for (int g = 0; g < 10; g++) {
                MarioGame game = new MarioGame();
                while (!game.isDone()) game.takeMysteryBox();
                p.addScore(game.getScore());
            }
        }
        Collections.sort(players);
        System.out.println("=== Ranked ===");
        for (Player p : players) System.out.println(p);
    }
}
