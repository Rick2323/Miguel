package Views;

import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Persistence.RankingPersistence;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameView {

	// UI
	private TextArea textArea = new TextArea();
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
		hBox1.getChildren().add(tfSquare);
		hBox1.getChildren().add(playButton);
		hBox1.getChildren().add(saveButton);
		vBox.getChildren().add(matrixView.getPane());
		vBox.getChildren().add(hBox1);
		hBox2.getChildren().add(vBox);
		hBox2.getChildren().add(textArea);
	}

	public void showText(String text) {

		String PreviousText = textArea.getText();
		textArea.setText(PreviousText + "\nA casa já está preenchida!");
	}

	public Pane getPane() {

		return hBox2;
	}

	private void setUp() {

		textArea.setStyle("-fx-font-size: 1.5em; -fx-padding: 0 0 0 5;");
		textArea.setPrefWidth(400);
		textArea.setEditable(false);
		textArea.setText(game.printPlayableBlocksText());

		tfBlock.setPromptText("Block");
		tfBlock.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));
		tfSquare.setPromptText("Square");
		tfSquare.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));
		playButton.setOnAction(actionEvent -> {

			playGame();
		});
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
		textArea.setText(PreviousText + "\nFim do Jogo!!!\nResultado: " + game.getScore());

		rankingPersistence.saveRanking();
	}

}
