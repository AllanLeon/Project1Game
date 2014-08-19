package game;

import java.awt.Rectangle;

public class BasicRectangle {

	protected int x, y, speedX, speedY, width, height;
	
	
	public BasicRectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.speedX = 0;
		this.speedY = 0;
		this.width = width;
		this.height = height;
	}
	
	public void update() {
		x += speedX;
		y += speedY;
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
