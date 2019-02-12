import java.util.Scanner;
import junit.framework.TestCase;

public class ParseTest extends TestCase
{
    private Parse test;
    private Scanner sc;
    private Bst<String, Rectangle> tree;

    public void setUp()
    {
        test = new Parse();
        tree = new Bst<String, Rectangle>();
    }

    public void testHandleInsert()
    {
        assertTrue(test.handleInsert("Yogi", 1, 2, 3, 4, tree));
        assertTrue(!test.handleInsert("Yogi", 1, 2, 3, 1024, tree));
        assertTrue(!test.handleInsert("1Yogi", 1, 2, 3, 1024, tree));
    }
    
    public void testHandleRemove()
    {
        sc = new Scanner("Yogi");
        assertTrue(!test.handleRemove("Yogi",sc,tree));
        
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        assertTrue(test.handleRemove("Yogi",sc,tree));
        
        sc = new Scanner(" 2 4 4");
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        assertTrue(!test.handleRemove("1",sc,tree));
        sc = new Scanner(" 2 3 4");
        assertTrue(test.handleRemove("1",sc,tree));
        
    }
    
    public void testHandleSearch()
    {
        sc = new Scanner("1 2 3 4");
        assertTrue(!test.handleSearch("Yogi", sc, tree));
        
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        assertTrue(test.handleSearch("Yogi", sc, tree));
        
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        assertTrue(test.handleSearch("Yogi", sc, tree));
        
        assertTrue(!test.handleSearch("Josh", sc, tree));
        
    }
    
    public void testHandleRegionSearch()
    {
        assertTrue(test.handleRegionSearch(0, 0, 1024, 1024, tree));
        
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        test.handleInsert("Josh", 60, 80, 50, 60, tree);
        assertTrue(test.handleRegionSearch(0, 1, 50, 40, tree));
    }
    
    public void testHandleIntersections()
    {
        assertTrue(!test.handleIntersections(tree));
        
        test.handleInsert("Yogi", 1, 2, 3, 4, tree);
        test.handleInsert("Josh", 2, 2, 50, 40, tree);
        test.handleInsert("Maggie", 627, 489, 11, 120, tree);
        
        assertTrue(test.handleIntersections(tree));
    }
    
    public void testParseFunction()
    {
        
    }
}
