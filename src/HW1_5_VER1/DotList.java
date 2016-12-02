package HW1_5_VER1;

import java.util.ArrayList;

 

public class DotList {
	private int width;
	private int height;
	private int current = 0;
	private boolean allClear;
	private ArrayList<Dot> dots;

	public DotList(int width, int height, int dotSize, int distance) {
		dots = new ArrayList<>();
		this.width = width;
		this.height = height;
		int x = 0;
		int y = 0;
		int fade = 0;
		for (int i = 0; i < (width * 2 + height * 2) / distance; i++) {
			if (x < width && y < height&& fade == 0) {
				dots.add(new Dot(x, y, dotSize));
				x += distance;
			}
			if (x == width && y < height&& fade == 0) {
				dots.add(new Dot(x, y, dotSize));
				y += distance;
			}
			if (x == width && y == height&& fade == 0) {
				dots.add(new Dot(x, y, dotSize));
				x -= distance;
				fade = 1;
			}
			if (x < width && y == height && fade == 1) {
				dots.add(new Dot(x, y, dotSize));
				x -= distance;
			}
			if (x == 0 && y == height && fade == 1) {
				dots.add(new Dot(x, y, dotSize));
				y -= distance;
				fade = 2;
			}
			if (x == 0 && y < height && fade == 2) {
				dots.add(new Dot(x, y, dotSize));
				y -= distance;
			}
			if(x==0&&y==0&&fade==2){
				break;
			}

		}
	}

	public void genDots(int dotSize, int distance) {
		int x = 0;
		int y = 0;
		int fade = 0;
		for (int i = 0; i < dots.size(); i++) {
		dots.get(i).setVisible(true);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Dot> getDots() {
		//current++;
		return dots;
	}

	public Dot getCurrent() {
		return dots.get(current);
	}

	public void clearCurrent() {
		this.current = 0;
	}

	public boolean isAllClear() {
	for (int i = 0; i < dots.size(); i++) {
		if (dots.get(i).isVisible() == true) 
			return false;
			
	}
	return true;
	}

	public void resetDots() {
		dots.clear();
	}
}
