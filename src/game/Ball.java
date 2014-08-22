package game;

import game.Main.GameState;
import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {

	private int centerX, centerY, speedX, speedY, radius;
	private Rectangle rect;
	private boolean colliding;
	private int lastPlayer;
	
	public Ball(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.speedX = 8;
		this.speedY = 0;
		this.radius = radius;
		this.colliding = false;
		this.rect = new Rectangle(centerX - radius, centerY - radius, radius * 2, radius * 2);
		this.lastPlayer = 1;
	}
	
	public void update() {
		centerX += speedX;
		centerY += speedY;
		rect.setBounds(centerX - radius, centerY - radius, radius * 2, radius * 2);
		
		if (centerY + radius >= Main.getWindowHeight() || centerY - radius <= 0) {
			speedY *= -1;
			centerY += speedY;
		}
		if (centerX + radius >= Main.getWindowWidth()) {
			Main.setState(GameState.P1Win);
			Main.getPlayer1().increasePoints();
		} else if (centerX - radius <= 0) {
			Main.setState(GameState.P2Win);
			Main.getPlayer2().increasePoints();
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 1; i < radius; i++) {
			Drawer.drawCircle(g, centerX, centerY, i, new Color(255 - i*20, 255 - i*20, 255 - i*20));
		}
		Drawer.drawCircle(g, centerX, centerY, radius, Color.WHITE);
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
	
	public boolean isColliding() {
		return colliding;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setSpeedX(int speedX) {
		if (speedX == 0) {
			speedX = 1;
		}
		this.speedX = speedX;
		if (Math.abs(this.speedX) < 5) {
			this.speedX = this.speedX / Math.abs(this.speedX) * 5;
		}
		if (Math.abs(this.speedX) > 10) {
			this.speedX = this.speedX / Math.abs(this.speedX) * 10;
		}
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
		if (Math.abs(this.speedY) > 15) {
			this.speedY = this.speedY / Math.abs(this.speedY) * 15;
		}
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setColliding(boolean colliding) {
		this.colliding = colliding;
	}
	
	public void setLastPlayer(int lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
	
	public int getLastPlayer() {
		return lastPlayer;
	}
	
	public Rectangle getBounds() {
		return rect.getBounds();
	}
}
