import junit.framework.TestCase;

/**
 * 
 * @author Quinton Miller qemiller
 * @author Josh Rehm jrehm135
 * 
 *@version 2-12-2019
 */
public class RectangleTest extends TestCase
{
    private Rectangle test;

    /**
     * Set up RectangleTest class
     */
    public void setUp()
    {
        test = new Rectangle("Yogi", 5, 7, 30, 40);
    }

    /**
     * test the geters for rectangle
     */
    public void testGeters()
    {
        assertTrue("Yogi".equals(test.getName()));
        assertEquals(5, test.getXVal());
        assertEquals(7, test.getYVal());
        assertEquals(30, test.getWidth());
        assertEquals(40, test.getHeight());
    }

    /**
     * test the toString method
     */
    public void testToString()
    {
        assertTrue("(Yogi, 5, 7, 30, 40)".equals(test.toString()));
    }

    /**
     * test intersection method
     */
    public void testIntersection()
    {
        Rectangle intersectTrueRect = new Rectangle(
                "intersectTest", 1, 2, 10, 10);
        assertTrue(test.intersects(intersectTrueRect));

        Rectangle intersectFalseRect1 = new Rectangle("intersectTest", 0, 0,
                500, 500);
        assertTrue(test.intersects(intersectFalseRect1));
        
        Rectangle intersectFalseRect2 = new Rectangle("intersectTest", 6, 8, 1,
                1);
        assertTrue(test.intersects(intersectFalseRect2));
        
        Rectangle intersectFalseRect3 = new Rectangle("intersectTest", 1, 2, 10,
                1);
        assertFalse(test.intersects(intersectFalseRect3));

        Rectangle intersectFalseRect4 = new Rectangle("intersectTest", 1, 8, 10,
                1);
        assertTrue(test.intersects(intersectFalseRect4));
    }

    /**
     * test isExact method
     */
    public void testIsExact()
    {
        assertTrue(test.isExact(5, 7, 30, 40));
        assertFalse(test.isExact(0, 2, 30, 40));
    }

    /**
     * test isContained method
     */
    public void testIsContained()
    {
        assertTrue(test.isContained(0, 0, 1024, 1024));
        assertFalse(test.isContained(0, 500, 1, 1));
        assertFalse(test.isContained(5, 500, 1, 1));
    }
}
