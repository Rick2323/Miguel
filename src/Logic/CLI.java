/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Map;

/**
 *
 * @author Miglob
 */
public class CLI {

    private Player player;
    private GameBoard gameBoard;
    private Ranking ranking;
    private boolean running;

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

    private void run() {

        this.running = true;
        InputReader inputReader = new InputReader();

        printWelcomeScreen();
        //forçar o load do player e colocar validação
        String name = inputReader.getText("");

        this.player = new Player(name);

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
        
    }

    private void openGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        Player[] players = (Player[]) top10.keySet().toArray();
        for (int i = 0; i < players.length; i++) {

            Player player = players[i];
            int score = top10.get(player);

            System.out.println("" + (i + 1) + " - " + player.getName() + " - " + score);
        }
    }

    private void exit() {

        printGoodByScreen();
        this.running = false;
    }

    private void printInvalidInput() {

        System.out.println("Input inválido!");
    }

    private void printGoodByScreen() {

        System.out.println("Obrigado por ter jogado BlockuDoku!!!!");
    }
}
