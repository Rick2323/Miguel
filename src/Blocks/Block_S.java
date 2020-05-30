package Blocks;
/**
 * A classe Block_S cria uma peça em forma de s.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_S extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de s.
 */
    public Block_S() {
        super(2, 3);

        Object[][] shape = super.getShape();

        shape[1][0] = true;
        shape[0][1] = true;
        shape[1][1] = true;
        shape[0][2] = true;

    }
}
