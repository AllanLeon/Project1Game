package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Ball {

	private int centerX, centerY, speedX, speedY, radius;
	private Ellipse2D.Double circle;
	
	public Ball(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.speedX = 8;
		this.speedY = 1;
		this.radius = radius;
		this.circle = new Ellipse2D.Double(centerX - radius, centerY + radius, radius * 2, radius * 2);
	}
	
	public void update() {
		centerX += speedX;
		centerY += speedY;
		circle.setFrame(centerX - radius, centerY + radius, radius * 2, radius * 2);
		
		if (centerY + radius >= Main.getWindowHeight() || centerY - radius <= 0) {
			speedY *= -1;
			centerY += speedY;
		}/* if (centerX + radius >= Main.getWindowWidth() || centerX - radius <= 0) {
			speedX *= -1;
			centerX += speedX;
		}*/
	}
	
	public void draw(Graphics g) {
		for(int i = 1; i <= radius; i++) {
			Drawer.drawCircle(g, centerX, centerY, i, new Color(255, 255, 255, 255 - (radius - i)*20));
		}
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
	
	public Ellipse2D.Double getCircle() {
		return circle;
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
	
	public Rectangle2D getBounds() {
		return circle.getBounds2D();
	}
}
