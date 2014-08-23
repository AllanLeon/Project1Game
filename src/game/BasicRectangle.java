package game;

import java.awt.Rectangle;

public class BasicRectangle {

	protected int x, y, speedX, speedY, width, height;
	protected Rectangle rect;
	
	public BasicRectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.speedX = 0;
		this.speedY = 0;
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(x, y, width, height);
	}
	
	public void update() {
		x += speedX;
		y += speedY;
		rect.setBounds(x, y, width, height);
	}
	
	public boolean ballIntersects() {
		Ball ball = Main.getBall();
		if (rect.intersects(Main.getBall().getBounds()) && !ball.isColliding()) {
			int cX, cY;
			
			if (ball.getCenterX() < x) {
				cX = x;
			} else if (ball.getCenterX() > x + width) {
				cX = x + width;
			} else {
				cX = ball.getCenterX();
			}
			if (ball.getCenterY() < y) {
				cY = y;
			} else if (ball.getCenterY() > y + height) {
				cY = y + height;
			} else {
				cY = ball.getCenterY();
			}
			
			if (calculateDistance(ball.getCenterX(), ball.getCenterY(), cX, cY) <= ball.getRadius()) {
				ball.setColliding(true);
				return true;
			}
		}
		ball.setColliding(false);
		return false;
	}
	
	private double calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
