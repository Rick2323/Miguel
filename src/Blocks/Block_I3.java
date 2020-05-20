package Blocks;

public class Block_I3 extends Shape {

    public Block_I3() {
        super(3, 1);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;

    }
}
