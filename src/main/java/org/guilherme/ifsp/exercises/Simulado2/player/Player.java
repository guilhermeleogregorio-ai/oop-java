package org.guilherme.ifsp.exercises.Simulado2.player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player> {
    private final String userName;
    private final List<Integer> gameScores = new ArrayList<>();

    public Player(String userName) {
        this.userName = userName;
    }

    public void addScore(int score) {
        gameScores.add(score);
    }

    @Override
    public int compareTo(Player other) {       // melhor jogador primeiro
        List<Integer> a = new ArrayList<>(gameScores);
        List<Integer> b = new ArrayList<>(other.gameScores);
        a.sort(Collections.reverseOrder());
        b.sort(Collections.reverseOrder());
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            int cmp = b.get(i).compareTo(a.get(i));
            if (cmp != 0) return cmp;
        }
        return userName.compareTo(other.userName);
    }

    @Override
    public String toString() {
        int max = gameScores.isEmpty() ? 0 : Collections.max(gameScores);
        return String.format("Username = %s | Max score = %d", userName, max);
    }
}