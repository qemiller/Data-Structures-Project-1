import junit.framework.TestCase;

/**
 * @author Josh Rehm jrehm135
 * @author Quinton Miller qemiller
 * 
 * @version 2-12-2019
 */
/**
 * @author Josh
 *
 */
public class BstTest extends TestCase {
	Bst<String, Rectangle> best = new Bst<String, Rectangle>();
	Rectangle rect1 = new Rectangle("dala", 1, 2, 3, 4);
	Rectangle rect2 = new Rectangle("bala", 1, 2, 3, 4);
	Rectangle rect3 = new Rectangle("cala", 1, 2, 3, 4);
	Rectangle rect4 = new Rectangle("ala", 1, 2, 3, 4);
	Rectangle rect5 = new Rectangle("eala", 1, 2, 3, 4);
	Rectangle rect6 = new Rectangle("fala", 1, 2, 3, 4);
	Rectangle rect7 = new Rectangle("gala", 1, 2, 3, 4);

	/**
	 * Test basic insert functionality
	 */
	public void testInsert() {
		best.insert(rect1.getName(), rect1);
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		assertEquals(best.size(), 3);
	}

	/**
	 * Test remove functionality
	 */
	public void testRemove() {
		// Insert and remove any
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
		best.removeAny();
		assertEquals(best.size(), 0);
		// Nothing to remove
		assertNull(best.removeAny());
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
		// Remove with multiple things in tree
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		best.insert(rect4.getName(), rect4);
		best.insert(rect5.getName(), rect5);
		best.insert(rect6.getName(), rect6);
		best.insert(rect7.getName(), rect7);
		best.remove(rect1.getName());
		best.insert(rect1.getName(), rect1);
		best.remove(rect2.getName());
		best.insert(rect2.getName(), rect2);
		best.remove(rect3.getName());
		best.insert(rect3.getName(), rect3);
		best.remove(rect4.getName());
		best.insert(rect4.getName(), rect4);
		best.remove(rect5.getName());
		best.insert(rect5.getName(), rect5);
		// Test fails here on remove root
		best.remove(rect6.getName());
		best.insert(rect6.getName(), rect6);
		best.remove(rect7.getName());
		best.insert(rect7.getName(), rect7);
	}

	/**
	 * Test search functionality
	 */
	public void testSearch() {
		best.insert(rect1.getName(), rect1);
		assertEquals(best.size(), 1);
		assertEquals(best.search(rect1.getName()), rect1);
		assertNull(best.search(rect2.getName()));
	}

	/**
	 * Test for proper dump output
	 */
	public void testDump() {
		// Test empty dump
		assertEquals(best.size(), 0);
		best.dump();
		// Test full dump
		best.insert(rect1.getName(), rect1);
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		best.insert(rect4.getName(), rect4);
		best.insert(rect5.getName(), rect5);
		best.insert(rect6.getName(), rect6);
		best.insert(rect7.getName(), rect7);
		assertEquals(best.size(), 7);
		best.dump();
	}
	
	/**
	 * Test iteration through the tree
	 */
	public void testIterTools() {
		best.insert(rect1.getName(), rect1);
		best.insert(rect2.getName(), rect2);
		best.insert(rect3.getName(), rect3);
		best.insert(rect4.getName(), rect4);
		best.insert(rect5.getName(), rect5);
		best.insert(rect6.getName(), rect6);
		best.insert(rect7.getName(), rect7);
		assertEquals(best.size(), 7);
		BstNode<String, Rectangle> tempNode = best.getFirst();
		while (tempNode != null) {
			tempNode = best.getNext(tempNode);
		}
	}
}