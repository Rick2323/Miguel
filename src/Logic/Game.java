/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Miglob
 */
public class Game {

    private LocalDate date;
    private GameBoard board;
    private GameScore score;
    private ArrayList<IShape> playableBlocks;
    private GameMode mode;

    public Game(GameMode mode) {
        date = LocalDate.now();
        board = new GameBoard();
        score = new GameScore();
        playableBlocks = new ArrayList<>();
        this.mode = mode;
    }

    public ArrayList<IShape> getPlayableBlocks() {

        populatePlayableBlocks();

        return playableBlocks;
    }

    public IShape getPlayableBlock(int index) {

        populatePlayableBlocks();

        return playableBlocks.remove(index);
    }

    private void populatePlayableBlocks() {

        int numberOfShapes = 3;

        if (playableBlocks.isEmpty()) {

            List<BlockType> supportedShapes = mode.getSupportedShapes();
            Collections.shuffle(supportedShapes);
            supportedShapes = supportedShapes.subList(0, numberOfShapes);

            for (BlockType supportedShape : supportedShapes) {

                playableBlocks.add(supportedShape.createBlock());
            }
        }
    }

    public void playBlock(int playableBlockIndex, String matrixPosition) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

        IShape block = getPlayableBlock(playableBlockIndex);

        board.placeBlock(block, matrixPosition);

        score.increaseScore(GameScore.getPointsForPlacedElement(block));
    }

//    public void playBlock(IShape shape, String matrixPosition) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {
//
//        board.placeBlock(shape, matrixPosition);
//
//        score.increaseScore(GameScore.getPointsForPlacedElement(shape));
//    }
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

    public void printGameBoard() {

        board.print();
    }

    public void printPlayableBlocks() {

        getPlayableBlocks();

        for (IShape playableBlock : playableBlocks) {

            playableBlock.printBody();
            System.out.println();
        }
    }

    public int getScore() {

        return score.getScore();
    }

    public void clearFilledRows() {

        int clearedElements = board.clearFilledRows();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, false));
    }

    public void clearFilledColumns() {

        int clearedElements = board.clearFilledColumns();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, false));

    }

    public void clearFilledSquares() {

        int clearedElements = board.clearFilledBigSquares();

        score.increaseScore(GameScore.getPointsForClearedElement(clearedElements, true));
    }

}
