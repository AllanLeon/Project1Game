package game;

import java.awt.geom.Ellipse2D;

public class Ball {

	private int centerX, centerY, speedX, speedY, radius;
	private Ellipse2D bounds;
	
	public Ball(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.speedX = 0;
		this.speedY = 0;
		this.radius = radius;
		bounds = new Ellipse2D.Double(centerX, centerY, radius, radius);
	}
}
