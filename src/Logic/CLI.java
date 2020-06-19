
package Logic;

import Persistence.RankingPersistence;
import java.util.Map;
import java.util.Set;

/**
 *Classe responsável pela criação dos gráficos e pela interacção do jogador na consola.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class CLI {

    private Player player;
    private GameBoard gameBoard;
    private Ranking ranking;
    private boolean running;
/**
 * Inicializa o jogador, a matriz do jogo e se está a jogar a null e cria o ranking.
 */
    public CLI() {
        player = null;
        gameBoard = null;
        running = false;
        ranking = new Ranking();

    }

    private void printWelcomeScreen() {

        System.out.println("Bem-Vindo ao BlockuDoku!!!\n");
        System.out.println("Insira o seu nome. (Pressione a tecla Enter)");
    }

    private void printMainScreen() {

        System.out.println("Olá " + player.getName());
        System.out.println();
        System.out.println();
        System.out.println("1 - Iniciar novo jogo");
        System.out.println("2 - Abrir o jogo");
        System.out.println("3 - Mostrar pontuações pessoais");
        System.out.println("4 - Ranking (TOP 10)");
        System.out.println("0 - Sair");
    }

    private void printNewGameScreen() {

        System.out.println("1 - Iniciar novo jogo - modo básico");
        System.out.println("2 - Iniciar novo jogo - modo avançado");
        System.out.println("0 - Voltar");
    }
/**
 * Metodo responsável pela interacção do jogo com o jogador.
 * 
 * Possui todas as caracteristicas e regras de jogabilidade que o jogo tem de ter,
 * as várias opções de jogo, os rankings (persistência), modos de jogo
 * e a saída do jogo.
 */
    public void run() {

        RankingPersistence rankingPersistence = RankingPersistence.getInstance();

        rankingPersistence.loadRanking();

        if (rankingPersistence.getRanking() != null) {
            this.ranking = rankingPersistence.getRanking();
        }else{
            this.ranking = new Ranking();
            rankingPersistence.setRanking(ranking);
        }

        this.running = true;
        InputReader inputReader = new InputReader();

        printWelcomeScreen();
        
        String name = inputReader.getText("");

        Player p = this.ranking.getPlayer(name);
        if (p != null) {
            this.player = p;
        } else {
            this.player = new Player(name);
            this.ranking.addPlayer(this.player);
        }

        while (this.running) {
            printMainScreen();
            int option = inputReader.getInteger("");

            switch (option) {
                case 1:
                    newGame();
                    break;
                case 2:
                    openGame();
                    break;
                case 3:
                    showPersonalScores();
                    break;
                case 4:
                    showTop10();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    printInvalidInput();
            }
        }
    }

    private void newGame() {

        printNewGameScreen();

        InputReader inputReader = new InputReader();
        int option = inputReader.getInteger("");

        switch (option) {
            case 1:
                newGame(GameMode.BASIC);
                break;
            case 2:
                newGame(GameMode.ADVANCED);
                break;
            case 0:
                break;
            default:
                printInvalidInput();
        }
    }

    private void openGame() {

       
        Game game = this.player.getRecentSavedGame(); 
        if(game != null){
            playGame(game);
        }else{
            System.out.println("Não existem jogos gravados!");
        }
       
    }

    private void showPersonalScores() {

        if (this.player != null) {
            System.out.println("**** RESULTADOS ****");
            System.out.println();
            for (Integer score : this.player.getScores()) {
                System.out.println("Resultado: " + score);
            }
        }
    }

    private void showTop10() {

        Map<Player, Integer> top10 = ranking.getTop10();

        System.out.println("TOP 10:");
        System.out.println();

        Set<Player> players = top10.keySet();
        
        int rank = 1;
        for (Player player : players) {

            
            int score = top10.get(player);

            System.out.println("" + rank + " - " + player.getName() + " - " + score);
            rank++;
        }
    }

    private void exit() {

        printGoodByeScreen();
        this.running = false;
    }

    private void printInvalidInput() {

        System.out.println("Input inválido!");
    }

    private void printGoodByeScreen() {

        System.out.println("Obrigado por ter jogado BlockuDoku!!!!");
    }

    private void newGame(GameMode gameMode) {

        Game game = new Game(gameMode);
        this.player.addGame(game);

        playGame(game);
    }

    private void playGame(Game game) {

        boolean gameRunning = !game.hasTheGameFinished();

        RankingPersistence rankingPersistence = RankingPersistence.getInstance();

        while (gameRunning) {

            printGameState(game);

            InputReader inputReader = new InputReader();

            String option = inputReader.getText("Indique a próxima jogada (Bloco-ColunaLinha): ");

            String[] split;

            switch (option) {
                case "CANCEL":
                    gameRunning = false;
                    break;
                case "SAVE":
                    rankingPersistence.saveRanking();
                    gameRunning = false;
                    break;
                default:

                    if (option.matches("([A-Z]-[A-Z][1-9])")) {

                        try {
                            split = split(option);

                            game.playBlock(split[0], split[1]);

                            gameRunning = !game.hasTheGameFinished();

                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("A peça não cabe no tabuleiro!");
                        } catch (ElementAlreadyFilledException ex) {
                            System.out.println("A casa já está preenchida!");
                        }catch(IndexOutOfBoundsException ex){
                           printInvalidInput();
                        }
                    } else {
                        printInvalidInput();
                    }
            }

        }
        System.out.println("Fim do Jogo!!!");
        System.out.println("Resultado: " + game.getScore());

        rankingPersistence.saveRanking();

    }

    private void printGameState(Game game) {

        if (game != null) {
            game.printGameBoard();
            game.printPlayableBlocks();
        }
    }

    private String[] split(String option) {

        String[] parts = option.split("-");

        return parts;

    }
}
