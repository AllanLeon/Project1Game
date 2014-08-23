package game;

import java.util.List;

public class LevelGenerator {
		
	private static final int BLOCK_WIDTH = 20;
	private static final int BLOCK_HEIGHT = 50;

	public static void generateLevel(int lvl) {
		int chosenLvl = lvl;
		switch (chosenLvl) {
		case 0:
			matrixLvl();
			break;
		case 1:
			lvl1();
			break;
		case 2:
			lvl2();
			break;
		case 3:
			lvl3();
			break;
		default:
			randomLvl();
			break;
		}
	}
	/**
	 * Level 1: The Envelope
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
	 * Level 2: The Cocktail Glass
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
	
	/**
	 * Level 3: The Wi-Fi Signal
	 * @param g
	 */
	public static void lvl3() {
		List<Block> blocks = Main.getBlocks();
		
		int sum = 0;

		//First signal
		for (int i = 0; i < 350; i += 21) {
			int j = 19 - Math.round(i/8);
			blocks.add(new Block(220 + i, 280 + sum, BLOCK_WIDTH, BLOCK_HEIGHT, 1));
			sum += j;
		}
		
		//Second signal
		for (int i = 0; i < 260; i += 21) {
			int j = 19 - Math.round(i/6);
			blocks.add(new Block(260 + i, 230 + sum, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
			sum += j;
		}
		
		//Third signal
		for (int i = 0; i < 150; i += 21) {
			int j = (int) (19 - Math.round(i/3.3));
			blocks.add(new Block(312 + i, 180 + sum, BLOCK_WIDTH, BLOCK_HEIGHT, 2));
			sum += j;
		}
		
		blocks.add(new Block(364, 60, BLOCK_WIDTH, BLOCK_HEIGHT, 5));
		blocks.add(new Block(385, 60, BLOCK_WIDTH, BLOCK_HEIGHT, 5));
		blocks.add(new Block(406, 60, BLOCK_WIDTH, BLOCK_HEIGHT, 5));
	}
	
	public static void randomLvl() {
		List<Block> blocks = Main.getBlocks();
		int[][] res = new int[8][20];
		int x = 250;
		int y = 50;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 20; i++) {
				res[j][i] = Main.getRandom().nextInt(20) - 15;
			}
		}
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 20; i++) {
				if (res[j][i] == 0) {
					blocks.add(new IndestructibleBlock(x + BLOCK_WIDTH*i, y + BLOCK_HEIGHT*(7-j), BLOCK_WIDTH, BLOCK_HEIGHT));
				} else if (res[j][i] > 0) {
					blocks.add(new Block(x + BLOCK_WIDTH*i, y + BLOCK_HEIGHT*(7-j), BLOCK_WIDTH, BLOCK_HEIGHT, res[j][i]));
				}
			}
		}
	}
	
	public static void matrixLvl() {
		List<Block> blocks = Main.getBlocks();
		int[][] res = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		};
		int x = 250;
		int y = 50;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 20; i++) {
				if (res[j][i] == 0) {
					blocks.add(new IndestructibleBlock(x + BLOCK_WIDTH*i, y + BLOCK_HEIGHT*(7-j), BLOCK_WIDTH, BLOCK_HEIGHT));
				} else if (res[j][i] > 0) {
					blocks.add(new Block(x + BLOCK_WIDTH*i, y + BLOCK_HEIGHT*(7-j), BLOCK_WIDTH, BLOCK_HEIGHT, res[j][i]));
				}
			}
		}
	}
}