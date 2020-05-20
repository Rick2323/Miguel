package Blocks;

public class Block_J extends Shape {

    public Block_J() {
        super(3, 2);

        Object[][] shape = super.getShape();

        shape[0][1] = true;
        shape[1][1] = true;
        shape[2][0] = true;
        shape[2][1] = true;

    }
}
