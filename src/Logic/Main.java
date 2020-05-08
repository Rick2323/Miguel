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

public class Main {
	
	public static void main(String[] args) {

		GameBoard coisa = new GameBoard();

		coisa.print();
		
		System.out.println();
		new Block_I().printBody();
		System.out.println();
		new Block_Q().printBody();
		System.out.println();
		new Block_T().printBody();
		System.out.println();
		new Block_L().printBody();
		System.out.println();
		new Block_J().printBody();
		System.out.println();
		new Block_S().printBody();
		System.out.println();
		new Block_Z().printBody();
		System.out.println();
		new Block_I1().printBody();
		System.out.println();
		new Block_I2().printBody();
		System.out.println();
		new Block_I3().printBody();
		System.out.println();
		new Block_Lmin().printBody();
		System.out.println();
		new Block_Lmax().printBody();
		System.out.println();
		new Block_Tbig().printBody();
		System.out.println();
		new Block_Qbig().printBody();
	}
}
