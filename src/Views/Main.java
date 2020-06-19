package Views;

import Logic.CLI;
import Logic.ElementAlreadyFilledException;
import Logic.Game;
import Logic.GameMode;
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

	TextArea textArea = new TextArea();

	@Override
	public void start(Stage primaryStage) {

		Game game = new Game(GameMode.BASIC);
		Matrix coisa = new Matrix();

		textArea.setStyle("-fx-font-size: 1.5em; -fx-padding: 0 0 0 5;");
		textArea.setPrefWidth(400);
		textArea.setText(game.printPlayableBlocksText());

		TextField tfBlock = new TextField();
		tfBlock.setPromptText("Block");
		tfBlock.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));
		TextField tfSquare = new TextField();
		tfSquare.setPromptText("Square");
		tfSquare.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));
		Button button = new Button("Play");
		button.setOnAction(actionEvent -> {
			try {
				// verificar o input com o regex
				if (tfBlock.getText().matches("([A-Z])") && tfSquare.getText().matches("([A-Z][1-9])")) {
					game.playBlock(tfBlock.getText(), tfSquare.getText());

					coisa.updateMatrix(game.getMatrix());
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
		});
		textArea.setEditable(false);

		HBox hBox1 = new HBox();
		hBox1.getChildren().add(tfBlock);
		hBox1.getChildren().add(tfSquare);
		hBox1.getChildren().add(button);

		VBox vBox = new VBox();
		vBox.getChildren().add(coisa.getPane());
		vBox.getChildren().add(hBox1);

		HBox hBox2 = new HBox();
		hBox2.getChildren().add(vBox);
		hBox2.getChildren().add(textArea);

		Scene scene = new Scene(hBox2);
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}