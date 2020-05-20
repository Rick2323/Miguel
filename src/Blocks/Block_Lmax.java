package Blocks;

public class Block_Lmax extends Shape {

    public Block_Lmax() {
        super(3, 3);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[2][0] = true;
        shape[2][1] = true;
        shape[2][2] = true;

    }
}
