
package Logic;

import Blocks.IShape;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Classe responsável pela gestão das peças durante o jogo.
 * 
 * Implementa a interface do Java Serializable.
 * Retém a data em que o jogo é jogado
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.25)
 */
public class Game implements Serializable {

    private LocalDateTime date;
    private GameBoard board;
    private GameScore score;
    private ArrayList<IShape> playableBlocks;
    private GameMode mode;
/**
 * Inicializa os elementos necessários para se jogar:
 * a data a que se começa o jogo, um tabuleiro, a pontuação no jogo,
 * os blocos disponiveis para jogar e o modo de jogo.
 * 
 * @param mode o modo de jogo (basico/avançado)
 */
    public Game(GameMode mode) {
        date = LocalDateTime.now();
        board = new GameBoard();
        score = new GameScore();
        playableBlocks = new ArrayList<>();
        this.mode = mode;
    }
/**
 * metodo que nos dá as peças de jogo que estão jogaveis.
 * 
 * @return um array com as peças jogaveis
 */
    public ArrayList<IShape> getPlayableBlocks() {

        populatePlayableBlocks();

        return playableBlocks;
    }

    private IShape getPlayableBlock(int index) {
        
        
        populatePlayableBlocks();

        return playableBlocks.get(index);
    }

    private void removePlayableBlock(int index){
        playableBlocks.remove(index);
    }
    
    private void populatePlayableBlocks() {//insere numa lista os blocos que pode jogar

        int numberOfShapes = 3;

        if (playableBlocks.isEmpty()) {

            List<BlockType> supportedShapes = mode.getSupportedShapes();
            Collections.shuffle(supportedShapes);
            supportedShapes = supportedShapes.subList(0, numberOfShapes);

            for (BlockType supportedShape : supportedShapes) {

                IShape createBlock = supportedShape.createBlock();
                createBlock.rotateMatrixNinetyDegreesClockwise(new Random().nextInt(4));
                playableBlocks.add(createBlock);
            }
        }
    }
/**
 * Metodo que nos permite utilizar as peças jogaveis e colocá-las na matriz (tabuleiro) do jogo.
 * 
 * @param playableBlock uma string que representa o bloco jogável.
 * @param matrixPosition uma string que representa a posição para onde se quer jogar o bloco.
 * 
 * @throws ArrayIndexOutOfBoundsException excepção lançada no caso de se jogar a peça em posições fora da matriz.
 * @throws ElementAlreadyFilledException excepção lançada se a peça que se joga for posta numa posição já ocupada.
 */
    public void playBlock(String playableBlock, String matrixPosition) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

        IShape block = getPlayableBlock(getPlayableBlockIndex(playableBlock));

        board.placeBlock(block, matrixPosition);
        
        removePlayableBlock(getPlayableBlockIndex(playableBlock));

        score.increaseScore(GameScore.getPointsForPlacedElement(block));
        
        clearFilled();
    }

    private int getPlayableBlockIndex(String playableBlock) {

        char a = 'A';

        return playableBlock.charAt(0) - a;
    }
/**
 * Metodo que dá o jogo por terminado quando não cabe mais peças  no tabuleiro
 * 
 * @return true se não houver espaço no tabuleiro para as peças que o jogador tem para jogar, false caso contrário.
 */
    public boolean hasTheGameFinished() {

        ArrayList<IShape> playableBlocks1 = getPlayableBlocks();
        boolean hasFinished = true;

        for (IShape shape : playableBlocks1) {

            if (board.shapeFitsOnGameboard(shape)) {
                hasFinished = false;
            }
        }

        return hasFinished;
    }
/**
 * Metodo que imprime a matriz de jogo
 */
    public void printGameBoard() {

        board.print();
    }
/**
 * Metodo que imprime na consola de jogo as peças disponiveis, três, numeradas por A, B e C, para o jogador jogar.
 */
    public void printPlayableBlocks() {

        getPlayableBlocks();

        char a = 'A';

        System.out.println("Blocos a jogar: ");

        for (int i = 0; i < this.playableBlocks.size(); i++) {

            IShape playableBlock = this.playableBlocks.get(i);
            char temp = (char) (a + i);
            System.out.println("Bloco " + temp);

            playableBlock.printBody();
            System.out.println();
        }
    }
/**
 * Metodo que retorna a hora em que o jogo ocorre
 * 
 * @return A data com determinado formato
 */
    public LocalDateTime getDate(){
        return this.date;
    }
    
/**
 * Devolve-nos a pontuação de um jogador.
 * 
 * @return um inteiro que dá a pontuação
 */    
    public int getScore() {

        return score.getScore();
    }

    private void clearFilledRows() {

        int clearedElements = board.clearFilledRows();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, false));
    }

    private void clearFilledColumns() {

        int clearedElements = board.clearFilledColumns();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, false));

    }

    private void clearFilledSquares() {

        int clearedElements = board.clearFilledBigSquares();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, true));
    }
    
    private void clearFilled(){
        
        clearFilledRows();
        clearFilledColumns();
        clearFilledSquares();
    }

}
