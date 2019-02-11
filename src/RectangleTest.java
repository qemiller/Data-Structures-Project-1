import junit.framework.TestCase;

public class RectangleTest extends TestCase
{
    Rectangle test;

    public void setUp()
    {
        test = new Rectangle("Yogi", 1, 2, 30, 40);
    }

    public void testGeters()
    {
        assertTrue("Yogi".equals(test.getName()));
        assertEquals(1, test.getXVal());
        assertEquals(2, test.getYVal());
        assertEquals(30, test.getWidth());
        assertEquals(40, test.getHeight());
    }

    public void testToString()
    {
        assertTrue("(Yogi, 1, 2, 30, 40)".equals(test.toString()));
    }

    public void testIntersection()
    {
        Rectangle intersectRect = new Rectangle("intersectTest", 2, 2, 10, 10);
        assertTrue(test.intersects(intersectRect));
    }
}
