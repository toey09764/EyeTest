package HW1_5_VER1;


public class Dot {
	private int x;
	private int y;
	private int size;
	private boolean visible;

	public Dot(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		visible = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	public boolean isVisible() {
		if(visible==true)
		{
			return true;
		}
		else{
			return false;
		}
	}

	public void setVisible(boolean visible) {
		this.visible=visible;
	}

}
