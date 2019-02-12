/**
 *This is the class for the rectangles to be inserted into the dictionary.
 *This class will also do operations on rectangles too.
 * 
 * @author Josh Rehm
 * 
 */
public class Rectangle
{
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private int xEnd;
    private int yEnd;
/**
 * Creates a new rectangle based on the parameters given.
 * 
 * @param nm name of rectangle
 * @param xVar x coordinate of rectangle
 * @param yVar y coordinate of rectangle
 * @param w width of rectangle
 * @param h height of rectangle
 */
    Rectangle(String nm, int xVar, int yVar, int w, int h)
    {
        name = nm;
        x = xVar;
        y = yVar;
        width = w;
        height = h;
        xEnd = xVar + w;
        yEnd = yVar + h;
    }
/**
 * Puts the rectangle into the given output format as a string.
 * @return the rectangle as a string in correct format.
 */
    public String toString()
    {
        return "(" + name + ", " + x + ", " + y + ", " + width + ", " + height
                + ")";
    }

    /**
     * This is a method to help with doing region search. It compares the rectangle coordinates and size 
     * with the input coordinates and size to see if the rectangle is within the given coordinates.
     * 
     * @param xVar starting x coordinate of region.
     * @param yVar starting y coordinate of region.
     * @param w width of region.
     * @param h height of region.
     * @return is the rectangle in the region given.
     */
    public boolean isContained(int xVar, int yVar, int w, int h)
    {
        // Checks to see if x is within bounds
        if ((x >= xVar && x <= (xVar + w))
                || (xEnd <= xVar && xEnd >= (xVar + w)))
        {
            // Checks to see if y is within bounds
            if ((y >= yVar && y <= (yVar + h))
                    || (yEnd <= yVar && yEnd >= (yVar + h)))
            {
                return true;
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    /**
     * Checks to see if two rectangles are intersecting for checking intersections. Compares
     * the left rectangle with the rectangle as the input parameter.
     * 
     * @param r the rectangle to compare with the left rectangle
     * @return if the rectangles intersect
     */
    // Used for intersections
    public boolean intersects(Rectangle r)
    {
        // Checks to see if x boundaries are crossed
        if ((x >= r.getXVal() && x < r.getXEnd() && xEnd > r.getXEnd())
                || (x < r.getXVal() && xEnd > r.getXVal()
                        && xEnd <= r.getXEnd()))
        {
            // Checks to see if it is within y boundaries
            if ((y >= r.getYVal() && y <= r.getYEnd() && yEnd >= r.getYEnd())
                    || (y <= r.getYVal() && yEnd >= r.getYVal()
                            && yEnd <= r.getYEnd()))
            {
                return true;
            } else
            {
                return false;
            }
        }
      else
        {
            return false;
        }
    }

    /**
     * Checks if the rectangles coordinates are exactly the same as the input parameters.
     * Used for removing by coordinate.
     * 
     * @param xVar x value to compare the rectangle x value to 
     * @param yVar y value to compare the rectangle y value to
     * @param w width value to compare the rectangle width value to
     * @param h height value to compare the rectangle height  to.
     * @return if the rectangle has the same input coordinates as the inputs
     */
    // Used for remove
    public boolean isExact(int xVar, int yVar, int w, int h)
    {
        if (x != xVar || y != yVar || width != w || height != h)
        {
            return false;
        } else
        {
            return true;
        }
    }
    /**
     * gets the name of the rectangle
     * @return name of rectangle
     */
    public String getName()
    {
        return name;
    }
    /**
     * gets the x value of the rectangle
     * @return x value of rectangle
     */
    public int getXVal()
    {
        return x;
    }

    /**
     * gets the y value of the rectangle
     * @return y value of rectangle
     */
    public int getYVal()
    {
        return y;
    }
    
    /**
     * gets the x end of the rectangle, this is the x value + the width
     * @return x coordinate of end of rectangle
     */
    public int getXEnd()
    {
        return xEnd;
    }
    
    /**
     * gets the y end of the rectangle, this is the y value + the height
     * @return y coordinate of the end of the rectangle
     */
    public int getYEnd()
    {
        return yEnd;
    }
    
    /**
     * gets the width of the rectangle
     * @return width of rectangle
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * gets the height of the rectangle
     * @return height of rectangle
     */
    public int getHeight()
    {
        return height;
    }

}
