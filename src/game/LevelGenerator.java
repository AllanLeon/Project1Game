package game;

import java.util.List;

public class LevelGenerator {
		
	private static final int BLOCK_WIDTH = 20;
	private static final int BLOCK_HEIGHT = 50;

	public static void generateLevel(int lvl) {
		int chosenLvl = lvl;
		switch (chosenLvl) {
		case 1:
			lvl1();
			break;
		case 2:
			lvl2();
			break;
		}
	}
	/**
	 * Level: The Envelope
	 * @param g
	 */
	public static void lvl1() { 	
		// Horizontal edges
		List<Block> blocks = Main.getBlocks();
		for (int i = 190; i < 600; i += 21) {
			blocks.add(new Block(i, 70, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
			blocks.add(new Block(i, 376, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
		}
		//vertical edges
		for (int i = 121; i < 400; i += 51) {
			blocks.add(new Block(190, i, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
			blocks.add(new Block(589, i, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
		}
		
		//forms envelope's flap
		blocks.add(new Block(211, 325, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(232, 325, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(253, 295, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(274, 295, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(295, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(316, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(337, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(358, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(379, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(400, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(421, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(442, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(463, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(484, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(505, 295, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(526, 295, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(547, 325, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(568, 325, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
	}
	
	/**
	 * Level: The Cocktail Glass
	 * @param g
	 */
	public static void lvl2() {
		List<Block> blocks = Main.getBlocks();
		//Rim
		for (int i = 240; i < 550; i += 21) {
			blocks.add(new Block(i, 356, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
		}
		
		//Foot
		for (int i = 345; i < 450; i += 21) {
			blocks.add(new Block(i, 11, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
		}
		
		//Stem
		for (int i = 62; i < 200; i += 51) {
			blocks.add(new Block(387, i, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
		}

		//Bowl
		blocks.add(new Block(240, 305, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(261, 305, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(282, 285, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(303, 275, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(324, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(345, 235, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(366, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(387, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(408, 215, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(429, 235, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(450, 255, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(471, 275, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(492, 285, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(513, 305, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
		blocks.add(new Block(534, 305, BLOCK_WIDTH, BLOCK_HEIGHT, 2));

		//Straw
		blocks.add(new Block(424, 305, BLOCK_WIDTH, BLOCK_HEIGHT, 5));
		blocks.add(new Block(440, 407, BLOCK_WIDTH, BLOCK_HEIGHT, 5));
	}
}