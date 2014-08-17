package game;

public class Ball {

	private int centerX, centerY, speedX, speedY, radius;
	
	public Ball(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.speedX = 0;
		this.speedY = 0;
		this.radius = radius;
	}
	
	public void update() {
		centerX += speedX;
		centerY += speedY;
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
