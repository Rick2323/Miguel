/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;
import java.io.Serializable;

/**
 * Classe que implementa o sistema de pontuação do jogo.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class GameScore implements Serializable{

    private static final int POINTS_FOR_PLACED_ELEMENT_IN_BASIC_MODE = 1;
    private static final int POINTS_FOR_PLACED_ELEMENT_IN_ADVANCED_MODE = 2;
    private static final int POINTS_FOR_CLEARED_ELEMENT = 4;
    private static final int BONUS_FOR_CLEARED_SQUARE = 10;

    private int score;
/**
 * Inicializa um novo jogo coma pontuação a zero
 */
    public GameScore() {
        score = 0;
    }
/**
 * Dá-nos a pontuação de um jogo.
 * 
 * @return um inteiro com a pontuação do jogo.
 */
    public int getScore() {
        return score;
    }
/**
 * Metodo para aumentar a pontuação do jogo.
 * 
 * @param score a pontuação
 */
    public void increaseScore(int score) {
        this.score += score;
    }
/**
 * Metodo que faz a gestão dos pontos ganhos por cada colocação de peças com as 
 * devidas diferenças entre os dois modos de jogo.
 * 
 * @param shape peça criada através da interface IShape
 * @return um inteiro que representa a pontuação a cada jogada.
 */
    public static int getPointsForPlacedElement(IShape shape) {

        GameMode gameModeOfShape = GameMode.getGameModeOfShape(shape);

        if (gameModeOfShape.equals(GameMode.BASIC)) {

            return shape.getElementCount() * POINTS_FOR_PLACED_ELEMENT_IN_BASIC_MODE;
        } else if (gameModeOfShape.equals(GameMode.ADVANCED)) {
            return shape.getElementCount() * POINTS_FOR_PLACED_ELEMENT_IN_ADVANCED_MODE;
        }
        return 0;

    }
/**
 * Metodo que faz a gestão dos pontos ganhos por cada retirada de elementos.
 * 
 * @param cleanedElements os elementos retirados do tabuleiro de jogo.
 * @param squareCleared os quadrados 3x3 que são retirados do tabuleiro.
 * @return um inteiro que representa a pontuação obtida pela retirade de elementos do tabuleiro.
 */
    public static int getPointsForClearedElement(int cleanedElements, boolean squareCleared) {

        int count = cleanedElements * POINTS_FOR_CLEARED_ELEMENT;

        if (squareCleared && cleanedElements > 0) {
            count += BONUS_FOR_CLEARED_SQUARE;
        }
        return count;
    }

}
