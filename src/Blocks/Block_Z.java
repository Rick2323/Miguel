package Blocks;
/**
 * A classe Block_Z cria uma peça em forma de z.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_Z extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de z.
 */
    public Block_Z() {
        super(2, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[1][1] = true;
        shape[1][2] = true;

    }
}
