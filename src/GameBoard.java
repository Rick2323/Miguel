import java.util.Arrays;

public class GameBoard {

	private final int BOARD_SIZE = Utils.getSquareSize();

	private BigSquare board[][];

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

	public void print() {
		printHeader();
		printBody();

//		System.out.println("COL 0\n");
//		board[0][0].printBody();
//		board[1][0].printBody();
//		board[2][0].printBody();
//
//		System.out.println("COL 1\n");
//		board[0][1].printBody();
//		board[1][1].printBody();
//		board[2][1].printBody();
//		
//		System.out.println("COL 2\n");
//		board[0][2].printBody();
//		board[1][2].printBody();
//		board[2][2].printBody();
	}

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

	private void printBody() { // MACUMBA QUE NEM SEI

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
			increment +=3;
		}
	}
}
