package Blocks;

public class Block_L extends Shape {

    public Block_L() {
        super(3, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[2][1] = true;

    }
}
