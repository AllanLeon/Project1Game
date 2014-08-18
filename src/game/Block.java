package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean invincible;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.resistance = resistance;
		if (resistance > 5) {
			invincible = true;
		} else {
			invincible = false;
		}
	}
	
	public void draw(Graphics g) {
		for (int i=0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0,255-5*i,0));
		}
		
		Drawer.drawLine(g, x, y, x + width, y, Color.white);
		Drawer.drawLine(g, x, y + height, x + width, y + height, Color.white);
		Drawer.drawLine(g, x, y, x, y + height, Color.white);
		Drawer.drawLine(g, x + width, y, x + width, y + height, Color.white);
	}
	
	public int getResistance() {
		return resistance;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}
}
