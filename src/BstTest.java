import junit.framework.TestCase;

/**
 * @author Josh Rehm jrehm135
 * @author Quinton Miller qemiller
 * 
 * @version 2-12-2019
 */
/**
 * @author Josh
 * @version 1.2
 */
public class BstTest extends TestCase
{
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT1 = new Rectangle("dala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT2 = new Rectangle("bala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT3 = new Rectangle("cala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT4 = new Rectangle("ala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT5 = new Rectangle("eala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT6 = new Rectangle("fala", 1, 2, 3, 4);
    /**
     * Test rectangles for node usage
     */
    public static final Rectangle RECT7 = new Rectangle("gala", 1, 2, 3, 4);

    /**
     * Test basic insert functionality
     */
    public void testInsert()
    {
        Bst<String, Rectangle> best = new Bst<String, Rectangle>();

        best.insert(RECT1.getName(), RECT1);
        best.insert(RECT2.getName(), RECT2);
        best.insert(RECT3.getName(), RECT3);
        assertEquals(best.size(), 3);
    }

    /**
     * Test remove functionality
     */
    public void testRemove()
    {
        Bst<String, Rectangle> best = new Bst<String, Rectangle>();

        // Insert and remove any
        best.insert(RECT1.getName(), RECT1);
        assertEquals(best.size(), 1);
        best.removeAny();
        assertEquals(best.size(), 0);
        // Nothing to remove
        assertNull(best.removeAny());
        // Insert and remove by name
        best.insert(RECT1.getName(), RECT1);
        assertEquals(best.size(), 1);
        best.remove(RECT1.getName());
        assertEquals(best.size(), 0);
        // Insert and then try to remove the wrong one
        best.insert(RECT1.getName(), RECT1);
        assertEquals(best.size(), 1);
        best.remove(RECT2.getName());
        assertEquals(best.size(), 1);
        // Remove with multiple things in tree
        best.insert(RECT2.getName(), RECT2);
        best.insert(RECT3.getName(), RECT3);
        best.insert(RECT4.getName(), RECT4);
        best.insert(RECT5.getName(), RECT5);
        best.insert(RECT6.getName(), RECT6);
        best.insert(RECT7.getName(), RECT7);
        best.remove(RECT1.getName());
        best.insert(RECT1.getName(), RECT1);
        best.remove(RECT2.getName());
        best.insert(RECT2.getName(), RECT2);
        best.remove(RECT3.getName());
        best.insert(RECT3.getName(), RECT3);
        best.remove(RECT4.getName());
        best.insert(RECT4.getName(), RECT4);
        best.remove(RECT5.getName());
        best.insert(RECT5.getName(), RECT5);
        best.remove(RECT6.getName());
        best.insert(RECT6.getName(), RECT6);
        best.remove(RECT7.getName());
        best.insert(RECT7.getName(), RECT7);
    }

    /**
     * Test search functionality
     */
    public void testSearch()
    {
        Bst<String, Rectangle> best = new Bst<String, Rectangle>();

        // Test simple find
        best.insert(RECT1.getName(), RECT1);
        assertEquals(best.size(), 1);
        assertEquals(best.search(RECT1.getName()), RECT1);
        // Test find without object
        assertNull(best.search(RECT2.getName()));
        // Test find with full tree
        best.insert(RECT2.getName(), RECT2);
        best.insert(RECT3.getName(), RECT3);
        best.insert(RECT4.getName(), RECT4);
        best.insert(RECT5.getName(), RECT5);
        best.insert(RECT6.getName(), RECT6);
        best.insert(RECT7.getName(), RECT7);
        assertEquals(best.search(RECT1.getName()), RECT1);
        assertEquals(best.search(RECT2.getName()), RECT2);
        assertEquals(best.search(RECT3.getName()), RECT3);
        assertEquals(best.search(RECT4.getName()), RECT4);
        assertEquals(best.search(RECT5.getName()), RECT5);
        assertEquals(best.search(RECT6.getName()), RECT6);
        assertEquals(best.search(RECT7.getName()), RECT7);
    }

    /**
     * Test for proper dump output
     */
    public void testDump()
    {
        Bst<String, Rectangle> best = new Bst<String, Rectangle>();

        // Test empty dump
        assertEquals(best.size(), 0);
        best.dump();
        // Test full dump
        best.insert(RECT1.getName(), RECT1);
        best.insert(RECT2.getName(), RECT2);
        best.insert(RECT3.getName(), RECT3);
        best.insert(RECT4.getName(), RECT4);
        best.insert(RECT5.getName(), RECT5);
        best.insert(RECT6.getName(), RECT6);
        best.insert(RECT7.getName(), RECT7);
        assertEquals(best.size(), 7);
        best.dump();
    }

    /**
     * Test iteration through the tree
     */
    public void testIterTools()
    {
        Bst<String, Rectangle> best = new Bst<String, Rectangle>();

        best.insert(RECT1.getName(), RECT1);
        best.insert(RECT2.getName(), RECT2);
        best.insert(RECT3.getName(), RECT3);
        best.insert(RECT4.getName(), RECT4);
        best.insert(RECT5.getName(), RECT5);
        best.insert(RECT6.getName(), RECT6);
        best.insert(RECT7.getName(), RECT7);
        assertEquals(best.size(), 7);
        BstNode<String, Rectangle> tempNode = best.getFirst();
        while (tempNode != null)
        {
            tempNode = best.getNext(tempNode);
        }
    }
}