package Blocks;

public class Block_Qbig extends Shape {

    public Block_Qbig() {
        super(3, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[0][1] = true;
        shape[0][2] = true;
        shape[1][0] = true;
        shape[1][1] = true;
        shape[1][2] = true;
        shape[2][0] = true;
        shape[2][1] = true;
        shape[2][2] = true;

    }
}
