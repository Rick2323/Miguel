package Views;

import Logic.Utils;

import Logic.Ranking;
import Persistence.RankingPersistence;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	// views
	MenuView menuView;

	@Override
	public void start(Stage primaryStage) {
		
		menuView = new MenuView(primaryStage);

		run(primaryStage);
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

		Scene scene = new Scene(menuView.getPane(), 400, 250);
		primaryStage.setTitle("BlockuDoku!");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}