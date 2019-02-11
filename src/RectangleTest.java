import junit.framework.TestCase;

public class RectangleTest extends TestCase 
{
	rectangle test;
	public void setUp()
	{
		test = new rectangle("Yogi", 1, 2, 3, 4);
	}
	
	public void testGeters()
	{
		assertTrue("Yogi".equals(test.getName()));
		assertEquals(1,test.getXVal());
		assertEquals(2,test.getYVal());
		
	}
}
