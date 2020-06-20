package Logic;

/**
 * Classe que utiliza um Singleton para criar uma unica instancia da matriz
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.17)
 */
public class Utils {

	private static Utils instance = new Utils();

	// sempre 3
	private static final int SQUARE_SIZE = 3;

	private Player player = null;
	private GameBoard gameBoard = null;
	private Ranking ranking = new Ranking();
	private boolean running = false;

	private Utils() {

	}

	public static Utils getInstance() {
		return instance;
	}

	/**
	 * Metodo que retorna o tamanho da matriz
	 *
	 * @return um inteiro que representa o tamanho da matriz
	 */
	public static int getSquareSize() {
		return SQUARE_SIZE;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
