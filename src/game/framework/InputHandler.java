package game.framework;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	private boolean[] keys;

	public InputHandler(Component c)
	{
		//c.addKeyListener(this);
		keys = new boolean[256];
 	}
    
	/**
	 * Checks whether a specific key is down
	 * @param keyCode The key to check
	 * @return Whether the key is pressed or not
	 */
 	public boolean isKeyDown(int keyCode)
 	{
 		if (keyCode > 0 && keyCode < 256)
 		{
 			return keys[keyCode];
 		}
 		
 		return false;
	}
    
 	/**
 	 * Called when a key is pressed while the component is focused
 	 * @param e KeyEvent sent by the component
 	 */
 	public void keyPressed(KeyEvent e)
 	{	
 		if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
 		{
 			keys[e.getKeyCode()] = true;
 		}
     }	
 	
 	/**
 	 * Called when a key is released while the component is focused
 	 * @param e KeyEvent sent by the component
 	 */
 	public void keyReleased(KeyEvent e)
 	{
 		if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
 		{
 			keys[e.getKeyCode()] = false;
 		}
 	}	
 	
 	/**
 	 * Not used
 	 */
 	public void keyTyped(KeyEvent e){} 
	/**
	 * {@inheritDoc}
	 */
	/*
	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_UP:
			Main.getPlayer2().setSpeedY(2);
			break;
		case KeyEvent.VK_DOWN:
			Main.getPlayer2().setSpeedY(-2);
			break;
		case KeyEvent.VK_W:
			Main.getPlayer1().setSpeedY(2);
			break;
		case KeyEvent.VK_S:
			Main.getPlayer1().setSpeedY(-2);
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_UP:
			Main.getPlayer2().setSpeedY(0);
			break;
		case KeyEvent.VK_DOWN:
			Main.getPlayer2().setSpeedY(0);
			break;
		case KeyEvent.VK_W:
			Main.getPlayer1().setSpeedY(0);
			break;
		case KeyEvent.VK_S:
			Main.getPlayer1().setSpeedY(0);
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 *//*
	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}*/
}
