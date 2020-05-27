/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.IShape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miglob
 */
public enum GameMode {
    BASIC, ADVANCED;

    public List<BlockType> getSupportedShapes() {

        ArrayList<BlockType> blocks = new ArrayList<>();
        switch (this) {
            case BASIC:

                blocks.add(BlockType.BLOCK_I);
                blocks.add(BlockType.BLOCK_Q);
                blocks.add(BlockType.BLOCK_T);
                blocks.add(BlockType.BLOCK_L);
                blocks.add(BlockType.BLOCK_J);
                blocks.add(BlockType.BLOCK_S);
                blocks.add(BlockType.BLOCK_Z);

                return blocks;

            case ADVANCED:

                blocks.add(BlockType.BLOCK_I);
                blocks.add(BlockType.BLOCK_Q);
                blocks.add(BlockType.BLOCK_T);
                blocks.add(BlockType.BLOCK_L);
                blocks.add(BlockType.BLOCK_J);
                blocks.add(BlockType.BLOCK_S);
                blocks.add(BlockType.BLOCK_Z);
                blocks.add(BlockType.BLOCK_I1);
                blocks.add(BlockType.BLOCK_I2);
                blocks.add(BlockType.BLOCK_I3);
                blocks.add(BlockType.BLOCK_LMIN);
                blocks.add(BlockType.BLOCK_LMAX);
                blocks.add(BlockType.BLOCK_TBIG);
                blocks.add(BlockType.BLOCK_QBIG);

                return blocks;

            default:
                return null;
        }
    }

    public static GameMode getGameModeOfShape(IShape shape) {

        List<BlockType> supportedShapes = GameMode.BASIC.getSupportedShapes();
        Class<? extends IShape> shapeClass = shape.getClass();
        Class<? extends IShape> testClass;

        for (BlockType supportedShape : supportedShapes) {

            IShape testBlock = supportedShape.createBlock();

            testClass = testBlock.getClass();

            if (shapeClass.equals(testClass)) {

                return BASIC;
            }
        }
        
        supportedShapes = GameMode.ADVANCED.getSupportedShapes();

        for (BlockType supportedShape : supportedShapes) {

            IShape testBlock = supportedShape.createBlock();

            testClass = testBlock.getClass();

            if (shapeClass.equals(testClass)) {

                return ADVANCED;
            }

        }
        return null;
    }
}
