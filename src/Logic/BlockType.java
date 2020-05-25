/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Blocks.*;

/**
 *
 * @author Miglob
 */
public enum BlockType {
    BLOCK_I, BLOCK_Q, BLOCK_T, BLOCK_L, BLOCK_J, BLOCK_S,
    BLOCK_Z, BLOCK_I1, BLOCK_I2, BLOCK_I3, BLOCK_LMIN, 
    BLOCK_LMAX, BLOCK_TBIG, BLOCK_QBIG;
    
    
    public IShape createBlock(){
        
        switch(this){
            case BLOCK_I:
                return new Block_I();
            case BLOCK_Q:
                return new Block_Q();
            case BLOCK_T:
                return new Block_T();
            case BLOCK_L:
                return new Block_L();
            case BLOCK_J:
                return new Block_J();
            case BLOCK_S:
                return new Block_S();
            case BLOCK_Z:
                return new Block_Z();
            case BLOCK_I1:
                return new Block_I1();
            case BLOCK_I2:
                return new Block_I2();
            case BLOCK_I3:
                return new Block_I3();
            case BLOCK_LMIN:
                return new Block_Lmin();
            case BLOCK_LMAX:
                return new Block_Lmax();
            case BLOCK_TBIG:
                return new Block_Tbig();
            case BLOCK_QBIG:
                return new Block_Qbig();
            default:
                return null;
        }
        
    }
    
}