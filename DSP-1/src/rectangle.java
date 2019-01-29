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
