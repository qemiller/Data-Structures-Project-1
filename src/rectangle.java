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
		//Checks to see if x is within bounds
		if((x >= xVar && x <= (xVar + w)) || (xEnd <= xVar && xEnd >= (xVar + w))) {
			//Checks to see if y is within bounds
			if((y >= yVar && y <= (yVar + h)) || (yEnd <= yVar && yEnd >= (yVar + h))) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	//Used for intersections
	public boolean intersects(rectangle r) {
		//Checks to see if x boundaries are crossed
		if((x >= r.getXVal() && x < r.getXEnd() && xEnd > r.getXEnd()) || 
				(x < r.getXVal() && xEnd > r.getXVal() && xEnd <= r.getXEnd())) {
			//Checks to see if it is within y boundaries
			if((y >= r.getYVal() && y <= r.getYEnd() && yEnd >= r.getYEnd()) ||
					(y <= r.getYVal() && yEnd >= r.getYVal() && yEnd <= r.getYEnd())) {
				return true;
			}
			else return false;
		}
		//Checks to see if y boundaries are crossed
		else if((y >= r.getYVal() && y < r.getYEnd() && yEnd > r.getYEnd()) ||
				(y < r.getYVal() && yEnd > r.getYVal() && yEnd <= r.getYEnd())) {
			//Checks to see if it is within x boundaries
			if((x >= r.getXVal() && x <= r.getXEnd() && xEnd >= r.getXEnd()) || 
					(x <= r.getXVal() && xEnd >= r.getXVal() && xEnd <= r.getXEnd())) {
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
