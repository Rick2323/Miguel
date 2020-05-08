package Blocks;

public class Block_T extends Shape {

	public Block_T() {
		super(2, 3);

		Object[][] shape = super.getShape();

		shape[0][0] = true;
		shape[0][1] = true;
		shape[0][2] = true;
		shape[1][1] = true;
	}
}
