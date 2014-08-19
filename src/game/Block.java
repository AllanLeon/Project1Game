package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean invincible;
	private Rectangle rect;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.rect = new Rectangle(x, y, width, height);
		this.resistance = resistance;
		if (resistance > 5) {
			invincible = true;
		} else {
			invincible = false;
		}
	}
	
	@Override
	public void update() {
		super.update();
		rect.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {
				
		for (int i=0; i < height; i++) {
			if (resistance == 1)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5*i, 0));
			if (resistance == 2)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 0, 255 - 5*i));
			if (resistance == 5)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5*i, 0, 0));		
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
