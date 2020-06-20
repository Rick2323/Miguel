package Views;

import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Persistence.RankingPersistence;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameView {

	// UI
	private TextArea textArea = new TextArea();
	private Text text = new Text();
	private TextField tfBlock = new TextField();
	private TextField tfSquare = new TextField();
	private Button playButton = new Button("Play");
	private Button saveButton = new Button("Save");
	private HBox hBox1 = new HBox();
	private VBox vBox = new VBox();
	private HBox hBox2 = new HBox();

	private MatrixView matrixView = new MatrixView();
	private Game game;
	private RankingPersistence rankingPersistence = RankingPersistence.getInstance();

	public GameView(Game game) {

		this.game = game;

		setUp();

		hBox1.getChildren().add(tfBlock);
		hBox1.getChildren().add(text);
		hBox1.getChildren().add(tfSquare);
		hBox1.getChildren().add(playButton);
		hBox1.getChildren().add(saveButton);
		vBox.getChildren().add(matrixView.getPane());
		vBox.getChildren().add(hBox1);
		hBox2.getChildren().add(vBox);
		hBox2.getChildren().add(textArea);
	}

	public Pane getPane() {

		return hBox2;
	}

	private void setUp() {
		
		matrixView.updateMatrix(game.getMatrix());
		

		hBox1.setStyle("-fx-padding: 5;");
		hBox1.setAlignment(Pos.CENTER);
		hBox1.setMargin(playButton, new Insets(0, 0, 0, 20));
		hBox1.setMargin(saveButton, new Insets(0, 0, 0, 10));
		
		text.setText(" - ");
		text.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold;");

		textArea.setStyle("-fx-font-size: 1.5em; -fx-padding: 0 0 0 5;");
		textArea.setPrefWidth(400);
		textArea.setEditable(false);
		textArea.setText(game.printPlayableBlocksText());

		tfBlock.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold;");
		tfBlock.setPrefWidth(80);
		tfBlock.setPromptText("Block");
		tfBlock.setAlignment(Pos.CENTER);
		tfBlock.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));
		
		tfSquare.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold;");
		tfSquare.setPrefWidth(80);
		tfSquare.setPromptText("Square");
		tfSquare.setAlignment(Pos.CENTER);
		tfSquare.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));

		playButton.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold; -fx-background-color: #cee3a1;");
		playButton.setOnAction(actionEvent -> {

			playGame();
		});
		
		saveButton.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold; -fx-background-color: #ffadad;");
		saveButton.setOnAction(actionEvent -> {

			endGame();
		});
	}

	private void playGame() {

		boolean gameRunning = !game.hasTheGameFinished();

		if (gameRunning) {

			try {
				// verificar o input com o regex
				if (tfBlock.getText().matches("([A-Z])") && tfSquare.getText().matches("([A-Z][1-9])")) {
					game.playBlock(tfBlock.getText(), tfSquare.getText());

					matrixView.updateMatrix(game.getMatrix());
					textArea.setText(game.printPlayableBlocksText());
				} else {
					String PreviousText = textArea.getText();
					textArea.setText(PreviousText + "\nInput inválido!");
				}

			} catch (ArrayIndexOutOfBoundsException ex) {
				String PreviousText = textArea.getText();
				textArea.setText(PreviousText + "\nA peça não cabe no tabuleiro!");
			} catch (ElementAlreadyFilledException ex) {
				String PreviousText = textArea.getText();
				textArea.setText(PreviousText + "\nA casa já está preenchida!");
			} catch (IndexOutOfBoundsException ex) {
				String PreviousText = textArea.getText();
				textArea.setText(PreviousText + "\nInput inválido!");
			}
		} else {
			endGame();
		}
	}

	private void endGame() {
		String PreviousText = textArea.getText();
		textArea.setText(PreviousText + "\nFim do Jogo!!!\nResultado: " + game.getScore()
				+ "\nObrigado por ter jogado BlockuDoku!!!!");

		rankingPersistence.saveRanking();
	}

}
