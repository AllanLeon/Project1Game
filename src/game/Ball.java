package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int centerX, centerY, speedX, speedY, radius;
	
	public Ball(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.speedX = 20;
		this.speedY = 10;
		this.radius = radius;
	}
	
	public void update() {
		centerX += speedX;
		centerY += speedY;
		
		if (centerY + radius >= Main.getWindowHeight() || centerY - radius <= 0) {
			speedY *= -1;
			centerY += speedY;
		} if (centerX + radius >= Main.getWindowWidth() || centerX - radius <= 0) {
			speedX *= -1;
			centerX += speedX;
		}
	}
	
	public void draw(Graphics g) {
		Drawer.drawCircle(g, centerX, centerY, radius, Color.CYAN);
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public int getRadius() {
		return radius;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}
