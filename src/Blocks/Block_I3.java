package Blocks;
/**
 * A classe Block_I3 cria uma peça com uma coluna e três linhas.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_I3 extends Shape {
/**
 * Cria uma peça 1x3
 */
    public Block_I3() {
        super(3, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;

    }
}
