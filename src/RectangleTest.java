import junit.framework.TestCase;

public class RectangleTest extends TestCase
{
    private Rectangle test;

    public void setUp()
    {
        test = new Rectangle("Yogi", 5, 7, 30, 40);
    }

    public void testGeters()
    {
        assertTrue("Yogi".equals(test.getName()));
        assertEquals(5, test.getXVal());
        assertEquals(7, test.getYVal());
        assertEquals(30, test.getWidth());
        assertEquals(40, test.getHeight());
    }

    public void testToString()
    {
        assertTrue("(Yogi, 5, 7, 30, 40)".equals(test.toString()));
    }

    public void testIntersection()
    {
        Rectangle intersectTrueRect = new Rectangle("intersectTest", 1, 2, 10,
                10);
        assertTrue(test.intersects(intersectTrueRect));

        Rectangle intersectFalseRect1 = new Rectangle("intersectTest", 0, 0, 500,
                500);
        assertTrue(!test.intersects(intersectFalseRect1));
        
        Rectangle intersectFalseRect2 = new Rectangle("intersectTest", 6, 8, 1,
                1);
        assertTrue(!test.intersects(intersectFalseRect2));
        
        Rectangle intersectFalseRect3 = new Rectangle("intersectTest", 1, 2, 10,
                1);
        assertTrue(!test.intersects(intersectFalseRect3));

        Rectangle intersectFalseRect4 = new Rectangle("intersectTest", 1, 8, 10,
                1);
        assertTrue(!test.intersects(intersectFalseRect4));
    }

    public void testIsExact()
    {
        assertTrue(test.isExact(5, 7, 30, 40));
        assertTrue(!test.isExact(0, 2, 30, 40));
    }

    public void testIsContained()
    {
        assertTrue(test.isContained(0, 0, 1024, 1024));
        assertTrue(!test.isContained(0, 500, 1, 1));
        assertTrue(!test.isContained(5, 500, 1, 1));
    }
}
