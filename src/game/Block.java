package game;

import game.framework.Drawer;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean visible;
	private int value;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.resistance = resistance;
		this.value = resistance * 50;
		this.visible = true;
	}
	
	@Override
	public void update() {
		super.update();
		//checkCollision();
		Collider.checkBlockBallCollision(this);
	}
	
	public void draw(Graphics g) {
				
		for (int i=0; i < height; i++) {
			switch (resistance) {
			case 1:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5*i, 0));
				break;
			case 2:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 255 - 5 * i, 255 - 5*i));
				break;
			case 3:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(0, 0, 255 - 5*i));
				break;
			case 4:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5 * i, 0, 255 - 5*i));
				break;
			case 5:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5*i, 0, 0));
				break;
			default:
				Drawer.drawLine(g, x, y + i, x + width, y + i, new Color(255 - 5*i, 255 - 5*i, 0, 50));
				break;
			}
		}
		
		Drawer.drawLine(g, x, y, x + width, y, Color.white);
		Drawer.drawLine(g, x, y + height, x + width, y + height, Color.white);
		Drawer.drawLine(g, x, y, x, y + height, Color.white);
		Drawer.drawLine(g, x + width, y, x + width, y + height, Color.white);
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	@Override
	public void checkCollision() {
		super.checkCollision();
		if (ballIntersects()) {
			resistance--;
			if (resistance == 0) {
				visible = false;
				//setValue(this.value);
			}
		}
		
		/*
		if (rect.intersects(Main.getBall().getBounds())) {
			bounceBall();
			
			resistance--;
			if (resistance <= 0) {
				visible = false;
				//setValue(this.value);
			}
		}*/
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void reduceResistance() {
		resistance--;
		if (resistance == 0) {
			visible = false;
		}
	}
	
	/*
	public void bounceBall() {
		Ball ball = Main.getBall();
		int rSpeed = Main.getRandom().nextInt(6) - 3;
		if ((ball.getSpeedX() > 0 && ball.getCenterX() <= x) ||
				(ball.getSpeedX() < 0 && ball.getCenterX() >= x + width)) {
			ball.setSpeedX(ball.getSpeedX() * -1 + rSpeed);
			ball.setSpeedY(ball.getSpeedY() + rSpeed);
			
		}
		if ((ball.getSpeedY() > 0 && ball.getCenterY() <= y) ||
				(ball.getSpeedY() < 0 && ball.getCenterY() >= y + height)) {
			ball.setSpeedX(ball.getSpeedY() * -1 + rSpeed);
			ball.setSpeedX(ball.getSpeedX() + rSpeed);
		}
	}*/
}
