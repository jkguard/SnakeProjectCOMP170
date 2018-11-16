import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard {
	private JFrame frame;
	
	public GameBoard() {
	frame = new JFrame("Game Board");
	frame.setLocation(0, 500);
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	frame.setVisible(true);
	}
}
