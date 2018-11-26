import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener {
Timer t = new Timer(5, this);
int x = 280, y = 50, velx = 0, vely = 0;
boolean play = true;

public Snake() {
	t.start();
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
}
// Head of the snake
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.RED);
	g.fillOval(x,y,15,15);
}


//Controls collision between snake and borders
public void actionPerformed(ActionEvent e) {
if(x < 0)
{
	velx=0;
	x = 0;
}

if(x > 584)
{
	velx=0;
	x = 584;
}

if(y < 0)
{
	vely=0;
	y = 0;
}

if(y > 362)
{
	vely=0;
	y = 362;
}


x += velx;
y += vely;
repaint();
}
//Action listener/ movement with keys.
public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_DOWN){
		vely = 1;
		velx = 0;
	}
	if (key == KeyEvent.VK_UP){
		vely = -1;
		velx = 0;
	}
	if (key == KeyEvent.VK_LEFT){
		vely = 0;
		velx = -1;
	}
	if (key == KeyEvent.VK_RIGHT){
		vely = 0;
		velx = 1;
		
	}
}

public void keyTyped(KeyEvent e) {
	
}
public void keyReleased(KeyEvent e) {
int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_DOWN){
		vely = 1;
		velx = 0;
	}
	if (key == KeyEvent.VK_UP){
		vely = -1;
		velx = 0;
	}
	if (key == KeyEvent.VK_LEFT){
		vely = 0;
		velx = -1;
	}
	if (key == KeyEvent.VK_RIGHT){
		vely = 0;
		velx = 1;
}


}
} 

	 


