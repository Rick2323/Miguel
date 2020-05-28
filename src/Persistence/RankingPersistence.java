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
import Logic.Ranking;

public class RankingPersistence {

	private static RankingPersistence instance;
	private static final String FILENAME = "Ranking.bin";

	private Ranking ranking;

	private RankingPersistence() {
		this.ranking = new Ranking();
	}

	public Ranking getRanking() {
		return this.ranking;
	}
	
	public static RankingPersistence getInstance() {
		if(instance == null) {
			instance = new RankingPersistence();
		}
		
		return instance;
	}

	public void setRanking(Ranking ranking) {
		if(ranking != null) {
			this.ranking = ranking;
		}
	}
	
	public void saveRanking() {
		FileOutputStream fileOut = null;
        
        try{
            fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.ranking);
            out.close();
            fileOut.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void loadRanking() {
		try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.ranking = (Ranking) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
