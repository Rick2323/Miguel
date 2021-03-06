package Logic;

import Blocks.IShape;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que trata de criar a matriz que representa o tabuleiro de jogo.
 * 
 * Implementa a interface do Java Serializable.
 * 
 * Constroi a matriz de jogo juntando 3x3 matrizes mais pequenas (bigSquare).
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.19)
 */
public class GameBoard implements Serializable {

	private final int BOARD_SIZE = Utils.getSquareSize();

	private BigSquare board[][];

	/**
	 * Inicializa um objecto BigSquare que representa uma matriz pequena
	 */
	public GameBoard() {

		board = new BigSquare[BOARD_SIZE][BOARD_SIZE];

		// fill array
		/*
		 * for (Object[] row : board) Arrays.fill(row, new BigSquare());
		 */
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new BigSquare();
			}
		}
	}

	/**
	 * Metodo que imprime para a consola o cabeçalho que representa as colunas (A,
	 * B, C...) e o tabuleiro de jogo (matriz grande).
	 * 
	 */
	public void print() {
		printHeader();
		printBody();
	}

	public Object[][] getMatrix() {

		int SQUARE_SIZE = Utils.getSquareSize();
		Object[][] matrix = new Object[SQUARE_SIZE*SQUARE_SIZE][SQUARE_SIZE*SQUARE_SIZE];
		BigSquare bs;
		int increment = SQUARE_SIZE;

		for (int i = 0; i < SQUARE_SIZE; i++) {
			for (int j = 0; j < SQUARE_SIZE; j++) {
				bs = getBigSquare(i, j);

				for (int x = 0; x < SQUARE_SIZE; x++) {
					for (int y = 0; y < SQUARE_SIZE; y++) {
						matrix[x + (i*increment)][y + (j*increment)] = bs.getElement(x, y);
					}
				}
			}
		}

		return matrix;

	}

	/**
	 * Metodo que retorna uma matriz pequena( (BigSquare).
	 * 
	 * @param row    um inteiro que representa a linha
	 * @param column um inteiro que representa a coluna
	 * @return uma matriz pequena
	 */
	public BigSquare getBigSquare(int row, int column) {
		return board[row][column];
	}

	private void printHeader() {

		// System.out.println(" |A|B|C|D|E|F|G|H|I");
		String str = " ";

		for (char alphabet = 'A'; alphabet < 'A' + (BOARD_SIZE * BOARD_SIZE); alphabet++) {
			str += "|" + alphabet;
		}

		System.out.println(str);
	}

	private void printBody() {

		BigSquare square;
		int increment = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			for (int k = 0; k < board.length; k++) {
				System.out.print("" + (k + 1 + increment));
				for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
					square = board[rowIndex][columnIndex];
					square.printRow(k);
				}
				System.out.println();
			}
			increment += 3;
		}
	}

	private void fillElement(int matrixPositionRow, int matrixPositionColumn) {

		int row = matrixPositionRow / 3;
		int column = matrixPositionColumn / 3;

		board[row][column].fillElement(matrixPositionRow, matrixPositionColumn);

	}

	private void testElement(int matrixPositionRow, int matrixPositionColumn)
			throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

		int row = matrixPositionRow / 3;
		int column = matrixPositionColumn / 3;

		board[row][column].testElement(matrixPositionRow, matrixPositionColumn);

	}

	private int getRowFromMatrixPosition(String matrixPosition) {// buscar a linha da string A3

		return Integer.parseInt(Character.toString(matrixPosition.charAt(1))) - 1;

	}

	private int getColumnFromMatrixPosition(String matrixPosition) {// buscar a coluna

		char a = 'A';

		return matrixPosition.charAt(0) - a;
	}

	/**
	 * Metodo que coloca uma peça jogada pelo jogador no tabuleiro segundo as
	 * regras do jogo.
	 * 
	 * @param shape          peça criada através da interface IShape
	 * @param matrixPosition uma string com a posição a colocar a peça no
	 *                       tabuleiro.
	 * 
	 * @throws ArrayIndexOutOfBoundsException excepção lançada caso a peça seja
	 *                                        colocado fora da matriz de jogo
	 * @throws ElementAlreadyFilledException  excepção lançada caso a peça seja
	 *                                        colocada numa posição já ocupada.
	 */
	public void placeBlock(IShape shape, String matrixPosition)
			throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

		Object[][] shapeMatrix = shape.getShape();

		int anchorRow = shape.getAnchorRow();

		ArrayList<int[]> placedBlocks = new ArrayList<>();

		int matrixPositionRow = getRowFromMatrixPosition(matrixPosition);
		int matrixPositionColumn = getColumnFromMatrixPosition(matrixPosition);

		testBlock(shapeMatrix, matrixPositionRow, matrixPositionColumn, anchorRow);

		for (int i = 0; i < shapeMatrix.length; i++) {
			for (int j = 0; j < shapeMatrix[0].length; j++) {

				if (shapeMatrix[i][j] == null || (shapeMatrix[i][j] == Boolean.FALSE)
						|| shapeMatrix[i][j].equals(false)) {

				} else {
					fillElement((matrixPositionRow - anchorRow + i), (matrixPositionColumn + j));
				}
			}
		}
	}

	/**
	 * Faz a verificação da peça para ver se cabe no tabuleiro de jogo.
	 * 
	 * @param shape A peça que foi criada através da interface IShape
	 * @return verdadeiro se a peça couber no tabuleiro, falso caso contrário.
	 */
	public boolean shapeFitsOnGameboard(IShape shape) {

		Object[][] shapeMatrix = shape.getShape();
		int anchorRow = shape.getAnchorRow();

		for (int i = 0; i < board.length * board.length; i++) {
			for (int j = 0; j < board.length * board.length; j++) {
				try {
					testBlock(shapeMatrix, i, j, anchorRow);

					return true;

				} catch (ArrayIndexOutOfBoundsException | ElementAlreadyFilledException e) {

				}
			}
		}

		return false;
	}

	private void testBlock(Object[][] shapeMatrix, int matrixPositionRow, int matrixPositionColumn, int anchorRow)
			throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

		for (int i = 0; i < shapeMatrix.length; i++) {
			for (int j = 0; j < shapeMatrix[0].length; j++) {
				if (shapeMatrix[i][j] == null || (shapeMatrix[i][j] == Boolean.FALSE)
						|| shapeMatrix[i][j].equals(false)) {

				} else {
					testElement((matrixPositionRow - anchorRow + i), (matrixPositionColumn + j));
				}
			}
		}
	}

	/**
	 * Metodo que ser para limpar do jogo várias linhas completamente ocupadas.
	 * 
	 * @return um inteiro com a totalidade de elementos limpos.
	 */
	public int clearFilledRows() {

		BigSquare square;
		int increment = 0;
		int clearedElements = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			for (int k = 0; k < board.length; k++) {
				boolean rowFilled = true;
				for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
					square = board[rowIndex][columnIndex];
					if (!square.rowIsComplete(k)) {
						rowFilled = false;
					}
				}
				if (rowFilled) {
					clearedElements += clearRow(rowIndex, k);
				}
			}
			increment += 3;

		}
		return clearedElements;

	}

	private int clearRow(int rowIndex, int k) {

		BigSquare square;
		int clearedElements = 0;

		for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
			square = board[rowIndex][columnIndex];

			clearedElements += square.clearRow(k);
		}
		return clearedElements;
	}

	/**
	 * Metodo que ser para limpar do jogo várias colunas completamente ocupadas.
	 * 
	 * @return um inteiro com a quantidade de elementos que foram limpos do
	 *         tabuleiro.
	 */
	public int clearFilledColumns() {

		BigSquare square;
		int increment = 0;
		int clearedElements = 0;
		for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
			for (int k = 0; k < board.length; k++) {
				boolean columnFilled = true;
				for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
					square = board[rowIndex][columnIndex];
					if (!square.columnIsComplete(k)) {
						columnFilled = false;
					}

				}
				if (columnFilled) {
					clearedElements += clearColumn(columnIndex, k);
				}

			}
			increment += 3;

		}
		return clearedElements;

	}

	private int clearColumn(int columnIndex, int k) {

		BigSquare square;
		int clearedElements = 0;
		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			square = board[rowIndex][columnIndex];
			clearedElements += square.clearColumn(k);
		}
		return clearedElements;
	}

	/**
	 * Metodo que serve para limpar do tabuleiro de jogo um espaço 3x3 ocupado.
	 * 
	 * @return um inteiro com a quantidade de elementos que foram limpos do
	 *         tabuleiro de jogo.
	 */
	public int clearFilledBigSquares() {

		BigSquare square;
		int clearedElements = 0;

		for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
				square = board[rowIndex][columnIndex];
				if (square.squareIsComplete()) {
					clearedElements += square.clearSquare();
				}
			}
		}
		return clearedElements;
	}
}
