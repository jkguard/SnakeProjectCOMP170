import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BoardGraphics {

	private int size;
	private Snake snake;
	private JLabel[][] board;

	public BoardGraphics() {
		//sets size of the board to be 50 spaces
		this.size = 50;
		snake = new Snake(0, 0, 1, 0); //snake starts at 0,0 moving right
		
		//sets up the frame and each of the 50 spaces that the snake can be in
		JFrame frame = new JFrame("Snake");
		frame.setLocation(0,  0);
		frame.setSize(10*50, 10*50);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//listen to keys typed
		frame.setFocusable(true);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {			}

			@Override
			public void keyReleased(KeyEvent e) {			}

			@Override
			public void keyTyped(KeyEvent e) {
				char typedChar = e.getKeyChar();
				if (typedChar == 'a') {
					snake.directionX = -1;
					snake.directionY = 0;
				}
				if (typedChar == 'd') {
					snake.directionX = 1;
					snake.directionY = 0;
				}
				if (typedChar == 'w') {
					snake.directionX = 0;
					snake.directionY = -1;
				}
				if (typedChar == 's') {
					snake.directionX = 0;
					snake.directionY = 1;
				}
			}
		});
		//setup board
		board = new JLabel[size][size];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new JLabel(" ");
				board[i][j].setSize(10, 10);
				board[i][j].setLocation(i*10, j*10);
				board[i][j].setBackground(Color.white);
				board[i][j].setOpaque(true);
				frame.add(board[i][j]);
			}
		}

		//sets up the "Snake" on the board
		board[snake.x][snake.y].setBackground(Color.green);
		board[10][10].setBackground(Color.red);
		frame.validate();
		frame.repaint();

		//infinite loop that moves the snake
		move();
	}

	public void move() {
		while (true) {
			try {
				Thread.sleep(1000);//sleep for that many milliseconds
				int x = snake.x;
				int y = snake.y;
				int directionX = snake.directionX;
				int directionY = snake.directionY;
				int newX = x + directionX;
				int newY = y + directionY;
				//if out of bounds, show a message
				if (newX >= size || newX < 0 || newY >= size || newY < 0) {
					JOptionPane.showMessageDialog(null, "Game Over", "Snake", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				//update snake's new position
				snake.x = newX;
				snake.y = newY;
				//change color of the board to display new position of snake
				board[x][y].setBackground(Color.white);
				board[newX][newY].setBackground(Color.green);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
