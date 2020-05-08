package Blocks;

public class Block_Tbig extends Shape {

	public Block_Tbig() {
		super(3, 3);

		Object[][] shape = super.getShape();

		shape[0][0] = true;
		shape[0][1] = true;
		shape[0][2] = true;
		shape[1][1] = true;
		shape[2][1] = true;
	}
}
