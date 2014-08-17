package game;

public class Block extends BasicRectangle {
	
	private int resistance;
	private boolean invincible;

	public Block(int x, int y, int width, int height, int resistance) {
		super(x, y, width, height);
		this.resistance = resistance;
		if (resistance > 5) {
			invincible = true;
		} else {
			invincible = false;
		}
	}
	
	public int getResistance() {
		return resistance;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}
}
