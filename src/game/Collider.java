package game;

public class Collider {

	public static void checkShipBallCollision(Ship ship) {
		if (ship.ballIntersects()) {
			Ball ball = Main.getBall();
			if (ball.getCenterX() <= ship.getX() || ball.getCenterX() >= ship.getX() + ship.getWidth()) {
				ball.setSpeedX(ball.getSpeedX() * -1);
				int newSpeedY = (5 * (ball.getCenterY() - ship.getY() - (ship.getHeight() / 2)) / (ship.getHeight() / 2)) + ball.getSpeedY();
				ball.setSpeedY(newSpeedY);
			}
			if ((ball.getCenterY() <= ship.getY() && ball.getSpeedY() > 0) || (ball.getCenterY() >= ship.getY() + ship.getHeight() && ball.getSpeedY() < 0)) {
				ball.setSpeedY(ball.getSpeedY() * -1);
			}
		}
	}
	
	public static void checkBlockBallCollision(Block block) {
		if (block.ballIntersects()) {
			block.reduceResistance();
			Ball ball = Main.getBall();
			if ((ball.getCenterX() <= block.getX() && ball.getSpeedX() > 0) || (ball.getCenterX() >= block.getX() + block.getWidth() && ball.getSpeedX() < 0)) {
				ball.setSpeedX(ball.getSpeedX() * -1);
			}
			if ((ball.getCenterY() <= block.getY() && ball.getSpeedY() > 0) || (ball.getCenterY() >= block.getY() + block.getHeight() && ball.getSpeedY() < 0)) {
				ball.setSpeedY(ball.getSpeedY() * -1);
			}
			ball.setColliding(false);
		}
	}
}
