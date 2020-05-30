
package Logic;

import Blocks.IShape;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Classe que divide as peças que podem ser utilizadas nos dois modos diferentes de jogo.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.27)
 */
public enum GameMode implements Serializable{
    BASIC, ADVANCED;
/**
 * Metodo que faz a distribuição das peças pelos dois diferentes tipos de jogo.
 * @return uma colecção com as peças consoante o modo de jogo, basico e avançado.
 */
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
/**
 * Metodo estático para devolver as peças consoante o modo de jogo.
 * 
 * @param shape peças criadas através da interface IShape
 * @return o modo de jogo e as suas peças.
 */
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
