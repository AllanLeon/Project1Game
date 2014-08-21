package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class IndestructibleBlock extends Block {

	public IndestructibleBlock(int x, int y, int width, int height) {
		super(x, y, width, height, -1);
	}
	/*
	@Override
	public void checkCollision() {
		if (rect.intersects(Main.getBall().getBounds())) {
			bounceBall();
		}
	}*/
	
	@Override
	public void draw(Graphics g) {
		for (int i=0; i < width; i++) {
			Drawer.drawLine(g, x + i, y, x + i, y + height, new Color(255 - Math.abs(255 - i*510/width), 255 - Math.abs(255 - i*510/width), 255 - Math.abs(255 - i*510/width)));		
		}
		
		Drawer.drawLine(g, x, y, x + width, y, Color.white);
		Drawer.drawLine(g, x, y + height, x + width, y + height, Color.white);
		Drawer.drawLine(g, x, y, x, y + height, Color.white);
		Drawer.drawLine(g, x + width, y, x + width, y + height, Color.white);
	}
}
