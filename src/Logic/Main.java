package Logic;

import Blocks.*;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(GameMode.ADVANCED);

        IShape shape = new Block_Qbig();
        
        game.printGameBoard();

        //game.printPlayableBlocks();

     
        
        try {
            game.playBlock(0, "C4");
            //game.playBlock(shape, "D1");
            //game.playBlock(shape, "G1");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ElementAlreadyFilledException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        game.printGameBoard();
        
        System.out.println("Score -> " + game.getScore());
        
        
        game.clearFilledSquares();
        
        game.printGameBoard();
        
        System.out.println("Score -> " + game.getScore());
        
        
        
    }
}
