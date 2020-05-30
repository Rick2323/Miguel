package Blocks;
/**
 * Classe Block_I2 cria uma peça com uma coluna e duas linhas.
 * 
 * Herda da classe Shape
 * 
 * @author Miglob
 * @version 1.1 (2020.05.29)
 */
public class Block_I2 extends Shape {
/**
 * Cria uma peça 1x2
 */
    public Block_I2() {
        super(2, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;

    }
}
