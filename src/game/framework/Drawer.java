package game.framework;

import java.awt.Color;
import java.awt.Graphics;

public class Drawer {

	public void drawCircle(Graphics g, int centerX, int centerY, int radius, Color color) {
		int x, y, d, dE, dSE;
		x = 0;
		y = radius;
		d = 1 - radius;
		dE = 3;
		dSE = -2*radius+5;
		simetry(g, x, y, centerX, centerY, color);
		while (y > x) {
			if (d < 0) {
				d += dE;
				dE += 2;
				dSE += 2;
				x += 1;
			} else {
				d += dSE;
				dE += 2;
				dSE += 4;
				x += 1;
				y += -1;
			}
			simetry(g, x, y, centerX, centerY, color);
		}
	}
	
	private void simetry(Graphics g, int x, int y, int centerX, int centerY, Color color) {
		putPixel(g, x + centerX, y + centerY, color);
		putPixel(g, y + centerX, x + centerY, color);
		putPixel(g, y + centerX, -x + centerY, color);
		putPixel(g, x + centerX, -y + centerY, color);
		putPixel(g, -x + centerX, -y + centerY, color);
		putPixel(g, -y + centerX, -x + centerY, color);
		putPixel(g, -y + centerX, x + centerY, color);
		putPixel(g, -x + centerX, y + centerY, color);
	}
	
	private void putPixel(Graphics g, int x, int y, Color color) {
		g.setColor(color);
		g.drawLine(x, y, x, y);
	}
}
