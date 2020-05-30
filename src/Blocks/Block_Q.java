package Blocks;
/**
 * A classe Block_Q constroi uma peça com duas linhas e duas colunas.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato.
 * @version 1.1 (2020.05.29)
 */
public class Block_Q extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de Q (2X2).
 */
    public Block_Q() {
        super(2, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[1][0] = true;
        shape[1][1] = true;

    }
}
