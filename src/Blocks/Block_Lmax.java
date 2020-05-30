package Blocks;
/**
 * A classe Block_Lmax constroi uma peça em forma de L para se 
 * jogar no modo avançado
 * 
 * Herda da classe Shape
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_Lmax extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de L (grande)
 */
    public Block_Lmax() {
        super(3, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[2][1] = true;
        shape[2][2] = true;

    }
}
