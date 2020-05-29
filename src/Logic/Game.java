/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Miglob
 */
public class Game implements Serializable {

    private LocalDateTime date;
    private GameBoard board;
    private GameScore score;
    private ArrayList<IShape> playableBlocks;
    private GameMode mode;

    public Game(GameMode mode) {
        date = LocalDateTime.now();
        board = new GameBoard();
        score = new GameScore();
        playableBlocks = new ArrayList<>();
        this.mode = mode;
    }

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

    public LocalDateTime getDate(){
        return this.date;
    }
    
    
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
