package Blocks;

public class Block_Lmin extends Shape {

    public Block_Lmin() {
        super(2, 2);

        Object[][] shape = super.getShape();

        shape[0][0] = true;
        shape[1][0] = true;
        shape[1][1] = true;

    }
}
