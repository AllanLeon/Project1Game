package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean visible;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.resistance = resistance;
		this.visible = true;
	}
	
	@Override
	public void update() {
		super.update();
		checkCollision();
	}
	
	public void draw(Graphics g) {
				
		for (int i=0; i < height; i++) {
			if (resistance == 1)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5*i, 0));
			if (resistance == 2)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 0, 255 - 5*i));
			if (resistance == 3)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5 * i, 255 - 5*i));
			if (resistance == 4)
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5 * i, 0, 255 - 5*i));
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
	
	public boolean isVisible() {
		return visible;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	
	public void checkCollision() {
		Ball ball = Main.getBall();
		int rSpeed = Main.getRandom().nextInt(6) - 3;
		if (rect.intersects(ball.getBounds())) {
			if ((ball.getSpeedX() > 0 && ball.getCenterX() <= x) ||
					(ball.getSpeedX() < 0 && ball.getCenterX() >= x + width)) {
				ball.setSpeedX(ball.getSpeedX() * -1 + rSpeed);
				ball.setSpeedY(ball.getSpeedY() + rSpeed);
				
			}
			if ((ball.getSpeedY() > 0 && ball.getCenterY() <= y) ||
					(ball.getSpeedY() < 0 && ball.getCenterY() >= y + height)) {
				ball.setSpeedX(ball.getSpeedY() * -1 + rSpeed);
				ball.setSpeedX(ball.getSpeedX() + rSpeed);
			} 
			
			resistance--;
			if (resistance <= 0) {
				visible = false;
			}
		}
	}
}
