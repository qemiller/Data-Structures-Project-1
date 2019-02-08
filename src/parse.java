/**BST can search, insert, and remove right now.**/
/**Parser for Dictionary ADT**/

import java.io.File;
import java.util.Scanner;
import java.lang.Character;

/*
 This function parses the file and executes the given commands
 @param fileName is name of file to be parsed
 */
public class parse {
	public void parseFile(String fileName) {
		try {
			Scanner sc = new Scanner(new File(fileName));
			bst<String, rectangle> tree = new bst<String, rectangle>();
			while (sc.hasNextLine()) {
				String command = sc.next();//command read in from file
				String name;//name of rectangle
				int x;//x-coordinate of rectangle
				int y;//y-coordinate of rectangle
				int w;//width of rectangle
				int h;//height of rectangle
				switch (command) {

				case "insert"://deal with the insert command
					name = sc.next();
					x = sc.nextInt();
					y = sc.nextInt();
					w = sc.nextInt();
					h = sc.nextInt();
					rectangle rectInsert = new rectangle(name, x, y, w, h);//rectangle to be inserted
					if (Character.isLetter(name.charAt(0))) {
						if (coordinatesCorrect(x, y, w, h)) {
							tree.insert(rectInsert.getName(), rectInsert);
							System.out.println("Rectangle accepted: " + rectInsert.toString());
						} else
							System.out.println("Rectangle rejected: " + rectInsert.toString());
					} else
						System.out.println("Rectangle rejected: " + rectInsert.toString());
					break;

				case "remove"://deal with the remove command
					name = sc.next();
					if (Character.isDigit(name.charAt(0))) { 
						x = Integer.parseInt(name);
						y = sc.nextInt();
						w = sc.nextInt();
						h = sc.nextInt();
						if (removeCoordinate(x, y, w, h, tree)) {
						} else
							System.out.println("Rectangle rejected (" + x + "," + y + "," + w + "," + h + ")");
					} else {
						if (tree.remove(name) == null)
							System.out.println("Rectangle rejected " + name);
					}
					break;

				case "dump"://deal with the dump command
					tree.dump();
					break;

				case "search"://deal with the search command
					name = sc.next();
					boolean foundOne = false;//Have I found one rectangle with the given name
					bstNode<String, rectangle> currNode = tree.getFirst();//current node the search is on
					while (currNode != null) {
						if (currNode.element().getName() == name) {
							System.out.println("Rectangle Found:" + currNode.element().toString());
							currNode = tree.getNext(currNode);
							foundOne = true;//I have found a rectangle while I was searching
						} else
							currNode = tree.getNext(currNode);
					}
					if (!foundOne)//If I haven't found a rectangle while I was searching, throw an error
						System.out.println("Rectangle not found:" + name);
					break;

				case "regionsearch"://deal with the regionsearch command
					x = sc.nextInt();
					y = sc.nextInt();
					w = sc.nextInt();
					h = sc.nextInt();
					bstNode<String, rectangle> currNodeRegion = tree.getFirst();//current node for regionsearch
					System.out.println("Rectanagles intersecting region  (" + x + "," + +y + "," + w + "," + h + "):");
					while (currNodeRegion != null) {
						if (currNodeRegion.element().isContained(x, y, w, h)) {
							System.out.println(currNodeRegion.element().toString() + "\n");
							currNodeRegion = tree.getNext(currNodeRegion);
						} else
							currNodeRegion = tree.getNext(currNodeRegion);
					}
					break;

				case "intersections"://deal with the intersections command
					System.out.println("Intersection pairs:");
					break;
					
				default:
					System.out.println("Unrecognized input " + command);
				}
			}
			sc.close();
		} catch (Exception FileNotFoundException) {//Throw this if I can't find the file
		}
	}

	/*
	 * will remove a rectangle by coordinate from the tree
	 * 
	 * @param x is x coordinate of rectangle
	 * 
	 * @param y is y coordinate of rectangle
	 * 
	 * @param w is width of rectangle
	 * 
	 * @param h is height of rectangle
	 * 
	 * @param is the tree to search for the given rectangle
	 * 
	 * @return if there was something removed from the tree
	 */
	private boolean removeCoordinate(int x, int y, int w, int h, bst<String, rectangle> tree) {
		boolean removedOne = false;
		bstNode<String, rectangle> curNode = tree.getFirst();
		while (curNode != null) {
			if (curNode.element().isExact(x, y, w, h)) {
				tree.remove(curNode.element().getName());
				removedOne = true;
				break;
			} else
				curNode = tree.getNext(curNode);
		}
		if (!removedOne)
			return false;
		else
			return true;
	}

	/*
	 * Checks to make sure the given coordinates are within the world box and width
	 * and height are greater than zero.
	 * 
	 * @param x is x coordinate of rectangle
	 * 
	 * @param y is y coordinate of rectangle
	 * 
	 * @param w is width of rectangle
	 * 
	 * @param h is height of rectangle
	 * 
	 * @return if the coordinates are correct
	 */
	private boolean coordinatesCorrect(int x, int y, int w, int h) {
		if (x + w <= 1024 && x >= 0 && y + h <= 1024 && y >= 0 && w > 0 && h > 0)
			return true;
		else
			return false;
	}

}
