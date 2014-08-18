package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;


public class Ship extends BasicRectangle {
	
	public Ship(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, Color.CYAN);
		}
	}
}
