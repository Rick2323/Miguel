package Persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import Logic.Ranking;
import java.io.File;
/**
 * Classe Singleton que trata da persistencia dos dados dada por uma unica instancia.
 * Cria um ficheiro binário onde ficam registados os dados dos jogos
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class RankingPersistence {

    private static RankingPersistence instance;
    private static final String FILENAME = "Ranking.bin";

    private Ranking ranking;

        
    private RankingPersistence() {
        this.ranking = new Ranking();
    }
/**
 * Metodo que retorna o ranking dos jogadores
 * 
 * @return um objecto da classe Ranking que nos dá o ranking dos jogadores
 */
    public Ranking getRanking() {
        return this.ranking;
    }
/**
 * Metodo getInstance do Singleton que nos retorna a nica instancia criada.
 * 
 * @return a instancia unica criada da classe RankingPersistence.
 */
    public static RankingPersistence getInstance() {
        if (instance == null) {
            instance = new RankingPersistence();
        }

        return instance;
    }
/**
 * metodo modificador do ranking
 * 
 * @param ranking um objecto da classe Ranking
 */
    public void setRanking(Ranking ranking) {
        if (ranking != null) {
            this.ranking = ranking;
        }
    }
/**
 * Metodo utilizado para guardar os rankings
 */
    public void saveRanking() {
        FileOutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.ranking);
            out.close();
            fileOut.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Não encontra");
        } catch (IOException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Metodo que nos permite aceder aos rankings que estão guardados no ficheiro .bin
 */
    public void loadRanking() {
        try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.ranking = (Ranking) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException ex) {
            saveRanking();

        } catch (IOException ex) {
            this.ranking = null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RankingPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
