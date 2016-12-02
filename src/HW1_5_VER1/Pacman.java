package HW1_5_VER1;

public class Pacman {
	private int diameter;
	private int x;
	private int y;
	private int eyeX;
	private int eyeY;
	private int startAngle;
	private int endAngle;
	private int direction;
	private int eyeSize;
	public final int LEFT = 0;
	public final int RIGHT = 1;
	public final int UP = 2;
	public final int DOWN = 3;
	private int MAX_ANGLE = 30;
	private int CHANGE_ANGLE;

	public Pacman() {
		this.x = 0;
		this.y = 0;
		this.eyeX = 1;
		this.eyeY = 1;
		this.startAngle = 1;
		this.direction = 1;
		this.eyeSize = 1;
	}

	public Pacman(int diameter, int x, int y, int direction) {
		this.diameter = diameter;
		this.direction = direction;
		this.eyeSize = 5;
		this.x = x;
		this.y = y;

		{
			if (direction == LEFT) {
				this.startAngle = -150;
				this.endAngle=300;
				this.eyeX=x+diameter/5+diameter/5;
				this.eyeY=y+diameter/3;
			} else if (direction == RIGHT) {
				this.startAngle = 30;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/5;
				this.eyeY=y+diameter/6+diameter/6;
			} else if (direction == UP) {
				this.startAngle = 120;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/4;
				this.eyeY=y+diameter/4+diameter/5;
			} else if (direction == DOWN) {
				this.startAngle = -60;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/3;
				this.eyeY=y+diameter/4+diameter/3;
			}
		}
		
		
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getEyeX() {
		return eyeX;
	}

	public int getEyeY() {
		return eyeY;
	}

	public int getEyeSize() {
		return eyeSize;
	}

	public int getStartAngle() {
		return startAngle;
	}

	public int getEndAngle() {
		return endAngle;
	}

	public void move() {

	}

	public void move(int range) {

		if (direction == LEFT) {
			this.x = x-range;
			this.eyeX=eyeX-range;
		} else if (direction == RIGHT) {
			this.x = x+range;
			this.eyeX=eyeX+range;
		} else if (direction == UP) {
			this.y = y-range;
			this.eyeY=eyeY-range;
		} else if (direction == DOWN) {
			this.y = y+range;
			this.eyeY=eyeY+range;
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
		{
			if (direction == LEFT) {
				this.startAngle = -150;
				this.endAngle=300;
				this.eyeX=x+diameter/5+diameter/5;
				this.eyeY=y+diameter/3;
			} else if (direction == RIGHT) {
				this.startAngle = 30;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/5;
				this.eyeY=y+diameter/6+diameter/6;
			} else if (direction == UP) {
				this.startAngle = 120;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/4;
				this.eyeY=y+diameter/4+diameter/5;
			} else if (direction == DOWN) {
				this.startAngle = -60;
				this.endAngle=300;
				this.eyeX=x+diameter/3+diameter/3;
				this.eyeY=y+diameter/4+diameter/3;
			}
		}
		
	}

}
