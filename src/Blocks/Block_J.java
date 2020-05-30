package Blocks;
/**
 * A classe Block_J cria uma peça com forma de J
 * 
 * Herda da classe Shape
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_J extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de J
 */
    public Block_J() {
        super(3, 2);

        Object[][] shape = super.getShape();

        shape[0][1] = true;
        shape[1][1] = true;
        shape[2][0] = true;
        shape[2][1] = true;

    }
}
