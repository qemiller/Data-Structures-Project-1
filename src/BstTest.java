import junit.framework.TestCase;

/**
 * @author Josh Rehm jrehm135
 * @author Quinton Miller qemiller
 * 
 * @version 2-12-2019
 */
public class BstTest extends TestCase
{

    private Bst<String, Rectangle> best;
    private Rectangle rect1;
    private Rectangle rect2;

    /**
     * Initialize testing class
     */
    public void setUp()
    {
        best = new Bst<String, Rectangle>();
        rect1 = new Rectangle("lala", 1, 2, 3, 4);
        rect2 = new Rectangle("ala", 1, 2, 3, 4);
    }

    /**
     * test the insert method
     */
    public void testInsert()
    {
        best.insert(rect1.getName(), rect1);
        assertEquals(best.size(), 1);
    }

    /**
     * test the remove methods
     */
    public void testRemove()
    {
        // Insert and remove any
        best.insert(rect1.getName(), rect1);
        assertEquals(best.size(), 1);
        best.removeAny();
        assertEquals(best.size(), 0);
        // Insert and remove by name
        best.insert(rect1.getName(), rect1);
        assertEquals(best.size(), 1);
        best.remove(rect1.getName());
        assertEquals(best.size(), 0);
        // Insert and then try to remove the wrong one
        best.insert(rect1.getName(), rect1);
        assertEquals(best.size(), 1);
        best.remove(rect2.getName());
        assertEquals(best.size(), 1);
    }

    /**
     * test the search method
     */
    public void testSearch()
    {
        best.insert(rect1.getName(), rect1);
        assertEquals(best.size(), 1);
    }

}
