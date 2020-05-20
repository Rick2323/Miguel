package Blocks;

public class Block_I extends Shape {

    public Block_I() {
        super(4, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[3][0] = true;

    }
}
