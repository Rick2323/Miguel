package Views;

import Logic.Utils;

import Logic.CLI;
import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Logic.GameBoard;
import Logic.GameMode;
import Logic.InputReader;
import Logic.Player;
import Logic.Ranking;
import Persistence.RankingPersistence;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	// views
	MenuView menuView;

	@Override
	public void start(Stage primaryStage) {
		
		menuView = new MenuView(primaryStage);

		run(primaryStage);

		//Game game = new Game(GameMode.BASIC);
		//GameView gameView = new GameView(game);

		/*
		 * Scene scene = new Scene(gameView.getPane());
		 * primaryStage.setTitle("Hello World!"); primaryStage.setScene(scene);
		 * primaryStage.setResizable(false); primaryStage.show();
		 */

	}

	public void run(Stage primaryStage) {

		RankingPersistence rankingPersistence = RankingPersistence.getInstance();

		rankingPersistence.loadRanking();

		if (rankingPersistence.getRanking() != null) {
			Utils.getInstance().setRanking(rankingPersistence.getRanking());
		} else {
			Ranking ranking = new Ranking();
			Utils.getInstance().setRanking(ranking);
			rankingPersistence.setRanking(ranking);
		}

		Utils.getInstance().setRunning(true);

		// mostrar menu
		Scene scene = new Scene(menuView.getPane(), 500, 500);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void run2() {

	}

	public static void main(String[] args) {
		launch(args);
	}
}