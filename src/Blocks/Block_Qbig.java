package Blocks;
/**
 * A classe Block_Qbig constroi uma peça com três linhas e três colunas.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_Qbig extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de Q (3x3).
 */
    public Block_Qbig() {
        super(3, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[0][2] = true;
        shape[1][0] = true;
        shape[1][1] = true;
        shape[1][2] = true;
        shape[2][0] = true;
        shape[2][1] = true;
        shape[2][2] = true;

    }
}
