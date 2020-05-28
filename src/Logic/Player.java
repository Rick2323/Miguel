/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miglob
 */
public class Player implements Comparable<Player>, Serializable {

    private String name;
    private ArrayList<Game> games;

    public Player(String name) {
        this.name = name;
        games = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public List<Integer> getScores(){
        
        List<Integer> scores = new ArrayList<>();
        
        this.games.forEach(game -> scores.add(game.getScore()));
        
        return scores;
    }

    public int getHighScore() {

        int highScore = 0;

        for (Game game : games) {
            int gameScore = game.getScore();

            if (gameScore > highScore) {
                highScore = gameScore;
            }
        }
        return highScore;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return false;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        final Player other = (Player) obj;
        return this.name.equals(other.getName());
    }

    @Override
    public int compareTo(Player player) {

        if (player != null) {

            int selfHighScore = getHighScore();
            int otherHighScore = player.getHighScore();

            if (selfHighScore > otherHighScore) {
                return 1;
            } else if (selfHighScore < otherHighScore) {
                return -1;
            } else {
                return 0;
            }
        }
        return -1;
    }

}
