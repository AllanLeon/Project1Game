package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.RectBounds;


public class Ship extends BasicRectangle {
	
	private Rectangle rect1, rect2, rect3;
	
	public Ship(int x, int y, int width, int height) {
		super(x, y, width, height);
		int dist = height / 3;
		this.rect1 = new Rectangle(x, y, width, dist);
		this.rect2 = new Rectangle(x, y + dist, width, dist);
		this.rect3 = new Rectangle(x, y + dist * 2, width, dist);
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, Color.CYAN);
		}
		Drawer.drawLine(g, rect1.x, rect1.y, rect1.width + rect1.x, rect1.y + rect1.height, Color.RED);
		Drawer.drawLine(g, rect2.x, rect2.y, rect2.width + rect2.x, rect2.y + rect2.height, Color.RED);
		Drawer.drawLine(g, rect3.x, rect3.y, rect3.width + rect3.x, rect3.y + rect3.height, Color.RED);
		//Drawer.drawLine(g, x, y, width + x, y + height, Color.RED);
	}
	
	@Override
	public void update() {
		super.update();
		int dist = height / 3;
		rect1.setBounds(x, y, width, dist);
		rect2.setBounds(x, y + dist, width, dist);
		rect3.setBounds(x, y + dist * 2, width, dist);
		checkCollision();
	}
	
	public void checkCollision() {
		/*if (rect1.contains(Main.getBall().getCenterX() + Main.getBall().getRadius(),
				Main.getBall().getCenterY() + Main.getBall().getRadius()) ||
				rect1.contains(Main.getBall().getCenterX() + Main.getBall().getRadius(),
						Main.getBall().getCenterY() - Main.getBall().getRadius())) {
			Main.getBall().setSpeedX(Main.getBall().getSpeedX() * -1);
			Main.getBall().setSpeedY(Main.getBall().getSpeedY() + 2);
			System.out.println("Collision");
		}*/
		if (rect1.intersects(Main.getBall().getCircle().getBounds())) {
			Main.getBall().setSpeedX(Main.getBall().getSpeedX() * -1);
			Main.getBall().setSpeedY(Main.getBall().getSpeedY() - 5);
			System.out.println("Collision");
		} else if (rect2.intersects(Main.getBall().getCircle().getBounds())) {
			Main.getBall().setSpeedX(Main.getBall().getSpeedX() * -1);
			System.out.println("Collision");
		} else if (rect3.intersects(Main.getBall().getCircle().getBounds())) {
			Main.getBall().setSpeedX(Main.getBall().getSpeedX() * -1);
			Main.getBall().setSpeedY(Main.getBall().getSpeedY() + 5);
			System.out.println("Collision");
		}
	}
}
