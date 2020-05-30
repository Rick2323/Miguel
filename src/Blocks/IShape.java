package Blocks;

import java.io.Serializable;
/**
 * A interface IShape disponibiliza metodos para se manipular as formas.
 * 
 * Possui metodos para se ir burscar o tipo de peça, imprimir a peça,
 * rodar a peça no sentido dos ponteiros do relógio, ir buscar a posição
 * ancora que traduz o "quadradinho" que serve de referência para a sua colocação 
 * na matriz do jogo e um metodo para saber quantos elementos (quadradinhos) a
 * peça tem
 * 
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
public interface IShape extends Serializable{

	public Object[][] getShape();
        public void printBody();
        public void rotateMatrixNinetyDegreesClockwise(int numberOfRotations);
        public int getAnchorRow();
        public int getElementCount();
        
}
