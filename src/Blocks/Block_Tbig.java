package Blocks;
/**
 * A classe Block_Tbig cria uma peça peça grande em forma de T para se jogar no modo avançado.
 * 
 * Herda da classe Shape.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public class Block_Tbig extends Shape {
/**
 * Chamando o construtor da classe Shape constroi uma peça em forma de T (maior para
 * modo avançado.
 */
    public Block_Tbig() {
        super(3, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[0][2] = true;
        shape[1][1] = true;
        shape[2][1] = true;

    }
}
