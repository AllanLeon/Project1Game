package game;

import java.awt.Graphics;

public class LevelGenerator {
		
	int staticWidth = 20;
	int staticHeight = 50;

	public void draw(Graphics g, int lvl) {
		int chosenLvl = lvl;
		switch (chosenLvl) {
		case 1:
			lvl1(g);
			break;
		case 2:
			lvl2(g);
			break;
		}
	}
	/**
	 * Level: The Envelope
	 * @param g
	 */
	public void lvl1(Graphics g) { 	
		// Horizontal edges
		for (int i = 190; i < 600; i += 21) {
			new Block(i, 70, staticWidth, staticHeight, 1).draw(g);
			new Block(i, 376, staticWidth, staticHeight, 1).draw(g);
		}
		//vertical edges
		for (int i = 121; i < 400; i += 51) {
			new Block(190, i, staticWidth, staticHeight, 1).draw(g);
			new Block(589, i, staticWidth, staticHeight, 1).draw(g);
		}
		
		//forms envelope's flap
		new Block(211, 325, staticWidth, staticHeight, 2).draw(g);
		new Block(232, 325, staticWidth, staticHeight, 2).draw(g);
		new Block(253, 295, staticWidth, staticHeight, 2).draw(g);
		new Block(274, 295, staticWidth, staticHeight, 2).draw(g);
		new Block(295, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(316, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(337, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(358, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(379, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(400, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(421, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(442, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(463, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(484, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(505, 295, staticWidth, staticHeight, 2).draw(g);
		new Block(526, 295, staticWidth, staticHeight, 2).draw(g);
		new Block(547, 325, staticWidth, staticHeight, 2).draw(g);
		new Block(568, 325, staticWidth, staticHeight, 2).draw(g);
	}
	
	/**
	 * Level: The Cocktail Glass
	 * @param g
	 */
	public void lvl2(Graphics g) { 	
		//Rim
		for (int i = 240; i < 550; i += 21) {
			new Block(i, 356, staticWidth, staticHeight, 1).draw(g);
		}
		
		//Foot
		for (int i = 345; i < 450; i += 21) {
			new Block(i, 11, staticWidth, staticHeight, 1).draw(g);
		}
		
		//Stem
		for (int i = 62; i < 200; i += 51) {
			new Block(387, i, staticWidth, staticHeight, 1).draw(g);
		}

		//Bowl
		new Block(240, 305, staticWidth, staticHeight, 2).draw(g);
		new Block(261, 305, staticWidth, staticHeight, 2).draw(g);
		new Block(282, 285, staticWidth, staticHeight, 2).draw(g);
		new Block(303, 275, staticWidth, staticHeight, 2).draw(g);
		new Block(324, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(345, 235, staticWidth, staticHeight, 2).draw(g);
		new Block(366, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(387, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(408, 215, staticWidth, staticHeight, 2).draw(g);
		new Block(429, 235, staticWidth, staticHeight, 2).draw(g);
		new Block(450, 255, staticWidth, staticHeight, 2).draw(g);
		new Block(471, 275, staticWidth, staticHeight, 2).draw(g);
		new Block(492, 285, staticWidth, staticHeight, 2).draw(g);
		new Block(513, 305, staticWidth, staticHeight, 2).draw(g);
		new Block(534, 305, staticWidth, staticHeight, 2).draw(g);

		//Straw
		new Block(424, 305, staticWidth, staticHeight, 5).draw(g);
		new Block(440, 407, staticWidth, staticHeight, 5).draw(g);
	}
}