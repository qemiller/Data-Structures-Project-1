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
        
    }
}
