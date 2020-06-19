package Views;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;

public class Coisa extends Application {

	@Override
	public void start(Stage primaryStage) {

		int SIZE = 9;
		int length = SIZE;
		int width = SIZE;
		int coisa = 1;

		GridPane root = new GridPane();

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {

				// Create a new TextField in each Iteration
				TextField tf = new TextField();
				tf.setPrefHeight(50);
				tf.setPrefWidth(50);
				tf.setAlignment(Pos.CENTER);
				tf.setEditable(false);
				tf.setText("(" + coisa++ + ")");

				// Iterate the Index using the loops
				root.setRowIndex(tf, y);
				root.setColumnIndex(tf, x);
				root.getChildren().add(tf);
			}
		}

		Scene scene = new Scene(root, 450, 450);
		primaryStage.setTitle("Random Binary Matrix (JavaFX)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}