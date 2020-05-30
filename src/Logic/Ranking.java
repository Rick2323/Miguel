
package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe que trata da gestão do ranking do jogo.
 * 
 * Implementa a interface do Java Serializable.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.24)
 */
public class Ranking implements Serializable {

    private ArrayList<Player> players;
/**
 * Cria uma colecção de jogadores.
 */
    public Ranking() {
        players = new ArrayList<>();
    }
/**
 *  Utilizo um Tree map que dado um jogador (chave) dá-nos o top10 dos jogadores com melhores pontuações.
 * 
 * @return uma colecção com os jogadores que estão no top10 das pontuações.
 */
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
/**
 * Metodo que acrescenta um jogador à nossa colecção de jogadores.
 * 
 * @param player o jogador
 */
    public void addPlayer(Player player) {

        if (player != null) {
            players.add(player);
        }
    }
/**
 * Metodo que dado um jogador nos dá um jogador que é filtrado pelo nome.
 * 
 * @param name uma string com o nome do jogador
 * @return o jogador se existir ou null.
 */
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
