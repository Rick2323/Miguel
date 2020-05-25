package Logic;

import Blocks.Block_I;
import Blocks.Block_I1;
import Blocks.Block_I2;
import Blocks.Block_I3;
import Blocks.Block_J;
import Blocks.Block_L;
import Blocks.Block_Lmax;
import Blocks.Block_Lmin;
import Blocks.Block_Q;
import Blocks.Block_Qbig;
import Blocks.Block_S;
import Blocks.Block_T;
import Blocks.Block_Tbig;
import Blocks.Block_Z;
import Blocks.IShape;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GameBoard coisa = new GameBoard();

//                coisa.fillElement("A3");
//                coisa.fillElement("D3");
//                coisa.fillElement("B5");
        //coisa.print();
        IShape shapeJ = new Block_Q();

//        shapeJ.rotateMatrixNinetyDegreesClockwise();
//        shapeJ.rotateMatrixNinetyDegreesClockwise();
//        shapeJ.rotateMatrixNinetyDegreesClockwise();
//        coisa.placeBlock(shapeJ, "A1");
//
//        coisa.placeBlock(shapeJ, "C1");
//        coisa.placeBlock(shapeJ, "A3");
//        coisa.placeBlock(shapeJ, "C3");
//        coisa.print();
//        coisa.clearFilledBigSquares();
//        coisa.print();

        List<BlockType> supportedShapes = GameMode.getSupportedShapes(GameMode.BASIC);
        supportedShapes.forEach((n) -> BlockType.createBlock(n).printBody());
        
//		System.out.println();
//		new Block_I().printBody();
//		System.out.println();
//		new Block_Q().printBody();
//		System.out.println();
//		new Block_T().printBody();
//		System.out.println();
//		new Block_L().printBody();
//		System.out.println();
//		new Block_J().printBody();
//		System.out.println();
//		new Block_S().printBody();
//		System.out.println();
//		new Block_Z().printBody();
//		System.out.println();
//		new Block_I1().printBody();
//		System.out.println();
//		new Block_I2().printBody();
//		System.out.println();
//		new Block_I3().printBody();
//		System.out.println();
//		new Block_Lmin().printBody();
//		System.out.println();
//		new Block_Lmax().printBody();
//		System.out.println();
//		new Block_Tbig().printBody();
//		System.out.println();
//		new Block_Qbig().printBody();
    }
}
