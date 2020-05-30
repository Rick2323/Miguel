package Blocks;
/**
 * A classe Block_I1 faz a criação de uma peça com uma linhaa e uma coluna
 * 
 * Herda da classe Shape
 * 
 * @author Miguel Lobato 
 * @version 1.1  (2020.05.29)
 */
public class Block_I1 extends Shape {
/**
 * Cria uma peça 1x1
 */
    public Block_I1() {
        super(1, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;

    }
}
