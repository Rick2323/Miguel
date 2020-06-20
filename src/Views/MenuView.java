package Views;

import java.util.Map;
import java.util.Set;

import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Logic.GameMode;
import Logic.InputReader;
import Logic.Player;
import Logic.Utils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MenuView {

	private Text text = new Text();
	private TextField name = new TextField();
	private VBox vBox = new VBox();
	private Button newGame = new Button("Iniciar novo jogo");
	private Button openGame = new Button("Abrir o jogo");
	private Button showPersonalScores = new Button("Mostrar pontuações pessoais");
	private Button showTop10 = new Button("Ranking (TOP 10)");
	private Button newGameBasic = new Button("Iniciar novo jogo - modo básico");
	private Button newGameAdvanced = new Button("Iniciar novo jogo - modo avançado");
	private GridPane grid1 = new GridPane();
	TextArea textArea = new TextArea();
	private Stage primaryStage;

	public MenuView(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setUpMenu1();
	}

	public Pane getPane() {

		return vBox;
	}

	private void setUpMenu1() {

		vBox.getChildren().clear();
		vBox.setStyle("-fx-padding: 5;");

		String str = "Bem-Vindo ao BlockuDoku!!!\n\nInsira o seu nome: (Pressione a tecla Enter)";
		text.setText(str);
		text.setStyle("-fx-font-size: 1.5em; -fx-font-weight: bold;");
		text.setTextAlignment(TextAlignment.CENTER);
		vBox.setMargin(name, new Insets(10, 0, 0, 0));

		name.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				if (name.getText() != null && !name.getText().isEmpty()) {
					setPlayer();
					setUpMenu2();
				}
			}
		});

		vBox.getChildren().add(text);
		vBox.getChildren().add(name);
	}

	private void setPlayer() {

		Player p = Utils.getInstance().getRanking().getPlayer(name.getText());
		if (p != null) {
			Utils.getInstance().setPlayer(p);
		} else {
			Utils.getInstance().setPlayer(new Player(name.getText()));
			Utils.getInstance().getRanking().addPlayer(Utils.getInstance().getPlayer());
		}
	}

	private void setUpMenu2() {

		vBox.getChildren().clear();

		String str = "Olá \"" + Utils.getInstance().getPlayer().getName() + "\"";
		text.setText(str);

		newGame.setOnAction(actionEvent -> {
			newGame();
		});
		openGame.setOnAction(actionEvent -> {
			openGame();
		});
		showPersonalScores.setOnAction(actionEvent -> {
			showPersonalScores();
		});
		showTop10.setOnAction(actionEvent -> {
			showTop10();
		});

		vBox.getChildren().add(text);		

		newGame.setPrefWidth(200);
		newGame.setPrefHeight(100);
		newGame.setStyle("-fx-font-size: 1.1em; -fx-font-weight: bold;");
		grid1.setRowIndex(newGame, 0);
		grid1.setColumnIndex(newGame, 0);	
		grid1.getChildren().add(newGame);	

		openGame.setPrefWidth(200);
		openGame.setPrefHeight(100);
		openGame.setStyle("-fx-font-size: 1.1em; -fx-font-weight: bold;");
		grid1.setRowIndex(openGame, 0);
		grid1.setColumnIndex(openGame, 1);
		grid1.getChildren().add(openGame);		

		showPersonalScores.setPrefWidth(200);
		showPersonalScores.setPrefHeight(100);
		showPersonalScores.setStyle("-fx-font-size: 1.1em; -fx-font-weight: bold;");
		grid1.setRowIndex(showPersonalScores, 1);
		grid1.setColumnIndex(showPersonalScores, 0);	
		grid1.getChildren().add(showPersonalScores);	

		showTop10.setPrefWidth(200);
		showTop10.setPrefHeight(100);
		showTop10.setStyle("-fx-font-size: 1.1em; -fx-font-weight: bold;");
		grid1.setRowIndex(showTop10, 1);
		grid1.setColumnIndex(showTop10, 1);
		grid1.getChildren().add(showTop10);
		
		grid1.setStyle("-fx-padding: 20 0 0 0;");
		grid1.setAlignment(Pos.CENTER);
		vBox.getChildren().add(grid1);
		
		textArea.setStyle("-fx-font-size: 1.1em; -fx-font-weight: bold;");
		textArea.setEditable(false);
		textArea.setVisible(false);
		
		vBox.getChildren().add(textArea);
	}

	private void newGame() {

		vBox.getChildren().clear();

		newGameBasic.setOnAction(actionEvent -> {
			newGame(GameMode.BASIC);
		});
		newGameAdvanced.setOnAction(actionEvent -> {
			newGame(GameMode.ADVANCED);
		});
		
		newGameBasic.setPrefWidth(280);
		newGameBasic.setPrefHeight(100);
		newGameBasic.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold;");
		
		newGameAdvanced.setPrefWidth(280);
		newGameAdvanced.setPrefHeight(100);
		newGameAdvanced.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold;");

		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(newGameBasic);
		vBox.getChildren().add(newGameAdvanced);
	}

	private void newGame(GameMode gameMode) {

		Game game = new Game(gameMode);
		Utils.getInstance().getPlayer().addGame(game);

		GameView gameView = new GameView(game);

		Scene scene = new Scene(gameView.getPane());
		primaryStage.setScene(scene);
	}

	private void openGame() {

		Game game = Utils.getInstance().getPlayer().getRecentSavedGame();
		if (game != null) {
			GameView gameView = new GameView(game);

			Scene scene = new Scene(gameView.getPane());
			primaryStage.setScene(scene);
		} else {
			String PreviousText = text.getText();
			text.setText(PreviousText + "\nNão existem jogos gravados!");
		}
	}

	private void showPersonalScores() {

		if (Utils.getInstance().getPlayer() != null) {

			textArea.setVisible(true);
			String str = "**** RESULTADOS ****\n";
			for (Integer score : Utils.getInstance().getPlayer().getScores()) {
				str += "\nResultado: " + score;
			}
			textArea.setText(str);
		}
	}

	private void showTop10() {

		Map<Player, Integer> top10 = Utils.getInstance().getRanking().getTop10();

		textArea.setVisible(true);
		String str = "**** TOP 10 ****\n";

		Set<Player> players = top10.keySet();
		int rank = 1;
		for (Player player : players) {

			int score = top10.get(player);

			str += "\n" + rank + " - " + player.getName() + " - " + score;
			rank++;
		}

		textArea.setText(str);
	}
}
