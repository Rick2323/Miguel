/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Miglob
 */
public class Ranking implements Serializable {

    private ArrayList<Player> players;

    public Ranking() {
        players = new ArrayList<>();
    }

    public Map<Player, Integer> getTop10() {
        Map<Player, Integer> aux = new TreeMap<>();

        this.players.forEach((player) -> aux.put(player, player.getHighScore()));
        
        Map<Player, Integer> top10 = new TreeMap<>();
        
        int limit = 10;
        
        for(Player player : aux.keySet()){
            if(limit > 0){
                top10.put(player, aux.get(player));
                limit--;
            }
        }

        return top10;
    }

    public void addPlayer(Player player) {

        if (player != null) {
            players.add(player);
        }
    }

    public Player getPlayer(String name) {
        try {
            Player player = this.players
                    .stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .get();
            
            return player;
        } catch (Exception e) {
            return null;
        }
    }

}
