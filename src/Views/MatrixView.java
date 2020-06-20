package Views;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import Logic.Utils;

public class MatrixView {

	int SIZE = Utils.getSquareSize() * Utils.getSquareSize();
	int length = SIZE;
	int width = SIZE;

	private GridPane topHeader = new GridPane();
	private GridPane sideHeader = new GridPane();
	private GridPane root = new GridPane();
	private VBox vBox = new VBox();
	private HBox hBox = new HBox();

	public MatrixView() {

		setUpTopHeader();
		setUpSideHeader();
		setUpRoot();

		vBox.getChildren().add(topHeader);
		vBox.getChildren().add(root);
		hBox.getChildren().add(sideHeader);
		hBox.getChildren().add(vBox);
	}

	public Pane getPane() {

		return hBox;
	}

	public void updateMatrix(Object[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

				boolean filled = ((boolean) matrix[i][j]);
				fillElement(i, j, filled);
			}
		}
	}

	private void setUpTopHeader() {

		char alphabet = 'A';
		for (int i = 0; i < SIZE; i++) {

			// Create a new TextField in each Iteration
			TextField tf = new TextField();
			tf.setPrefHeight(50);
			tf.setPrefWidth(50);
			tf.setAlignment(Pos.CENTER);
			tf.setEditable(false);
			char text = (char) (alphabet + i);

			tf.setText("" + text);
			tf.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold; -fx-control-inner-background: #cee3a1;");

			// Iterate the Index using the loops
			topHeader.setRowIndex(tf, 0);
			topHeader.setColumnIndex(tf, i);
			topHeader.getChildren().add(tf);

		}
	}

	private void setUpSideHeader() {

		for (int i = 0; i < (SIZE + 1); i++) {

			// Create a new TextField in each Iteration
			TextField tf = new TextField();
			tf.setPrefHeight(50);
			tf.setPrefWidth(50);
			tf.setAlignment(Pos.CENTER);
			tf.setEditable(false);

			if (i == 0) {
				tf.setText("\\");
			} else {
				tf.setText("" + i);
			}

			tf.setStyle("-fx-font-size: 1.3em; -fx-font-weight: bold; -fx-control-inner-background: #cee3a1;");

			// Iterate the Index using the loops
			sideHeader.setRowIndex(tf, i);
			sideHeader.setColumnIndex(tf, 0);
			sideHeader.getChildren().add(tf);

		}
	}

	private void setUpRoot() {

		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {

				// Create a new TextField in each Iteration
				TextField tf = new TextField();
				tf.setPrefHeight(50);
				tf.setPrefWidth(50);
				tf.setAlignment(Pos.CENTER);
				tf.setEditable(false);

				// Iterate the Index using the loops
				root.setRowIndex(tf, y);
				root.setColumnIndex(tf, x);
				root.getChildren().add(tf);
			}
		}
	}

	private void fillElement(int x, int y, boolean filled) {

		// cima direita baixo esquerda

		TextField tf = getNodeByRowColumnIndex(x, y);
		if (filled) {
			tf.setStyle("-fx-control-inner-background: red; -fx-font-weight: bold; -fx-font-size: 1.5em;");
		} else {

			// 1st matrix
			if (x == 1 && y == 2 || x == 1 && y == 5 || x == 1 && y == 8 || x == 4 && y == 2 || x == 4 && y == 5
					|| x == 4 && y == 8 || x == 7 && y == 2 || x == 7 && y == 5 || x == 7 && y == 8) { // direita
				tf.setStyle("-fx-border-color: #c6c6c6 black #c6c6c6 #c6c6c6; -fx-border-width: 1.5;");
			} else if (x == 2 && y == 2 || x == 2 && y == 5 || x == 2 && y == 8 || x == 5 && y == 2 || x == 5 && y == 5
					|| x == 5 && y == 8 || x == 8 && y == 2 || x == 8 && y == 5 || x == 8 && y == 8) { // canto direito baixo
				tf.setStyle("-fx-border-color: #c6c6c6 black black #c6c6c6; -fx-border-width: 1.5;");
			} else if (x == 2 && y == 1 || x == 2 && y == 4 || x == 2 && y == 7 || x == 5 && y == 1 || x == 5 && y == 4
					|| x == 5 && y == 7 || x == 8 && y == 1 || x == 8 && y == 4 || x == 8 && y == 7) { // baixo
				tf.setStyle("-fx-border-color: #c6c6c6 #c6c6c6 black #c6c6c6; -fx-border-width: 1.5;");
			} else if (x == 2 && y == 0 || x == 2 && y == 3 || x == 2 && y == 6 || x == 5 && y == 0 || x == 5 && y == 3
					|| x == 5 && y == 6 || x == 8 && y == 0 || x == 8 && y == 3 || x == 8 && y == 6) { // canto esquerda baixo
				tf.setStyle("-fx-border-color: #c6c6c6 #c6c6c6 black black; -fx-border-width: 1.5;");
			} else if (x == 1 && y == 0 || x == 1 && y == 3 || x == 1 && y == 6 || x == 4 && y == 0 || x == 4 && y == 3
					|| x == 4 && y == 6 || x == 7 && y == 0 || x == 7 && y == 3 || x == 7 && y == 6) { // esquerda
				tf.setStyle("-fx-border-color: #c6c6c6 #c6c6c6 #c6c6c6 black; -fx-border-width: 1.5;");
			} else if (x == 0 && y == 0 || x == 0 && y == 3 || x == 0 && y == 6 || x == 3 && y == 0 || x == 3 && y == 3
					|| x == 3 && y == 6 || x == 6 && y == 0 || x == 6 && y == 3 || x == 6 && y == 6) { // canto esquerda cima
				tf.setStyle("-fx-border-color: black #c6c6c6 #c6c6c6 black; -fx-border-width: 1.5;");
			} else if (x == 0 && y == 1 || x == 0 && y == 4 || x == 0 && y == 7 || x == 3 && y == 1 || x == 3 && y == 4
					|| x == 3 && y == 7 || x == 6 && y == 1 || x == 6 && y == 4 || x == 6 && y == 7) { // cima
				tf.setStyle("-fx-border-color: black #c6c6c6 #c6c6c6 #c6c6c6; -fx-border-width: 1.5;");
			} else if (x == 0 && y == 2 || x == 0 && y == 5 || x == 0 && y == 8 || x == 3 && y == 2 || x == 3 && y == 5
					|| x == 3 && y == 8 || x == 6 && y == 2 || x == 6 && y == 5 || x == 6 && y == 8) { // canto direita cima
				tf.setStyle("-fx-border-color: black black #c6c6c6 #c6c6c6; -fx-border-width: 1.5;");
			} else {
				tf.setStyle("");
			}
		}
	}

	private TextField getNodeByRowColumnIndex(final int row, final int column) {
		Node result = null;
		ObservableList<Node> childrens = root.getChildren();

		for (Node node : childrens) {
			if (root.getRowIndex(node) == row && root.getColumnIndex(node) == column) {
				result = node;
				break;
			}
		}

		return (TextField) result;
	}
}