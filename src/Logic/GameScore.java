/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;
import java.util.List;

/**
 *
 * @author Miglob
 */
public class GameScore {

    private static final int POINTS_BY_ELEMENT_IN_BASIC_MODE = 1;
    private static final int POINTS_BY_ELEMENT_IN_ADVANCED_MODE = 2;

    public static int getPointsByElement(IShape shape) {

        GameMode gameModeOfShape = GameMode.getGameModeOfShape(shape);

        if (gameModeOfShape.equals(GameMode.BASIC)) {

            return shape.getElementCount() * POINTS_BY_ELEMENT_IN_BASIC_MODE;
        } else if (gameModeOfShape.equals(GameMode.ADVANCED)) {
            return shape.getElementCount() * POINTS_BY_ELEMENT_IN_ADVANCED_MODE;
        }
        return 0;

    }

}
