package Blocks;

public class Block_S extends Shape {

	public Block_S() {
		super(2, 3);

		Object[][] shape = super.getShape();

		shape[1][0] = true;
		shape[0][1] = true;
		shape[1][1] = true;
		shape[0][2] = true;
	}
}
