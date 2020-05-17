package Blocks;

abstract class Shape implements IShape{

	private Object[][] shape;

	public Shape(int rows, int columns) {
		shape = new Object[rows][columns];
	}

	public Object[][] getShape() {
		return shape;
	}
	
	// pode vir a sair ou mudar

	public void printBody() {

		for (int i = 0; i < shape.length; i++) {
			printRow(i);
			System.out.println();
		}
	}

	private void printRow(int rowIndex) {

		String str = "";
		Object[] row = getRow(rowIndex);

		for (int i = 0; i < row.length; i++) {
			if (row[i] == null || (row[i] == Boolean.FALSE)) {
				str += ".";
			} else {
				str += "#";
			}

//			para mostar o conteúdo
//			str += "|" + row[i];
		}

		System.out.print(str);
	}

	private Object[] getRow(int index) {
		Object[] row = new Object[shape[0].length];
		for (int i = 0; i < row.length; i++) {
			row[i] = shape[index][i];
		}
		return row;
	}
}
