package game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Main window of the game
 * @author Allan Leon
 */
public class Main extends JFrame implements KeyListener, ActionListener {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	private BufferedImage doubleBuffer;
	private static Ball ball;
	private Ship player1, player2;
	private LevelGenerator level;
	private boolean isRunning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		initialize();
	}
	
	/**
	 * Initialize and set up the basic components of the frame.
	 */
	private void initialize() {
		setTitle("Game");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setFocusable(true);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		doubleBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	}
	
	public void start() {
		ball = new Ball(60, HEIGHT / 2, 10);
		player1 = new Ship(10, HEIGHT / 2, 15, 100);
		player2 = new Ship(WIDTH - 10 - 15, HEIGHT / 2, 15, 100);
		level = new LevelGenerator();
		isRunning = true;
		//run();
		Timer timer = new Timer(1000/60, this);
		timer.start();
		
	}	

	public void update() {
		ball.update();
		player1.update();
		player2.update();
	}

	public void run() {
		if(isRunning) {
			long time = System.currentTimeMillis();
            
            update();
            paint();
            /*time = (1000 / 30) - (System.currentTimeMillis() - time);
           
            if (time > 0)
            {
                    try
                    {
                            Thread.sleep(time);
                    }
                    catch(Exception e){}
            }*/
		}
	}
	
	private void paint() {
		Graphics dbg = doubleBuffer.getGraphics();
		dbg.setColor(Color.BLACK);
		dbg.fillRect(0, 0, WIDTH, HEIGHT);
		ball.draw(dbg);
		player1.draw(dbg);
		player2.draw(dbg);
		level.draw(dbg,2);
		getGraphics().drawImage(doubleBuffer, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawImage(doubleBuffer, 0, 0, this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_UP:
			player2.setSpeedY(8);
			break;
		case KeyEvent.VK_DOWN:
			player2.setSpeedY(-8);
			break;
		case KeyEvent.VK_W:
			player1.setSpeedY(8);
			break;
		case KeyEvent.VK_S:
			player1.setSpeedY(-8);
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_UP:
			player2.setSpeedY(0);
			break;
		case KeyEvent.VK_DOWN:
			player2.setSpeedY(0);
			break;
		case KeyEvent.VK_W:
			player1.setSpeedY(0);
			break;
		case KeyEvent.VK_S:
			player1.setSpeedY(0);
			break;
		}
	}

	/**q
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
	
	public static int getWindowWidth() {
		return WIDTH;
	}
	
	public static int getWindowHeight() {
		return HEIGHT;
	}
	
	public static Ball getBall() {
		return ball;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		run();
	}
}
