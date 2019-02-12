import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Josh
 *
 */
public class BstTest extends TestCase {

	Bst<String, Rectangle> best = new Bst<String, Rectangle>();
	Rectangle rect1 = new Rectangle("lala", 1, 2, 3, 4);
	Rectangle rect2 = new Rectangle("ala", 1, 2, 3, 4);
	Rectangle rect3 = new Rectangle("pala", 1, 2, 3, 4);
	Rectangle rect4 = new Rectangle("rala", 1, 2, 3, 4);
	
	public void testInsert() {
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
	}
	
	public void testRemove() {
		//Insert and remove any
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
		best.removeAny();
		assertEquals(best.size(), 0);
		//Insert and remove by name
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
		best.remove(rect1.getName());
		assertEquals(best.size(), 0);
		//Insert and then try to remove the wrong one
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
		best.remove(rect2.getName());
		assertEquals(best.size(), 1);
	}
	
	public void testSearch() {
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
	}
	
}
