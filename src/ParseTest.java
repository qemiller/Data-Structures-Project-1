import java.util.Scanner;
import junit.framework.TestCase;
/**
 * 
 * @author Quinton Miller qemiller
 * @author Josh Rehm jrehm135
 *
 * @version 2-12-2019
 */
public class ParseTest extends TestCase
{
    private Parse test;
    private Scanner sc;
    private Bst<String, Rectangle> tree;

    /**
     * set up ParseTest class
     */
    public void setUp()
    {
        test = new Parse();
        tree = new Bst<String, Rectangle>();
    }

    /**
     * test insert method
     */
    public void testHandleInsert()
    {
        sc = new Scanner("1 2 3 4");
        assertTrue(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1 2 1024 1024");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1 2 3 4");
        assertFalse(test.handleInsert("1Yogi", tree, sc));
        sc = new Scanner("1 2 3 6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1 -6722 3 6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("-40 -6722 3 6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("8 4 -3 6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1 50 3 -6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1 2 3 6723");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1000 1000 400 10");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        
        //New tests
        // Test Full boundaries
        sc = new Scanner("0 0 1024 1024");
        assertTrue(test.handleInsert("Yogi", tree, sc));
        // Test with negative x/y
        sc = new Scanner("-1 -1 1024 1024");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        // Test with greater than bounds
        sc = new Scanner("0 0 1025 1025");
        assertFalse(test.handleInsert("Yogi", tree, sc));
        // Test additive bounds
        sc = new Scanner("1023 1023 1 1");
        assertTrue(test.handleInsert("Yogi", tree, sc));
        sc = new Scanner("1023 1023 2 2");
        assertFalse(test.handleInsert("Yogi", tree, sc));
    }
    
    /**
     * test remove method
     */
    public void testHandleRemove()
    {
        sc = new Scanner("1 2 3 4");
        assertFalse(test.handleRemove("Yogi", sc, tree));
        
        test.handleInsert("Yogi", tree, sc);
        assertTrue(test.handleRemove("Yogi", sc, tree));
        
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Yogi", tree, sc);
        sc = new Scanner("2 4 4");
        assertFalse(test.handleRemove("1", sc, tree));
        sc = new Scanner("2 3 4");
        assertTrue(test.handleRemove("1", sc, tree));
        
        sc = new Scanner("2 3 4");
        assertFalse(test.handleRemove("-1", sc, tree));
    }
    
    /**
     * test search method
     */
    public void testHandleSearch()
    {
        sc = new Scanner("1 5 3 4");
        assertFalse(test.handleSearch("Yogi", tree));
        System.out.println("");
        
        test.handleInsert("Mogi", tree, sc);
        assertTrue(test.handleSearch("Mogi", tree));
        System.out.println("");
        
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Zogi", tree, sc);
        assertTrue(test.handleSearch("Zogi", tree));
        System.out.println("");
        
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Zogi", tree, sc);
        assertTrue(test.handleSearch("Zogi", tree));
        System.out.println("");
        
        sc = new Scanner("1 50 437 678");
        test.handleInsert("Yogi", tree, sc);
        assertTrue(test.handleSearch("Yogi", tree));
        System.out.println("");
        
        sc = new Scanner("400 285 700 630");
        test.handleInsert("Zogi", tree, sc);
        assertTrue(test.handleSearch("Zogi", tree));
        System.out.println("");
        
        assertFalse(test.handleSearch("Josh", tree));
        assertTrue(test.handleSearch("Zogi", tree));
        System.out.println("");
        
        sc = new Scanner("4 5 700 630");
        test.handleInsert("Josh", tree, sc);
        assertTrue(test.handleSearch("Josh", tree));
        System.out.println("");
        
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Josh", tree, sc);
        assertTrue(test.handleSearch("Josh", tree));
        System.out.println("");
        
        sc = new Scanner("50 60 70 80");
        test.handleInsert("Josh", tree, sc);
        assertTrue(test.handleSearch("Josh", tree));
        System.out.println("");
        
        sc = new Scanner("95 85 700 630");
        test.handleInsert("Josh", tree, sc);
        assertTrue(test.handleSearch("Josh", tree));
        System.out.println("");
        
        assertTrue(test.handleSearch("Zogi", tree));
        System.out.println("");
        
        sc = new Scanner("95 85 700 630");
        test.handleInsert("Karol", tree, sc);
        assertTrue(test.handleSearch("Karol", tree));
        System.out.println("");
        
        sc = new Scanner("95 85 700 630");
        test.handleInsert("Mark", tree, sc);
        assertTrue(test.handleSearch("Mark", tree));
        System.out.println("");
        
        sc = new Scanner("95 85 700 630");
        test.handleInsert("Alan", tree, sc);
        
        sc = new Scanner("95 85 700 630");
        test.handleInsert("Blan", tree, sc);
        
        
        assertTrue(test.handleSearch("Mark", tree));
        System.out.println("");
        
        tree.dump();
    }
    
    /**
     * test regionsearch method
     */
    public void testHandleRegionSearch()
    {
        assertTrue(test.handleRegionSearch(0, 0, 1024, 1024, tree));
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Yogi", tree, sc);
        sc = new Scanner("60 80 50 60");
        test.handleInsert("Josh", tree, sc);
        assertTrue(test.handleRegionSearch(0, 1, 50, 40, tree));
        sc = new Scanner("1 2 0 4");
        assertFalse(test.handleRegionSearch(1, 2, 0, 4, tree));

        sc = new Scanner("1 2 0 4");
        assertTrue(test.handleRegionSearch(1024, 1024, 1, 4, tree));
    }
     /**
      * test intersection methods
      */
    public void testHandleIntersections()
    {
        assertFalse(test.handleIntersections(tree));
        sc = new Scanner("1 2 3 4");
        test.handleInsert("Yogi", tree, sc);
        sc = new Scanner("2 2 50 40");
        test.handleInsert("Josh", tree, sc);
        sc = new Scanner("627 489 11 120");
        test.handleInsert("Maggie", tree, sc);
        
        assertTrue(test.handleIntersections(tree));
    }
    
    /**
     * test parse
     */
    public void testParseFunction()
    {
        sc = new Scanner("insert Yogi 1 2 3 4");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("insert Josh 40 80 600 900");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("search Yogi");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("regionsearch 0 0 1024 1024");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("intersections");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("Remove Josh");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("remove 1 2 3 4");
        assertTrue(test.parse(sc));
        
        sc = new Scanner("dump");
        assertTrue(test.parse(sc));
        
    }
        
}
