package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;


public class Ship extends BasicRectangle {
	
	private int points, score, id;
	
	public Ship(int x, int y, int width, int height, int id) {
		super(x, y, width, height);
		this.points = 0;
		this.score = 0;
		this.id = id;
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < height; i++) {
			Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(Main.getRandom().nextInt(255), Main.getRandom().nextInt(255),Main.getRandom().nextInt(255)));
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
	
	@Override
	public void checkCollision() {
		/*Ball ball =  Main.getBall();
		if ((ball.getSpeedX() > 0 && ball.getCenterX() + ball.getRadius() >= getX() - 10)
				|| ball.getSpeedX() < 0 && ball.getCenterX() - ball.getRadius() <= x + width + 10) {
			if (rect.intersects(ball.getBounds())) {
				int newSpeedY = (5 * (ball.getCenterY() - y - (height / 2)) / (height / 2)) + ball.getSpeedY();
				ball.setSpeedX(ball.getSpeedX() * -1);
				ball.setSpeedY(newSpeedY);
			}
		}*/
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
