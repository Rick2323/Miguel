package Blocks;
/**
 * A classe Block_T cria uma peça em forma de T.
 * 
 * Herda da classeShape.
 * 
 * @author Miguel Lobato.
 * @version 1.1 (2020.05.29)
 */
public class Block_T extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de T.
 */
    public Block_T() {
        super(2, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[0][2] = true;
        shape[1][1] = true;

    }
}
