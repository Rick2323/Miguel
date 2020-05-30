package Blocks;
/**
 * Classe abstracta que implementa a interface IShape 
 * 
 * Cria instâncias (shape - forma) do tipo array bidimencional de Object
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.29)
 */
abstract class Shape implements IShape {

    private Object[][] shape;
/**
 * Cria um objecto bidimensional que tem uma posição na matriz dada por linha e coluna
 * 
 * @param rows um inteiro que representa uma linha
 * @param columns um inteiro que representa uma coluna
 */
    public Shape(int rows, int columns) {
        this.shape = new Object[rows][columns];

    }
/**
 * Vai retornar um determinado bloco numa dada posição bidimensional 
 * 
 * @return uma forma de bloco do tipo Object
 */
    public Object[][] getShape() {
        return shape;
    }

    private void rotate() {//roda 90º para a direita

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
/**
 * Faz com que a peça possa rodar para quatro posições diferentes.
 * 
 * @param numberOfRotations inteiro que representa o número de rotações que a peça pode dar.
 */
    public void rotateMatrixNinetyDegreesClockwise(int numberOfRotations) {

        if (numberOfRotations > 0) {

            int rotation = numberOfRotations % 4;

            for (int i = 0; i < rotation; i++) {
                rotate();
            }
        }
    }
/**
 * Metodo que nos retorna um inteiro que representa o elemento da peça que serve de ancora para a sua
 * colocação na matris de jogo.
 * Caso contário retorna zero
 * 
 * @return um inteiro que representa o elemento na peça que serve de ancora para a sua colocação na matriz de jogo.
 */
    public int getAnchorRow() {

        for (int i = 0; i < shape.length; i++) {

            if (shape[i][0] == null || (shape[i][0] == Boolean.FALSE)) {

            } else {
                return i;
            }

        }
        return 0;
    }

/**
 * Metodo que serve para imprimir a peça na matriz de jogo
 */
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
/**
 * Serve para fazer a contagem dos elementos qie uma peça tem.
 * 
 * @return um inteiro que representa o número de elementos que a peça tem.
 */
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
