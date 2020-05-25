package Logic;

import Blocks.IShape;
import java.util.ArrayList;
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
            increment += 3;
        }
    }

    private void fillElement(int matrixPositionRow, int matrixPositionColumn) {

        int row = matrixPositionRow / 3;
        int column = matrixPositionColumn / 3;

        board[row][column].fillElement(matrixPositionRow, matrixPositionColumn);

    }

    private void testElement(int matrixPositionRow, int matrixPositionColumn) throws ArrayIndexOutOfBoundsException, ElementAlreadyFilledException {

        int row = matrixPositionRow / 3;
        int column = matrixPositionColumn / 3;

        board[row][column].testElement(matrixPositionRow, matrixPositionColumn);

    }

    private int getRowFromMatrixPosition(String matrixPosition) {//buscar a linha da string A3

        return Integer.parseInt(Character.toString(matrixPosition.charAt(1))) - 1;

    }

    private int getColumnFromMatrixPosition(String matrixPosition) {//buscar a coluna

        char a = 'A';

        return matrixPosition.charAt(0) - a;
    }

    public void placeBlock(IShape shape, String matrixPosition) {

        Object[][] shapeMatrix = shape.getShape();

        int anchorRow = shape.getAnchorRow();

        ArrayList<int[]> placedBlocks = new ArrayList<>();

        int matrixPositionRow = getRowFromMatrixPosition(matrixPosition);
        int matrixPositionColumn = getColumnFromMatrixPosition(matrixPosition);

        if (testBlock(shapeMatrix, matrixPositionRow, matrixPositionColumn, anchorRow)) {
            for (int i = 0; i < shapeMatrix.length; i++) {
                for (int j = 0; j < shapeMatrix[0].length; j++) {
                    if (shapeMatrix[i][j] == null || (shapeMatrix[i][j] == Boolean.FALSE)) {

                    } else {
                        fillElement((matrixPositionRow - anchorRow + i), (matrixPositionColumn + j));

                    }
                }
            }
        }
    }

    private boolean testBlock(Object[][] shapeMatrix, int matrixPositionRow, int matrixPositionColumn, int anchorRow) {

        try {
            for (int i = 0; i < shapeMatrix.length; i++) {
                for (int j = 0; j < shapeMatrix[0].length; j++) {
                    if (shapeMatrix[i][j] == null || (shapeMatrix[i][j] == Boolean.FALSE)) {

                    } else {
                        testElement((matrixPositionRow - anchorRow + i), (matrixPositionColumn + j));

                    }
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não cabe dentro da matriz");
            return false;
        } catch (ElementAlreadyFilledException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public void clearFilledRows() {

        BigSquare square;
        int increment = 0;

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
                    clearRow(rowIndex, k);
                }

            }
            increment += 3;

        }

    }

    private void clearRow(int rowIndex, int k) {

        BigSquare square;
        for (int columnIndex = 0; columnIndex < board.length; columnIndex++) {
            square = board[rowIndex][columnIndex];
            square.clearRow(k);
        }
    }

    public void clearFilledColumns() {

        BigSquare square;
        int increment = 0;
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
                    clearColumn(columnIndex, k);
                }

            }
            increment += 3;

        }

    }

    private void clearColumn(int columnIndex, int k) {
        
        BigSquare square;
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            square = board[rowIndex][columnIndex];
            square.clearColumn(k);
        }
    }
    
    public void clearFilledBigSquares(){
            
        BigSquare square;
        
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < board.length; columnIndex++){
                square = board[rowIndex][columnIndex];
                if(square.squareIsComplete()){
                    square.clear();
                }
            }
        }
    }
}
