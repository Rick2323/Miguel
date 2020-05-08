package Blocks;

public class Block_I2 extends Shape {

	public Block_I2() {
		super(2, 1);

		Object[][] shape = super.getShape();

		shape[0][0] = true;
		shape[1][0] = true;
	}
}
