package Views;

import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Logic.GameMode;
import Logic.InputReader;
import Logic.Player;
import Logic.Utils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

		String str = "Bem-Vindo ao BlockuDoku!!!\n Insira o seu nome. (Pressione a tecla Enter)";
		text.setText(str);

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

		String str = "Olá " + Utils.getInstance().getPlayer().getName();
		text.setText(str);

		newGame.setOnAction(actionEvent -> {
			newGame();
		});
		openGame.setOnAction(actionEvent -> {
			// TODO
		});
		showPersonalScores.setOnAction(actionEvent -> {
			// TODO
		});
		showTop10.setOnAction(actionEvent -> {
			// TODO
		});

		vBox.getChildren().add(text);
		vBox.getChildren().add(newGame);
		vBox.getChildren().add(openGame);
		vBox.getChildren().add(showPersonalScores);
		vBox.getChildren().add(showTop10);

	}

	private void newGame() {

		vBox.getChildren().clear();

		newGameBasic.setOnAction(actionEvent -> {
			newGame(GameMode.BASIC);
		});
		newGameAdvanced.setOnAction(actionEvent -> {
			newGame(GameMode.ADVANCED);
		});

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
}
