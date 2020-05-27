/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author Miglob
 */
public class Player {
    
    private String name;
    private ArrayList<Game> games;

    public Player(String name) {
        this.name = name;
        games = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    
}
