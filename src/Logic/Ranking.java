/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Miglob
 */
public class Ranking {
    
    private ArrayList<Player> players;
    
    public Ranking(){
        players = new ArrayList<>();
    }
    
    public Map<Player, Integer> getTop10(){
        Map<Player, Integer> top10 = new TreeMap<>();
        
        this.players.forEach((player) -> top10.put(player, player.getHighScore()));
            
        return top10;
    } 
    
    public void addPlayer(Player player){
        
        if(player != null){
            players.add(player);
        }
    }
}
