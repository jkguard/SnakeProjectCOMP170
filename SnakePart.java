
public class SnakePart {

	int x;
	int y;
	int directionX;
	int directionY;
	Snake head;
	SnakePart next = null;
	
	public SnakePart(int X, int Y, int dx, int dy, Snake h) {
		x = X;
		y = Y;
		directionX = dx;
		directionY = dy;
		head = h;
	}
}
