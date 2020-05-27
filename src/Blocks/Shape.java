package Blocks;



abstract class Shape implements IShape {

    private Object[][] shape;

    public Shape(int rows, int columns) {
        this.shape = new Object[rows][columns];

    }

    public Object[][] getShape() {
        return shape;
    }

    public void rotateMatrixNinetyDegreesClockwise() {//roda 90º para a direita

        int n = shape.length;
        int m = shape[0].length;
        Object[][] output = new Object[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output[j][n - 1 - i] = shape[i][j];
            }
        }
        this.shape = output;
    }

    public int getAnchorRow() {

        for (int i = 0; i < shape.length; i++) {

            if (shape[i][0] == null || (shape[i][0] == Boolean.FALSE)) {

            } else {
                return i;
            }

        }
        return 0;
    }

    // pode vir a sair ou mudar
    public void printBody() {

        for (int i = 0; i < shape.length; i++) {
            printRow(i);
            System.out.println();
        }
    }

    private void printRow(int rowIndex) {

        String str = "";
        Object[] row = getRow(rowIndex);

        for (int i = 0; i < row.length; i++) {
            if (row[i] == null || (row[i] == Boolean.FALSE)) {
                str += ".";
            } else {
                str += "#";
            }

//			para mostar o conte�do
//			str += "|" + row[i];
        }

        System.out.print(str);
    }

    private Object[] getRow(int index) {
        Object[] row = new Object[shape[0].length];
        for (int i = 0; i < row.length; i++) {
            row[i] = shape[index][i];
        }
        return row;
    }

    public int getElementCount() {

        int count = 0;
        for (int i = 0; i < shape.length; i++) {
            
            count += getElementCountByRow(getRow(i));

        }
        return count;
    }

    private int getElementCountByRow(Object[] row) {

        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (!(row[i] == null || (row[i] == Boolean.FALSE))) {
                count++;
            }

        }
        return count;
    }
}
