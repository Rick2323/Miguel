package Blocks;

public interface IShape {

	public Object[][] getShape();
        public void printBody();
        public void rotateMatrixNinetyDegreesClockwise(int numberOfRotations);
        public int getAnchorRow();
        public int getElementCount();
        
}
