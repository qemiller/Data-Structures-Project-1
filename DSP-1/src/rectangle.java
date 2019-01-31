public class rectangle {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private int xEnd;
	private int yEnd;
	
	
	rectangle(String nm, int xVar, int yVar, int w, int h){
		name = nm;
		x = xVar;
		y = yVar;
		width = w;
		height = h;
		xEnd = xVar + w;
		yEnd = yVar + h;
	}
	
	public String toString() {
		return "(" + name + ", " + x + ", " + y + ", " + width + ", " + height + ")";
	}
	
	//Used for regionsearch
	public boolean isContained(int xVar, int yVar, int w, int h) {
		if((x >= xVar && x <= (xVar + w)) || (xEnd <= xVar && xEnd >= (xVar + w))) {
			//Intersection with x
			if((y >= yVar && y <= (yVar + h)) || (yEnd <= yVar && yEnd >= (yVar + h))) {
				//Intersection with y
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	//Used for remove
	public boolean isExact(int xVar, int yVar, int w, int h) {
		if(x != xVar || y != yVar || width != w || height != h) {
			return false;
		}
		else return true;
	}
	
	public String getName() {
		return name;
	}
	
	public int getXVal() {
		return x;
	}
	
	public int getYVal() {
		return y;
	}

	public int getXEnd() {
		return xEnd;
	}
	
	public int getYEnd() {
		return yEnd;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
