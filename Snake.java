
public class Snake {
	int x;
	int y;
	int directionX;
	int directionY;
	SnakePart next = null;
	
	public Snake(int X, int Y, int dX, int dY) {
		x = X;
		y = Y;
		directionX = dX;
		directionY = dY;
	}
}
