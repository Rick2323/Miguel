import java.util.Arrays;

public class BigSquare {

	private final int SQUARE_SIZE = Utils.getSquareSize();

	private Object[][] board;

	public BigSquare() {
		
		board = new Object[SQUARE_SIZE][SQUARE_SIZE];

		// fill array
		/*for (Object[] row: board)
		    Arrays.fill(row, true);*/
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Utils.getBosta();
			}
		}
		
	}

	public boolean rowIsComplete(int index) {

		Object[] row = getRow(index);

		for (int i = 0; i < board.length; i++) {
			if (row[i] == null) {
				return false;
			}
		}

		return true;
	}

	public boolean columnIsComplete(int index) {

		Object[] column = getColumn(index);

		for (int i = 0; i < board.length; i++) {
			if (column[i] == null) {
				return false;
			}
		}

		return true;
	}
	
	public boolean squareIsComplete() {
		
		for (int i = 0; i < board.length; i++) {
			if (!rowIsComplete(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Private Methods

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
	
	// Prints
	
	public void printBody() {
		
		for (int i = 0; i < board.length; i++) {
			printRow(i);
			System.out.println();
		}
	}

	public void printRow(int rowIndex) {

		String str = "";
		Object[] row = getRow(rowIndex);

		for (int i = 0; i < row.length; i++) {
//			if (row[i] != null) {
//				str += "|#";
//			} else {
//				str += "|.";
//			}
			str += "|" + row[i];
		}

		System.out.print(str);
	}

}
