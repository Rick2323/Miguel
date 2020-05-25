/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miglob
 */
public enum GameMode {
    BASIC, ADVANCED;

    public List<BlockType> getSupportedShapes() {

        ArrayList<BlockType> basicBlocks = new ArrayList<>();
        switch (this) {
            case BASIC:

                basicBlocks.add(BlockType.BLOCK_I);
                basicBlocks.add(BlockType.BLOCK_Q);
                basicBlocks.add(BlockType.BLOCK_T);
                basicBlocks.add(BlockType.BLOCK_L);
                basicBlocks.add(BlockType.BLOCK_J);
                basicBlocks.add(BlockType.BLOCK_S);
                basicBlocks.add(BlockType.BLOCK_Z);

                return basicBlocks;
                
            case ADVANCED:
                
                basicBlocks.add(BlockType.BLOCK_I1);
                basicBlocks.add(BlockType.BLOCK_I2);
                basicBlocks.add(BlockType.BLOCK_I3);
                basicBlocks.add(BlockType.BLOCK_LMIN);
                basicBlocks.add(BlockType.BLOCK_LMAX);
                basicBlocks.add(BlockType.BLOCK_TBIG);
                basicBlocks.add(BlockType.BLOCK_QBIG);
                
                return basicBlocks;
                
            default:
                return null;
        }
    }
}
