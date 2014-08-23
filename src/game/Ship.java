package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Ship extends BasicRectangle {
	
	private int points, score, id;
	private Random random;
	
	public Ship(int x, int y, int width, int height, int id) {
		super(x, y, width, height);
		this.points = 0;
		this.score = 0;
		this.id = id;
		this.random = new Random();
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}
	}
	
	@Override
	public void update() {
		super.update();
		if (y + height >= Main.getWindowHeight()) {
			y = Main.getWindowHeight() - height;
		} else if (y <= 0) {
			y = 0;
		}
		Collider.checkShipBallCollision(this);
	}

	public int getPoints() {
		return points;
	}

	public void increasePoints() {
		points++;
	}
	
	public int getScore() {
		return score;
	}

	public void increaseScore(int score) {
		this.score += score;
	}
	
	public void reduceHeight() {
		height -= 10;
		if (height < 50) {
			height = 50;
		}
	}
	
	public int getId() {
		return id;
	}
}
