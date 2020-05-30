package Blocks;
/**
 * A classe Block_Lmin constroi uma peça em forma de L pequeno.
 * 
 * Herda da classe Shape
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_Lmin extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de L (pequeno)
 */
    public Block_Lmin() {
        super(2, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[1][1] = true;

    }
}
