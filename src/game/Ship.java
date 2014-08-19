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
	
	@Override
	public void update() {
		super.update();
		if (y + height >= Main.getWindowHeight()) {
			y = Main.getWindowHeight() - height;
		} else if (y <= 0) {
			y = 0;
		}
		checkCollision();
	}
	
	public void checkCollision() {
		Ball ball =  Main.getBall();
		if ((ball.getSpeedX() > 0 && ball.getCenterX() + ball.getRadius() >= getX() - 10)
				|| ball.getSpeedX() < 0 && ball.getCenterX() - ball.getRadius() <= x + width + 10) {
			if (rect.intersects(ball.getCircle().getBounds())) {
				int newSpeedY = (5 * (ball.getCenterY() - y - (height / 2)) / (height / 2)) + ball.getSpeedY();
				System.out.println(newSpeedY);
				ball.setSpeedX(ball.getSpeedX() * -1);
				ball.setSpeedY(newSpeedY);
			}
		}
	}
}
