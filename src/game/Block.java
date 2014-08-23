package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean visible;
	private int value;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.resistance = resistance;
		this.value = resistance * 50;
		this.visible = true;
	}
	
	@Override
	public void update() {
		super.update();
		Collider.checkBlockBallCollision(this);
	}
	
	public void draw(Graphics g) {
				
		for (int i=0; i < height; i++) {
			switch (resistance) {
			case 1:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5*i, 0));
				break;
			case 2:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5 * i, 255 - 5*i));
				break;
			case 3:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 0, 255 - 5*i));
				break;
			case 4:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5 * i, 0, 255 - 5*i));
				break;
			case 5:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5*i, 0, 0));
				break;
			default:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5*i, 255 - 5*i, 0, 50));
				break;
			}
		}
		
		Drawer.drawLine(g, x, y, x + width, y, Color.white);
		Drawer.drawLine(g, x, y + height, x + width, y + height, Color.white);
		Drawer.drawLine(g, x, y, x, y + height, Color.white);
		Drawer.drawLine(g, x + width, y, x + width, y + height, Color.white);
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void reduceResistance() {
		resistance--;
		if (resistance == 0) {
			visible = false;
		}
	}
}
