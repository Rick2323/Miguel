
package Blocks;

/**
 * A classe Block_I constroi uma peça com quatro linhas e uma coluna.
 * 
 * Herda da classe Shape
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_I extends Shape {

    /**
     * Cria uma peça 1x4
     */
    public Block_I() {
        super(4, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[3][0] = true;

    }
}
