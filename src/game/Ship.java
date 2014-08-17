package game;

import java.awt.Rectangle;

public class Ship {

	private int x, y, speedX, speedY, width, height;
	private Rectangle bounds;
	
	public Ship(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.speedX = 0;
		this.speedY = 0;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(x, y, width, height);
	}
}
