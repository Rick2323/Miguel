/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;

/**
 *
 * @author Miglob
 */
public class GameScore {

    private static final int POINTS_FOR_PLACED_ELEMENT_IN_BASIC_MODE = 1;
    private static final int POINTS_FOR_PLACED_ELEMENT_IN_ADVANCED_MODE = 2;
    private static final int POINTS_FOR_CLEARED_ELEMENT = 4;
    private static final int BONUS_FOR_CLEARED_SQUARE = 10;
    
    private int score;

    public GameScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    
    public static int getPointsForPlacedElement(IShape shape) {

        GameMode gameModeOfShape = GameMode.getGameModeOfShape(shape);

        if (gameModeOfShape.equals(GameMode.BASIC)) {

            return shape.getElementCount() * POINTS_FOR_PLACED_ELEMENT_IN_BASIC_MODE;
        } else if (gameModeOfShape.equals(GameMode.ADVANCED)) {
            return shape.getElementCount() * POINTS_FOR_PLACED_ELEMENT_IN_ADVANCED_MODE;
        }
        return 0;

    }

    public static int getPointsForClearedElement(int cleanedElements, boolean squareCleared) {

        int count = cleanedElements * POINTS_FOR_CLEARED_ELEMENT;

        if (squareCleared) {
            count += BONUS_FOR_CLEARED_SQUARE;
        }
        return count;
    }

}
