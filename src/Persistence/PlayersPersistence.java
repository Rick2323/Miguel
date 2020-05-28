package Persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Logic.Player;

public class PlayersPersistence {

	private static PlayersPersistence instance;
	private static final String FILENAME = "Players.bin";

	private List<Player> players;

	private PlayersPersistence() {
		this.players = new ArrayList<>();
	}

	public List<Player> getPlayers() {
		return this.players;
	}
	
	public static PlayersPersistence getInstance() {
		if(instance == null) {
			instance = new PlayersPersistence();
		}
		
		return instance;
	}

	public void addPlayer(Player player) {
		if (player != null) {
			boolean exists = this.players.stream().anyMatch(p -> p.equals(player));
			
			if (!exists) {
				this.players.add(player);
			}
		}
	}
	
	public void savePlayers() {
		FileOutputStream fileOut = null;
        
        try{
            fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.players);
            out.close();
            fileOut.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlayersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void loadPlayers() {
		try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.players = (List<Player>) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException ex) {
            Logger.getLogger(PlayersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlayersPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
