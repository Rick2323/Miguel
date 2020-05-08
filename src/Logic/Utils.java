package Logic;

public class Utils {
	
	private static Utils instance = new Utils();
	
	// >= 2 SEMPRE
	private static final int SQUARE_SIZE = 3;
	

	private static int bosta = 1;

	private Utils() {
		
	};
	
	/*public static Utils getInstance() {
		return instance;
	}*/
	
	public static int getSquareSize() {
		return SQUARE_SIZE;
	}
	
	public static int getBosta() {
		return bosta++;
	}
}
