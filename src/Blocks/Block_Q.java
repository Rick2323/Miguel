package Blocks;

public class Block_Q extends Shape {

    public Block_Q() {
        super(2, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[1][0] = true;
        shape[1][1] = true;

    }
}
