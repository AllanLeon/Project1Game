package game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Main window of the game
 * @author Allan Leon
 */
public class Main extends JFrame implements KeyListener, ActionListener {
	
	enum GameState {
		Ready, Running, P1Win, P2Win
	}
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	private BufferedImage doubleBuffer;
	private static Ball ball;
	private static Ship player1, player2;
	private static GameState state;
	private static List<Block> blocks;
	private static Random random;

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
		random = new Random();
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
		blocks = new ArrayList<Block>();
	}
	
	public void start() {
		ball = new Ball(60, HEIGHT / 2, 10);
		player1 = new Ship(10, HEIGHT / 2, 15, 100);
		player2 = new Ship(WIDTH - 10 - 15, HEIGHT / 2, 15, 100);
		LevelGenerator.generateLevel(3);
		state = GameState.Ready;
		Timer timer = new Timer(1000/60, this);
		timer.start();
		
	}	

	public void update() {
		ball.update();
		player1.update();
		player2.update();
		for(int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).isVisible()) {
				blocks.get(i).update();
			} else {
				blocks.remove(i);
			}
		}
	}

	public void run() {
		if(state == GameState.Running) {
            update();
		} else if (state == GameState.Ready) {
		} else {
			reset();
		}
		paint();
	}
	
	private void paint() {
		Graphics dbg = doubleBuffer.getGraphics();
		dbg.setColor(Color.BLACK);
		dbg.fillRect(0, 0, WIDTH, HEIGHT);
		if (state == GameState.Running) {
			for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).draw(dbg);
			}
			ball.draw(dbg);
			player1.draw(dbg);
			player2.draw(dbg);
		} else if (state == GameState.Ready) {
			dbg.setColor(Color.WHITE);
			dbg.drawString("Press ENTER to play", WIDTH / 2 - 50, HEIGHT / 2);
		} else if (state == GameState.P1Win) {
			dbg.setColor(Color.WHITE);
			dbg.drawString("Player 1 WON!", WIDTH / 2 - 50, HEIGHT / 2);
		} else if (state == GameState.P2Win) {
			dbg.setColor(Color.WHITE);
			dbg.drawString("Player 2 WON!", WIDTH / 2 - 50, HEIGHT / 2);
		}
		dbg.setColor(Color.WHITE);
		dbg.drawString(player1.getScore() + " : " + player2.getScore(), WIDTH / 2 - 50, HEIGHT / 8);
		getGraphics().drawImage(doubleBuffer, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
	}

	
	@Override
	public void paint(Graphics g) {
		g.drawImage(doubleBuffer, 0, 0, this);
	}
	
	public void reset() {
		doubleBuffer.getGraphics().clearRect(0, 0, WIDTH, HEIGHT);
		player1.setY(HEIGHT / 2 - player1.getHeight() / 2);
		player2.setY(HEIGHT / 2 - player2.getHeight() / 2);
		blocks.clear();
		ball.setSpeedY(0);
		ball.setCenterY(HEIGHT / 2);
		if (state == GameState.P1Win) {
			ball.setCenterX(player1.getX() + player1.getWidth() + ball.getRadius());
		} else if (state == GameState.P2Win) {
			ball.setCenterX(player2.getX() - ball.getRadius());
		}
		LevelGenerator.generateLevel(3);
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
		case KeyEvent.VK_ENTER:
			if (state == GameState.Ready) {
				state = GameState.Running;
			} else if (state != GameState.Running) {
				state = GameState.Ready;
			}
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
	
	public static Random getRandom() {
		return random;
	}
	
	public static List<Block> getBlocks() {
		return blocks;
	}
	
	public static void setState(GameState state) {
		Main.state = state;
	}
	
	public static Ship getPlayer1() {
		return player1;
	}
	
	public static Ship getPlayer2() {
		return player2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		run();
	}
}
