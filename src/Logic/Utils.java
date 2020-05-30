package Logic;
/**
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.17)
 */
public class Utils {
	
	private static Utils instance = new Utils();
	
	// >= 2 SEMPRE
	private static final int SQUARE_SIZE = 3;
	

	private static int b = 1;

	private Utils() {
		
	};
	
	/*public static Utils getInstance() {
		return instance;
	}*/
/**
 * Metodo que retorna o tamanho da matriz
 * 
 * @return um inteiro que representa o tamanho da matriz
 */	
	public static int getSquareSize() {
		return SQUARE_SIZE;
	}
	
	public static int getB() {
		return b++;
	}
}
