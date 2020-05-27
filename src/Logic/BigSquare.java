package Logic;

public class BigSquare {

    private final int SQUARE_SIZE = Utils.getSquareSize();

    private Object[][] board;

    public BigSquare() {

        board = new Object[SQUARE_SIZE][SQUARE_SIZE];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                //board[i][j] = Utils.getBosta();
                board[i][j] = false;
            }
        }

    }

    public boolean rowIsComplete(int index) {

        Object[] row = getRow(index);

        for (int i = 0; i < board.length; i++) {

            if (row[i] == null || (row[i] == Boolean.FALSE)) {
                return false;
            }
        }

        return true;
    }

    public boolean columnIsComplete(int index) {

        Object[] column = getColumn(index);

        for (int i = 0; i < board.length; i++) {

            if (column[i] == null || (column[i] == Boolean.FALSE)) {
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
            if (row[i] == null || (row[i] == Boolean.FALSE)) {
                str += "|.";
            } else {
                str += "|#";
            }

            // para mostar o conte�do
            //str += "|" + row[i];
        }

        System.out.print(str);
    }

    public void fillElement(int matrixPositionRow, int matrixPositionColumn) {

        int row = matrixPositionRow % 3;
        int column = matrixPositionColumn % 3;

        board[row][column] = true;
    }

    public void testElement(int matrixPositionRow, int matrixPositionColumn) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

        int row = matrixPositionRow % 3;
        int column = matrixPositionColumn % 3;

        //if(board[row][column].equals(new Boolean(true))){
        if (!(board[row][column] == null || (board[row][column] == Boolean.FALSE))) {

            throw new ElementAlreadyFilledException("Bosta preenchida");
        }

    }
    
    public int clearRow(int rowIndex){
        
       for (int i = 0; i < board.length; i++) {
            board[rowIndex][i] = false;
        }
       return board.length;
    }
    public int clearColumn(int columnIndex){
        
       for (int i = 0; i < board.length; i++) {
            board[i][columnIndex] = false;
        }
       return board.length;
    }

    public int clearSquare() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = false;
            }
        }
        return board.length * board.length;
    }

}
