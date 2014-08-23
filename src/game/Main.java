package game;

import game.data.Data;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Main window of the game
 */
public class Main extends JFrame implements KeyListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum GameState {
		Ready, Running, P1Win, P2Win, Starting
	}
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	private static Ball ball;
	private static Ship player1, player2;
	private static GameState state;
	private static List<Block> blocks;
	
	private BufferedImage doubleBuffer;
	private Image logo;
	private Insets insets;
	private int timeElapsed, level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main();
					//game.start();
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
		setVisible(true);
		insets = getInsets();
		setSize(insets.left + WIDTH + insets.right, insets.top + HEIGHT + insets.bottom);
		
		setResizable(false);
		setFocusable(true);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		timeElapsed = 0;
		level = Data.STARTING_LEVEL;
		doubleBuffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		blocks = new ArrayList<Block>();
		state = GameState.Starting;
		drawLogo();
	}
	
	private void drawLogo() {
        try {
			logo = ImageIO.read(Main.class.getResourceAsStream("SUPER-logo.jpg"));
			getGraphics().drawImage(logo, insets.left, insets.top, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		logo.flush();
		ball = new Ball(Data.SHIP_STARTING_X + Data.SHIP_WIDTH, HEIGHT / 2, Data.BALL_RADIUS);
		player1 = new Ship(Data.SHIP_STARTING_X, HEIGHT / 2, Data.SHIP_WIDTH, Data.SHIP_HEIGHT, 1);
		player2 = new Ship(WIDTH - Data.SHIP_STARTING_X - Data.SHIP_WIDTH, HEIGHT / 2, Data.SHIP_WIDTH, Data.SHIP_HEIGHT, 2);
		LevelGenerator.generateLevel(level);
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
				int blockValue = blocks.get(i).getValue();
				switch (ball.getLastPlayer()) {
				case 1:
					player1.increaseScore(blockValue);
					break;
				case 2:
					player2.increaseScore(blockValue);
					break;
				}
				blocks.remove(i);
			}
		}
		timeElapsed++;
		checkTime();
	}

	public void run() {
		if(state == GameState.Running) {
            update();
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
			dbg.setFont(new Font("EcuyerDAX", Font.BOLD, 24));
			dbg.drawString("Press ENTER to play", WIDTH / 2 - 130, HEIGHT / 2);
		} else if (state == GameState.P1Win) {
			dbg.setColor(Color.WHITE);
			dbg.setFont(new Font("EcuyerDAX", Font.BOLD, 24));
			dbg.drawString("Player 1 WON!", WIDTH / 2 - 100, HEIGHT / 2);
		} else if (state == GameState.P2Win) {
			dbg.setColor(Color.WHITE);
			dbg.setFont(new Font("EcuyerDAX", Font.BOLD, 24));
			dbg.drawString("Player 2 WON!", WIDTH / 2 - 100, HEIGHT / 2);
		}
		drawScores(dbg);
		getGraphics().drawImage(doubleBuffer, insets.left, insets.top, this);
	}
	
	private void drawScores(Graphics dbg) {
		String points = player1.getPoints() + " : " + player2.getPoints();
		dbg.setFont(new Font("EcuyerDAX", Font.BOLD, 24));
		dbg.setColor(new Color(255, 128, 0));
		dbg.drawString(points, WIDTH / 2 - dbg.getFontMetrics().stringWidth(points) / 2, 30);
		dbg.setColor(new Color(0, 153, 76));
		dbg.drawString(player1.getScore() + "", 10, 30);
		dbg.drawString(player2.getScore() + "", WIDTH - 10 - dbg.getFontMetrics().stringWidth("" + player2.getScore()), 30);
	}
	
	private void checkTime() {
		if (timeElapsed % 1000 == 0) {
			player1.reduceHeight();
			player2.reduceHeight();
		}
	}

	@Override
	public void update(Graphics g) {}

	
	@Override
	public void paint(Graphics g) {}
	
	public void reset() {
		doubleBuffer.getGraphics().clearRect(0, 0, WIDTH, HEIGHT);
		blocks.clear();
		player1.setHeight(Data.SHIP_HEIGHT);
		player2.setHeight(Data.SHIP_HEIGHT);
		player1.setY(HEIGHT / 2 - player1.getHeight() / 2);
		player2.setY(HEIGHT / 2 - player2.getHeight() / 2);
		ball.setSpeedY(0);
		ball.setCenterY(HEIGHT / 2);
		if (state == GameState.P1Win) {
			ball.setCenterX(player1.getX() + player1.getWidth() + ball.getRadius());
			ball.setSpeedX(Data.BALL_SPEED_X);
			ball.setLastPlayer(1);
		} else if (state == GameState.P2Win) {
			ball.setCenterX(player2.getX() - ball.getRadius());
			ball.setSpeedX(-Data.BALL_SPEED_X);
			ball.setLastPlayer(2);
		}
		timeElapsed = 0;
		level++;
		LevelGenerator.generateLevel(level);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_UP:
			player2.setSpeedY(Data.SHIP_SPEED_Y);
			break;
		case KeyEvent.VK_DOWN:
			player2.setSpeedY(-Data.SHIP_SPEED_Y);
			break;
		case KeyEvent.VK_W:
			player1.setSpeedY(Data.SHIP_SPEED_Y);
			break;
		case KeyEvent.VK_S:
			player1.setSpeedY(-Data.SHIP_SPEED_Y);
			break;
		case KeyEvent.VK_ENTER:
			if (state == GameState.Ready) {
				state = GameState.Running;
			} else if (state == GameState.Starting) {
				start();
			} else if (state != GameState.Running) {
				reset();
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

	@Override
	public void keyTyped(KeyEvent ke) {	}
	
	public static int getWindowWidth() {
		return WIDTH;
	}
	
	public static int getWindowHeight() {
		return HEIGHT;
	}
	
	public static Ball getBall() {
		return ball;
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
