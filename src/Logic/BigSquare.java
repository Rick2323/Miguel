package Logic;

import java.io.Serializable;

/**
 * Classe que serve para cria um quadrado 3x3 que fará parte da matriz do jogo
 * 
 *Implementa a interface do Java Serializable.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.20)
 */
public class BigSquare implements Serializable {

    private final int SQUARE_SIZE = Utils.getSquareSize();

    private Object[][] board;
/**
 * Inicializa um objecto board do tipo Object que é um array bidimencional com um determinado tamanho constante
 */
    public BigSquare() {

        board = new Object[SQUARE_SIZE][SQUARE_SIZE];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                board[i][j] = false;
            }
        }

    }
/**
 * Metodo que retorna um boleano que é true no caso de uma linha esteja completa
 * 
 * @param index um inteiro que representa a posição na linha
 * @return verdadeiro se a linha estiver completa com peças, false caso contrário
 */
    public boolean rowIsComplete(int index) {

        Object[] row = getRow(index);

        for (int i = 0; i < board.length; i++) {

            if (row[i] == null || (row[i] == Boolean.FALSE) || row[i].equals(false)) {
                return false;
            }
        }

        return true;
    }
/**
 * Metodo que retorna um boleano que é true no caso de uma coluna esteja completa
 * 
 * @param index um inteiro que representa a posição na coluna
 * @return verdadeiro se a coluna estiver completa com peças, false caso contrário
 */
    public boolean columnIsComplete(int index) {

        Object[] column = getColumn(index);

        for (int i = 0; i < board.length; i++) {

            if (column[i] == null || (column[i] == Boolean.FALSE) || column[i].equals(false)) {
                return false;
            }
        }

        return true;
    }
/**
 * Metodo que retorna um boleano que é true no caso da matriz estar completa.
 * 
 * @return verdadeiro se a matriz estiver completa com peças, false caso contrário
 */
    public boolean squareIsComplete() {

        for (int i = 0; i < board.length; i++) {
            if (!rowIsComplete(i)) {
                return false;
            }
        }

        return true;
    }

   
    private Object[] getRow(int index) {
        Object[] row = new Object[board[0].length];
        for (int i = 0; i < row.length; i++) {
            row[i] = board[index][i];
        }
        return row;
    }

    private Object[] getColumn(int index) {
        Object[] column = new Object[board[0].length];
        for (int j = 0; j < column.length; j++) {
            column[j] = board[j][index];
        }
        return column;
    }
    
    public Object getElement(int row, int column) {
		return board[row][column];
	}

/**
 * Metodo que percorre as linhas e imprime a matriz
 */
    public void printBody() {

        for (int i = 0; i < board.length; i++) {
            printRow(i);
            System.out.println();
        }
    }
/**
 * percorre as linhas e imprime a matriz ou as peças que estão colocadas em determinado index
 * 
 * @param rowIndex um inteiro que representa o index da linha
 */
    public void printRow(int rowIndex) {

        String str = "";
        Object[] row = getRow(rowIndex);

        for (int i = 0; i < row.length; i++) {
            if (row[i] == null || (row[i] == Boolean.FALSE) || row[i].equals(false)) {
                str += "|.";
            } else {
                str += "|#";
            }

            // para mostar o conte�do
            //str += "|" + row[i];
        }

        System.out.print(str);
    }
/**
 * Metodo que coloca a peça na posição da pequena matriz que faz parte da matriz de jogo
 * 
 * @param matrixPositionRow inteiro que representa a posição na linha da matriz
 * @param matrixPositionColumn  inteiro que representa a posição na coluna da matriz
 */
    public void fillElement(int matrixPositionRow, int matrixPositionColumn) {

        int row = matrixPositionRow % 3;
        int column = matrixPositionColumn % 3;

        board[row][column] = true;
    }
/**
 * Metodo que serve para verificar se a peça a ser colocada está a ser inserida
 * numa posição já ocupada.
 * 
 * @param matrixPositionRow um inteiro que representa a posição numa linha da matriz
 * @param matrixPositionColumn um inteiro que representa a posição numa coluna da matriz.
 * @throws ArrayIndexOutOfBoundsException excepção lançada caso a peça seja colocada fora da matriz
 * @throws ElementAlreadyFilledException excepção lançada caso a peça esteja a ser colocada numa posição já ocupada.
 */
    public void testElement(int matrixPositionRow, int matrixPositionColumn) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

        int row = matrixPositionRow % 3;
        int column = matrixPositionColumn % 3;

        //if(board[row][column].equals(new Boolean(true))){
        if (!(board[row][column] == null || (board[row][column] == Boolean.FALSE) || board[row][column].equals(false))) {

            throw new ElementAlreadyFilledException("Casa preenchida");
        }

    }
/**
 * Serve para limpar uma linha da pequena matriz totalmente ocupada.
 * 
 * @param rowIndex um inteiro que serve de referència para a posição na linha
 * @return o comprimento da linha
 */
    public int clearRow(int rowIndex) {

        for (int i = 0; i < board.length; i++) {
            board[rowIndex][i] = false;
        }
        return board.length;
    }
/**
 * Serve para limpar uma coluna da pequena matriz totalmente ocupada.
 * 
 * @param columnIndex um inteiro que serve de referència para a posição na coluna
 * @return o comprimento da coluna
 */
    public int clearColumn(int columnIndex) {

        for (int i = 0; i < board.length; i++) {
            board[i][columnIndex] = false;
        }
        return board.length;
    }
/**
 * Serve para limpar um quadrado 3x3 (pequena matriz) totalmente ocupado.
 * 
 * @return o comprimento das colunas e das linhas
 */
    public int clearSquare() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = false;
            }
        }
        return board.length * board.length;
    }

}
