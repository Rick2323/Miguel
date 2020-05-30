package Blocks;
/**
 * A classe Block_L cria uma peça em forma de L.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_L extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de L.
 */
    public Block_L() {
        super(3, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[2][1] = true;

    }
}
