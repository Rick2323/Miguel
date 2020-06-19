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
import Logic.Utils;

public class Matrix {

	int SIZE = Utils.getSquareSize() * Utils.getSquareSize();
	int length = SIZE;
	int width = SIZE;

	GridPane topHeader = new GridPane();
	GridPane sideHeader = new GridPane();
	GridPane root = new GridPane();

	public Matrix() {
		setUpTopHeader();
		setUpSideHeader();
		setUpRoot();
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
			tf.setStyle("-fx-font-weight: bold");

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

			tf.setStyle("-fx-font-weight: bold");

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
				tf.setText("");

				// Iterate the Index using the loops
				root.setRowIndex(tf, y);
				root.setColumnIndex(tf, x);
				root.getChildren().add(tf);
			}
		}
	}

	public Pane getPane() {
		VBox vBox = new VBox();
		vBox.getChildren().add(topHeader);
		vBox.getChildren().add(root);
		HBox hBox = new HBox();
		hBox.getChildren().add(sideHeader);
		hBox.getChildren().add(vBox);

		return hBox;
	}

	public void updateMatrix(Object[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

				boolean filled = ((boolean) matrix[i][j]);

				String icon = (filled ? "X" : "");
				fillElement(i, j, "" + icon, filled);
			}
		}
	}

	private void fillElement(int x, int y, String msg, boolean filled) {

		TextField tf = getNodeByRowColumnIndex(x, y);
		tf.setText(msg);
		if (filled) {
			tf.setStyle("-fx-text-inner-color: red; -fx-font-weight: bold; -fx-font-size: 12pt;");
		} else {
			tf.setStyle("");
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