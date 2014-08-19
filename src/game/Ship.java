package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.RectBounds;


public class Ship extends BasicRectangle {
	
	private Rectangle rect, rect1, rect2, rect3;
	
	public Ship(int x, int y, int width, int height) {
		super(x, y, width, height);
		int dist = height / 3;
		this.rect = new Rectangle(x, y, width, height);
		this.rect1 = new Rectangle(x, y, width, dist);		
		this.rect2 = new Rectangle(x, y + dist, width, dist);
		this.rect3 = new Rectangle(x, y + dist * 2, width, dist);
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, Color.CYAN);
		}
	}
	
	@Override
	public void update() {
		super.update();
		int dist = height / 3;
		rect.setBounds(x, y, width, height);
		rect1.setBounds(x, y, width, dist);
		rect2.setBounds(x, y + dist, width, dist);
		rect3.setBounds(x, y + dist * 2, width, dist);
		checkCollision();
	}
	
	public void checkCollision() {
		Ball ball =  Main.getBall();
		if ((ball.getSpeedX() > 0 && ball.getCenterX() + ball.getRadius() >= getX() - 10)
				|| ball.getSpeedX() < 0 && ball.getCenterX() - ball.getRadius() <= x + width + 10) {
			/*if (rect1.intersects(ball.getCircle().getBounds())) {
				ball.setSpeedX(ball.getSpeedX() * -1);
				ball.setSpeedY(ball.getSpeedY() - 5);
				System.out.println("Collision");
			} else if (rect2.intersects(ball.getCircle().getBounds())) {
				ball.setSpeedX(ball.getSpeedX() * -1);
				System.out.println("Collision");
			} else if (rect3.intersects(ball.getCircle().getBounds())) {
				ball.setSpeedX(ball.getSpeedX() * -1);
				ball.setSpeedY(ball.getSpeedY() + 5);
				System.out.println("Collision");
			}*/
			if (rect.intersects(ball.getCircle().getBounds())) {
				int newSpeedY = (5 * (ball.getCenterY() - y - (height / 2)) / (height / 2)) + ball.getSpeedY();
				System.out.println(newSpeedY);
				ball.setSpeedX(ball.getSpeedX() * -1);
				ball.setSpeedY(newSpeedY);
			}
		}
	}
}
