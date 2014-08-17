package game;

import java.awt.Rectangle;

public class Ship {

	private int x, y, speedX, speedY, sizeX, sizeY;
	private Rectangle bounds;
	
	public Ship(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;
		this.speedX = 0;
		this.speedY = 0;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
}
