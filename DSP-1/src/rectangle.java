public class rectangle {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	
	rectangle(String nm, int xvar, int yvar, int w, int h){
		name = nm;
		x = xvar;
		y = yvar;
		width = w;
		height = h;
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
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
