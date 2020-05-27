package Logic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(GameMode.ADVANCED);

        game.printGameBoard();

        game.printPlayableBlocks();

     
        
        try {
            game.playBlock(0, "C4");
            game.playBlock(0, "F7");
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ElementAlreadyFilledException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        game.printGameBoard();
        
        
    }
}
