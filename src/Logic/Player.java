
package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe que representa um jogador dando-he um nome associando-lhe os jogos que já 
 * poderá ter jogado.
 * 
 * Implemanta as interfaces do Java Comparable (para os jogadores) e Serializable.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.20)
 */
public class Player implements Comparable<Player>, Serializable {

    private String name;
    private ArrayList<Game> games;
/**
 * Cria o nome do jogador e inicializa um array de jogos.
 * 
 * @param name uma string com o nome do jogador
 */
    public Player(String name) {
        this.name = name;
        games = new ArrayList<>();
    }
/**
 * metodo que retorna o nome do jogador
 * 
 * @return uma string com o nome do jogador
 */
    public String getName() {
        return name;
    }
/**
 * Metodo que nos devolve uma colecção com as pontuações de um jogador.
 * 
 * @return uma colecção com as pontuações de um jogador.
 */
    public List<Integer> getScores() {

        List<Integer> scores = new ArrayList<>();

        this.games.forEach(game -> scores.add(game.getScore()));

        return scores;
    }
/**
 * Devolve-nos a pontuação mais alta de um jogador.
 * 
 * @return um inteiro com a pontuação mais alta.
 */
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
/**
 * Metodo equals para comparar os nomes dos jogadores
 * @param obj o objecto a ser comparado. Neste caso o nome.
 * @return verdadeiro se o nome a comparar coincidir.
 */
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
/**
 * Metodo para comparar a pontuaçao mais alta de um jogador com outra que o jogador fez,
 * dando-nos a mais alta.
 * 
 * @param player um jogador
 * @return um inteiro com a pontuação mais alta
 */
    @Override
    public int compareTo(Player player) {

        if (player != null) {

            int selfHighScore = getHighScore();
            int otherHighScore = player.getHighScore();

            if (selfHighScore > otherHighScore) {
                return -1;
            } else if (selfHighScore < otherHighScore) {
                return 1;
            } else {
                return this.getName().compareTo(player.getName());
            }
        }
        return -1;
    }
/**
 * Metodo que adiciona o novo jogo a um array de jogos de um jogador
 * 
 * @param game o jogo
 */
    public void addGame(Game game) {

        if (game != null) {
            games.add(game);
        }
    }

    /**
     * Compara a jogo, chamado byDate, e retorna -1 ou 0 e apanha o último jogo, que foi gravado e retorna-o para 
     * continuar a jogar.
     * 
     * @return O último jogo que abandonou a meio para o continuar a jogar.
     */
    public Game getRecentSavedGame() {

        Comparator<Game> byDate = (game1, game2) -> game1.getDate().compareTo(game2.getDate());
        if (this.games.size() == 0) {
            return null;
        } else if (this.games.size() == 1 && !this.games.get(0).hasTheGameFinished()) {
            return this.games.get(0);
        }
        try {
            Game game = this.games.stream()
                    .filter(g -> !g.hasTheGameFinished())
                    .sorted(byDate)
                    .findFirst()
                    .get();

            return game;
        } catch (Exception e) {
            return null;
        }

    }

}
