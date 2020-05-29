package Blocks;

import java.io.Serializable;

public interface IShape extends Serializable{

	public Object[][] getShape();
        public void printBody();
        public void rotateMatrixNinetyDegreesClockwise(int numberOfRotations);
        public int getAnchorRow();
        public int getElementCount();
        
}
